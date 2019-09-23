package com.kh.yapx3.stat.controller;

import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.stat.model.service.StatService;
import com.kh.yapx3.stat.model.vo.MatchString;

@Controller
@RequestMapping("/stat")
public class StatController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	StatService statService;
	
	@RequestMapping("/statChamp.do")
	public ModelAndView statChamp() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
}
