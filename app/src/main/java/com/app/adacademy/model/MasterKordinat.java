package com.app.adacademy.model;

import com.orm.SugarRecord;

public class MasterKordinat extends SugarRecord {

    private Long id;
    private String name;
    private Double lat;
    private Double lon;

    public MasterKordinat(){

    }

    public MasterKordinat(Long id, String name, Double lat, Double lon) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
