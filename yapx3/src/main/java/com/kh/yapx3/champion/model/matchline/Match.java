package com.kh.yapx3.champion.model.matchline;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"lane",
"gameId",
"champion",
"platformId",
"timestamp",
"queue",
"role",
"season"
})
public class Match {

@JsonProperty("lane")
private String lane;
@JsonProperty("gameId")
private String gameId;
@JsonProperty("champion")
private Integer champion;
@JsonProperty("platformId")
private String platformId;
@JsonProperty("timestamp")
private String timestamp;
@JsonProperty("queue")
private Integer queue;
@JsonProperty("role")
private String role;
@JsonProperty("season")
private Integer season;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("lane")
public String getLane() {
return lane;
}

@JsonProperty("lane")
public void setLane(String lane) {
this.lane = lane;
}

@JsonProperty("gameId")
public String getGameId() {
return gameId;
}

@JsonProperty("gameId")
public void setGameId(String gameId) {
this.gameId = gameId;
}

@JsonProperty("champion")
public Integer getChampion() {
return champion;
}

@JsonProperty("champion")
public void setChampion(Integer champion) {
this.champion = champion;
}

@JsonProperty("platformId")
public String getPlatformId() {
return platformId;
}

@JsonProperty("platformId")
public void setPlatformId(String platformId) {
this.platformId = platformId;
}

@JsonProperty("timestamp")
public String getTimestamp() {
return timestamp;
}

@JsonProperty("timestamp")
public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

@JsonProperty("queue")
public Integer getQueue() {
return queue;
}

@JsonProperty("queue")
public void setQueue(Integer queue) {
this.queue = queue;
}

@JsonProperty("role")
public String getRole() {
return role;
}

@JsonProperty("role")
public void setRole(String role) {
this.role = role;
}

@JsonProperty("season")
public Integer getSeason() {
return season;
}

@JsonProperty("season")
public void setSeason(Integer season) {
this.season = season;
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