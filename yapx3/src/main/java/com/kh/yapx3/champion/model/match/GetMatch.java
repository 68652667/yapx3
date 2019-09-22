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
"seasonId",
"queueId",
"gameId",
"participantIdentities",
"gameVersion",
"platformId",
"gameMode",
"mapId",
"gameType",
"teams",
"participants",
"gameDuration",
"gameCreation"
})
public class GetMatch {

@JsonProperty("seasonId")
private Integer seasonId;
@JsonProperty("queueId")
private Integer queueId;
@JsonProperty("gameId")
private String gameId;
@JsonProperty("participantIdentities")
private List<ParticipantIdentity> participantIdentities = null;
@JsonProperty("gameVersion")
private String gameVersion;
@JsonProperty("platformId")
private String platformId;
@JsonProperty("gameMode")
private String gameMode;
@JsonProperty("mapId")
private Integer mapId;
@JsonProperty("gameType")
private String gameType;
@JsonProperty("teams")
private List<Team> teams = null;
@JsonProperty("participants")
private List<Participant> participants = null;
@JsonProperty("gameDuration")
private String gameDuration;
@JsonProperty("gameCreation")
private String gameCreation;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("seasonId")
public Integer getSeasonId() {
return seasonId;
}

@JsonProperty("seasonId")
public void setSeasonId(Integer seasonId) {
this.seasonId = seasonId;
}

@JsonProperty("queueId")
public Integer getQueueId() {
return queueId;
}

@JsonProperty("queueId")
public void setQueueId(Integer queueId) {
this.queueId = queueId;
}

@JsonProperty("gameId")
public String getGameId() {
return gameId;
}

@JsonProperty("gameId")
public void setGameId(String gameId) {
this.gameId = gameId;
}

@JsonProperty("participantIdentities")
public List<ParticipantIdentity> getParticipantIdentities() {
return participantIdentities;
}

@JsonProperty("participantIdentities")
public void setParticipantIdentities(List<ParticipantIdentity> participantIdentities) {
this.participantIdentities = participantIdentities;
}

@JsonProperty("gameVersion")
public String getGameVersion() {
return gameVersion;
}

@JsonProperty("gameVersion")
public void setGameVersion(String gameVersion) {
this.gameVersion = gameVersion;
}

@JsonProperty("platformId")
public String getPlatformId() {
return platformId;
}

@JsonProperty("platformId")
public void setPlatformId(String platformId) {
this.platformId = platformId;
}

@JsonProperty("gameMode")
public String getGameMode() {
return gameMode;
}

@JsonProperty("gameMode")
public void setGameMode(String gameMode) {
this.gameMode = gameMode;
}

@JsonProperty("mapId")
public Integer getMapId() {
return mapId;
}

@JsonProperty("mapId")
public void setMapId(Integer mapId) {
this.mapId = mapId;
}

@JsonProperty("gameType")
public String getGameType() {
return gameType;
}

@JsonProperty("gameType")
public void setGameType(String gameType) {
this.gameType = gameType;
}

@JsonProperty("teams")
public List<Team> getTeams() {
return teams;
}

@JsonProperty("teams")
public void setTeams(List<Team> teams) {
this.teams = teams;
}

@JsonProperty("participants")
public List<Participant> getParticipants() {
return participants;
}

@JsonProperty("participants")
public void setParticipants(List<Participant> participants) {
this.participants = participants;
}

@JsonProperty("gameDuration")
public String getGameDuration() {
return gameDuration;
}

@JsonProperty("gameDuration")
public void setGameDuration(String gameDuration) {
this.gameDuration = gameDuration;
}

@JsonProperty("gameCreation")
public String getGameCreation() {
return gameCreation;
}

@JsonProperty("gameCreation")
public void setGameCreation(String gameCreation) {
this.gameCreation = gameCreation;
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