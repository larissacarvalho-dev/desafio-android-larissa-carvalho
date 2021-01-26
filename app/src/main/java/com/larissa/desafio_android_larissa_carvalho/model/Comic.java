package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.Url;

public class Comic {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("urls")
    private List<Urls> urls;

    @SerializedName("prices")
    private List<Price> prices;

    @SerializedName("thumbnail")
    CharacterThumbnail thumbnail;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Urls> getUrls() {
        return urls;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public CharacterThumbnail getThumbnail() {
        return thumbnail;
    }
}
