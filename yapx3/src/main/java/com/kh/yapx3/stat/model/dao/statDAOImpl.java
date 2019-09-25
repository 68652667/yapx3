package com.kh.yapx3.stat.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.stat.model.vo.MatchString;

@Repository
public class statDAOImpl implements StatDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

}
