package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class TypeOther implements Serializable {

    private String name_typeOther;
    private String name_subTypeOther;

    public TypeOther(){
    }

    public TypeOther(String name_typeOther, String name_subTypeOther) {

        this.name_typeOther = name_typeOther;
        this.name_subTypeOther = name_subTypeOther;

    }

    public String getName_typeOther() {
        return name_typeOther;
    }

    public void setName_typeOther(String name_typeOther) {
        this.name_typeOther = name_typeOther;
    }

    public String getName_subTypeOther() {
        return name_subTypeOther;
    }

    public void setName_subTypeOther(String name_subTypeOther) {
        this.name_subTypeOther = name_subTypeOther;
    }
}


