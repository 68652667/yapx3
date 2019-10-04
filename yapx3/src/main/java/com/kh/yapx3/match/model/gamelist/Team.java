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
"teamId",
"win",
"bans"
})
public class Team {

@JsonProperty("teamId")
private Integer teamId;
@JsonProperty("win")
private String win;
@JsonProperty("bans")
private List<Ban> bans = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("teamId")
public Integer getTeamId() {
return teamId;
}

@JsonProperty("teamId")
public void setTeamId(Integer teamId) {
this.teamId = teamId;
}

@JsonProperty("win")
public String getWin() {
return win;
}

@JsonProperty("win")
public void setWin(String win) {
this.win = win;
}

@JsonProperty("bans")
public List<Ban> getBans() {
return bans;
}

@JsonProperty("bans")
public void setBans(List<Ban> bans) {
this.bans = bans;
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
