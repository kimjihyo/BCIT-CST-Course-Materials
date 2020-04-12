package com.jihyokim.async_lecturedemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseToon {
    @SerializedName("toons")
    @Expose
    private ArrayList<Toon> toons = new ArrayList<>();

    public ArrayList<Toon> getToons() {
        return toons;
    }

    public void setToons(ArrayList<Toon> toons) {
        this.toons = toons;
    }
}
