package com.kh.yapx3.user.model.vo;

import java.sql.Date;

public class Message {
	private int messageNo;
	private String sendUserEmail;
	private String receiveUserEmail;
	private String sendUserNickName;
	private String receiveUserNickName;
	private String messageTitle;
	private String messageContent;
	private Date messageDate;
	private String messageRead;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int messageNo, String sendUserEmail, String receiveUserEmail, String sendUserNickName,
			String receiveUserNickName, String messageTitle, String messageContent, Date messageDate,
			String messageRead) {
		super();
		this.messageNo = messageNo;
		this.sendUserEmail = sendUserEmail;
		this.receiveUserEmail = receiveUserEmail;
		this.sendUserNickName = sendUserNickName;
		this.receiveUserNickName = receiveUserNickName;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.messageDate = messageDate;
		this.messageRead = messageRead;
	}
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public String getSendUserEmail() {
		return sendUserEmail;
	}
	public void setSendUserEmail(String sendUserEmail) {
		this.sendUserEmail = sendUserEmail;
	}
	public String getReceiveUserEmail() {
		return receiveUserEmail;
	}
	public void setReceiveUserEmail(String receiveUserEmail) {
		this.receiveUserEmail = receiveUserEmail;
	}
	public String getSendUserNickName() {
		return sendUserNickName;
	}
	public void setSendUserNickName(String sendUserNickName) {
		this.sendUserNickName = sendUserNickName;
	}
	public String getReceiveUserNickName() {
		return receiveUserNickName;
	}
	public void setReceiveUserNickName(String receiveUserNickName) {
		this.receiveUserNickName = receiveUserNickName;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public String getMessageRead() {
		return messageRead;
	}
	public void setMessageRead(String messageRead) {
		this.messageRead = messageRead;
	}
	
	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", sendUserEmail=" + sendUserEmail + ", receiveUserEmail="
				+ receiveUserEmail + ", sendUserNickName=" + sendUserNickName + ", receiveUserNickName="
				+ receiveUserNickName + ", messageTitle=" + messageTitle + ", messageContent=" + messageContent
				+ ", messageDate=" + messageDate + ", messageRead=" + messageRead + "]";
	}
	
}
