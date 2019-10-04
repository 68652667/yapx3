package com.kh.yapx3.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.yapx3.common.util.CreateRandomString;
import com.kh.yapx3.user.mail.GmailSend;
import com.kh.yapx3.user.model.service.MemberService;
import com.kh.yapx3.user.model.vo.Member;

@RequestMapping( "/user" )
@Controller
@SessionAttributes( { "memberLoggedIn" } )
public class MemberController {

	@Autowired
	MemberService ms;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	CreateRandomString crs = new CreateRandomString();
	
	Logger logger = LoggerFactory.getLogger( getClass() );
	
	
	@RequestMapping( "/loginClick.do" )
	public String loginClick() {
		logger.info( "loginClick" );
		
		return "user/loginClick";
	}
	
	@RequestMapping( "/findPW.do" )
	public String findPW() {
		logger.info( "findPW" );
		
		return "user/findPW";
	}
	
	@RequestMapping( "/findPWEnd.do" )
	public String findPWEnd(Member member,
							Model m ) {
		logger.info( "findPWEnd" );
		
		Member serchMember = ms.selectOneMember( member.getUserEmail() );
		
		String password = crs.create( 6 );
		String encodedPassword = passwordEncoder.encode( password );
		serchMember.setUserPassword( encodedPassword );
		
		
		int result = ms.updateMember( serchMember );
		
		new GmailSend().GmailSet( serchMember.getUserEmail(), "reset password", password );
		
		
		//2.view단처리
		m.addAttribute( "msg", result>0?"비밀번호 신규발급 성공!":"비밀번호 신규발급 실패!" );
		m.addAttribute( "loc", "/" );
		return "common/msg";
	}
	
	@RequestMapping( "/loginForm.do" )
	public String loginForm() {
		logger.info( "loginForm" );
		return "user/loginForm";
	}
	
	@RequestMapping( "/loginFormEnd.do" )
	public String loginFormEnd( Member member,
								Model m ) {
		logger.debug( "회원가입 처리요청" );
		//0.비밀번호 암호화
		String rawPassword = member.getUserPassword();
		logger.debug( "암호화전 : " + rawPassword );
		String encodedPassword = passwordEncoder.encode(rawPassword);
		logger.debug( "암호화후 : " + encodedPassword );
		//member객체 대입
		member.setUserPassword(encodedPassword);
		//1.비지니스로직
		logger.debug( "member@memberEnrollEnd = " + member );
		int result = ms.updateMember( member );
		
		//2.view단처리
		if( result == 1 ) {
			m.addAttribute( "msg", "회원가입성공!" );
		}else if( result == -2147482646 ) {
			m.addAttribute( "msg", "회원가입성공!" );
		}else {
			m.addAttribute( "msg", "회원가입실패!" );
		}
		
		m.addAttribute( "loc", "/" );
		return "common/msg";
	}
	
	@RequestMapping( "/logoutClick.do" )
	public String memberLogout( SessionStatus sessionStatus ) {
		logger.debug( "로그아웃 요청" );
		if( !sessionStatus.isComplete() ) {
			sessionStatus.setComplete();
		}
		
		return "redirect:/";
	}
	
	@RequestMapping( "/loginCheck.do" )
	public String loginCheck( @RequestParam String memberId,
							  @RequestParam String password,
							  Model m ){
		//1.업무로직: 회원정보 가져오기
		Member member = ms.selectOneMember( memberId );
		
		String msg = "";
		String loc = "/";
		
		//1-1.아이디가 존재하지 않는 경우
		if( member == null ) {
			msg = "아이디가 존재하지 않습니다.";
			loc = "/user/loginClick.do";
			
		}
		else {
			//1-2.로그인 성공
			if( passwordEncoder.matches( password, member.getUserPassword() ) ) {
				msg = "로그인 성공!";
				//memberLoggedIn 세션 속성에 지정
				//model에 지정된 속성은 requestScope속성에 담김
				
				m.addAttribute( "memberLoggedIn", member );
			}
			//1-3.비밀번호가 틀린 경우
			else {
				msg = "비밀번호가 틀립니다.";
				loc = "/user/loginClick.do";
			}
		}
		
		//2. view단 처리
		m.addAttribute( "msg", msg );
		m.addAttribute( "loc", loc );
		return "common/msg";
	}
	
	@ResponseBody
	@RequestMapping( "/checkIdDuplicate.do" )
	public Map<String,Object> checkIdDuplicate(@RequestParam String memberId ) {
		boolean isUsable = false;
		Member serchMember = ms.selectOneMember( memberId );
		if( serchMember == null ) {
			isUsable = false;
		}else {
			
			if( serchMember.getUserPassword() == null ) {
				isUsable = false;
			}else {
				logger.info("serchMember.getUserPassword().length()={}", serchMember.getUserPassword().length());
				if( serchMember.getUserPassword().length() > 30 ) {
					isUsable = true;
				}else {
					isUsable = false;
				}
			}
				
		}
		
		
		Map<String,Object> map = new HashMap<>();
		map.put( "isUsable", isUsable);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping( "/sendEmail.do" )
	public int sendEmail( @RequestParam String memberId,
							Model m ) {
		logger.info( "sendEmail:memberId={}", memberId );
		
		Member serchMember = ms.selectOneMember( memberId );
		
		String activeKey = crs.create( 30 );
		
		Member member = new Member();
		member.setUserEmail(memberId);
		member.setUserActivationKey(activeKey);
		int result = 0;
		
		if( serchMember == null ) {
			result = ms.insertMember( member );
		}else {
			logger.info( "sendEmail:serchMember.getUserPassword()={}", serchMember.getUserPassword() );
			
			if( serchMember.getUserPassword() == null ) {
				result = ms.updateMember( member );
			}else {
				if( serchMember.getUserPassword().length() == 30 ) {
					result = -10;
				}else {
					result = ms.updateMember( member );
				}
			}
				
		}
		logger.info( "result={}" , result );
		if( result < 1 ) {
			if( result == -2147482646 ) {
				new GmailSend().GmailSet( memberId, "activeKey", activeKey );
			}
		}else {
			new GmailSend().GmailSet( memberId, "activeKey", activeKey );
		}
		
		return result;
	}
	
	
	@RequestMapping( "/updatePasswordEnd.do" )
	public String updatePasswordEnd( @RequestParam String memberId,
									 @RequestParam String password,
									 @RequestParam String password_new,
									 Model m ) {
		
		logger.info( "updatePasswordEnd memberId = {}", memberId );
		//1.업무로직: 회원정보 가져오기
		Member member = ms.selectOneMember( memberId );
		
		String msg = "";
		String loc = "/user/updatePassword?memberId="+memberId;
		logger.info( "updatePasswordEnd member = {}", member );
		
		//1-2.로그인 성공
		if( passwordEncoder.matches( password, member.getUserPassword() ) ) {
			
			String encodedPassword = passwordEncoder.encode( password_new );
			logger.debug( "암호화후 : " + encodedPassword );
			//member객체 대입
			member.setUserPassword(encodedPassword);
			
			int result = ms.updateMember( member );
			
			if( result == 1 ) {
				msg = "비밀번호가 변경되었습니다.";
			}else {
				msg = "비밀번호변경중 오류가 발생했습니다.";
			}
		}
		//1-3.비밀번호가 틀린 경우
		else {
			msg = "비밀번호가 틀립니다.";
			
		}
		
		
		//2. view단 처리
		m.addAttribute( "msg", msg );
		m.addAttribute( "loc", loc );

		
		return "common/msg";
	}
	
	@RequestMapping( "/updatePassword" )
	public String updatePassword( @RequestParam String memberId,
								  Model m ) {
		logger.info( "pass memberId = {}", memberId );
		m.addAttribute( "memberId", memberId );
		return "user/updatePassword";
	}
	
	@ResponseBody
	@RequestMapping( "/activeCheck.do" )
	public int activeCheck( @RequestParam String memberId,
							@RequestParam String activeKey,
							Model m ) {
		int result = 0;
		Member serchMember = ms.selectOneMember( memberId );
		
		if( serchMember.getUserActivationKey().equals(activeKey)) {
			result = 1;
		}else {
			result = 0;
		}
		
		
		return result;
		
	}
}
