package com.larissa.desafio_android_larissa_carvalho.model.responses;

import com.google.gson.annotations.SerializedName;

public class CharacterDetailsResponse {

    @SerializedName("data")
    private CharacterResponseDataDetails data;

    public CharacterResponseDataDetails getData() {
        return data;
    }
}
