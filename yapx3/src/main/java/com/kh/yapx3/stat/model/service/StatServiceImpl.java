package com.kh.yapx3.stat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.stat.model.dao.StatDAO;
import com.kh.yapx3.stat.model.vo.MatchString;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired
	StatDAO statDAO;

}
