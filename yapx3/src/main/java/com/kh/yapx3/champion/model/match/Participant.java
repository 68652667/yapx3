package com.kh.yapx3.champion.model.match;

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
"stats",
"spell1Id",
"participantId",
"highestAchievedSeasonTier",
"spell2Id",
"teamId",
"timeline",
"championId"
})
public class Participant {

@JsonProperty("stats")
private Stats stats;
@JsonProperty("spell1Id")
private Integer spell1Id;
@JsonProperty("participantId")
private Integer participantId;
@JsonProperty("highestAchievedSeasonTier")
private String highestAchievedSeasonTier;
@JsonProperty("spell2Id")
private Integer spell2Id;
@JsonProperty("teamId")
private Integer teamId;
@JsonProperty("timeline")
private Timeline timeline;
@JsonProperty("championId")
private Integer championId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("stats")
public Stats getStats() {
return stats;
}

@JsonProperty("stats")
public void setStats(Stats stats) {
this.stats = stats;
}

@JsonProperty("spell1Id")
public Integer getSpell1Id() {
return spell1Id;
}

@JsonProperty("spell1Id")
public void setSpell1Id(Integer spell1Id) {
this.spell1Id = spell1Id;
}

@JsonProperty("participantId")
public Integer getParticipantId() {
return participantId;
}

@JsonProperty("participantId")
public void setParticipantId(Integer participantId) {
this.participantId = participantId;
}

@JsonProperty("highestAchievedSeasonTier")
public String getHighestAchievedSeasonTier() {
return highestAchievedSeasonTier;
}

@JsonProperty("highestAchievedSeasonTier")
public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
this.highestAchievedSeasonTier = highestAchievedSeasonTier;
}

@JsonProperty("spell2Id")
public Integer getSpell2Id() {
return spell2Id;
}

@JsonProperty("spell2Id")
public void setSpell2Id(Integer spell2Id) {
this.spell2Id = spell2Id;
}

@JsonProperty("teamId")
public Integer getTeamId() {
return teamId;
}

@JsonProperty("teamId")
public void setTeamId(Integer teamId) {
this.teamId = teamId;
}

@JsonProperty("timeline")
public Timeline getTimeline() {
return timeline;
}

@JsonProperty("timeline")
public void setTimeline(Timeline timeline) {
this.timeline = timeline;
}

@JsonProperty("championId")
public Integer getChampionId() {
return championId;
}

@JsonProperty("championId")
public void setChampionId(Integer championId) {
this.championId = championId;
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