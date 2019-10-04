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
"hp",
"hpperlevel",
"mp",
"mpperlevel",
"movespeed",
"armor",
"armorperlevel",
"spellblock",
"spellblockperlevel",
"attackrange",
"hpregen",
"hpregenperlevel",
"mpregen",
"mpregenperlevel",
"crit",
"critperlevel",
"attackdamage",
"attackdamageperlevel",
"attackspeedoffset",
"attackspeedperlevel"
})
public class Stats {

@JsonProperty("hp")
private Double hp;
@JsonProperty("hpperlevel")
private Integer hpperlevel;
@JsonProperty("mp")
private Double mp;
@JsonProperty("mpperlevel")
private Integer mpperlevel;
@JsonProperty("movespeed")
private Integer movespeed;
@JsonProperty("armor")
private Double armor;
@JsonProperty("armorperlevel")
private Double armorperlevel;
@JsonProperty("spellblock")
private Double spellblock;
@JsonProperty("spellblockperlevel")
private Double spellblockperlevel;
@JsonProperty("attackrange")
private Integer attackrange;
@JsonProperty("hpregen")
private Double hpregen;
@JsonProperty("hpregenperlevel")
private Double hpregenperlevel;
@JsonProperty("mpregen")
private Integer mpregen;
@JsonProperty("mpregenperlevel")
private Integer mpregenperlevel;
@JsonProperty("crit")
private Integer crit;
@JsonProperty("critperlevel")
private Integer critperlevel;
@JsonProperty("attackdamage")
private Double attackdamage;
@JsonProperty("attackdamageperlevel")
private Double attackdamageperlevel;
@JsonProperty("attackspeedoffset")
private Double attackspeedoffset;
@JsonProperty("attackspeedperlevel")
private Integer attackspeedperlevel;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("hp")
public Double getHp() {
return hp;
}

@JsonProperty("hp")
public void setHp(Double hp) {
this.hp = hp;
}

@JsonProperty("hpperlevel")
public Integer getHpperlevel() {
return hpperlevel;
}

@JsonProperty("hpperlevel")
public void setHpperlevel(Integer hpperlevel) {
this.hpperlevel = hpperlevel;
}

@JsonProperty("mp")
public Double getMp() {
return mp;
}

@JsonProperty("mp")
public void setMp(Double mp) {
this.mp = mp;
}

@JsonProperty("mpperlevel")
public Integer getMpperlevel() {
return mpperlevel;
}

@JsonProperty("mpperlevel")
public void setMpperlevel(Integer mpperlevel) {
this.mpperlevel = mpperlevel;
}

@JsonProperty("movespeed")
public Integer getMovespeed() {
return movespeed;
}

@JsonProperty("movespeed")
public void setMovespeed(Integer movespeed) {
this.movespeed = movespeed;
}

@JsonProperty("armor")
public Double getArmor() {
return armor;
}

@JsonProperty("armor")
public void setArmor(Double armor) {
this.armor = armor;
}

@JsonProperty("armorperlevel")
public Double getArmorperlevel() {
return armorperlevel;
}

@JsonProperty("armorperlevel")
public void setArmorperlevel(Double armorperlevel) {
this.armorperlevel = armorperlevel;
}

@JsonProperty("spellblock")
public Double getSpellblock() {
return spellblock;
}

@JsonProperty("spellblock")
public void setSpellblock(Double spellblock) {
this.spellblock = spellblock;
}

@JsonProperty("spellblockperlevel")
public Double getSpellblockperlevel() {
return spellblockperlevel;
}

@JsonProperty("spellblockperlevel")
public void setSpellblockperlevel(Double spellblockperlevel) {
this.spellblockperlevel = spellblockperlevel;
}

@JsonProperty("attackrange")
public Integer getAttackrange() {
return attackrange;
}

@JsonProperty("attackrange")
public void setAttackrange(Integer attackrange) {
this.attackrange = attackrange;
}

@JsonProperty("hpregen")
public Double getHpregen() {
return hpregen;
}

@JsonProperty("hpregen")
public void setHpregen(Double hpregen) {
this.hpregen = hpregen;
}

@JsonProperty("hpregenperlevel")
public Double getHpregenperlevel() {
return hpregenperlevel;
}

@JsonProperty("hpregenperlevel")
public void setHpregenperlevel(Double hpregenperlevel) {
this.hpregenperlevel = hpregenperlevel;
}

@JsonProperty("mpregen")
public Integer getMpregen() {
return mpregen;
}

@JsonProperty("mpregen")
public void setMpregen(Integer mpregen) {
this.mpregen = mpregen;
}

@JsonProperty("mpregenperlevel")
public Integer getMpregenperlevel() {
return mpregenperlevel;
}

@JsonProperty("mpregenperlevel")
public void setMpregenperlevel(Integer mpregenperlevel) {
this.mpregenperlevel = mpregenperlevel;
}

@JsonProperty("crit")
public Integer getCrit() {
return crit;
}

@JsonProperty("crit")
public void setCrit(Integer crit) {
this.crit = crit;
}

@JsonProperty("critperlevel")
public Integer getCritperlevel() {
return critperlevel;
}

@JsonProperty("critperlevel")
public void setCritperlevel(Integer critperlevel) {
this.critperlevel = critperlevel;
}

@JsonProperty("attackdamage")
public Double getAttackdamage() {
return attackdamage;
}

@JsonProperty("attackdamage")
public void setAttackdamage(Double attackdamage) {
this.attackdamage = attackdamage;
}

@JsonProperty("attackdamageperlevel")
public Double getAttackdamageperlevel() {
return attackdamageperlevel;
}

@JsonProperty("attackdamageperlevel")
public void setAttackdamageperlevel(Double attackdamageperlevel) {
this.attackdamageperlevel = attackdamageperlevel;
}

@JsonProperty("attackspeedoffset")
public Double getAttackspeedoffset() {
return attackspeedoffset;
}

@JsonProperty("attackspeedoffset")
public void setAttackspeedoffset(Double attackspeedoffset) {
this.attackspeedoffset = attackspeedoffset;
}

@JsonProperty("attackspeedperlevel")
public Integer getAttackspeedperlevel() {
return attackspeedperlevel;
}

@JsonProperty("attackspeedperlevel")
public void setAttackspeedperlevel(Integer attackspeedperlevel) {
this.attackspeedperlevel = attackspeedperlevel;
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