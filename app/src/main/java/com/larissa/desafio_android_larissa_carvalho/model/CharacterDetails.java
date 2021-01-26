package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterDetails {

    @SerializedName("resourceURI")
    private String resourceURI;

    @SerializedName("description")
    private String description;

    @SerializedName("comics")
    private Comic comic;

    @SerializedName("events")
    private Events events;

    @SerializedName("stories")
    private Stories stories;

    @SerializedName("series")
    private Series series;

    @SerializedName("urls")
    private List<Urls> urls;

    @SerializedName("modified")
    private String modified;

}
