package com.larissa.desafio_android_larissa_carvalho.model.responses;

import com.google.gson.annotations.SerializedName;
import com.larissa.desafio_android_larissa_carvalho.model.Character;

import java.util.List;

public class CharacterResponseData {

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    @SerializedName("total")
    private Integer totalPages;

    @SerializedName("results")
    private List<Character> results;

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public List<Character> getResults() {
        return results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

}
