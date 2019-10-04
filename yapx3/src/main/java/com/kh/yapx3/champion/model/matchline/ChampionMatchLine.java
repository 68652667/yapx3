package com.kh.yapx3.champion.model.matchline;

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
"matches",
"endIndex",
"startIndex",
"totalGames"
})
public class ChampionMatchLine {

@JsonProperty("matches")
private List<Match> matches = null;
@JsonProperty("endIndex")
private Integer endIndex;
@JsonProperty("startIndex")
private Integer startIndex;
@JsonProperty("totalGames")
private Integer totalGames;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("matches")
public List<Match> getMatches() {
return matches;
}

@JsonProperty("matches")
public void setMatches(List<Match> matches) {
this.matches = matches;
}

@JsonProperty("endIndex")
public Integer getEndIndex() {
return endIndex;
}

@JsonProperty("endIndex")
public void setEndIndex(Integer endIndex) {
this.endIndex = endIndex;
}

@JsonProperty("startIndex")
public Integer getStartIndex() {
return startIndex;
}

@JsonProperty("startIndex")
public void setStartIndex(Integer startIndex) {
this.startIndex = startIndex;
}

@JsonProperty("totalGames")
public Integer getTotalGames() {
return totalGames;
}

@JsonProperty("totalGames")
public void setTotalGames(Integer totalGames) {
this.totalGames = totalGames;
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