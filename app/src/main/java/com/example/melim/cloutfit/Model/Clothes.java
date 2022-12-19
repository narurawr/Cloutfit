package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Clothes implements Serializable {



    private String id_clothes;
    private String name_clothes;
    private String photo_clothes;

    private String name_type;
    private String id_style;
    private String name_dayNight;
    private String name_season;
    private String name_occasion;

    public Clothes (){

    }

    public Clothes(String id_clothes, String name_clothes, String photo_clothes
                    , String name_type, String id_style, String name_dayNight
                    , String name_season, String name_occasion) {

        this.id_clothes = id_clothes;
        this.name_clothes = name_clothes;
        this.photo_clothes = photo_clothes;

        this.name_type = name_type;
        this.id_style = id_style;
        this.name_dayNight = name_dayNight;
        this.name_season = name_season;
        this.name_occasion = name_occasion;

    }

    public String getId_clothes() {
        return id_clothes;
    }

    public void setId_clothes(String id_clothes) {
        this.id_clothes = id_clothes;
    }

    public String getName_clothes() {
        return name_clothes;
    }

    public void setName_clothes(String name_clothes) {
        this.name_clothes = name_clothes;
    }

    public String getPhoto_clothes() {
        return photo_clothes;
    }

    public void setPhoto_clothes(String photo_clothes) {
        this.photo_clothes = photo_clothes;
    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public String getId_style() {
        return id_style;
    }

    public void setId_style(String id_style) {
        this.id_style = id_style;
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


