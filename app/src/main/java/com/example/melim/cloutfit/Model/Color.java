package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Color implements Serializable {

    private String id_color;

    public Color (){
    }

    public Color(String id_color) {
        this.id_color = id_color;
    }

    public String getId_color() {
        return id_color;
    }

    public void setId_color(String id_color) {
        this.id_color = id_color;
    }
}


