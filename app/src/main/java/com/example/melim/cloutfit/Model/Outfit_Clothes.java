package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Outfit_Clothes implements Serializable {

    private String id_outfit;
    private String id_clothes;


    public String getId_outfit() {
        return id_outfit;
    }

    public void setId_outfit(String id_outfit) {
        this.id_outfit = id_outfit;
    }

    public String getId_clothes() {
        return id_clothes;
    }

    public void setId_clothes(String id_clothes) {
        this.id_clothes = id_clothes;
    }

    public Outfit_Clothes (){

    }

    public Outfit_Clothes(String id_outfit, String id_clothes) {

        this.id_outfit = id_outfit;
        this.id_clothes = id_clothes;

    }

}


