package com.example.override_fivemonthn.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

public class BoredAction {
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("activity")
    @Expose
    private String activity;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("participents")
    @Expose
    private Integer participents;
    @Expose
    @SerializedName("price")
    private Float price;
    @Expose
    @SerializedName("link")

    private String link;
    @SerializedName("accessibility")
    @Expose
    private Float accessibility;

    public BoredAction(String key, String activity, String type, Integer participents, Float price, String link, Float accessibility) {
        this.key = key;
        this.activity = activity;
        this.type = type;
        this.participents = participents;
        this.price = price;
        this.link = link;
        this.accessibility = accessibility;
    }

    public BoredAction() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParticipents() {
        return participents;
    }

    public void setParticipents(Integer participents) {
        this.participents = participents;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Float accessibility) {
        this.accessibility = accessibility;
    }


    @NotNull
    @Override
    public String toString() {
        return "BoredActivity{" +
                "key='" + key + '\'' +
                ", activity='" + activity + '\'' +
                ", type='" + type + '\'' +
                ", participents=" + participents +
                ", price=" + price +
                ", link='" + link + '\'' +
                ", accessibility=" + accessibility +
                '}';
    }
}



