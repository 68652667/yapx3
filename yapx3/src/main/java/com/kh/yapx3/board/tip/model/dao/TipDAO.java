package com.kh.yapx3.board.tip.model.dao;

import java.util.List;

import com.kh.yapx3.board.tip.model.vo.Tip;
import com.kh.yapx3.board.tip.model.vo.TipAttachment;
import com.kh.yapx3.board.tip.model.vo.TipComment;
import com.kh.yapx3.board.tip.model.vo.TipVO;
import com.kh.yapx3.board.tip.model.vo.TipWithFileCount;

public interface TipDAO {

	List<TipWithFileCount> selectTipList(int cPage);

	int insertBoard(Tip free);

	int insertAttachment(TipAttachment a);

	TipVO selectTipOne(int tipBoardNo);

	int tipCommentUp(TipComment tipComment);

	List<TipComment> selectCommentList(int tipBoardNo);

	int tipCommentDel(int commentNo);

}