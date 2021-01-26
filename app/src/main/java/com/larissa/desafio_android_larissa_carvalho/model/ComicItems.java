package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

public class ComicItems {

    @SerializedName("name")
    private String name;

    @SerializedName("resourceURI")
    private String uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
