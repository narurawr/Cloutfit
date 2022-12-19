package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class SubTypeOther implements Serializable {

    private String name_subTypeOther;

    public SubTypeOther (){
    }

    public SubTypeOther(String name_subTypeOther) {
        this.name_subTypeOther = name_subTypeOther;

    }

    public String getName_subTypeOther() {
        return name_subTypeOther;
    }

    public void setName_subTypeOther(String name_subTypeOther) {
        this.name_subTypeOther = name_subTypeOther;
    }
}


