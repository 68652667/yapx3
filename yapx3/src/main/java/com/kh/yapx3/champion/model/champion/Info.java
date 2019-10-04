package com.kh.yapx3.champion.model.champion;

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
"attack",
"defense",
"magic",
"difficulty"
})
public class Info {

@JsonProperty("attack")
private Integer attack;
@JsonProperty("defense")
private Integer defense;
@JsonProperty("magic")
private Integer magic;
@JsonProperty("difficulty")
private Integer difficulty;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("attack")
public Integer getAttack() {
return attack;
}

@JsonProperty("attack")
public void setAttack(Integer attack) {
this.attack = attack;
}

@JsonProperty("defense")
public Integer getDefense() {
return defense;
}

@JsonProperty("defense")
public void setDefense(Integer defense) {
this.defense = defense;
}

@JsonProperty("magic")
public Integer getMagic() {
return magic;
}

@JsonProperty("magic")
public void setMagic(Integer magic) {
this.magic = magic;
}

@JsonProperty("difficulty")
public Integer getDifficulty() {
return difficulty;
}

@JsonProperty("difficulty")
public void setDifficulty(Integer difficulty) {
this.difficulty = difficulty;
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