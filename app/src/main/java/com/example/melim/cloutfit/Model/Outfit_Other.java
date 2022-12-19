package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Outfit_Other implements Serializable {

    private String id_outfit;
    private String id_other;



    public Outfit_Other (){

    }
    public Outfit_Other(String id_outfit, String id_other) {

        this.id_outfit = id_outfit;
        this.id_other = id_other;

    }

    public String getId_outfit() {
        return id_outfit;
    }

    public void setId_outfit(String id_outfit) {
        this.id_outfit = id_outfit;
    }

    public String getId_other() {
        return id_other;
    }

    public void setId_other(String id_other) {
        this.id_other = id_other;
    }




}


