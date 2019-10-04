package com.kh.yapx3.match.model.gamelist;

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
"participantId",
"win",
"item0",
"item1",
"item2",
"item3",
"item4",
"item5",
"item6",
"perk0",
"perk1",
"perk2",
"perk3",
"perk4",
"perk5",
"perkPrimaryStyle",
"perkSubStyle",
"statPerk0",
"statPerk1",
"statPerk2"
})
public class Stats {

@JsonProperty("participantId")
private Integer participantId;
@JsonProperty("win")
private Boolean win;
@JsonProperty("item0")
private Integer item0;
@JsonProperty("item1")
private Integer item1;
@JsonProperty("item2")
private Integer item2;
@JsonProperty("item3")
private Integer item3;
@JsonProperty("item4")
private Integer item4;
@JsonProperty("item5")
private Integer item5;
@JsonProperty("item6")
private Integer item6;
@JsonProperty("perk0")
private Integer perk0;
@JsonProperty("perk1")
private Integer perk1;
@JsonProperty("perk2")
private Integer perk2;
@JsonProperty("perk3")
private Integer perk3;
@JsonProperty("perk4")
private Integer perk4;
@JsonProperty("perk5")
private Integer perk5;
@JsonProperty("perkPrimaryStyle")
private Integer perkPrimaryStyle;
@JsonProperty("perkSubStyle")
private Integer perkSubStyle;
@JsonProperty("statPerk0")
private Integer statPerk0;
@JsonProperty("statPerk1")
private Integer statPerk1;
@JsonProperty("statPerk2")
private Integer statPerk2;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("participantId")
public Integer getParticipantId() {
return participantId;
}

@JsonProperty("participantId")
public void setParticipantId(Integer participantId) {
this.participantId = participantId;
}

@JsonProperty("win")
public Boolean getWin() {
return win;
}

@JsonProperty("win")
public void setWin(Boolean win) {
this.win = win;
}

@JsonProperty("item0")
public Integer getItem0() {
return item0;
}

@JsonProperty("item0")
public void setItem0(Integer item0) {
this.item0 = item0;
}

@JsonProperty("item1")
public Integer getItem1() {
return item1;
}

@JsonProperty("item1")
public void setItem1(Integer item1) {
this.item1 = item1;
}

@JsonProperty("item2")
public Integer getItem2() {
return item2;
}

@JsonProperty("item2")
public void setItem2(Integer item2) {
this.item2 = item2;
}

@JsonProperty("item3")
public Integer getItem3() {
return item3;
}

@JsonProperty("item3")
public void setItem3(Integer item3) {
this.item3 = item3;
}

@JsonProperty("item4")
public Integer getItem4() {
return item4;
}

@JsonProperty("item4")
public void setItem4(Integer item4) {
this.item4 = item4;
}

@JsonProperty("item5")
public Integer getItem5() {
return item5;
}

@JsonProperty("item5")
public void setItem5(Integer item5) {
this.item5 = item5;
}

@JsonProperty("item6")
public Integer getItem6() {
return item6;
}

@JsonProperty("item6")
public void setItem6(Integer item6) {
this.item6 = item6;
}

@JsonProperty("perk0")
public Integer getPerk0() {
return perk0;
}

@JsonProperty("perk0")
public void setPerk0(Integer perk0) {
this.perk0 = perk0;
}

@JsonProperty("perk1")
public Integer getPerk1() {
return perk1;
}

@JsonProperty("perk1")
public void setPerk1(Integer perk1) {
this.perk1 = perk1;
}

@JsonProperty("perk2")
public Integer getPerk2() {
return perk2;
}

@JsonProperty("perk2")
public void setPerk2(Integer perk2) {
this.perk2 = perk2;
}

@JsonProperty("perk3")
public Integer getPerk3() {
return perk3;
}

@JsonProperty("perk3")
public void setPerk3(Integer perk3) {
this.perk3 = perk3;
}

@JsonProperty("perk4")
public Integer getPerk4() {
return perk4;
}

@JsonProperty("perk4")
public void setPerk4(Integer perk4) {
this.perk4 = perk4;
}

@JsonProperty("perk5")
public Integer getPerk5() {
return perk5;
}

@JsonProperty("perk5")
public void setPerk5(Integer perk5) {
this.perk5 = perk5;
}

@JsonProperty("perkPrimaryStyle")
public Integer getPerkPrimaryStyle() {
return perkPrimaryStyle;
}

@JsonProperty("perkPrimaryStyle")
public void setPerkPrimaryStyle(Integer perkPrimaryStyle) {
this.perkPrimaryStyle = perkPrimaryStyle;
}

@JsonProperty("perkSubStyle")
public Integer getPerkSubStyle() {
return perkSubStyle;
}

@JsonProperty("perkSubStyle")
public void setPerkSubStyle(Integer perkSubStyle) {
this.perkSubStyle = perkSubStyle;
}

@JsonProperty("statPerk0")
public Integer getStatPerk0() {
return statPerk0;
}

@JsonProperty("statPerk0")
public void setStatPerk0(Integer statPerk0) {
this.statPerk0 = statPerk0;
}

@JsonProperty("statPerk1")
public Integer getStatPerk1() {
return statPerk1;
}

@JsonProperty("statPerk1")
public void setStatPerk1(Integer statPerk1) {
this.statPerk1 = statPerk1;
}

@JsonProperty("statPerk2")
public Integer getStatPerk2() {
return statPerk2;
}

@JsonProperty("statPerk2")
public void setStatPerk2(Integer statPerk2) {
this.statPerk2 = statPerk2;
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
