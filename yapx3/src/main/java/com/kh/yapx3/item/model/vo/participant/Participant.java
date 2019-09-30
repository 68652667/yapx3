
/**
 * com.kh.yapx3.item.model.vo.participant.Participant.java
 *
 * Generated via http://jsonformatter-online.com on Sat, 28 Sep 2019 05:12:20
 */
package com.kh.yapx3.item.model.vo.participant;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "participantId",
    "teamId",
    "championId",
    "spell1Id",
    "spell2Id",
    "win",
    "item0",
    "item1",
    "item2",
    "item3",
    "item4",
    "item5",
    "item6",
    "kills",
    "deaths",
    "assists",
    "largestMultiKill",
    "totalDamageDealtToChampions",
    "goldEarned",
    "totalMinionsKilled",
    "champLevel",
    "perk0",
    "perk0Var1",
    "perk0Var2",
    "perk0Var3",
    "perk1",
    "perk1Var1",
    "perk1Var2",
    "perk1Var3",
    "perk2",
    "perk2Var1",
    "perk2Var2",
    "perk2Var3",
    "perk3",
    "perk3Var1",
    "perk3Var2",
    "perk3Var3",
    "perk4",
    "perk4Var1",
    "perk4Var2",
    "perk4Var3",
    "perk5",
    "perk5Var1",
    "perk5Var2",
    "perk5Var3",
    "perkPrimaryStyle",
    "perkSubStyle",
    "statPerk0",
    "statPerk1",
    "statPerk2",
    "lane",
    "summonerName",
    "timestamp",
    "type",
    "afterId",
    "levelUpType",
    "skillSlot"
})
public class Participant implements Serializable
{

    @JsonProperty("participantId")
    private String participantId;
    @JsonProperty("teamId")
    private String teamId;
    @JsonProperty("championId")
    private String championId;
    @JsonProperty("spell1Id")
    private String spell1Id;
    @JsonProperty("spell2Id")
    private String spell2Id;
    @JsonProperty("win")
    private String win;
    @JsonProperty("item0")
    private String item0;
    @JsonProperty("item1")
    private String item1;
    @JsonProperty("item2")
    private String item2;
    @JsonProperty("item3")
    private String item3;
    @JsonProperty("item4")
    private String item4;
    @JsonProperty("item5")
    private String item5;
    @JsonProperty("item6")
    private String item6;
    @JsonProperty("kills")
    private String kills;
    @JsonProperty("deaths")
    private String deaths;
    @JsonProperty("assists")
    private String assists;
    @JsonProperty("largestMultiKill")
    private String largestMultiKill;
    @JsonProperty("totalDamageDealtToChampions")
    private String totalDamageDealtToChampions;
    @JsonProperty("goldEarned")
    private String goldEarned;
    @JsonProperty("totalMinionsKilled")
    private String totalMinionsKilled;
    @JsonProperty("champLevel")
    private String champLevel;
    @JsonProperty("perk0")
    private String perk0;
    @JsonProperty("perk0Var1")
    private String perk0Var1;
    @JsonProperty("perk0Var2")
    private String perk0Var2;
    @JsonProperty("perk0Var3")
    private String perk0Var3;
    @JsonProperty("perk1")
    private String perk1;
    @JsonProperty("perk1Var1")
    private String perk1Var1;
    @JsonProperty("perk1Var2")
    private String perk1Var2;
    @JsonProperty("perk1Var3")
    private String perk1Var3;
    @JsonProperty("perk2")
    private String perk2;
    @JsonProperty("perk2Var1")
    private String perk2Var1;
    @JsonProperty("perk2Var2")
    private String perk2Var2;
    @JsonProperty("perk2Var3")
    private String perk2Var3;
    @JsonProperty("perk3")
    private String perk3;
    @JsonProperty("perk3Var1")
    private String perk3Var1;
    @JsonProperty("perk3Var2")
    private String perk3Var2;
    @JsonProperty("perk3Var3")
    private String perk3Var3;
    @JsonProperty("perk4")
    private String perk4;
    @JsonProperty("perk4Var1")
    private String perk4Var1;
    @JsonProperty("perk4Var2")
    private String perk4Var2;
    @JsonProperty("perk4Var3")
    private String perk4Var3;
    @JsonProperty("perk5")
    private String perk5;
    @JsonProperty("perk5Var1")
    private String perk5Var1;
    @JsonProperty("perk5Var2")
    private String perk5Var2;
    @JsonProperty("perk5Var3")
    private String perk5Var3;
    @JsonProperty("perkPrimaryStyle")
    private String perkPrimaryStyle;
    @JsonProperty("perkSubStyle")
    private String perkSubStyle;
    @JsonProperty("statPerk0")
    private String statPerk0;
    @JsonProperty("statPerk1")
    private String statPerk1;
    @JsonProperty("statPerk2")
    private String statPerk2;
    @JsonProperty("lane")
    private String lane;
    @JsonProperty("summonerName")
    private String summonerName;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("type")
    private String type;
    @JsonProperty("afterId")
    private String afterId;
    @JsonProperty("levelUpType")
    private String levelUpType;
    @JsonProperty("skillSlot")
    private String skillSlot;
    private final static long serialVersionUID = -7605535395365700630L;

    @JsonProperty("participantId")
    public String getParticipantId() {
        return participantId;
    }

    @JsonProperty("participantId")
    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    @JsonProperty("teamId")
    public String getTeamId() {
        return teamId;
    }

    @JsonProperty("teamId")
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("championId")
    public String getChampionId() {
        return championId;
    }

    @JsonProperty("championId")
    public void setChampionId(String championId) {
        this.championId = championId;
    }

    @JsonProperty("spell1Id")
    public String getSpell1Id() {
        return spell1Id;
    }

    @JsonProperty("spell1Id")
    public void setSpell1Id(String spell1Id) {
        this.spell1Id = spell1Id;
    }

    @JsonProperty("spell2Id")
    public String getSpell2Id() {
        return spell2Id;
    }

    @JsonProperty("spell2Id")
    public void setSpell2Id(String spell2Id) {
        this.spell2Id = spell2Id;
    }

    @JsonProperty("win")
    public String getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(String win) {
        this.win = win;
    }

    @JsonProperty("item0")
    public String getItem0() {
        return item0;
    }

    @JsonProperty("item0")
    public void setItem0(String item0) {
        this.item0 = item0;
    }

    @JsonProperty("item1")
    public String getItem1() {
        return item1;
    }

    @JsonProperty("item1")
    public void setItem1(String item1) {
        this.item1 = item1;
    }

    @JsonProperty("item2")
    public String getItem2() {
        return item2;
    }

    @JsonProperty("item2")
    public void setItem2(String item2) {
        this.item2 = item2;
    }

    @JsonProperty("item3")
    public String getItem3() {
        return item3;
    }

    @JsonProperty("item3")
    public void setItem3(String item3) {
        this.item3 = item3;
    }

    @JsonProperty("item4")
    public String getItem4() {
        return item4;
    }

    @JsonProperty("item4")
    public void setItem4(String item4) {
        this.item4 = item4;
    }

    @JsonProperty("item5")
    public String getItem5() {
        return item5;
    }

    @JsonProperty("item5")
    public void setItem5(String item5) {
        this.item5 = item5;
    }

    @JsonProperty("item6")
    public String getItem6() {
        return item6;
    }

    @JsonProperty("item6")
    public void setItem6(String item6) {
        this.item6 = item6;
    }

    @JsonProperty("kills")
    public String getKills() {
        return kills;
    }

    @JsonProperty("kills")
    public void setKills(String kills) {
        this.kills = kills;
    }

    @JsonProperty("deaths")
    public String getDeaths() {
        return deaths;
    }

    @JsonProperty("deaths")
    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    @JsonProperty("assists")
    public String getAssists() {
        return assists;
    }

    @JsonProperty("assists")
    public void setAssists(String assists) {
        this.assists = assists;
    }

    @JsonProperty("largestMultiKill")
    public String getLargestMultiKill() {
        return largestMultiKill;
    }

    @JsonProperty("largestMultiKill")
    public void setLargestMultiKill(String largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    @JsonProperty("totalDamageDealtToChampions")
    public String getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    @JsonProperty("totalDamageDealtToChampions")
    public void setTotalDamageDealtToChampions(String totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    @JsonProperty("goldEarned")
    public String getGoldEarned() {
        return goldEarned;
    }

    @JsonProperty("goldEarned")
    public void setGoldEarned(String goldEarned) {
        this.goldEarned = goldEarned;
    }

    @JsonProperty("totalMinionsKilled")
    public String getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    @JsonProperty("totalMinionsKilled")
    public void setTotalMinionsKilled(String totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    @JsonProperty("champLevel")
    public String getChampLevel() {
        return champLevel;
    }

    @JsonProperty("champLevel")
    public void setChampLevel(String champLevel) {
        this.champLevel = champLevel;
    }

    @JsonProperty("perk0")
    public String getPerk0() {
        return perk0;
    }

    @JsonProperty("perk0")
    public void setPerk0(String perk0) {
        this.perk0 = perk0;
    }

    @JsonProperty("perk0Var1")
    public String getPerk0Var1() {
        return perk0Var1;
    }

    @JsonProperty("perk0Var1")
    public void setPerk0Var1(String perk0Var1) {
        this.perk0Var1 = perk0Var1;
    }

    @JsonProperty("perk0Var2")
    public String getPerk0Var2() {
        return perk0Var2;
    }

    @JsonProperty("perk0Var2")
    public void setPerk0Var2(String perk0Var2) {
        this.perk0Var2 = perk0Var2;
    }

    @JsonProperty("perk0Var3")
    public String getPerk0Var3() {
        return perk0Var3;
    }

    @JsonProperty("perk0Var3")
    public void setPerk0Var3(String perk0Var3) {
        this.perk0Var3 = perk0Var3;
    }

    @JsonProperty("perk1")
    public String getPerk1() {
        return perk1;
    }

    @JsonProperty("perk1")
    public void setPerk1(String perk1) {
        this.perk1 = perk1;
    }

    @JsonProperty("perk1Var1")
    public String getPerk1Var1() {
        return perk1Var1;
    }

    @JsonProperty("perk1Var1")
    public void setPerk1Var1(String perk1Var1) {
        this.perk1Var1 = perk1Var1;
    }

    @JsonProperty("perk1Var2")
    public String getPerk1Var2() {
        return perk1Var2;
    }

    @JsonProperty("perk1Var2")
    public void setPerk1Var2(String perk1Var2) {
        this.perk1Var2 = perk1Var2;
    }

    @JsonProperty("perk1Var3")
    public String getPerk1Var3() {
        return perk1Var3;
    }

    @JsonProperty("perk1Var3")
    public void setPerk1Var3(String perk1Var3) {
        this.perk1Var3 = perk1Var3;
    }

    @JsonProperty("perk2")
    public String getPerk2() {
        return perk2;
    }

    @JsonProperty("perk2")
    public void setPerk2(String perk2) {
        this.perk2 = perk2;
    }

    @JsonProperty("perk2Var1")
    public String getPerk2Var1() {
        return perk2Var1;
    }

    @JsonProperty("perk2Var1")
    public void setPerk2Var1(String perk2Var1) {
        this.perk2Var1 = perk2Var1;
    }

    @JsonProperty("perk2Var2")
    public String getPerk2Var2() {
        return perk2Var2;
    }

    @JsonProperty("perk2Var2")
    public void setPerk2Var2(String perk2Var2) {
        this.perk2Var2 = perk2Var2;
    }

    @JsonProperty("perk2Var3")
    public String getPerk2Var3() {
        return perk2Var3;
    }

    @JsonProperty("perk2Var3")
    public void setPerk2Var3(String perk2Var3) {
        this.perk2Var3 = perk2Var3;
    }

    @JsonProperty("perk3")
    public String getPerk3() {
        return perk3;
    }

    @JsonProperty("perk3")
    public void setPerk3(String perk3) {
        this.perk3 = perk3;
    }

    @JsonProperty("perk3Var1")
    public String getPerk3Var1() {
        return perk3Var1;
    }

    @JsonProperty("perk3Var1")
    public void setPerk3Var1(String perk3Var1) {
        this.perk3Var1 = perk3Var1;
    }

    @JsonProperty("perk3Var2")
    public String getPerk3Var2() {
        return perk3Var2;
    }

    @JsonProperty("perk3Var2")
    public void setPerk3Var2(String perk3Var2) {
        this.perk3Var2 = perk3Var2;
    }

    @JsonProperty("perk3Var3")
    public String getPerk3Var3() {
        return perk3Var3;
    }

    @JsonProperty("perk3Var3")
    public void setPerk3Var3(String perk3Var3) {
        this.perk3Var3 = perk3Var3;
    }

    @JsonProperty("perk4")
    public String getPerk4() {
        return perk4;
    }

    @JsonProperty("perk4")
    public void setPerk4(String perk4) {
        this.perk4 = perk4;
    }

    @JsonProperty("perk4Var1")
    public String getPerk4Var1() {
        return perk4Var1;
    }

    @JsonProperty("perk4Var1")
    public void setPerk4Var1(String perk4Var1) {
        this.perk4Var1 = perk4Var1;
    }

    @JsonProperty("perk4Var2")
    public String getPerk4Var2() {
        return perk4Var2;
    }

    @JsonProperty("perk4Var2")
    public void setPerk4Var2(String perk4Var2) {
        this.perk4Var2 = perk4Var2;
    }

    @JsonProperty("perk4Var3")
    public String getPerk4Var3() {
        return perk4Var3;
    }

    @JsonProperty("perk4Var3")
    public void setPerk4Var3(String perk4Var3) {
        this.perk4Var3 = perk4Var3;
    }

    @JsonProperty("perk5")
    public String getPerk5() {
        return perk5;
    }

    @JsonProperty("perk5")
    public void setPerk5(String perk5) {
        this.perk5 = perk5;
    }

    @JsonProperty("perk5Var1")
    public String getPerk5Var1() {
        return perk5Var1;
    }

    @JsonProperty("perk5Var1")
    public void setPerk5Var1(String perk5Var1) {
        this.perk5Var1 = perk5Var1;
    }

    @JsonProperty("perk5Var2")
    public String getPerk5Var2() {
        return perk5Var2;
    }

    @JsonProperty("perk5Var2")
    public void setPerk5Var2(String perk5Var2) {
        this.perk5Var2 = perk5Var2;
    }

    @JsonProperty("perk5Var3")
    public String getPerk5Var3() {
        return perk5Var3;
    }

    @JsonProperty("perk5Var3")
    public void setPerk5Var3(String perk5Var3) {
        this.perk5Var3 = perk5Var3;
    }

    @JsonProperty("perkPrimaryStyle")
    public String getPerkPrimaryStyle() {
        return perkPrimaryStyle;
    }

    @JsonProperty("perkPrimaryStyle")
    public void setPerkPrimaryStyle(String perkPrimaryStyle) {
        this.perkPrimaryStyle = perkPrimaryStyle;
    }

    @JsonProperty("perkSubStyle")
    public String getPerkSubStyle() {
        return perkSubStyle;
    }

    @JsonProperty("perkSubStyle")
    public void setPerkSubStyle(String perkSubStyle) {
        this.perkSubStyle = perkSubStyle;
    }

    @JsonProperty("statPerk0")
    public String getStatPerk0() {
        return statPerk0;
    }

    @JsonProperty("statPerk0")
    public void setStatPerk0(String statPerk0) {
        this.statPerk0 = statPerk0;
    }

    @JsonProperty("statPerk1")
    public String getStatPerk1() {
        return statPerk1;
    }

    @JsonProperty("statPerk1")
    public void setStatPerk1(String statPerk1) {
        this.statPerk1 = statPerk1;
    }

    @JsonProperty("statPerk2")
    public String getStatPerk2() {
        return statPerk2;
    }

    @JsonProperty("statPerk2")
    public void setStatPerk2(String statPerk2) {
        this.statPerk2 = statPerk2;
    }

    @JsonProperty("lane")
    public String getLane() {
        return lane;
    }

    @JsonProperty("lane")
    public void setLane(String lane) {
        this.lane = lane;
    }

    @JsonProperty("summonerName")
    public String getSummonerName() {
        return summonerName;
    }

    @JsonProperty("summonerName")
    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("afterId")
    public String getAfterId() {
        return afterId;
    }

    @JsonProperty("afterId")
    public void setAfterId(String afterId) {
        this.afterId = afterId;
    }

    @JsonProperty("levelUpType")
    public String getLevelUpType() {
        return levelUpType;
    }

    @JsonProperty("levelUpType")
    public void setLevelUpType(String levelUpType) {
        this.levelUpType = levelUpType;
    }

    @JsonProperty("skillSlot")
    public String getSkillSlot() {
        return skillSlot;
    }

    @JsonProperty("skillSlot")
    public void setSkillSlot(String skillSlot) {
        this.skillSlot = skillSlot;
    }

    

}
