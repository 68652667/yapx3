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
"full",
"sprite",
"group",
"x",
"y",
"w",
"h"
})
public class Image {

@JsonProperty("full")
private String full;
@JsonProperty("sprite")
private String sprite;
@JsonProperty("group")
private String group;
@JsonProperty("x")
private Integer x;
@JsonProperty("y")
private Integer y;
@JsonProperty("w")
private Integer w;
@JsonProperty("h")
private Integer h;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("full")
public String getFull() {
return full;
}

@JsonProperty("full")
public void setFull(String full) {
this.full = full;
}

@JsonProperty("sprite")
public String getSprite() {
return sprite;
}

@JsonProperty("sprite")
public void setSprite(String sprite) {
this.sprite = sprite;
}

@JsonProperty("group")
public String getGroup() {
return group;
}

@JsonProperty("group")
public void setGroup(String group) {
this.group = group;
}

@JsonProperty("x")
public Integer getX() {
return x;
}

@JsonProperty("x")
public void setX(Integer x) {
this.x = x;
}

@JsonProperty("y")
public Integer getY() {
return y;
}

@JsonProperty("y")
public void setY(Integer y) {
this.y = y;
}

@JsonProperty("w")
public Integer getW() {
return w;
}

@JsonProperty("w")
public void setW(Integer w) {
this.w = w;
}

@JsonProperty("h")
public Integer getH() {
return h;
}

@JsonProperty("h")
public void setH(Integer h) {
this.h = h;
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