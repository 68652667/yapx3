package com.kh.yapx3.user.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
	private int messageNo;
	private String sendUserEmail;
	private String receiveUserEmail;
	private String sendUserNickName;
	private String receiveNickName;
	private String messageTitle;
	private String messageContent;
	private Date messageDate;
	private String messageRead;
	
}
