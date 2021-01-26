package com.larissa.desafio_android_larissa_carvalho.model;

import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("type")
    private String type;

    @SerializedName("price")
    private Double price;

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }
}
