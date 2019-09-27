package com.kh.yapx3.board.free.model.vo;

import java.sql.Date;
import java.util.List;

public class FreeVO extends Free {
	
	private List<FreeAttachment> attachList;
	
	public FreeVO() {
		super();
	}

	public FreeVO(int freeBoardNo, String userEmail, String freeBoardTitle, String userNickName,
			String freeBoardContent, Date freeBoardDate, int freeBoardViews, int freeBoardLike,
			String freeBoardLikeList, List<FreeAttachment> attachList) {
		super(freeBoardNo, userEmail, freeBoardTitle, userNickName, freeBoardContent, freeBoardDate, freeBoardViews,
				freeBoardLike, freeBoardLikeList);
		this.attachList = attachList;
	}
	
	public List<FreeAttachment> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<FreeAttachment> attachList) {
		this.attachList = attachList;
	}

	@Override
	public String toString() {
		return "{ attachList:\"" + attachList + "\", freeBoardNo:\"" + freeBoardNo + "\", userEmail:\"" + userEmail
				+ "\", freeBoardTitle:\"" + freeBoardTitle + "\", userNickName:\"" + userNickName
				+ "\", freeBoardContent:\"" + freeBoardContent + "\", freeBoardDate:\"" + freeBoardDate
				+ "\", freeBoardViews:\"" + freeBoardViews + "\", freeBoardLike:\"" + freeBoardLike
				+ "\", freeBoardLikeList:\"" + freeBoardLikeList + "}";
	}

	
}
