package com.app.adacademy.model;

public class ModelHome {
    public int image;
    public String versionName;
    public String versionNumber;


    public ModelHome(String vName, String vNumber, int image)
    {
        this.versionName = vName;
        this.versionNumber = vNumber;
        this.image = image;
    }
}
