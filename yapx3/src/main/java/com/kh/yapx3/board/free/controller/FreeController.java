package com.kh.yapx3.board.free.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	@Autowired
	FreeService freeService;
	
	@RequestMapping("/freeList.do")
	public ModelAndView freeList(ModelAndView mav, @RequestParam(value="cPage", defaultValue="1", required=false) int cPage) {
		mav.setViewName("board/free/freeList");
		
		List<FreeWithFileCount> list = freeService.selectFreeList(cPage);
		
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("freeBoardView.do")
	public ModelAndView freeBoardView(ModelAndView mav, @RequestParam int freeBoardNo) {
		mav.setViewName("board/free/freeBoardView");
		FreeVO free = freeService.selectFreeOne(freeBoardNo);
		
		List<FreeComment> commentList = null;
		commentList = freeService.selectCommentList(freeBoardNo);
		
		mav.addObject("free", free);
		mav.addObject("commentList", commentList);
		
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
	

}
