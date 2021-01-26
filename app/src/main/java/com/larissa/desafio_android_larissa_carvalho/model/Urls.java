package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
