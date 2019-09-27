package com.kh.yapx3.user.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author young
 *
 */
public class MyAuthentication extends Authenticator {

	PasswordAuthentication pa;

	public MyAuthentication() { // 생성자를 통해 구글 ID/PW 인증

		String id = "pitipipi"; // 구글 ID
		String pw = "reilove12"; // 구글 비밀번호

		// ID와 비밀번호를 입력한다.
		pa = new PasswordAuthentication(id, pw);
	}

	// 시스템에서 사용하는 인증정보
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}

}
