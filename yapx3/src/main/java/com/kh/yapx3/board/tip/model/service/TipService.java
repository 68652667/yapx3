package com.kh.yapx3.board.tip.model.service;

import java.util.List;

import com.kh.yapx3.board.tip.model.vo.Tip;
import com.kh.yapx3.board.tip.model.vo.TipAttachment;
import com.kh.yapx3.board.tip.model.vo.TipComment;
import com.kh.yapx3.board.tip.model.vo.TipVO;
import com.kh.yapx3.board.tip.model.vo.TipWithFileCount;

public interface TipService {

	int NUM_PER_PAGE = 10;
	
	List<TipWithFileCount> selectTipList(int cPage);

	int insertBoard(Tip tip, List<TipAttachment> attachList);

	TipVO selectTipOne(int tipBoardNo);

	int tipCommentUp(TipComment tipComment);

	List<TipComment> selectCommentList(int tipBoardNo);

	int tipCommentDel(int commentNo);

	List<TipWithFileCount> selectTipMyList(String memberId);
	
	int updateTip(TipVO tip);

	int selectTipTotal();

}
