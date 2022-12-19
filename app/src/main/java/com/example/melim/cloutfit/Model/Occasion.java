package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Occasion implements Serializable {

    private String name_occasion;

    public Occasion (){
    }

    public Occasion(String name_occasion) {
        this.name_occasion = name_occasion;
    }

    public String getName_occasion() {
        return name_occasion;
    }

    public void setName_occasion(String name_occasion) {
        this.name_occasion = name_occasion;
    }
}


