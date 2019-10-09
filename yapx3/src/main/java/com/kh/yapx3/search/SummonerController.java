package com.kh.yapx3.search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;


@Controller
@RequestMapping("/summoner")
public class SummonerController {
		
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String ApiKey = "RGAPI-b0f1c9f8-bc6b-48c9-bd2d-e303c45548ff";
	
	@GetMapping("/summonerSearch.do")
	public void Search() {
		
	}
	@GetMapping("/search")
	public void summonerSearch( HttpServletRequest request,
								HttpServletResponse response) {
		
		String searchName = request.getParameter("summonerName").replaceAll(" ","%20");
		
		String key = "RGAPI-b0f1c9f8-bc6b-48c9-bd2d-e303c45548ff";
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + searchName + "?api_key=" + ApiKey;
		
		try {
			URL url = new URL( urlStr );
			BufferedReader br = new BufferedReader( 
						new InputStreamReader( url.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			
			JSONObject jobj = new JSONObject( sb.toString() );
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jobj.toString());
			
			
		} catch ( Exception e ) {
			e.printStackTrace();
			logger.info("없는 아이디입니다.");

			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().append("noneId");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	@GetMapping("/league")
	public void league( HttpServletRequest request,
						HttpServletResponse response) {
		String summonerId = request.getParameter("summonerId");
		logger.debug( summonerId );
		String key = "RGAPI-b0f1c9f8-bc6b-48c9-bd2d-e303c45548ff";
		String urlStr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId + "?api_key=" + ApiKey;
		logger.debug( urlStr );
		try {
			URL url = new URL( urlStr );
			BufferedReader br = new BufferedReader
					( new InputStreamReader( url.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			
			JSONArray jobj = new JSONArray( sb.toString() );
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jobj.toString());
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/champion")
	public void champion( HttpServletRequest request,
						  HttpServletResponse response) {

		String key = "RGAPI-b0f1c9f8-bc6b-48c9-bd2d-e303c45548ff";
		String urlStr = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=" + ApiKey;
		String urlStr2 = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/en_US/champion.json";
		try {
			URL url = new URL( urlStr );
			BufferedReader br = new BufferedReader
					( new InputStreamReader( url.openConnection().getInputStream() ) );
			
			URL url2 = new URL( urlStr2 );
			BufferedReader br2 = new BufferedReader
					( new InputStreamReader( url2.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			String sb2 = br2.readLine();
			
			logger.debug( sb );

			JSONObject jobj = new JSONObject( sb.toString() );
			JSONObject jobj2 = new JSONObject( sb2.toString() );
			
			JSONArray jar = (JSONArray)jobj.get("freeChampionIds");
			JSONObject dataObject = jobj2.getJSONObject("data");
			
			logger.debug( dataObject.toString() );

			Iterator num = dataObject.keys();
			
			List<String> list = new ArrayList<String>();
			
			while( num.hasNext() ) {
				String dataKey = num.next().toString();
				
				JSONObject data = dataObject.getJSONObject( dataKey );
				JSONObject data_ = data.getJSONObject("image");
				String img = data_.getString("full");
				
				String championKey = data.getString( "key" );
				
				for( int i = 0; i < jar.length(); i++ ) {
					String chap = jar.get(i).toString();
					if( championKey.equals( chap ) ) {
						list.add( img );
					}
				}
			}
			
			System.out.println( list.toString() );
			
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(list, response.getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/spectator")
	public void spectator (HttpServletRequest request,
						  HttpServletResponse response) {
		
		String key = "RGAPI-b0f1c9f8-bc6b-48c9-bd2d-e303c45548ff";
		String summonerId = request.getParameter("summonerId");
		String urlStr = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"+summonerId+"?api_key="+ApiKey;
		
		try {
			
			URL url = new URL(urlStr);
			
			BufferedReader br = new BufferedReader
					( new InputStreamReader( url.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			
			JSONObject jobj = new JSONObject( sb.toString() );
			
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jobj.toString());
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
