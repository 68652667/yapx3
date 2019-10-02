package com.kh.yapx3.board.tip.model.vo;

import java.sql.Date;

public class TipAttachment {
	
	private int AttachmentNo;
	private int boardNo;
	private String originalFileName;
	private String renamedFileName;
	private Date uploadDate;
	
	public TipAttachment() {}

	public int getAttachmentNo() {
		return AttachmentNo;
	}

	public void setAttachmentNo(int attachmentNo) {
		AttachmentNo = attachmentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenamedFileName() {
		return renamedFileName;
	}

	public void setRenamedFileName(String renamedFileName) {
		this.renamedFileName = renamedFileName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public TipAttachment(int attachmentNo, int boardNo, String originalFileName, String renamedFileName,
			Date uploadDate) {
		super();
		AttachmentNo = attachmentNo;
		this.boardNo = boardNo;
		this.originalFileName = originalFileName;
		this.renamedFileName = renamedFileName;
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "{ AttachmentNo:\"" + AttachmentNo + "\", boardNo:\"" + boardNo + "\", originalFileName:\""
				+ originalFileName + "\", renamedFileName:\"" + renamedFileName + "\", uploadDate:\"" + uploadDate
				+ "}";
	}
	
	
	
}
