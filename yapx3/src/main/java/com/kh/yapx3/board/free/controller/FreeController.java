package com.kh.yapx3.board.free.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.yapx3.board.free.model.service.FreeService;
import com.kh.yapx3.board.free.model.vo.Free;
import com.kh.yapx3.board.free.model.vo.FreeAttachment;
import com.kh.yapx3.board.free.model.vo.FreeComment;
import com.kh.yapx3.board.free.model.vo.FreeVO;
import com.kh.yapx3.board.free.model.vo.FreeWithFileCount;
import com.kh.yapx3.common.util.HelloSpringUtils;
import com.kh.yapx3.user.model.vo.Member;

@Controller
@RequestMapping("/free")
public class FreeController {
	
	final int NUM_PER_PAGE = 10;
	final int pageBarSize = 10;
	
	@Autowired
	FreeService freeService;
	
	@RequestMapping("/freeList.do")
	public ModelAndView freeList(ModelAndView mav, @RequestParam(value="cPage", defaultValue="1", required=false) int cPage) {
		mav.setViewName("board/free/freeList");
		
		List<FreeWithFileCount> list = freeService.selectFreeList(cPage);
		
		int totalBoard = freeService.selectFreeTotal();
		
		int totalPage = (int) Math.ceil((double)totalBoard/NUM_PER_PAGE);
		String pageBar = "";
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		//a.[이전]
		if(pageNo==1) {
//			pageBar += "<span>&laquo;</span>";
			pageBar += "<a href='#' class='none'>&laquo;</a>"; 
		}
		else {
			pageBar += "<a href='/yapx3/free/freeList.do?cPage="+(pageNo-1)+"'>&laquo;</a>"; 
		}
		
		//b.page
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			//현재 페이지인 경우. 링크필요없음
			if(pageNo == cPage) {
//				pageBar += "<span class='active'>"+pageNo+"</span>";
				pageBar += "<a href='/yapx3/free/freeList.do?cPage="+pageNo+"' class='active'>"+pageNo+"</a>"; 
			}
			else {
				pageBar += "<a href='/yapx3/free/freeList.do?cPage="+pageNo+"'>"+pageNo+"</a>"; 
			}
			pageNo++;
		}
		
		//c.[다음]
		if(pageNo>totalPage) {
			pageBar += "<a href='#' class='none'>&raquo;</a>";
		}
		else {
			pageBar += "<a href='/yapx3/free/freeList.do?cPage="+pageNo+"'>&raquo;</a>"; 
		}
		
		mav.addObject("list", list);
		mav.addObject("pageBar", pageBar);
		
		return mav;
	}
	
	@RequestMapping("freeBoardView.do")
	public ModelAndView freeBoardView(ModelAndView mav, @RequestParam int freeBoardNo) {
		mav.setViewName("board/free/freeBoardView");
		FreeVO free = freeService.selectFreeOne(freeBoardNo);
		freeService.increaseReadCount(freeBoardNo);

		List<FreeComment> commentList = null;
		commentList = freeService.selectCommentList(freeBoardNo);
		int commentNumber = freeService.selectCommentNumber(freeBoardNo);
		
		mav.addObject("free", free);
		mav.addObject("commentList", commentList);
		mav.addObject("commentNumber", commentNumber);
		
		return mav;
	}
	
	@RequestMapping("freeBoardWrite.do")
	public ModelAndView freeBoardWrite(ModelAndView mav, @RequestParam String userEmail, @RequestParam String userNickname) {
		mav.setViewName("board/free/freeBoardWrite");
		
		Member m = new Member();
		m.setUserEmail(userEmail);
		m.setUserNickname(userNickname);
		
		mav.addObject("member", m);
		
		return mav;
	}
	
	@RequestMapping("freeBoardWriteEnd.do")
	public String freeBoardWriteEnd(Model model, 
									HttpServletRequest request, 
									MultipartFile[] upFile,
									Free free) {
		try {
			
			String saveDirectory
			= request.getSession()
					 .getServletContext()
					 .getRealPath("/resources/upload/board");
			
			List<FreeAttachment> attachList = new ArrayList<>();
			
			for(MultipartFile f : upFile) {
				if(!f.isEmpty()) {
					String originalFileName = f.getOriginalFilename();
					String renamedFileName = HelloSpringUtils.getRenamedFileName(originalFileName);
					
					try {
						f.transferTo(new File(saveDirectory+"/"+renamedFileName));
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					FreeAttachment attach = new FreeAttachment();
					attach.setOriginalFileName(originalFileName);
					attach.setRenamedFileName(renamedFileName);
					attachList.add(attach);

				}
			}
			
			System.out.println("attachList : "+attachList);
			int result = freeService.insertBoard(free, attachList);
			String msg = result>0?"게시물 등록 성공":"게시물 등록 실패";
			
			model.addAttribute("msg", msg);
			model.addAttribute("loc", "/free/freeBoardView.do?freeBoardNo="+free.getFreeBoardNo());
			
		} catch(Exception e) {e.printStackTrace();}
		
		return "common/msg";
	}
	
	@RequestMapping("/freeCommentUp.do")
	public ModelAndView freeCommentUp(ModelAndView mav, 
								HttpServletRequest request, 
								FreeComment freeComment) {
		System.out.println(freeComment);
		int result = freeService.freeCommentUp(freeComment);
		mav.setViewName("redirect:/free/freeBoardView.do?freeBoardNo="+freeComment.getFreeBoardNo());
		return mav;
	}
	
	@RequestMapping("/freeCommentDel.do")
	public ModelAndView freeCommentDel(ModelAndView mav, 
			HttpServletRequest request, 
			@RequestParam int commentNo, @RequestParam int freeBoardNo) {
		int result = freeService.freeCommentDel(commentNo);
		mav.setViewName("redirect:/free/freeBoardView.do?freeBoardNo="+freeBoardNo);
		return mav;
	}
	
	@RequestMapping("/freeboardLike")
	public void freeboardLike(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Integer> likeValue = new HashMap<String, Integer>();
		String freeboardNo = request.getParameter("freeboardNo");
		String userEmail = request.getParameter("userEmail");
		
		String likeUserList = freeService.likeUserList(freeboardNo);
		System.out.println(likeUserList);
		if(likeUserList==null) {
			freeService.likeincrease(userEmail, freeboardNo);
		}
		else if(!likeUserList.contains(userEmail)){
			likeUserList += ", "+userEmail;
			freeService.likeincrease2(likeUserList, freeboardNo);
		}
		else {
			if(userEmail.equals(likeUserList)) {
				likeUserList = null;
			}
			else {
				if(likeUserList.contains(", "+userEmail)) {
					likeUserList.replaceAll(", "+userEmail, "");
				}
				else {
					likeUserList.replaceAll(userEmail, "");
				}
			}
			freeService.deleteLike(likeUserList, freeboardNo);
		}
		int like = freeService.likeValue(freeboardNo);
		
		likeValue.put("like", like);
		
		response.setCharacterEncoding("utf-8");
		try {
			new Gson().toJson(likeValue, response.getWriter());
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
