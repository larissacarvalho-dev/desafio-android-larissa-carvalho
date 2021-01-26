package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterSummary {

    @SerializedName("available")
    private Integer available;

    @SerializedName("collectionURI")
    private String collectionURI;

    @SerializedName("items")
    private List<ItemRes> items = null;

    @SerializedName("returned")
    private Integer returned;

    public Integer getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<ItemRes> getItems() {
        return items;
    }

    public Integer getReturned() {
        return returned;
    }
}
