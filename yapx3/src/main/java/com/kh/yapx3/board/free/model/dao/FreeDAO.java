package com.kh.yapx3.board.free.model.dao;

import java.util.List;

import com.kh.yapx3.board.free.model.vo.Free;
import com.kh.yapx3.board.free.model.vo.FreeAttachment;
import com.kh.yapx3.board.free.model.vo.FreeComment;
import com.kh.yapx3.board.free.model.vo.FreeVO;
import com.kh.yapx3.board.free.model.vo.FreeWithFileCount;

public interface FreeDAO {

	List<FreeWithFileCount> selectFreeList(int cPage);

	int insertBoard(Free free);

	int insertAttachment(FreeAttachment a);

	FreeVO selectFreeOne(int freeBoardNo);

	int freeCommentUp(FreeComment freeComment);

	List<FreeComment> selectCommentList(int freeBoardNo);

	int freeCommentDel(int commentNo);

	List<FreeWithFileCount> selectFreeMyList(String memberId);

	int updateFree(FreeVO free);

	int selectFreeTotal();

}
