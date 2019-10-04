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
"lane",
"participantId",
"csDiffPerMinDeltas",
"goldPerMinDeltas",
"xpDiffPerMinDeltas",
"creepsPerMinDeltas",
"xpPerMinDeltas",
"role",
"damageTakenDiffPerMinDeltas",
"damageTakenPerMinDeltas"
})
public class Timeline {

@JsonProperty("lane")
private String lane;
@JsonProperty("participantId")
private Integer participantId;
@JsonProperty("csDiffPerMinDeltas")
private CsDiffPerMinDeltas csDiffPerMinDeltas;
@JsonProperty("goldPerMinDeltas")
private GoldPerMinDeltas goldPerMinDeltas;
@JsonProperty("xpDiffPerMinDeltas")
private XpDiffPerMinDeltas xpDiffPerMinDeltas;
@JsonProperty("creepsPerMinDeltas")
private CreepsPerMinDeltas creepsPerMinDeltas;
@JsonProperty("xpPerMinDeltas")
private XpPerMinDeltas xpPerMinDeltas;
@JsonProperty("role")
private String role;
@JsonProperty("damageTakenDiffPerMinDeltas")
private DamageTakenDiffPerMinDeltas damageTakenDiffPerMinDeltas;
@JsonProperty("damageTakenPerMinDeltas")
private DamageTakenPerMinDeltas damageTakenPerMinDeltas;
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

@JsonProperty("participantId")
public Integer getParticipantId() {
return participantId;
}

@JsonProperty("participantId")
public void setParticipantId(Integer participantId) {
this.participantId = participantId;
}

@JsonProperty("csDiffPerMinDeltas")
public CsDiffPerMinDeltas getCsDiffPerMinDeltas() {
return csDiffPerMinDeltas;
}

@JsonProperty("csDiffPerMinDeltas")
public void setCsDiffPerMinDeltas(CsDiffPerMinDeltas csDiffPerMinDeltas) {
this.csDiffPerMinDeltas = csDiffPerMinDeltas;
}

@JsonProperty("goldPerMinDeltas")
public GoldPerMinDeltas getGoldPerMinDeltas() {
return goldPerMinDeltas;
}

@JsonProperty("goldPerMinDeltas")
public void setGoldPerMinDeltas(GoldPerMinDeltas goldPerMinDeltas) {
this.goldPerMinDeltas = goldPerMinDeltas;
}

@JsonProperty("xpDiffPerMinDeltas")
public XpDiffPerMinDeltas getXpDiffPerMinDeltas() {
return xpDiffPerMinDeltas;
}

@JsonProperty("xpDiffPerMinDeltas")
public void setXpDiffPerMinDeltas(XpDiffPerMinDeltas xpDiffPerMinDeltas) {
this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
}

@JsonProperty("creepsPerMinDeltas")
public CreepsPerMinDeltas getCreepsPerMinDeltas() {
return creepsPerMinDeltas;
}

@JsonProperty("creepsPerMinDeltas")
public void setCreepsPerMinDeltas(CreepsPerMinDeltas creepsPerMinDeltas) {
this.creepsPerMinDeltas = creepsPerMinDeltas;
}

@JsonProperty("xpPerMinDeltas")
public XpPerMinDeltas getXpPerMinDeltas() {
return xpPerMinDeltas;
}

@JsonProperty("xpPerMinDeltas")
public void setXpPerMinDeltas(XpPerMinDeltas xpPerMinDeltas) {
this.xpPerMinDeltas = xpPerMinDeltas;
}

@JsonProperty("role")
public String getRole() {
return role;
}

@JsonProperty("role")
public void setRole(String role) {
this.role = role;
}

@JsonProperty("damageTakenDiffPerMinDeltas")
public DamageTakenDiffPerMinDeltas getDamageTakenDiffPerMinDeltas() {
return damageTakenDiffPerMinDeltas;
}

@JsonProperty("damageTakenDiffPerMinDeltas")
public void setDamageTakenDiffPerMinDeltas(DamageTakenDiffPerMinDeltas damageTakenDiffPerMinDeltas) {
this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
}

@JsonProperty("damageTakenPerMinDeltas")
public DamageTakenPerMinDeltas getDamageTakenPerMinDeltas() {
return damageTakenPerMinDeltas;
}

@JsonProperty("damageTakenPerMinDeltas")
public void setDamageTakenPerMinDeltas(DamageTakenPerMinDeltas damageTakenPerMinDeltas) {
this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
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