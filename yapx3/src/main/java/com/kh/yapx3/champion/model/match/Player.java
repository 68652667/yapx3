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
"currentPlatformId",
"summonerName",
"matchHistoryUri",
"platformId",
"currentAccountId",
"profileIcon",
"summonerId",
"accountId"
})
public class Player {

@JsonProperty("currentPlatformId")
private String currentPlatformId;
@JsonProperty("summonerName")
private String summonerName;
@JsonProperty("matchHistoryUri")
private String matchHistoryUri;
@JsonProperty("platformId")
private String platformId;
@JsonProperty("currentAccountId")
private String currentAccountId;
@JsonProperty("profileIcon")
private Integer profileIcon;
@JsonProperty("summonerId")
private String summonerId;
@JsonProperty("accountId")
private String accountId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("currentPlatformId")
public String getCurrentPlatformId() {
return currentPlatformId;
}

@JsonProperty("currentPlatformId")
public void setCurrentPlatformId(String currentPlatformId) {
this.currentPlatformId = currentPlatformId;
}

@JsonProperty("summonerName")
public String getSummonerName() {
return summonerName;
}

@JsonProperty("summonerName")
public void setSummonerName(String summonerName) {
this.summonerName = summonerName;
}

@JsonProperty("matchHistoryUri")
public String getMatchHistoryUri() {
return matchHistoryUri;
}

@JsonProperty("matchHistoryUri")
public void setMatchHistoryUri(String matchHistoryUri) {
this.matchHistoryUri = matchHistoryUri;
}

@JsonProperty("platformId")
public String getPlatformId() {
return platformId;
}

@JsonProperty("platformId")
public void setPlatformId(String platformId) {
this.platformId = platformId;
}

@JsonProperty("currentAccountId")
public String getCurrentAccountId() {
return currentAccountId;
}

@JsonProperty("currentAccountId")
public void setCurrentAccountId(String currentAccountId) {
this.currentAccountId = currentAccountId;
}

@JsonProperty("profileIcon")
public Integer getProfileIcon() {
return profileIcon;
}

@JsonProperty("profileIcon")
public void setProfileIcon(Integer profileIcon) {
this.profileIcon = profileIcon;
}

@JsonProperty("summonerId")
public String getSummonerId() {
return summonerId;
}

@JsonProperty("summonerId")
public void setSummonerId(String summonerId) {
this.summonerId = summonerId;
}

@JsonProperty("accountId")
public String getAccountId() {
return accountId;
}

@JsonProperty("accountId")
public void setAccountId(String accountId) {
this.accountId = accountId;
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
