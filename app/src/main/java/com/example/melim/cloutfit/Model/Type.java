package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Type implements Serializable {

    private String name_type;
    private String name_subType;

    public Type (){
    }

    public Type(String name_type, String name_subType) {
        this.name_type = name_type;
        this.name_subType = name_subType;

    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public String getName_subType() {
        return name_subType;
    }

    public void setName_subType(String name_subType) {
        this.name_subType = name_subType;
    }
}


