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
"creepsPerMinDeltas",
"xpPerMinDeltas",
"goldPerMinDeltas",
"csDiffPerMinDeltas",
"xpDiffPerMinDeltas",
"damageTakenPerMinDeltas",
"damageTakenDiffPerMinDeltas",
"role",
"lane"
})
public class Timeline {

@JsonProperty("participantId")
private Integer participantId;
@JsonProperty("creepsPerMinDeltas")
private CreepsPerMinDeltas creepsPerMinDeltas;
@JsonProperty("xpPerMinDeltas")
private XpPerMinDeltas xpPerMinDeltas;
@JsonProperty("goldPerMinDeltas")
private GoldPerMinDeltas goldPerMinDeltas;
@JsonProperty("csDiffPerMinDeltas")
private CsDiffPerMinDeltas csDiffPerMinDeltas;
@JsonProperty("xpDiffPerMinDeltas")
private XpDiffPerMinDeltas xpDiffPerMinDeltas;
@JsonProperty("damageTakenPerMinDeltas")
private DamageTakenPerMinDeltas damageTakenPerMinDeltas;
@JsonProperty("damageTakenDiffPerMinDeltas")
private DamageTakenDiffPerMinDeltas damageTakenDiffPerMinDeltas;
@JsonProperty("role")
private String role;
@JsonProperty("lane")
private String lane;
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

@JsonProperty("goldPerMinDeltas")
public GoldPerMinDeltas getGoldPerMinDeltas() {
return goldPerMinDeltas;
}

@JsonProperty("goldPerMinDeltas")
public void setGoldPerMinDeltas(GoldPerMinDeltas goldPerMinDeltas) {
this.goldPerMinDeltas = goldPerMinDeltas;
}

@JsonProperty("csDiffPerMinDeltas")
public CsDiffPerMinDeltas getCsDiffPerMinDeltas() {
return csDiffPerMinDeltas;
}

@JsonProperty("csDiffPerMinDeltas")
public void setCsDiffPerMinDeltas(CsDiffPerMinDeltas csDiffPerMinDeltas) {
this.csDiffPerMinDeltas = csDiffPerMinDeltas;
}

@JsonProperty("xpDiffPerMinDeltas")
public XpDiffPerMinDeltas getXpDiffPerMinDeltas() {
return xpDiffPerMinDeltas;
}

@JsonProperty("xpDiffPerMinDeltas")
public void setXpDiffPerMinDeltas(XpDiffPerMinDeltas xpDiffPerMinDeltas) {
this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
}

@JsonProperty("damageTakenPerMinDeltas")
public DamageTakenPerMinDeltas getDamageTakenPerMinDeltas() {
return damageTakenPerMinDeltas;
}

@JsonProperty("damageTakenPerMinDeltas")
public void setDamageTakenPerMinDeltas(DamageTakenPerMinDeltas damageTakenPerMinDeltas) {
this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
}

@JsonProperty("damageTakenDiffPerMinDeltas")
public DamageTakenDiffPerMinDeltas getDamageTakenDiffPerMinDeltas() {
return damageTakenDiffPerMinDeltas;
}

@JsonProperty("damageTakenDiffPerMinDeltas")
public void setDamageTakenDiffPerMinDeltas(DamageTakenDiffPerMinDeltas damageTakenDiffPerMinDeltas) {
this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
}

@JsonProperty("role")
public String getRole() {
return role;
}

@JsonProperty("role")
public void setRole(String role) {
this.role = role;
}

@JsonProperty("lane")
public String getLane() {
return lane;
}

@JsonProperty("lane")
public void setLane(String lane) {
this.lane = lane;
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
