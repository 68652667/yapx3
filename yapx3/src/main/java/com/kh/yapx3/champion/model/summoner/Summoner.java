package com.kh.yapx3.champion.model.summoner;

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
"profileIconId",
"name",
"puuid",
"summonerLevel",
"accountId",
"id",
"revisionDate"
})
public class Summoner {

@JsonProperty("profileIconId")
private Integer profileIconId;
@JsonProperty("name")
private String name;
@JsonProperty("puuid")
private String puuid;
@JsonProperty("summonerLevel")
private Integer summonerLevel;
@JsonProperty("accountId")
private String accountId;
@JsonProperty("id")
private String id;
@JsonProperty("revisionDate")
private String revisionDate;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("profileIconId")
public Integer getProfileIconId() {
return profileIconId;
}

@JsonProperty("profileIconId")
public void setProfileIconId(Integer profileIconId) {
this.profileIconId = profileIconId;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("puuid")
public String getPuuid() {
return puuid;
}

@JsonProperty("puuid")
public void setPuuid(String puuid) {
this.puuid = puuid;
}

@JsonProperty("summonerLevel")
public Integer getSummonerLevel() {
return summonerLevel;
}

@JsonProperty("summonerLevel")
public void setSummonerLevel(Integer summonerLevel) {
this.summonerLevel = summonerLevel;
}

@JsonProperty("accountId")
public String getAccountId() {
return accountId;
}

@JsonProperty("accountId")
public void setAccountId(String accountId) {
this.accountId = accountId;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("revisionDate")
public String getRevisionDate() {
return revisionDate;
}

@JsonProperty("revisionDate")
public void setRevisionDate(String revisionDate) {
this.revisionDate = revisionDate;
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