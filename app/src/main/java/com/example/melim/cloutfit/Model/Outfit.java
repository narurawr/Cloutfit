package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Outfit implements Serializable {

    private String id_outfit;
    private String name_outfit;
    private String photo_outfit;
    private String name_dayNight;
    private String name_season;
    private String name_occasion;

    public Outfit (){
    }

    public Outfit(String id_outfit, String name_outfit, String photo_outfit
            , String name_dayNight, String name_season, String name_occasion) {

        this.id_outfit = id_outfit;
        this.name_outfit = name_outfit;
        this.photo_outfit = photo_outfit;

        this.name_dayNight = name_dayNight;
        this.name_season = name_season;
        this.name_occasion = name_occasion;
    }

    public String getId_outfit() {
        return id_outfit;
    }

    public void setId_outfit(String id_outfit) {
        this.id_outfit = id_outfit;
    }

    public String getName_outfit() {
        return name_outfit;
    }

    public void setName_outfit(String name_outfit) {
        this.name_outfit = name_outfit;
    }

    public String getPhoto_outfit() {
        return photo_outfit;
    }

    public void setPhoto_outfit(String photo_outfit) {
        this.photo_outfit = photo_outfit;
    }

    public String getName_dayNight() {
        return name_dayNight;
    }

    public void setName_dayNight(String name_dayNight) {
        this.name_dayNight = name_dayNight;
    }

    public String getName_season() {
        return name_season;
    }

    public void setName_season(String name_season) {
        this.name_season = name_season;
    }

    public String getName_occasion() {
        return name_occasion;
    }

    public void setName_occasion(String name_occasion) {
        this.name_occasion = name_occasion;
    }





}


