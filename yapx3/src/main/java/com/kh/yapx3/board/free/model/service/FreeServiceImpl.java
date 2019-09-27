package com.kh.yapx3.board.free.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.board.free.model.dao.FreeDAO;
import com.kh.yapx3.board.free.model.vo.Free;
import com.kh.yapx3.board.free.model.vo.FreeAttachment;
import com.kh.yapx3.board.free.model.vo.FreeVO;
import com.kh.yapx3.board.free.model.vo.FreeWithFileCount;
import com.kh.yapx3.common.exception.BoardException;

@Service
public class FreeServiceImpl implements FreeService {
	
	@Autowired
	FreeDAO freeDAO;

	@Override
	public List<FreeWithFileCount> selectFreeList(int cPage) {
		return freeDAO.selectFreeList(cPage);
	}

	@Override
	public int insertBoard(Free free, List<FreeAttachment> attachList) {
		int result = freeDAO.insertBoard(free);
		
		int boardNo = free.getFreeBoardNo();
		
		if(attachList.size() > 0) {
			for(FreeAttachment a : attachList) {
				a.setBoardNo(boardNo);
				result = freeDAO.insertAttachment(a);
			}
		}
		return result;
	}

	@Override
	public FreeVO selectFreeOne(int freeBoardNo) {
		return freeDAO.selectFreeOne(freeBoardNo);
	}

}
