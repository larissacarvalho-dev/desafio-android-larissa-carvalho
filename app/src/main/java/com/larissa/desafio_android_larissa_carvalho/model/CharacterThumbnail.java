package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

public class CharacterThumbnail {

    @SerializedName("path")
    private String path;

    @SerializedName("extension")
    private String extension;

    private String image;

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public String getImage() {
        return path + "." + extension;
    }

}
