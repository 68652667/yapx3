package com.kh.yapx3.champion.model.challenger;

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
"tier",
"leagueId",
"entries",
"queue",
"name"
})
public class ChallengerLegue {

@JsonProperty("tier")
private String tier;
@JsonProperty("leagueId")
private String leagueId;
@JsonProperty("entries")
private List<Entry> entries = null;
@JsonProperty("queue")
private String queue;
@JsonProperty("name")
private String name;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("tier")
public String getTier() {
return tier;
}

@JsonProperty("tier")
public void setTier(String tier) {
this.tier = tier;
}

@JsonProperty("leagueId")
public String getLeagueId() {
return leagueId;
}

@JsonProperty("leagueId")
public void setLeagueId(String leagueId) {
this.leagueId = leagueId;
}

@JsonProperty("entries")
public List<Entry> getEntries() {
return entries;
}

@JsonProperty("entries")
public void setEntries(List<Entry> entries) {
this.entries = entries;
}

@JsonProperty("queue")
public String getQueue() {
return queue;
}

@JsonProperty("queue")
public void setQueue(String queue) {
this.queue = queue;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
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