package com.kh.yapx3.champion.model.champion;

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
"version",
"id",
"key",
"name",
"title",
"blurb",
"info",
"image",
"tags",
"partype",
"stats"
})
public class Ahri {

@JsonProperty("version")
private String version;
@JsonProperty("id")
private String id;
@JsonProperty("key")
private String key;
@JsonProperty("name")
private String name;
@JsonProperty("title")
private String title;
@JsonProperty("blurb")
private String blurb;
@JsonProperty("info")
private Info_ info;
@JsonProperty("image")
private Image_ image;
@JsonProperty("tags")
private List<String> tags = null;
@JsonProperty("partype")
private String partype;
@JsonProperty("stats")
private Stats_ stats;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("version")
public String getVersion() {
return version;
}

@JsonProperty("version")
public void setVersion(String version) {
this.version = version;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("key")
public String getKey() {
return key;
}

@JsonProperty("key")
public void setKey(String key) {
this.key = key;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("blurb")
public String getBlurb() {
return blurb;
}

@JsonProperty("blurb")
public void setBlurb(String blurb) {
this.blurb = blurb;
}

@JsonProperty("info")
public Info_ getInfo() {
return info;
}

@JsonProperty("info")
public void setInfo(Info_ info) {
this.info = info;
}

@JsonProperty("image")
public Image_ getImage() {
return image;
}

@JsonProperty("image")
public void setImage(Image_ image) {
this.image = image;
}

@JsonProperty("tags")
public List<String> getTags() {
return tags;
}

@JsonProperty("tags")
public void setTags(List<String> tags) {
this.tags = tags;
}

@JsonProperty("partype")
public String getPartype() {
return partype;
}

@JsonProperty("partype")
public void setPartype(String partype) {
this.partype = partype;
}

@JsonProperty("stats")
public Stats_ getStats() {
return stats;
}

@JsonProperty("stats")
public void setStats(Stats_ stats) {
this.stats = stats;
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