package com.kh.yapx3.match.model.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.service.ChampValue;
import com.kh.yapx3.match.common.URLConnection;
import com.kh.yapx3.match.model.dao.MatchDAO;
import com.kh.yapx3.match.model.gamelist.MatchGameList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class MatchServiceImpl implements MatchService {
	Logger logger = LoggerFactory.getLogger(getClass());

	int cnt;
	int sqlFileNameCount = 36;
	int sqlCount = 0;
	String championNameStr;

	@Autowired
	MatchDAO matchDAO;

	JSONArray participantDataAll;

	Map<String, Integer> championMap = new HashMap<String, Integer>();
	Map<String, Integer> championKON;

	List<String> championName;
	List<Integer> championKey;
	List<String> keyList = new ArrayList<String>();
	
	URLConnection connection;

	public List<JSONObject> itemLits() {
		List<JSONObject> jobj = matchDAO.mybatisTest(keyList);
		for (int i = 0; i < jobj.size(); i++) {
			logger.info("jobj:" + jobj.get(i));
		}
		return jobj;
	}

	// 모든 챔피언의 리스트를 가져온다(가,나,다 순)
	public Map<String, Integer> championAll() {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity,
				ChampionAll.class);

		Map<String, Integer> championKON = new HashMap<String, Integer>();
		championName = new ArrayList<String>();
		championKey = new ArrayList<Integer>();

		for (Map.Entry<String, ChampValue> champ : championAll.getBody().getData().entrySet()) {
			championKON.put(champ.getValue().getName(), champ.getValue().getKey());
			championName.add(champ.getValue().getName());
			championKey.add(champ.getValue().getKey());
		}

//		matchDAO.championInsert(championName, championKey);

		return championKON;
	}

	// ojdbc 버젼
	public JSONArray participantDataFor(int i, int id) {
		List<String> insertList = new ArrayList<String>();
		String sql = "";
		for (int j = 0; j < participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1)).size(); j++) {
			logger.info("---------------------participant" + (i) + "---------------------");
			JSONObject participantDataAllStr = participantDataAll.getJSONObject(i + 1).getJSONArray("participant" + (i + 1))
					.getJSONObject(j);
			String participantid = participantDataAllStr.getString("participantId").toString();
			insertList.add(participantid);
			String teamid = participantDataAllStr.getString("teamId").toString();
			insertList.add(teamid);
			String championid = participantDataAllStr.getString("championId").toString();
			insertList.add(championid);
			String spell1Id = "";
			String spell2Id = "";
			// 소환사 주문을 가져오는 for문
			for (int k = 0; k < 2; k++) {
				if (k == 0) {
					spell1Id = participantDataAllStr.getString("spell" + (k + 1) + "Id").toString();
					insertList.add(spell1Id);
				} else {
					spell2Id = participantDataAllStr.getString("spell" + (k + 1) + "Id").toString();
					insertList.add(spell2Id);
				}
				logger.info("spell: " + participantDataAllStr.getString("spell" + (k + 1) + "Id"));
			}
			String win = participantDataAllStr.getString("win").toString();
			insertList.add(win);
			String item0 = "";
			String item1 = "";
			String item2 = "";
			String item3 = "";
			String item4 = "";
			String item5 = "";
			String item6 = "";
			// 아이템 가져오는 for문
			for (int k = 0; k < 7; k++) {
				switch (k) {
				case 0:
					logger.info(participantDataAllStr.getString("item" + k).toString());
					item0 = participantDataAllStr.getString("item" + k).toString();
					insertList.add(item0);
					break;
				case 1:
					logger.info(participantDataAllStr.getString("item" + k).toString());
					item1 = participantDataAllStr.getString("item" + k).toString();
					insertList.add(item1);
					break;
				case 2:
					logger.info(participantDataAllStr.getString("item" + k).toString());
					item2 = participantDataAllStr.getString("item" + k).toString();
					insertList.add(item2);
					break;
				case 3:
					logger.info(participantDataAllStr.getString("item" + k).toString());
					item3 = participantDataAllStr.getString("item" + k).toString();
					insertList.add(item3);
					break;
				case 4:
					logger.info(participantDataAllStr.getString("item" + k).toString());
					item4 = participantDataAllStr.getString("item" + k).toString();
					insertList.add(item4);
					break;
				case 5:
					logger.info(participantDataAllStr.getString("item" + k).toString());
					item5 = participantDataAllStr.getString("item" + k).toString();
					insertList.add(item5);
					break;
				case 6:
					logger.info(participantDataAllStr.getString("item" + k).toString());
					item6 = participantDataAllStr.getString("item" + k).toString();
					insertList.add(item6);
					break;
				default:
					break;

				}
			}

			String kills = participantDataAllStr.getString("kills").toString();
			insertList.add(kills);
			
			String deaths = participantDataAllStr.getString("deaths").toString();
			insertList.add(deaths);
			
			String largestMultiKill = participantDataAllStr.getString("largestMultiKill").toString();
			insertList.add(largestMultiKill);
			
			String totalDamageDealtToChampions = participantDataAllStr.getString("totalDamageDealtToChampions").toString();
			insertList.add(totalDamageDealtToChampions);
			
			String goldEarned = participantDataAllStr.getString("goldEarned").toString();
			insertList.add(goldEarned);
			
			String totalMinionsKilled = participantDataAllStr.getString("totalMinionsKilled").toString();
			insertList.add(totalMinionsKilled);
			
			String champLevel = participantDataAllStr.getString("champLevel").toString();
			insertList.add(champLevel);
			
			String perk0 = "";
			String perk0Var1 = "";
			String perk0Var2 = "";
			String perk0Var3 = "";
			String perk1 = "";
			String perk1Var1 = "";
			String perk1Var2 = "";
			String perk1Var3 = "";
			String perk2 = "";
			String perk2Var1 = "";
			String perk2Var2 = "";
			String perk2Var3 = "";
			String perk3 = "";
			String perk3Var1 = "";
			String perk3Var2 = "";
			String perk3Var3 = "";
			String perk4 = "";
			String perk4Var1 = "";
			String perk4Var2 = "";
			String perk4Var3 = "";
			String perk5 = "";
			String perk5Var1 = "";
			String perk5Var2 = "";
			String perk5Var3 = "";
			// 룬을 가져오는 for문
			for (int k = 0; k < 6; k++) {
				switch (k) {
				case 0:
					perk0 = participantDataAllStr.getString("perk" + k).toString();
					insertList.add(perk0);
					for (int l = 1; l < 4; l++) {
						switch (l) {
						case 1:
							perk0Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk0Var1);
							break;
						case 2:
							perk0Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk0Var2);
							break;
						case 3:
							perk0Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk0Var3);
							break;
						default:
							break;
						}
					}

				case 1:
					perk1 = participantDataAllStr.getString("perk" + k).toString();
					insertList.add(perk1);
					for (int l = 1; l < 4; l++) {
						switch (l) {
						case 1:
							perk1Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk1Var1);
							break;
						case 2:
							perk1Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk1Var2);
							break;
						case 3:
							perk1Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk1Var3);
							break;
						default:
							break;
						}

					}

				case 2:
					perk2 = participantDataAllStr.getString("perk" + k).toString();
					insertList.add(perk2);
					for (int l = 1; l < 4; l++) {
						switch (l) {
						case 1:
							perk2Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk2Var1);
							break;
						case 2:
							perk2Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk2Var2);
							break;
						case 3:
							perk2Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk2Var3);
							break;
						default:
							break;
						}

					}

				case 3:
					perk3 = participantDataAllStr.getString("perk" + k).toString();
					insertList.add(perk3);
					for (int l = 1; l < 4; l++) {
						switch (l) {
						case 1:
							perk3Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk3Var1);
							break;
						case 2:
							perk3Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk3Var1);
							break;
						case 3:
							perk3Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk3Var1);
							break;
						default:
							break;
						}

					}

				case 4:
					perk4 = participantDataAllStr.getString("perk" + k).toString();
					insertList.add(perk4);
					for (int l = 1; l < 4; l++) {
						switch (l) {
						case 1:
							perk4Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk4Var1);
							break;
						case 2:
							perk4Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk4Var2);
							break;
						case 3:
							perk4Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk4Var3);
							break;
						default:
							break;
						}

					}

				case 5:
					perk5 = participantDataAllStr.getString("perk" + k).toString();
					insertList.add(perk5);
					for (int l = 1; l < 4; l++) {
						switch (l) {
						case 1:
							perk5Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk5Var1);
							break;
						case 2:
							perk5Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk5Var2);
							break;
						case 3:
							perk5Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
							insertList.add(perk5Var3);
							break;
						default:
							break;
						}

					}
				}
			}
			String perkPrimaryStyle = participantDataAllStr.getString("perkPrimaryStyle").toString();
			insertList.add(perkPrimaryStyle);
			String perkSubStyle = participantDataAllStr.getString("perkSubStyle").toString();
			insertList.add(perkSubStyle);
			String statPerk0 = "";
			String statPerk1 = "";
			String statPerk2 = "";
			for(int k = 0; k < 3; k++) {
				switch (k) {
				case 0:statPerk0 = participantDataAllStr.getString("statPerk0").toString();insertList.add(statPerk0);break;
				case 1:statPerk1 = participantDataAllStr.getString("statPerk1").toString();insertList.add(statPerk1);break;
				case 2:statPerk2 = participantDataAllStr.getString("statPerk2").toString();insertList.add(statPerk2);break;
				default:break;
				}
			}
			String lane = participantDataAllStr.getString("lane").toString();
			insertList.add(lane);
			
			String summonerName = participantDataAllStr.getString("summonerName").toString();
			insertList.add(summonerName);
			
			String timestamp = participantDataAllStr.getString("timestamp").toString();
			insertList.add(timestamp);
			
			String type = participantDataAllStr.getString("type").toString();
			insertList.add(type);
			
			String afterId = participantDataAllStr.getString("afterId").toString();
			insertList.add(afterId);
			
			String levelUpType = participantDataAllStr.getString("levelUpType").toString();
			insertList.add(levelUpType);
			
			String skillSlot = participantDataAllStr.getString("skillSlot").toString();
			insertList.add(skillSlot);
			
			
			sql = "insert into participantall (datano, participantid, teamid, championid, spell1id, spell2id, win, item0, item1, item2, item3, item4, item5, item6, "
					+ "kills, deaths, assists, largestmultikill, totaldamagedealttochampions, goldearned, totalminionskilled, champlevel, perk0, perk0var1, perk0var2, perk0var3, "
					+ "perk1, perk1var1, perk1var2, perk1var3, perk2, perk2var1, perk2var2, perk2var3, perk3, perk3var1, perk3var2, perk3var3, perk4, perk4var1, perk4var2, perk4var3,"
					+ "perk5, perk5var1, perk5var2, perk5var3, perkprimarystyle, perksubstyle, statperk0, statperk1, statperk2, lane, summonername, timestamp, type, afterid, leveluptype, skillslot) "
					+ "values(participantall_seq.nextval, ";
			
			for(int k = 0; k<insertList.size(); k++) {
				if(k != insertList.size() -1) {
					sql = sql + insertList.get(k) + ", ";
				}else {
					sql = sql + insertList.get(k) + ")";
				}
			}
			
			File file = new File("/Users/anchangho/git/yapx3/yapx3/participant/participant" + (i + 1)+ ".sql");
			FileWriter fw;
			try {
				fw = new FileWriter(file, true);
				logger.info("sql: " + sql);
				fw.write(sql +"\n");
				fw.close();
				insertList.clear();
			} catch (IOException e) {
				e.printStackTrace();
			}

//			for(int k = 0; k <championKON.size(); k++) {
//				
//				//championKON.size = 145
//				//선택한 챔피언의 픽률을 보기위한 for문
////				if(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getInt("championId") == id) {
////					championMap.put(championNameStr, cnt += 1);
////					logger.info("championKey: "+ participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("championId"));
////					logger.info("championCount: " + championMap.get(championNameStr));
////					break;
////				}
//				
//				//챔피언 전체의 픽율을 보기 위한 for문 ex) [ 아트룩스 : 16, ...]
//				if(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getInt("championId") == championKey.get(k)) {
//					logger.info("championMap.get(championName.get(" + k + ")): " + championMap.get(championName.get(k)) + "cnt: " + cnt);
//					championMap.put(championName.get(k), championMap.get(championName.get(k)) == null?1:championMap.get(championName.get(k))+1);
//				}
//				
//			}

//			logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("championId").toString());
//			logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).toString());

			// 보조룬을 가져오는 for문
			for (int k = 0; k < 3; k++) {
//				logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("statPerk"+k).toString());
				logger.info(participantDataAllStr.getString("statPerk" + k).toString());
			}
			

		}
		return participantDataAll;
	}
	
	//ojdbc 버젼 sql문 만들기
	public JSONArray participantInsert(int id) {
		JSONArray jarr = matchDAO.participant();
		String sql = "";
		List<String> insertList = new ArrayList<String>();
		for(int i = 0; i < jarr.size(); i++) {
			for(int j = 0; j < jarr.getJSONObject(i).getJSONArray("participant10").size(); j ++) {
				logger.info("participant2: " + jarr.getJSONObject(i).getJSONArray("participant10").getJSONObject(j).getString("championId"));

				JSONObject participantDataAllStr = jarr.getJSONObject(i).getJSONArray("participant10")
						.getJSONObject(j);
				String participantid = participantDataAllStr.getString("participantId").toString();
				insertList.add(participantid);
				String teamid = participantDataAllStr.getString("teamId").toString();
				insertList.add(teamid);
				String championid = participantDataAllStr.getString("championId").toString();
				insertList.add(championid);
				String spell1Id = "";
				String spell2Id = "";
				// 소환사 주문을 가져오는 for문
				for (int k = 0; k < 2; k++) {
					if (k == 0) {
						spell1Id = participantDataAllStr.getString("spell" + (k + 1) + "Id").toString();
						insertList.add(spell1Id);
					} else {
						spell2Id = participantDataAllStr.getString("spell" + (k + 1) + "Id").toString();
						insertList.add(spell2Id);
					}
					logger.info("spell: " + participantDataAllStr.getString("spell" + (k + 1) + "Id"));
				}
				String win = "'"+participantDataAllStr.getString("win").toString()+"'";
				insertList.add(win);
				String item0 = "";
				String item1 = "";
				String item2 = "";
				String item3 = "";
				String item4 = "";
				String item5 = "";
				String item6 = "";
				// 아이템 가져오는 for문
				for (int k = 0; k < 7; k++) {
					switch (k) {
					case 0:
						logger.info(participantDataAllStr.getString("item" + k).toString());
						item0 = participantDataAllStr.getString("item" + k).toString();
						insertList.add(item0);
						break;
					case 1:
						logger.info(participantDataAllStr.getString("item" + k).toString());
						item1 = participantDataAllStr.getString("item" + k).toString();
						insertList.add(item1);
						break;
					case 2:
						logger.info(participantDataAllStr.getString("item" + k).toString());
						item2 = participantDataAllStr.getString("item" + k).toString();
						insertList.add(item2);
						break;
					case 3:
						logger.info(participantDataAllStr.getString("item" + k).toString());
						item3 = participantDataAllStr.getString("item" + k).toString();
						insertList.add(item3);
						break;
					case 4:
						logger.info(participantDataAllStr.getString("item" + k).toString());
						item4 = participantDataAllStr.getString("item" + k).toString();
						insertList.add(item4);
						break;
					case 5:
						logger.info(participantDataAllStr.getString("item" + k).toString());
						item5 = participantDataAllStr.getString("item" + k).toString();
						insertList.add(item5);
						break;
					case 6:
						logger.info(participantDataAllStr.getString("item" + k).toString());
						item6 = participantDataAllStr.getString("item" + k).toString();
						insertList.add(item6);
						break;
					default:
						break;

					}
				}

				String kills = participantDataAllStr.getString("kills").toString();
				insertList.add(kills);
				
				String deaths = participantDataAllStr.getString("deaths").toString();
				insertList.add(deaths);
				
				String assists = participantDataAllStr.getString("assists").toString();
				insertList.add(assists);
				
				String largestMultiKill = participantDataAllStr.getString("largestMultiKill").toString();
				insertList.add(largestMultiKill);
				
				String totalDamageDealtToChampions = participantDataAllStr.getString("totalDamageDealtToChampions").toString();
				insertList.add(totalDamageDealtToChampions);
				
				String goldEarned = participantDataAllStr.getString("goldEarned").toString();
				insertList.add(goldEarned);
				
				String totalMinionsKilled = participantDataAllStr.getString("totalMinionsKilled").toString();
				insertList.add(totalMinionsKilled);
				
				String champLevel = participantDataAllStr.getString("champLevel").toString();
				insertList.add(champLevel);
				
				String perk0 = "";
				String perk0Var1 = "";
				String perk0Var2 = "";
				String perk0Var3 = "";
				String perk1 = "";
				String perk1Var1 = "";
				String perk1Var2 = "";
				String perk1Var3 = "";
				String perk2 = "";
				String perk2Var1 = "";
				String perk2Var2 = "";
				String perk2Var3 = "";
				String perk3 = "";
				String perk3Var1 = "";
				String perk3Var2 = "";
				String perk3Var3 = "";
				String perk4 = "";
				String perk4Var1 = "";
				String perk4Var2 = "";
				String perk4Var3 = "";
				String perk5 = "";
				String perk5Var1 = "";
				String perk5Var2 = "";
				String perk5Var3 = "";
				// 룬을 가져오는 for문
				for (int k = 0; k < 6; k++) {
					switch (k) {
					case 0:
						perk0 = participantDataAllStr.getString("perk" + k).toString();
						insertList.add(perk0);
						for (int l = 1; l < 4; l++) {
							switch (l) {
							case 1:
								perk0Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk0Var1);
								break;
							case 2:
								perk0Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk0Var2);
								break;
							case 3:
								perk0Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk0Var3);
								break;
							default:
								break;
							}
						}
						break;
					case 1:
						perk1 = participantDataAllStr.getString("perk" + k).toString();
						insertList.add(perk1);
						for (int l = 1; l < 4; l++) {
							switch (l) {
							case 1:
								perk1Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk1Var1);
								break;
							case 2:
								perk1Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk1Var2);
								break;
							case 3:
								perk1Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk1Var3);
								break;
							default:
								break;
							}

						}
						break;
					case 2:
						perk2 = participantDataAllStr.getString("perk" + k).toString();
						insertList.add(perk2);
						for (int l = 1; l < 4; l++) {
							switch (l) {
							case 1:
								perk2Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk2Var1);
								break;
							case 2:
								perk2Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk2Var2);
								break;
							case 3:
								perk2Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk2Var3);
								break;
							default:
								break;
							}

						}
						break;
					case 3:
						perk3 = participantDataAllStr.getString("perk" + k).toString();
						insertList.add(perk3);
						for (int l = 1; l < 4; l++) {
							switch (l) {
							case 1:
								perk3Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk3Var1);
								break;
							case 2:
								perk3Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk3Var1);
								break;
							case 3:
								perk3Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk3Var1);
								break;
							default:
								break;
							}

						}
						break;
					case 4:
						perk4 = participantDataAllStr.getString("perk" + k).toString();
						insertList.add(perk4);
						for (int l = 1; l < 4; l++) {
							switch (l) {
							case 1:
								perk4Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk4Var1);
								break;
							case 2:
								perk4Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk4Var2);
								break;
							case 3:
								perk4Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk4Var3);
								break;
							default:
								break;
							}

						}
						break;
					case 5:
						perk5 = participantDataAllStr.getString("perk" + k).toString();
						insertList.add(perk5);
						for (int l = 1; l < 4; l++) {
							switch (l) {
							case 1:
								perk5Var1 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk5Var1);
								break;
							case 2:
								perk5Var2 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk5Var2);
								break;
							case 3:
								perk5Var3 = participantDataAllStr.getString("perk" + k + "Var" + l).toString();
								insertList.add(perk5Var3);
								break;
							default:
								break;
							}
						}
						break;
					}
				}
				String perkPrimaryStyle = participantDataAllStr.getString("perkPrimaryStyle").toString();
				insertList.add(perkPrimaryStyle);
				String perkSubStyle = participantDataAllStr.getString("perkSubStyle").toString();
				insertList.add(perkSubStyle);
				String statPerk0 = "";
				String statPerk1 = "";
				String statPerk2 = "";
				for(int k = 0; k < 3; k++) {
					switch (k) {
					case 0:statPerk0 = participantDataAllStr.getString("statPerk0").toString();insertList.add(statPerk0);break;
					case 1:statPerk1 = participantDataAllStr.getString("statPerk1").toString();insertList.add(statPerk1);break;
					case 2:statPerk2 = participantDataAllStr.getString("statPerk2").toString();insertList.add(statPerk2);break;
					default:break;
					}
				}
				String lane = "'" + participantDataAllStr.getString("lane").toString() + "'";
				insertList.add(lane);
				
				String summonerName = "'" + participantDataAllStr.getString("summonerName").toString()+"'";
				insertList.add(summonerName);
				
				String timestamp = participantDataAllStr.getString("timestamp").toString();
				insertList.add(timestamp);
				
				String type = participantDataAllStr.getString("type").toString();
				insertList.add(type);
				
				String afterId = participantDataAllStr.getString("afterId").toString();
				insertList.add(afterId);
				
				String levelUpType = participantDataAllStr.getString("levelUpType").toString();
				insertList.add(levelUpType);
				
				String skillSlot = participantDataAllStr.getString("skillSlot").toString();
				insertList.add(skillSlot);
				
				
				sql = "insert into participantall (datano, participantid, teamid, championid, spell1id, spell2id, win, item0, item1, item2, item3, item4, item5, item6, "
						+ "kills, deaths, assists, largestmultikill, totaldamagedealttochampions, goldearned, totalminionskilled, champlevel, perk0, perk0var1, perk0var2, perk0var3, "
						+ "perk1, perk1var1, perk1var2, perk1var3, perk2, perk2var1, perk2var2, perk2var3, perk3, perk3var1, perk3var2, perk3var3, perk4, perk4var1, perk4var2, perk4var3,"
						+ "perk5, perk5var1, perk5var2, perk5var3, perkprimarystyle, perksubstyle, statperk0, statperk1, statperk2, lane, summonername, timestamp, type, afterid, leveluptype, skillslot) "
						+ "values(participantall_seq.nextval, ";
				
				for(int k = 0; k<insertList.size(); k++) {
					if(k != insertList.size() -1) {
						sql = sql + insertList.get(k) + ", ";
					}else {
						sql = sql + insertList.get(k) + ");";
					}
				}
				
				File file = new File("/Users/anchangho/git/yapx3/yapx3/participant/participant10.sql");
				FileWriter fw;
				try {
					fw = new FileWriter(file, true);
					logger.info("sql: " + sql);
					fw.write(sql +"\n");
					fw.close();
					insertList.clear();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jarr;
	}

	// mybatis버젼
	public JSONArray participantDataFor(int i, String id) {

		// 선택한 챔피언일 경우의 for문
//		for(int j = 0; j < championName.size(); j++) {
//			if(championKey.get(j) == id) {
//				championNameStr = championName.get(j);
//			}
//		}
		for (int j = 0; j < participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1)).size(); j++) {
			logger.info("---------------------participant" + (i + 1) + "---------------------");
			for (int k = 0; k < championKON.size(); k++) {

				// championKON.size = 145
				// 선택한 챔피언의 픽률을 보기위한 for문
//				if(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getInt("championId") == id) {
//					championMap.put(championNameStr, cnt += 1);
//					logger.info("championKey: "+ participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("championId"));
//					logger.info("championCount: " + championMap.get(championNameStr));
//					break;
//				}

				// 챔피언 전체의 픽율을 보기 위한 for문
				if (participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1)).getJSONObject(j)
						.getInt("championId") == championKey.get(k)) {
					logger.info("championMap.get(championName.get(" + k + ")): " + championMap.get(championName.get(k))
							+ "cnt: " + cnt);
					championMap.put(championName.get(k), championMap.get(championName.get(k)) == null ? 1
							: championMap.get(championName.get(k)) + 1);
				}
			}
			logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1)).getJSONObject(j)
					.getString("championId").toString());
			// 아이템 가져오는 for문
			for (int k = 0; k < 7; k++) {
				logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1)).getJSONObject(j)
						.getString("item" + k).toString());
			}
			// 룬을 가져오는 for문
			for (int k = 0; k < 6; k++) {
				logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1)).getJSONObject(j)
						.getString("perk" + k).toString());
			}
			// 보조룬을 가져오는 for문
			for (int k = 0; k < 3; k++) {
				logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1)).getJSONObject(j)
						.getString("statPerk" + k).toString());
			}
			// 소환사 주문을 가져오는 for문
			for (int k = 0; k < 2; k++) {
				logger.info("spell: " + participantDataAll.getJSONObject(i).getJSONArray("participant" + (i + 1))
						.getJSONObject(j).getString("spell" + (k + 1) + "Id"));
			}

		}
		return participantDataAll;
	}

	// ojdbc 버젼
	public JSONArray participantData(int id) throws InterruptedException {
		// 챔피언 선택했을시 카운트 초기화
		cnt = 0;
		championKON = championAll();

		// ChampionMap 초기화
		for (int i = 0; i < championKON.size(); i++) {
			championMap.put(championName.get(i), 0);
		}

		matchDAO = new MatchDAO();
		participantDataAll = matchDAO.participant(id);

		for (int i = 0; i < participantDataAll.size(); i++) {
			if (i == 1) {
				participantDataFor(i, id);
			}
			if (i == 2) {
				participantDataFor(i, id);
			}
			if (i == 3) {
				participantDataFor(i, id);
			}
			if (i == 4) {
				participantDataFor(i, id);
			}
			if (i == 5) {
				participantDataFor(i, id);
			}
			if (i == 6) {
				participantDataFor(i, id);
			}
			if (i == 7) {
				participantDataFor(i, id);
			}
			if (i == 8) {
				participantDataFor(i, id);
			}
			if (i == 9) {
				participantDataFor(i, id);
			}
			if (i == 10) {
				participantDataFor(i, id);
			}
		}
		// db에 넣을 키값만 가져오기
		Iterator<Map.Entry<String, String>> entries = participantDataAll.getJSONObject(0).getJSONArray("participant" + (0 + 1)).getJSONObject(0).entrySet().iterator();
		while (entries.hasNext()) { 
			Entry<String, String> entry = (Entry<String, String>) entries.next();
			keyList.add(entry.getKey());
		}
		for (int i = 0; i < keyList.size(); i++) {
			logger.info("keys: " + keyList.get(i));
		}

//		matchDAO.createParticipant(keyList);
		return participantDataAll;
	}

	// mybatis 버젼
	public JSONArray participantData(String id) {
		// 챔피언 선택했을시 카운트 초기화
		cnt = 0;
		championKON = championAll();

		// ChampionMap 초기화
		for (int i = 0; i < championKON.size(); i++) {
			championMap.put(championName.get(i), 0);
		}

		matchDAO = new MatchDAO();
		participantDataAll = matchDAO.participant(id);
		for (int i = 0; i < participantDataAll.size(); i++) {
			if (i == 0) {
				participantDataFor(i, id);
			}
			if (i == 1) {
				participantDataFor(i, id);
			}
			if (i == 2) {
				participantDataFor(i, id);
			}
			if (i == 3) {
				participantDataFor(i, id);
			}
			if (i == 4) {
				participantDataFor(i, id);
			}
			if (i == 5) {
				participantDataFor(i, id);
			}
			if (i == 6) {
				participantDataFor(i, id);
			}
			if (i == 7) {
				participantDataFor(i, id);
			}
			if (i == 8) {
				participantDataFor(i, id);
			}
			if (i == 9) {
				participantDataFor(i, id);
			}
		}
		// db에 넣을 키값만 가져오기
		Iterator<Map.Entry<String, String>> entries = participantDataAll.getJSONObject(0)
				.getJSONArray("participant" + (0 + 1)).getJSONObject(0).entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) entries.next();
			keyList.add(entry.getKey());
		}
		for (int i = 0; i < keyList.size(); i++) {
			logger.info("keys: " + keyList.get(i));
		}
		logger.info("끝!");

//		matchDAO.createParticipant(keyList);
		return participantDataAll;
	}

	@Override
	public List<MatchGameList> gameList(List<String> gameId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getGameIdAll() {
		List<String> gameIdAll = matchDAO.getGameIdAllMethod();
		for(int i = 0; i<gameIdAll.size(); i++) {
			logger.info("getGameId: "  + gameIdAll.get(i));
		}
		return gameIdAll;
	}
	
	public String participantEvent(org.json.JSONObject jobj, int championId){
//		CHAMPION_KILL, 
//		WARD_PLACED, 
//		WARD_KILL, 
//		BUILDING_KILL, 
//		ELITE_MONSTER_KILL, 
//		ITEM_PURCHASED, 
//		ITEM_SOLD, 
//		ITEM_DESTROYED, 
//		ITEM_UNDO, 
//		SKILL_LEVEL_UP, 
//		ASCENDED_EVENT, 
//		CAPTURE_POINT, 
//		PORO_KING_SUMMON
		Map<String, org.json.JSONObject> mapJobj = new HashMap<String, org.json.JSONObject>();
		List<String> sqlList = new ArrayList<String>();
		org.json.JSONObject jjj;
		org.json.JSONArray jarr = new org.json.JSONArray();
		String sql = "insert into(event_no, type, timestamp, wardType, participantId, creatorId, itemId, skillSlot, levelUpType, beforeId, afterId) values(event_seq.nextval, ";
		
		for(int i = 0; i < jobj.length(); i++) {
			jjj = new org.json.JSONObject();
			String type = null;
			String timestamp = null;
			String wardType = null;
			String participantId = null;
			String creatorId = null;
			String itemId = null;
			String skillSlot = null;
			String levelUpType = null;
			String beforeId = null;
			String afterId = null;
			if(jobj.getString("type").equals("WARD_PLACED")) {
				
//				logger.info("--------------------------WARD_PLACED--------------------------");
				
//				logger.info("type: " + jobj.getString("type"));
//				logger.info("timestamp: " + jobj.get("timestamp").toString());
//				logger.info("wardType: " + jobj.getString("wardType"));
//				logger.info("creatorId: " + jobj.get("creatorId").toString());
				
				type = jobj.getString("type");
				timestamp = jobj.get("timestamp").toString();
				wardType = jobj.getString("wardType");
				creatorId = jobj.get("creatorId").toString();
				
				sql = sql +"'"+ type + "', " + timestamp + ", '" + wardType + "', " + participantId + ", " + creatorId + ", " + itemId + 
						  ", " + skillSlot + ", '" + levelUpType + "', " + beforeId + ", " +  afterId + ");";
//				logger.info(sql);
				return sql;
			}else if(jobj.getString("type").equals("ITEM_PURCHASED") || jobj.getString("type").equals("ITEM_SOLD") || jobj.getString("type").equals("ITEM_DESTROYED")){
				
//				logger.info("--------------------------ITEM_PURCHASED, ITEM_SOLD, ITEM_DESTROYED--------------------------");
				
//				logger.info("type: " + jobj.getString("type"));
//				logger.info("timestamp: " + jobj.get("timestamp").toString());
//				logger.info("participantId: " + jobj.get("participantId").toString());
//				logger.info("itemId: " + jobj.get("itemId").toString());
				
				type = jobj.getString("type");
				timestamp = jobj.get("timestamp").toString();
				participantId = jobj.get("participantId").toString();
				itemId = jobj.get("itemId").toString();
				
				sql = sql +"'"+ type + "', " + timestamp + ", '" + wardType + "', " + participantId + ", " + creatorId + ", " + itemId + 
						  ", " + skillSlot + ", '" + levelUpType + "', " + beforeId + ", " +  afterId + ");";
//				logger.info(sql);
				return sql;
			}else if(jobj.getString("type").equals("SKILL_LEVEL_UP")) {
				
//				logger.info("--------------------------SKILL_LEVEL_UP--------------------------");
				
//				logger.info("type: " + jobj.getString("type"));
//				logger.info("timestamp: " + jobj.get("timestamp").toString());
//				logger.info("participantId: " + jobj.get("participantId").toString());
//				logger.info("skillSlot: " + jobj.get("skillSlot").toString());
//				logger.info("levelUpType: " + jobj.getString("levelUpType"));
				
				type = jobj.getString("type");
				timestamp = jobj.get("timestamp").toString();
				participantId = jobj.get("participantId").toString();
				skillSlot = jobj.get("skillSlot").toString();
				levelUpType = jobj.getString("levelUpType");
				
				sql = sql +"'"+ type + "', " + timestamp + ", '" + wardType + "', " + participantId + ", " + creatorId + ", " + itemId + 
						  ", " + skillSlot + ", '" + levelUpType + "', " + beforeId + ", " +  afterId + ");";
//				logger.info(sql);
				return sql;
			}else if(jobj.getString("type").equals("ITEM_UNDO")) {
				
//				logger.info("--------------------------ITEM_UNDO--------------------------");
				
//				logger.info("type: " + jobj.getString("type"));
//				logger.info("timestamp: " + jobj.get("timestamp").toString());
//				logger.info("participantId: " + jobj.get("participantId").toString());
//				logger.info("afterId: " + jobj.get("afterId").toString());
//				logger.info("beforeId: " + jobj.get("beforeId").toString());
				
				type = jobj.getString("type");
				timestamp = jobj.get("timestamp").toString();
				participantId = jobj.get("participantId").toString();
				afterId = jobj.get("afterId").toString();
				beforeId = jobj.get("beforeId").toString();
				
				sql = sql +"'"+ type + "', " + timestamp + ", '" + wardType + "', " + participantId + ", " + creatorId + ", " + itemId + 
						  ", " + skillSlot + ", '" + levelUpType + "', " + beforeId + ", " +  afterId + ");";
				
//				logger.info(sql);
				return sql;
			}
			else {
				continue;
			}
		}
		return sql;
	}
	
	
	@Override
	public org.json.JSONObject gameMatch(List<String> gameId) {
		org.json.JSONObject eventJobj = new org.json.JSONObject();
		org.json.JSONObject matchJobj = new org.json.JSONObject();
		org.json.JSONArray eventJarr = new org.json.JSONArray();
		org.json.JSONArray matchJarr = new org.json.JSONArray();
		org.json.JSONArray eventJarrShort = new org.json.JSONArray();
		org.json.JSONArray eventAllJarr = new org.json.JSONArray();
		List<String> championIdList = new ArrayList<String>();
		List<String> participantIdList = new ArrayList<String>();
		List<String> itemIdList = new ArrayList<String>();
		List<String> typeList = new ArrayList<String>();
		List<String> sqlList = new ArrayList<String>();
		String apiKey = "RGAPI-39986d2a-9ad9-476e-9b37-45d56cf2c4cf";
		try {
			connection = new URLConnection();
			int cnt = 0;
			for(int g = 16022; g < gameId.size(); g++) {
				sqlList.clear();
				logger.info("cnt: " + cnt);
				if( cnt != 0 && cnt%40 == 0) {
					if(apiKey == "RGAPI-39986d2a-9ad9-476e-9b37-45d56cf2c4cf") {
						logger.info("잠시 쉬었다 갑니다. ------------------------------------------------------------" + (cnt + 1)+"번째");
						Thread.sleep(60002);
						cnt++;
					}
					logger.info("현재키: " + apiKey);
					switch (apiKey) {
					case "RGAPI-39986d2a-9ad9-476e-9b37-45d56cf2c4cf": apiKey = "RGAPI-65b2e42a-3890-4260-a232-ddb56b611074"; break;
					case "RGAPI-65b2e42a-3890-4260-a232-ddb56b611074": apiKey = "RGAPI-453d67fb-f64c-4bd5-a045-7714b5d19702"; break;
					case "RGAPI-453d67fb-f64c-4bd5-a045-7714b5d19702": apiKey = "RGAPI-11678be1-caf2-439f-b340-d862b570fb90"; break;
					case "RGAPI-11678be1-caf2-439f-b340-d862b570fb90": apiKey = "RGAPI-24644a67-5304-43dd-b853-51048bd088a3"; break;
					case "RGAPI-24644a67-5304-43dd-b853-51048bd088a3": apiKey = "RGAPI-39986d2a-9ad9-476e-9b37-45d56cf2c4cf"; break;
					default:break;
					}
					logger.info("변경키: " + apiKey);
				}
					cnt++;
					eventJobj = connection.matchEvent(gameId.get(g), apiKey);
					matchJobj = connection.matchGame(gameId.get(g), apiKey);
					
					eventJarr = eventJobj.getJSONArray("frames");
					matchJarr = matchJobj.getJSONArray("participants");
					//한게임에 실행되는 코드
					for(int i = 1; i <= 2; i++) {
						eventJarrShort = eventJarr.getJSONObject(i).getJSONArray("events");
//						logger.info("eventJarrShort(" + i + ")");
						for(int j = 0 ; j < eventJarrShort.length(); j++) {
							for(int k = 0; k < matchJarr.length(); k++) {
								if(eventJarrShort.getJSONObject(j).has("creatorId") && 
								  (eventJarrShort.getJSONObject(j).getInt("creatorId") == matchJarr.getJSONObject(k).getInt("participantId"))) {
									
									sqlList.add(participantEvent(eventJarrShort.getJSONObject(j), matchJarr.getJSONObject(k).getInt("championId")));
									
	//							logger.info("events"+ "(" + j + "): " + eventJarrShort.getJSONObject(j));
	//							logger.info("championId: " + matchJarr.getJSONObject(k).getInt("championId"));
								}else if((!eventJarrShort.getJSONObject(j).has("creatorId") && eventJarrShort.getJSONObject(j).has("participantId")) &&
										(eventJarrShort.getJSONObject(j).getInt("participantId") == matchJarr.getJSONObject(k).getInt("participantId"))){
									sqlList.add(participantEvent(eventJarrShort.getJSONObject(j), matchJarr.getJSONObject(k).getInt("championId")));
	//							logger.info("events"+ "(" + j + "): " + eventJarrShort.getJSONObject(j));
	//							logger.info("championId: " + matchJarr.getJSONObject(k).getInt("championId"));
								}
							}
						}
					}
					try {
						
						File file = new File("/Users/anchangho/git/yapx3/yapx3/eventSQL/sqlEvent"+sqlFileNameCount+".sql");
						FileWriter fw = new FileWriter(file, true);
						String data = "";
						
				        	for(int j = 0; j < sqlList.size(); j++) {
				        		data = sqlList.get(j);
				    			fw.write(data + "\n");
				    			sqlCount++;
				        	}
				        	if(cnt != 0 && cnt%500 == 0) {
			    				sqlFileNameCount++;
			    				logger.info("sqlFileNameCount: " + sqlFileNameCount);
			    			}
						fw.close();
					}  catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					logger.info("sqlListSize: " + sqlList.size() + ", api사용 횟수: " +  g);
					
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
