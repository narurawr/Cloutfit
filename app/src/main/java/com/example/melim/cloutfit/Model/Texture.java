package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Texture implements Serializable {

    private String name_texture;

    public Texture (){

    }

    public Texture(String name_texture) {
        this.name_texture = name_texture;

    }

    public String getName_texture() {
        return name_texture;
    }

    public void setName_texture(String name_texture) {
        this.name_texture = name_texture;
    }


}


