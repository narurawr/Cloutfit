package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class DayNight implements Serializable {

    private String name_dayNight;

    public DayNight(){
    }

    public DayNight(String name_dayNight) {
        this.name_dayNight = name_dayNight;

    }
    public String getName_dayNight() {
        return name_dayNight;
    }

    public void setName_dayNight(String name_dayNight) {
        this.name_dayNight = name_dayNight;
    }
}


