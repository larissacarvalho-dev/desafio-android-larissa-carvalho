package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

public class ItemRes {
    @SerializedName("resourceURI")
    private String resourceURI;

    @SerializedName("name")
    private String name;

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }
}
