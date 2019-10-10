package com.kh.yapx3.board.free.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.board.free.model.dao.FreeDAO;
import com.kh.yapx3.board.free.model.vo.Free;
import com.kh.yapx3.board.free.model.vo.FreeAttachment;
import com.kh.yapx3.board.free.model.vo.FreeComment;
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

	@Override
	public int freeCommentUp(FreeComment freeComment) {
		return freeDAO.freeCommentUp(freeComment);
	}

	@Override
	public List<FreeComment> selectCommentList(int freeBoardNo) {
		return freeDAO.selectCommentList(freeBoardNo);
	}

	@Override
	public int freeCommentDel(int commentNo) {
		return freeDAO.freeCommentDel(commentNo);
	}

	@Override
	public List<FreeWithFileCount> selectFreeMyList(String memberId) {
		return freeDAO.selectFreeMyList(memberId);
	}

	@Override
	public int updateFree(FreeVO free) {
		return freeDAO.updateFree(free);
	}

	@Override
	public int selectFreeTotal() {
		return freeDAO.selectFreeTotal();
	}

}
