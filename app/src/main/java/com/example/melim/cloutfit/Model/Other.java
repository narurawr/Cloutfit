package com.example.melim.cloutfit.Model;

import java.io.Serializable;

/**
 * Created by melim on 16-03-2018.
 */

public class Other implements Serializable {

    private String id_other;
    private String name_other;
    private String photo_other;
    private String name_typeOther;

    public Other (){
    }

    public Other(String id_other, String name_other, String photo_other
                  , String name_typeOther) {
        this.id_other = id_other;
        this.name_other = name_other;
        this.photo_other = photo_other;
        this.name_typeOther = name_typeOther;
    }

    public String getId_other() {
        return id_other;
    }

    public void setId_other(String id_other) {
        this.id_other = id_other;
    }

    public String getName_other() {
        return name_other;
    }

    public void setName_other(String name_other) {
        this.name_other = name_other;
    }

    public String getPhoto_other() {
        return photo_other;
    }

    public void setPhoto_other(String photo_other) {
        this.photo_other = photo_other;
    }

    public String getName_typeOther() {
        return name_typeOther;
    }

    public void setName_typeOther(String name_typeOther) {
        this.name_typeOther = name_typeOther;
    }

}


