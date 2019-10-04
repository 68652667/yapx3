package com.kh.yapx3.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;


@Controller
@RequestMapping("/summoner")
public class ChampionController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/championSearch.do")
	public void champion() {
		
	}
	
	@RequestMapping("/championAll")
	public void championAll( HttpServletRequest request, 
							 HttpServletResponse response ) {
		
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		
		try {
			URL url = new URL( urlStr );
			
			BufferedReader br = new BufferedReader
					( new InputStreamReader( url.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			
			JSONObject jobj = new JSONObject( sb.toString() );
			JSONObject dataObject = jobj.getJSONObject("data");
			
			Iterator num = dataObject.keys();
			
			List<String> list = new ArrayList<String>();
			
			while( num.hasNext() ) {
				String dataKey = num.next().toString();
				
				JSONObject data = dataObject.getJSONObject( dataKey );
				
				JSONObject championImage = data.getJSONObject("image");
				
				String img = championImage.getString("full");
				
				String championKey = data.getString("key");
				
				list.add( img );
			}
			
			response.setCharacterEncoding("utf-8");
			
			new Gson().toJson(list, response.getWriter());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
