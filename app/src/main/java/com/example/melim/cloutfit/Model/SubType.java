package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class SubType implements Serializable {

    private String name_subType;


    public SubType (){
    }

    public SubType(String name_subType) {
        this.name_subType = name_subType;
    }

    public String getName_subType() {
    return name_subType;
    }

    public void setName_subType(String name_subType) {
        this.name_subType = name_subType;
    }

}

