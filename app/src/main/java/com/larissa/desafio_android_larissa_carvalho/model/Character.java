package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Character {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnail")
    private CharacterThumbnail thumbnail;

    @SerializedName("resourceURI")
    private String resourceURI;

    public String getName() {
        return name;
    }

    public CharacterThumbnail getThumbnail() {
        return thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public String getDescription() {
        if (description.isEmpty()){
             description= "Descrição vazia.";
            return description;
        }else {
            return description;
        }
    }
}
