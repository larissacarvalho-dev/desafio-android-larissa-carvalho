package com.larissa.desafio_android_larissa_carvalho.model.responses;

import com.google.gson.annotations.SerializedName;
import com.larissa.desafio_android_larissa_carvalho.model.CharacterDetails;

import java.util.List;

public class CharacterResponseDataDetails {

    @SerializedName("results")
    private List<CharacterDetails> results;

    public List<CharacterDetails> getResults() {
        return results;
    }
}
