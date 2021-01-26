package com.larissa.desafio_android_larissa_carvalho.model.responses;

import com.google.gson.annotations.SerializedName;

public class CharacterResponse {

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("attributionText")
    private String attributionText;

    @SerializedName("attributionHTML")
    private String attributionHTML;

    @SerializedName("data")
    private CharacterResponseData data;

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public CharacterResponseData getData() {
        return data;
    }
}
