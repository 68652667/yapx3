package com.kh.yapx3.champion.model.champion;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kh.yapx3.champion.model.service.ChampValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"type",
"format",
"version",
"data"
})
public class ChampionAll {

@JsonProperty("type")
private String type;
@JsonProperty("format")
private String format;
@JsonProperty("version")
private String version;
@JsonProperty("data")
private Map<String, ChampValue> data;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("format")
public String getFormat() {
return format;
}

@JsonProperty("format")
public void setFormat(String format) {
this.format = format;
}

@JsonProperty("version")
public String getVersion() {
return version;
}

@JsonProperty("version")
public void setVersion(String version) {
this.version = version;
}

@JsonProperty("data")
public Map<String, ChampValue> getData() {
return data;
}

@JsonProperty("data")
public void setData(Map<String, ChampValue> data) {
this.data = data;
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