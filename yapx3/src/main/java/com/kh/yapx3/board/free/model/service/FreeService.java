package com.kh.yapx3.board.free.model.service;

import java.util.List;

import com.kh.yapx3.board.free.model.vo.Free;
import com.kh.yapx3.board.free.model.vo.FreeAttachment;
import com.kh.yapx3.board.free.model.vo.FreeComment;
import com.kh.yapx3.board.free.model.vo.FreeVO;
import com.kh.yapx3.board.free.model.vo.FreeWithFileCount;

public interface FreeService {

	int NUM_PER_PAGE = 10;
	
	List<FreeWithFileCount> selectFreeList(int cPage);

	int insertBoard(Free free, List<FreeAttachment> attachList);

	FreeVO selectFreeOne(int freeBoardNo);

	int freeCommentUp(FreeComment freeComment);

	List<FreeComment> selectCommentList(int freeBoardNo);

	int freeCommentDel(int commentNo);

	List<FreeWithFileCount> selectFreeMyList(String memberId);

	int updateFree(FreeVO free);

	int selectFreeTotal();

}
