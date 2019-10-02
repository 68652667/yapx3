package com.kh.yapx3.board.tip.model.vo;

import java.sql.Date;
import java.util.List;

public class TipVO extends Tip {
	
	private List<TipAttachment> attachList;
	
	public TipVO() {
		super();
	}

	public TipVO(int tipBoardNo, String userEmail, String tipBoardTitle, String userNickName, String tipBoardContent,
			Date tipBoardDate, int tipBoardViews, int tipBoardLike, String tipBoardLikeList, String yL,
			List<TipAttachment> attachList) {
		super(tipBoardNo, userEmail, tipBoardTitle, userNickName, tipBoardContent, tipBoardDate, tipBoardViews,
				tipBoardLike, tipBoardLikeList, yL);
		this.attachList = attachList;
	}

	public List<TipAttachment> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<TipAttachment> attachList) {
		this.attachList = attachList;
	}

	@Override
	public String toString() {
		return "{ attachList:\"" + attachList + "\", tipBoardNo:\"" + tipBoardNo + "\", userEmail:\"" + userEmail
				+ "\", tipBoardTitle:\"" + tipBoardTitle + "\", userNickName:\"" + userNickName
				+ "\", tipBoardContent:\"" + tipBoardContent + "\", tipBoardDate:\"" + tipBoardDate
				+ "\", tipBoardViews:\"" + tipBoardViews + "\", tipBoardLike:\"" + tipBoardLike
				+ "\", tipBoardLikeList:\"" + tipBoardLikeList + "\", YL:\"" + YL + "}";
	}
	
}
