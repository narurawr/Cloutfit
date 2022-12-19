package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Season implements Serializable {
    private String name_season;

    public Season (){

    }
    
    public Season(String name_season) {
        this.name_season = name_season;

    }

    public String getName_season() {
        return name_season;
    }

    public void setName_season(String name_season) {
        this.name_season = name_season;
    }
}


