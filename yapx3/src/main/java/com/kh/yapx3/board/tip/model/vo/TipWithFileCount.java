package com.kh.yapx3.board.tip.model.vo;

import java.sql.Date;

public class TipWithFileCount extends Tip{

	private int fileCount;
	
	public TipWithFileCount() {
		super();
	}
	
	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	public TipWithFileCount(int tipBoardNo, String userEmail, String tipBoardTitle, String userNickName,
			String tipBoardContent, Date tipBoardDate, int tipBoardViews, int tipBoardLike, String tipBoardLikeList,
			String yL, int fileCount) {
		super(tipBoardNo, userEmail, tipBoardTitle, userNickName, tipBoardContent, tipBoardDate, tipBoardViews,
				tipBoardLike, tipBoardLikeList, yL);
		this.fileCount = fileCount;
	}

	@Override
	public String toString() {
		return "{ fileCount:\"" + fileCount + "\", tipBoardNo:\"" + tipBoardNo + "\", userEmail:\"" + userEmail
				+ "\", tipBoardTitle:\"" + tipBoardTitle + "\", userNickName:\"" + userNickName
				+ "\", tipBoardContent:\"" + tipBoardContent + "\", tipBoardDate:\"" + tipBoardDate
				+ "\", tipBoardViews:\"" + tipBoardViews + "\", tipBoardLike:\"" + tipBoardLike
				+ "\", tipBoardLikeList:\"" + tipBoardLikeList + "\", YL:\"" + YL + "}";
	}
	
}
