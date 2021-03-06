package com.kh.yapx3.board.tip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.board.tip.model.dao.TipDAO;
import com.kh.yapx3.board.tip.model.vo.Tip;
import com.kh.yapx3.board.tip.model.vo.TipAttachment;
import com.kh.yapx3.board.tip.model.vo.TipComment;
import com.kh.yapx3.board.tip.model.vo.TipVO;
import com.kh.yapx3.board.tip.model.vo.TipWithFileCount;

@Service
public class TipServiceImpl implements TipService {
	
	@Autowired
	TipDAO tipDAO;

	@Override
	public List<TipWithFileCount> selectTipList(int cPage) {
		return tipDAO.selectTipList(cPage);
	}

	@Override
	public int insertBoard(Tip tip, List<TipAttachment> attachList) {
		int result = tipDAO.insertBoard(tip);
		
		int boardNo = tip.getTipBoardNo();
		
		if(attachList.size() > 0) {
			for(TipAttachment a : attachList) {
				a.setBoardNo(boardNo);
				result = tipDAO.insertAttachment(a);
			}
		}
		return result;
	}

	@Override
	public TipVO selectTipOne(int tipBoardNo) {
		return tipDAO.selectTipOne(tipBoardNo);
	}

	@Override
	public int tipCommentUp(TipComment tipComment) {
		return tipDAO.tipCommentUp(tipComment);
	}

	@Override
	public int tipCommentDel(int commentNo) {
		return tipDAO.tipCommentDel(commentNo);
	}

	@Override
	public List<TipComment> selectCommentList(int tipBoardNo) {
		return tipDAO.selectCommentList(tipBoardNo);
	}

	@Override
	public List<TipWithFileCount> selectTipMyList(String memberId) {
		return tipDAO.selectTipMyList(memberId);
	}

	@Override
	public int updateTip(TipVO tip) {
		return tipDAO.updateTip(tip);
	}

	@Override
	public int selectTipTotal() {
		return tipDAO.selectTipTotal();
	}

	@Override
	public int selectCommentNumber(int tipBoardNo) {
		return tipDAO.selectCommentNumber(tipBoardNo);
	}

	@Override
	public String likeUserList(String tipboardNo) {
		return tipDAO.likeUserList(tipboardNo);
	}

	@Override
	public void likeincrease(String userEmail, String tipboardNo) {
		tipDAO.likeincrease(userEmail, tipboardNo);
	}

	@Override
	public void likeincrease2(String likeUserList, String tipboardNo) {
		tipDAO.likeincrease2(likeUserList, tipboardNo);
	}

	@Override
	public void deleteLike(String likeUserList, String tipboardNo) {
		tipDAO.deleteLike(likeUserList, tipboardNo);
	}

	@Override
	public int likeValue(String tipboardNo) {
		return tipDAO.likeValue(tipboardNo);
	}

	@Override
	public int tipDel(int tipBoardNo) {
		return tipDAO.tipDel(tipBoardNo);
	}

}
