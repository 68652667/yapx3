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
public class Member {
	
	private String userEmail;
	private String userNickname;
	private int userCode;
	private String userActivationKey;
	private String userPassword;
	private Date userEnrollDate;
	private String favoriteSummoner;
	private String favoriteChampion;
	
}
