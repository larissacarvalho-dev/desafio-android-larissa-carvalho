package com.larissa.desafio_android_larissa_carvalho.model.responses;

import com.google.gson.annotations.SerializedName;

public class ComicResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private String status;

    @SerializedName("etag")
    private String etag;

    @SerializedName("data")
    private ComicResponseData data;

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getEtag() {
        return etag;
    }

    public ComicResponseData getData() {
        return data;
    }
}
