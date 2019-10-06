package com.kh.yapx3.board.tip.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	public ModelAndView tipBoardWrite(ModelAndView mav, @RequestParam String userEmail, @RequestParam String userNickname) {
		mav.setViewName("board/tip/tipBoardWrite");
		
		Member m = new Member();
		m.setUserEmail(userEmail);
		m.setUserNickname(userNickname);
		
		List<ChampSkills> champList = new ArrayList<ChampSkills>();
		try {
		String url = "http://ddragon.leagueoflegends.com/cdn/9.19.1/data/ko_KR/champion.json";
		URL url_ = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(url_.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject champ =  new JSONObject(sb.toString());
		JSONObject dataObject = (JSONObject) champ.get("data");
		Iterator i = (Iterator) dataObject.keys();
		while(i.hasNext()) {
			ChampSkills c = new ChampSkills();
			
			String dataKey = i.next().toString();
			JSONObject data = dataObject.getJSONObject(dataKey);
			String id = (String) data.get("id");
			c.setId(id);
			
			String url2 = "http://ddragon.leagueoflegends.com/cdn/9.19.1/data/en_US/champion/"+id+".json";
			URL url2_ = new URL(url2);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(url2_.openConnection().getInputStream()));
			String sb2 = br2.readLine();
			JSONObject champ2 =  new JSONObject(sb2.toString());
			JSONObject dataObject2 = (JSONObject) champ2.get("data");
			Iterator i2 = (Iterator) dataObject2.keys();
			while(i2.hasNext()) {
				String dataKey2 = i2.next().toString();
				JSONObject dataObject2_2 = (JSONObject) dataObject2.get(dataKey2);
				JSONArray spells = (JSONArray) dataObject2_2.get("spells");
				JSONObject passive = dataObject2_2.getJSONObject("passive").getJSONObject("image");
				String pa = (String) passive.get("full");
				JSONObject k1 = spells.getJSONObject(0).getJSONObject("image");
				String spell1 = (String) k1.get("full");
				JSONObject k2 = spells.getJSONObject(1).getJSONObject("image");
				String spell2 = (String) k2.get("full");
				JSONObject k3 = spells.getJSONObject(2).getJSONObject("image");
				String spell3 = (String) k3.get("full");
				JSONObject k4 = spells.getJSONObject(3).getJSONObject("image");
				String spell4 = (String) k4.get("full");
				c.setQ(spell1);
				c.setW(spell2);
				c.setE(spell3);
				c.setR(spell4);
				c.setPassive(pa);
			}
			
			champList.add(c);
		}
		
		} catch(Exception e) {e.printStackTrace();}
		
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
