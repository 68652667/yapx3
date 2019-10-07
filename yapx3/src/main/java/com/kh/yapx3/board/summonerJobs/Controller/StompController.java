package com.kh.yapx3.board.summonerJobs.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.kh.yapx3.user.model.vo.Member;
import com.kh.yapx3.board.summonerJobs.model.service.StompService;
import com.kh.yapx3.board.summonerJobs.model.vo.summonerJobsChatRoom;

@Controller
@RequestMapping("/board")
public class StompController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	StompService stompService;
	
	//전체 채팅방 목록이 보인다
	@RequestMapping("/viewRoom.do")
	public ModelAndView viewRoom( ModelAndView mav, HttpSession session,
								  @SessionAttribute(value="memberLoggedIn", required=false) 
								  Member memberLoggedIn) {
		List<summonerJobsChatRoom> rlist = stompService.viewRoom();
		mav.addObject( "rlist", rlist);
		mav.setViewName("board/summonerJobs/viewRoom");
		return mav;
	}
	//채팅방 생성
	@ResponseBody
	@RequestMapping("/createRoomCheck.do")
	public int createRoomCheck( @RequestParam("userId") String userId ) {
		
		logger.info( "userId={}", userId );
		
		int result = stompService.selectUserId( userId );

		return result;
	}
	
	@RequestMapping("/createRoom.do")
	public String createRoom() {
		return "board/summonerJobs/createRoom";
	}
	
	
	@RequestMapping("/createRoomEnd.do")
	public String createRoomEnd( @ModelAttribute("chatRoom") summonerJobsChatRoom chatRoom,
			Model model ) {
		
		logger.info( "createchatRoom={}", chatRoom );
		
		int result = stompService.createRoom( chatRoom );
		
		logger.info( "result={}", result );
		
		summonerJobsChatRoom robiRoom = stompService.findUserEmail( chatRoom.getUserEmail() );
		
		logger.info( "robiRoom={}", robiRoom );
		
		model.addAttribute( "robiRoom", robiRoom);
		model.addAttribute("msg", result > 0 ? " 방 생성 성공 !!" : " 방 생성 실패 !!");
		model.addAttribute("loc", "/board/robi.do?roomId=" + robiRoom.getRoomId() + "&summonerName=" + robiRoom.getSummonerNickname());
		
		return "common/msg";
	}
	@ResponseBody
	@RequestMapping("/selectRobi.do")
	public Map<String, String> selectRobi( HttpSession session,
							@RequestParam("boardNo") int boardNo,
							
							@RequestParam("summonerName") String summonerName
							) {
		
		logger.info( "boarNoSelectRobi={}", boardNo );
		
		summonerJobsChatRoom robiRoom = stompService.selectRoom( boardNo );
		logger.info( "robiRoom={}", robiRoom );
		logger.info( "robiRoom.getChatContent()={}", robiRoom.getChatContent() );
		
		if( robiRoom.getChatContent() == null ) {
			robiRoom.setChatContent( summonerName );
		}else {
			robiRoom.setChatContent( robiRoom.getChatContent() + "." +  summonerName ); 
		}
		
		logger.info( "robiRoomSelectRobi={}", robiRoom );
		
		int result = stompService.updateRoom( robiRoom );
		
		logger.info( "resultupdateRoom={}", result );
		
		logger.info( "robiRoomSelectRobi={}", robiRoom );
		
		Map<String, String> map = new HashMap<>();
		
		map.put( "robiRoom", robiRoom.getRoomId() );
		map.put( "summonerName", summonerName );
		
		logger.info("===========================================.");
		return map;
	}

	//채팅방 들어가기
	@RequestMapping("/robi.do")
	public ModelAndView visitRoom( ModelAndView mav, HttpSession session,
								   @RequestParam String roomId,
								   @RequestParam String summonerName) {
		logger.info("방을들어간다 !!");
		logger.info("roomId={}", roomId);
		logger.info("summonerName={}", summonerName);
		List<summonerJobsChatRoom> rlist = stompService.visitRoom( roomId );
		
		mav.addObject( "rlist", rlist);
		mav.addObject( "summonerName", summonerName);
		mav.setViewName("board/summonerJobs/robi");
		
		return mav;
	}
	
	//채팅방 인원수 체크
	@ResponseBody
	@RequestMapping("/checkBoardNo.do")
	public int checkBoardNo( @RequestParam("roomId") String roomId ) {
		
		int result = stompService.checkBoardNo( roomId );
		
		return result;
	}

	//채팅방 인원수 증가
	@ResponseBody
	@RequestMapping("/boardPersonnelNo.do")
	public int boardPersonnelNo( @RequestParam("roomId") String roomId ) {
		
		logger.info( "boardRoomId={}", roomId );
		
		int result = stompService.boardPersonnelNo( roomId );
		
		if( result > 0 ) {
			List<summonerJobsChatRoom> rlist = stompService.visitRoom( roomId );
			
			summonerJobsChatRoom sjc = (summonerJobsChatRoom)rlist.get( 0 );
			
			logger.info( "boardsjc={}", sjc );
			
			result = sjc.getBoardPersonnelNo();
		}
		return result;
	}
	//채팅방 나가기
	@ResponseBody
	@RequestMapping("/outRoom.do")
	public int outRoom( @RequestParam("roomId") String roomId) {
		logger.info( "outRoomroomId={}", roomId );
		
		int result = stompService.outRoomboardPersonnelNo( roomId );
		
		if( result > 0 ) {
			List<summonerJobsChatRoom> rlist = stompService.visitRoom( roomId );
			
			summonerJobsChatRoom sjc = (summonerJobsChatRoom)rlist.get( 0 );
			
			logger.info( "boardsjc={}", sjc );
			
			result = sjc.getBoardPersonnelNo();
		}
		
		
		return result;
	}
	
	//채팅방 삭제하기
	@ResponseBody
	@RequestMapping("/deleteRoom.do")
	public int deleteRoom( @RequestParam("roomId") String roomId) {
		
		logger.info( "outRoomroomId={}", roomId );
		
		int result = stompService.deleteRoom( roomId );
		
		logger.info("result={}", result);
		
		return result;
	}
}
