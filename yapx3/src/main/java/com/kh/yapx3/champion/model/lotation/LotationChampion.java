package com.kh.yapx3.champion.model.lotation;

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
"freeChampionIds"
})
public class LotationChampion {

@JsonProperty("freeChampionIds")
private List<Integer> freeChampionIds = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("freeChampionIds")
public List<Integer> getFreeChampionIds() {
return freeChampionIds;
}

@JsonProperty("freeChampionIds")
public void setFreeChampionIds(List<Integer> freeChampionIds) {
this.freeChampionIds = freeChampionIds;
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