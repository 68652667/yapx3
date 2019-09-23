package com.kh.yapx3.match.model.gamelist;

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
"gameId",
"platformId",
"queueId",
"gameVersion",
"gameMode",
"gameType",
"teams",
"participants",
"participantIdentities"
})
public class MatchGameList {

@JsonProperty("gameId")
private String gameId;
@JsonProperty("platformId")
private String platformId;
@JsonProperty("queueId")
private Integer queueId;
@JsonProperty("gameVersion")
private String gameVersion;
@JsonProperty("gameMode")
private String gameMode;
@JsonProperty("gameType")
private String gameType;
@JsonProperty("teams")
private List<Team> teams = null;
@JsonProperty("participants")
private List<Participant> participants = null;
@JsonProperty("participantIdentities")
private List<ParticipantIdentity> participantIdentities = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("gameId")
public String getGameId() {
return gameId;
}

@JsonProperty("gameId")
public void setGameId(String gameId) {
this.gameId = gameId;
}

@JsonProperty("platformId")
public String getPlatformId() {
return platformId;
}

@JsonProperty("platformId")
public void setPlatformId(String platformId) {
this.platformId = platformId;
}

@JsonProperty("queueId")
public Integer getQueueId() {
return queueId;
}

@JsonProperty("queueId")
public void setQueueId(Integer queueId) {
this.queueId = queueId;
}

@JsonProperty("gameVersion")
public String getGameVersion() {
return gameVersion;
}

@JsonProperty("gameVersion")
public void setGameVersion(String gameVersion) {
this.gameVersion = gameVersion;
}

@JsonProperty("gameMode")
public String getGameMode() {
return gameMode;
}

@JsonProperty("gameMode")
public void setGameMode(String gameMode) {
this.gameMode = gameMode;
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

@JsonProperty("participantIdentities")
public List<ParticipantIdentity> getParticipantIdentities() {
return participantIdentities;
}

@JsonProperty("participantIdentities")
public void setParticipantIdentities(List<ParticipantIdentity> participantIdentities) {
this.participantIdentities = participantIdentities;
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
