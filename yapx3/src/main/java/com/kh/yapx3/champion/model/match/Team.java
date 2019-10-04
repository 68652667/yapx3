package com.kh.yapx3.champion.model.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"firstDragon",
"bans",
"firstInhibitor",
"win",
"firstRiftHerald",
"firstBaron",
"baronKills",
"riftHeraldKills",
"firstBlood",
"teamId",
"firstTower",
"vilemawKills",
"inhibitorKills",
"towerKills",
"dominionVictoryScore",
"dragonKills"
})
public class Team {

@JsonProperty("firstDragon")
private Boolean firstDragon;
@JsonProperty("bans")
private List<Ban> bans = null;
@JsonProperty("firstInhibitor")
private Boolean firstInhibitor;
@JsonProperty("win")
private String win;
@JsonProperty("firstRiftHerald")
private Boolean firstRiftHerald;
@JsonProperty("firstBaron")
private Boolean firstBaron;
@JsonProperty("baronKills")
private Integer baronKills;
@JsonProperty("riftHeraldKills")
private Integer riftHeraldKills;
@JsonProperty("firstBlood")
private Boolean firstBlood;
@JsonProperty("teamId")
private Integer teamId;
@JsonProperty("firstTower")
private Boolean firstTower;
@JsonProperty("vilemawKills")
private Integer vilemawKills;
@JsonProperty("inhibitorKills")
private Integer inhibitorKills;
@JsonProperty("towerKills")
private Integer towerKills;
@JsonProperty("dominionVictoryScore")
private Integer dominionVictoryScore;
@JsonProperty("dragonKills")
private Integer dragonKills;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("firstDragon")
public Boolean getFirstDragon() {
return firstDragon;
}

@JsonProperty("firstDragon")
public void setFirstDragon(Boolean firstDragon) {
this.firstDragon = firstDragon;
}

@JsonProperty("bans")
public List<Ban> getBans() {
return bans;
}

@JsonProperty("bans")
public void setBans(List<Ban> bans) {
this.bans = bans;
}

@JsonProperty("firstInhibitor")
public Boolean getFirstInhibitor() {
return firstInhibitor;
}

@JsonProperty("firstInhibitor")
public void setFirstInhibitor(Boolean firstInhibitor) {
this.firstInhibitor = firstInhibitor;
}

@JsonProperty("win")
public String getWin() {
return win;
}

@JsonProperty("win")
public void setWin(String win) {
this.win = win;
}

@JsonProperty("firstRiftHerald")
public Boolean getFirstRiftHerald() {
return firstRiftHerald;
}

@JsonProperty("firstRiftHerald")
public void setFirstRiftHerald(Boolean firstRiftHerald) {
this.firstRiftHerald = firstRiftHerald;
}

@JsonProperty("firstBaron")
public Boolean getFirstBaron() {
return firstBaron;
}

@JsonProperty("firstBaron")
public void setFirstBaron(Boolean firstBaron) {
this.firstBaron = firstBaron;
}

@JsonProperty("baronKills")
public Integer getBaronKills() {
return baronKills;
}

@JsonProperty("baronKills")
public void setBaronKills(Integer baronKills) {
this.baronKills = baronKills;
}

@JsonProperty("riftHeraldKills")
public Integer getRiftHeraldKills() {
return riftHeraldKills;
}

@JsonProperty("riftHeraldKills")
public void setRiftHeraldKills(Integer riftHeraldKills) {
this.riftHeraldKills = riftHeraldKills;
}

@JsonProperty("firstBlood")
public Boolean getFirstBlood() {
return firstBlood;
}

@JsonProperty("firstBlood")
public void setFirstBlood(Boolean firstBlood) {
this.firstBlood = firstBlood;
}

@JsonProperty("teamId")
public Integer getTeamId() {
return teamId;
}

@JsonProperty("teamId")
public void setTeamId(Integer teamId) {
this.teamId = teamId;
}

@JsonProperty("firstTower")
public Boolean getFirstTower() {
return firstTower;
}

@JsonProperty("firstTower")
public void setFirstTower(Boolean firstTower) {
this.firstTower = firstTower;
}

@JsonProperty("vilemawKills")
public Integer getVilemawKills() {
return vilemawKills;
}

@JsonProperty("vilemawKills")
public void setVilemawKills(Integer vilemawKills) {
this.vilemawKills = vilemawKills;
}

@JsonProperty("inhibitorKills")
public Integer getInhibitorKills() {
return inhibitorKills;
}

@JsonProperty("inhibitorKills")
public void setInhibitorKills(Integer inhibitorKills) {
this.inhibitorKills = inhibitorKills;
}

@JsonProperty("towerKills")
public Integer getTowerKills() {
return towerKills;
}

@JsonProperty("towerKills")
public void setTowerKills(Integer towerKills) {
this.towerKills = towerKills;
}

@JsonProperty("dominionVictoryScore")
public Integer getDominionVictoryScore() {
return dominionVictoryScore;
}

@JsonProperty("dominionVictoryScore")
public void setDominionVictoryScore(Integer dominionVictoryScore) {
this.dominionVictoryScore = dominionVictoryScore;
}

@JsonProperty("dragonKills")
public Integer getDragonKills() {
return dragonKills;
}

@JsonProperty("dragonKills")
public void setDragonKills(Integer dragonKills) {
this.dragonKills = dragonKills;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}