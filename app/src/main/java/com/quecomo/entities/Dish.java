package com.quecomo.entities;

import com.orm.SugarRecord;

/**
 * Created by armando on 12/02/18.
 */

public class Dish extends SugarRecord {

    private String name;
    private String season;

    public Dish() {
    }

    public Dish(String name, String season) {
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
