package com.kh.yapx3.board.free.model.vo;

import java.sql.Date;

public class FreeWithFileCount extends Free{

	private int fileCount;
	
	public FreeWithFileCount() {
		super();
	}

	public FreeWithFileCount(int freeBoardNo, String userEmail, String freeBoardTitle, String userNickName,
			String freeBoardContent, Date freeBoardDate, int freeBoardViews, int freeBoardLike,
			String freeBoardLikeList, int fileCount) {
		super(freeBoardNo, userEmail, freeBoardTitle, userNickName, freeBoardContent, freeBoardDate, freeBoardViews,
				freeBoardLike, freeBoardLikeList);
		this.fileCount = fileCount;
	}
	
	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	@Override
	public String toString() {
		return "{ fileCount:\"" + fileCount + "\", freeBoardNo:\"" + freeBoardNo + "\", userEmail:\"" + userEmail
				+ "\", freeBoardTitle:\"" + freeBoardTitle + "\", userNickName:\"" + userNickName
				+ "\", freeBoardContent:\"" + freeBoardContent + "\", freeBoardDate:\"" + freeBoardDate
				+ "\", freeBoardViews:\"" + freeBoardViews + "\", freeBoardLike:\"" + freeBoardLike
				+ "\", freeBoardLikeList:\"" + freeBoardLikeList + "}";
	}
	
}
