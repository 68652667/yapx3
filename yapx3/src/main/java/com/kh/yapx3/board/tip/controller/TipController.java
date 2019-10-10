package com.kh.yapx3.board.tip.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.yapx3.board.tip.model.service.TipService;
import com.kh.yapx3.board.tip.model.vo.ChampSkills;
import com.kh.yapx3.board.tip.model.vo.Tip;
import com.kh.yapx3.board.tip.model.vo.TipAttachment;
import com.kh.yapx3.board.tip.model.vo.TipComment;
import com.kh.yapx3.board.tip.model.vo.TipVO;
import com.kh.yapx3.board.tip.model.vo.TipWithFileCount;
import com.kh.yapx3.common.util.HelloSpringUtils;
import com.kh.yapx3.user.model.vo.Member;

@Controller
@RequestMapping("/tip")
public class TipController {
	
	final int NUM_PER_PAGE = 10;
	final int pageBarSize = 10;
	
	@Autowired
	TipService tipService;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/tipList.do")
	public ModelAndView TipList(ModelAndView mav, @RequestParam(value="cPage", defaultValue="1", required=false) int cPage) {
		mav.setViewName("board/tip/tipList");
		
		List<TipWithFileCount> list = tipService.selectTipList(cPage);
		
		int totalBoard = tipService.selectTipTotal();
		
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
			pageBar += "<a href='/yapx3/tip/tipList.do?cPage="+(pageNo-1)+"'>&laquo;</a>"; 
		}
		
		//b.page
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			//현재 페이지인 경우. 링크필요없음
			if(pageNo == cPage) {
//				pageBar += "<span class='active'>"+pageNo+"</span>";
				pageBar += "<a href='/yapx3/tip/tipList.do?cPage="+pageNo+"' class='active'>"+pageNo+"</a>"; 
			}
			else {
				pageBar += "<a href='/yapx3/tip/tipList.do?cPage="+pageNo+"'>"+pageNo+"</a>"; 
			}
			pageNo++;
		}
		
		//c.[다음]
		if(pageNo>totalPage) {
			pageBar += "<a href='#' class='none'>&raquo;</a>";
		}
		else {
			pageBar += "<a href='/yapx3/tip/tipList.do?cPage="+pageNo+"'>&raquo;</a>"; 
		}
		
		mav.addObject("list", list);
		mav.addObject("pageBar", pageBar);
		
		return mav;
	}
	
	@RequestMapping("tipBoardView.do")
	public ModelAndView tipBoardView(ModelAndView mav, @RequestParam int tipBoardNo) {
		mav.setViewName("board/tip/tipBoardView");
		TipVO tip = tipService.selectTipOne(tipBoardNo);
		
		tip.setTipBoardViews( tip.getTipBoardViews() + 1 );
		
		tipService.updateTip( tip );
		
		List<TipComment> commentList = null;
		commentList = tipService.selectCommentList(tipBoardNo);
		int commentNumber = tipService.selectCommentNumber(tipBoardNo);
		
		mav.addObject("tip", tip);
		mav.addObject("commentList", commentList);
		mav.addObject("commentNumber", commentNumber);
		
		return mav;
	}
	
	@RequestMapping("tipBoardWrite.do")
	public ModelAndView tipBoardWrite(ModelAndView mav, @RequestParam String userEmail, @RequestParam String userNickname, HttpServletRequest request) throws Exception{
		mav.setViewName("board/tip/tipBoardWrite");
		
		Member m = new Member();
		m.setUserEmail(userEmail);
		m.setUserNickname(userNickname);
		
		List<ChampSkills> champList = new ArrayList<ChampSkills>();
		
		String ar = servletContext.getRealPath("/resources/txt/data.txt");
		File file = new File(ar);
		FileReader fr = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(fr);

		String sb = "";
		String line = "";
        while((line = bufReader.readLine()) != null){
            sb += line;
        }
        bufReader.close();
        
        JSONObject champ =  new JSONObject(sb.toString());
        JSONArray arr = champ.getJSONArray("champ");
        for(int i=0; i<arr.length(); i++) {
        	JSONObject c = (JSONObject) arr.get(i);
        	ChampSkills s = new ChampSkills(c.getString("id"), c.getString("passive"), c.getString("spell1"), c.getString("spell2"), c.getString("spell3"), c.getString("spell4"));
        	champList.add(s);
        }
		
		mav.addObject("champList", champList);
		mav.addObject("member", m);
		
		return mav;
	}
	
	@RequestMapping("tipBoardWriteEnd.do")
	public String tipBoardWriteEnd(Model model, 
									HttpServletRequest request, 
									MultipartFile[] upFile,
									Tip tip) {
		try {
			
			String saveDirectory
			= request.getSession()
					 .getServletContext()
					 .getRealPath("/resources/upload/board");
			
			List<TipAttachment> attachList = new ArrayList<>();
			
			for(MultipartFile f : upFile) {
				if(!f.isEmpty()) {
					String originalFileName = f.getOriginalFilename();
					String renamedFileName = HelloSpringUtils.getRenamedFileName(originalFileName);
					
					try {
						f.transferTo(new File(saveDirectory+"/"+renamedFileName));
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					TipAttachment attach = new TipAttachment();
					attach.setOriginalFileName(originalFileName);
					attach.setRenamedFileName(renamedFileName);
					attachList.add(attach);

				}
			}
			
			System.out.println("attachList : "+attachList);
			int result = tipService.insertBoard(tip, attachList);
			String msg = result>0?"게시물 등록 성공":"게시물 등록 실패";
			
			model.addAttribute("msg", msg);
			model.addAttribute("loc", "/tip/tipBoardView.do?tipBoardNo="+tip.getTipBoardNo());
			
		} catch(Exception e) {e.printStackTrace();}
		
		return "common/msg";
	}
	
	@RequestMapping("/tipCommentUp.do")
	public ModelAndView tipCommentUp(ModelAndView mav, 
								HttpServletRequest request, 
								TipComment tipComment) {
		System.out.println(tipComment);
		int result = tipService.tipCommentUp(tipComment);
		mav.setViewName("redirect:/tip/tipBoardView.do?tipBoardNo="+tipComment.getTipBoardNo());
		return mav;
	}
	
	@RequestMapping("/tipCommentDel.do")
	public ModelAndView tipCommentDel(ModelAndView mav, 
			HttpServletRequest request, 
			@RequestParam int commentNo, @RequestParam int tipBoardNo) {
		int result = tipService.tipCommentDel(commentNo);
		mav.setViewName("redirect:/tip/tipBoardView.do?tipBoardNo="+tipBoardNo);
		return mav;
	}
	
	@RequestMapping("/tipboardLike")
	public void tipboardLike(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Integer> likeValue = new HashMap<String, Integer>();
		String tipboardNo = request.getParameter("tipboardNo");
		String userEmail = request.getParameter("userEmail");
		
		String likeUserList = tipService.likeUserList(tipboardNo);
		if(likeUserList==null) {
			tipService.likeincrease(userEmail, tipboardNo);
		}
		else if(!likeUserList.contains(userEmail)) {
			likeUserList += ", "+userEmail;
			tipService.likeincrease2(likeUserList, tipboardNo);
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
			tipService.deleteLike(likeUserList, tipboardNo);
		}
		int like = tipService.likeValue(tipboardNo);
		
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
