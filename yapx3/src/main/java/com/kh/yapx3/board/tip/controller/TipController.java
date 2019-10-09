package com.kh.yapx3.board.tip.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	@Autowired
	TipService tipService;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/tipList.do")
	public ModelAndView TipList(ModelAndView mav, @RequestParam(value="cPage", defaultValue="1", required=false) int cPage) {
		mav.setViewName("board/tip/tipList");
		
		List<TipWithFileCount> list = tipService.selectTipList(cPage);
		
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("tipBoardView.do")
	public ModelAndView tipBoardView(ModelAndView mav, @RequestParam int tipBoardNo) {
		mav.setViewName("board/tip/tipBoardView");
		TipVO tip = tipService.selectTipOne(tipBoardNo);
		
		List<TipComment> commentList = null;
		commentList = tipService.selectCommentList(tipBoardNo);
		
		mav.addObject("tip", tip);
		mav.addObject("commentList", commentList);
		
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
	

}
