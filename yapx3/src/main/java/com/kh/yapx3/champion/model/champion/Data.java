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
"Aatrox",
"Ahri"
})
public class Data {

@JsonProperty("Aatrox")
private Aatrox aatrox;
@JsonProperty("Ahri")
private Ahri ahri;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("Aatrox")
public Aatrox getAatrox() {
return aatrox;
}

@JsonProperty("Aatrox")
public void setAatrox(Aatrox aatrox) {
this.aatrox = aatrox;
}

@JsonProperty("Ahri")
public Ahri getAhri() {
return ahri;
}

@JsonProperty("Ahri")
public void setAhri(Ahri ahri) {
this.ahri = ahri;
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