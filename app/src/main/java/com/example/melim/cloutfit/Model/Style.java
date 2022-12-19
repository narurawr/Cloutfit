package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Style implements Serializable {



    private String id_style;

    private String id_color;
    private String name_texture;

    public Style(){

}
    public Style(String id_style, String id_color, String name_texture) {

        this.id_style = id_style;
        this.id_color = id_color;
        this.name_texture = name_texture;
    }

    public String getId_style() {
        return id_style;
    }

    public void setId_style(String id_style) {
        this.id_style = id_style;
    }

    public String getId_color() {
        return id_color;
    }

    public void setId_color(String id_color) {
        this.id_color = id_color;
    }

    public String getName_texture() {
        return name_texture;
    }

    public void setName_texture(String name_texture) {
        this.name_texture = name_texture;
    }
}


