package com.larissa.desafio_android_larissa_carvalho.model.responses;

import com.google.gson.annotations.SerializedName;
import com.larissa.desafio_android_larissa_carvalho.model.Comic;

import java.util.List;

public class ComicResponseData {

    @SerializedName("ofsset")
    private int offset;

    @SerializedName("limit")
    private int limit;

    @SerializedName("total")
    private int total;

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<Comic> results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<Comic> getResults() {
        return results;
    }
}
