package com.kh.yapx3.board.gontip.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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

import com.kh.yapx3.board.gontip.model.service.GontipService;
import com.kh.yapx3.board.gontip.model.vo.Gontip;
import com.kh.yapx3.board.tip.model.service.TipService;
import com.kh.yapx3.board.tip.model.vo.ChampSkills;
import com.kh.yapx3.common.util.HelloSpringUtils;
import com.kh.yapx3.user.model.vo.Member;

@Controller
@RequestMapping("/gontip")
public class GontipController {
	
	@Autowired
	GontipService gontipService;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/gontipList.do")
	public ModelAndView TipList(ModelAndView mav, @RequestParam(value="cPage", defaultValue="1", required=false) int cPage) {
		mav.setViewName("board/gontip/gontipList");
		
		List<Gontip> list = gontipService.selectGontipList(cPage);
		
		mav.addObject("list", list);
		
		return mav;
	}

}
