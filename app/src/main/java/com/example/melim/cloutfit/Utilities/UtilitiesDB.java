package com.example.melim.cloutfit.Utilities;

public class UtilitiesDB {


    //Constantes campos tabla CLOTHES
    public static final String TABLE_CLOTHES ="Clothes";
    public static final String ID_CLOTHES ="id_clothes";
    public static final String NAME_CLOTHES="name_clothes";
    public static final String PHOTO_CLOTHES="photo_clothes";
    public static final String ID_STYLE_CLOTHES="id_style";
    public static final String NAME_TYPE_CLOTHES="name_clothes";
    public static final String NAME_DAYNIGHT_CLOTHES="name_daynight";
    public static final String NAME_SEASON_CLOTHES="name_season";
    public static final String NAME_OCCASION_CLOTHES="name_occasion";

    public static final String CREATE_TABLE_CLOTHES ="CREATE TABLE "
            + TABLE_CLOTHES +" ("+ ID_CLOTHES +"INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_CLOTHES +" TEXT,"
            + PHOTO_CLOTHES +" TEXT,"
            + ID_STYLE_CLOTHES +" TEXT,"
            + NAME_DAYNIGHT_CLOTHES +" TEXT,"
            + NAME_SEASON_CLOTHES +" TEXT,"
            + NAME_OCCASION_CLOTHES +" TEXT)";



    //Constantes campos tabla COLOR
    public static final String TABLE_COLOR ="Color";
    public static final String ID_COLOR ="id_color";


    public static final String CREATE_TABLE_COLOR ="CREATE TABLE " +
            ""+ TABLE_COLOR +" ("+ ID_COLOR +" TEXT)";




    //Constantes campos tabla DAYNIGHT
    public static final String TABLE_DAYNIGHT ="DayNight";
    public static final String NAME_DAYNIGHT ="name_dayNight";


    public static final String CREATE_TABLE_DAYNIGHT ="CREATE TABLE " +
            ""+ TABLE_DAYNIGHT +" ("+ NAME_DAYNIGHT +" TEXT)";




    //Constantes campos tabla OCCASION
    public static final String TABLE_OCCASION ="Occasion";
    public static final String NAME_OCCASION ="name_occasion";


    public static final String CREATE_TABLE_OCCASION ="CREATE TABLE " +
            ""+ TABLE_OCCASION +" ("+ NAME_OCCASION +" TEXT)";



    //Constantes campos tabla OTHER
    public static final String TABLE_OTHER ="Other";
    public static final String ID_OTHER ="id_other";
    public static final String NAME_OTHER="name_other";
    public static final String PHOTO_OTHER="photo_other";
    public static final String NAME_TYPEOTHER_OTHER ="name_occasion";

    public static final String CREATE_TABLE_OTHER ="CREATE TABLE " +
            ""+ TABLE_OTHER +" ("+ ID_OTHER +"INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_OTHER +" TEXT,"
            + PHOTO_OTHER +" TEXT,"
            + NAME_TYPEOTHER_OTHER +" TEXT)";



    //Constantes campos tabla OUTFIT
    public static final String TABLE_OUTFIT ="Outfit";
    public static final String ID_OUTFIT ="id_outfit";
    public static final String NAME_OUTFIT="name_outfit";
    public static final String PHOTO_OUTFIT="photo_outfit";
    public static final String NAME_DAYNIGHT_OUTFIT="name_daynight";
    public static final String NAME_SEASON_OUTFIT="name_season";
    public static final String NAME_OCCASION_OUTFIT="name_occasion";

    public static final String CREATE_TABLE_OUTFIT ="CREATE TABLE "
            + TABLE_OUTFIT +" ("+ ID_OUTFIT +"INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_OUTFIT +" TEXT,"
            + PHOTO_OUTFIT +" TEXT,"
            + NAME_DAYNIGHT_OUTFIT +" TEXT,"
            + NAME_SEASON_OUTFIT +" TEXT,"
            + NAME_OCCASION_OUTFIT +" TEXT)";


    //Constantes campos tabla OUTFIT_CLOTHES
    public static final String TABLE_OUTFIT_CLOTHES ="Outfit_clothes";
    public static final String ID_OUTFIT_OC ="id_outfit";
    public static final String ID_CLOTHES_OC ="id_clothes";

    public static final String CREATE_TABLE_OUTFIT_CLOTHES ="CREATE TABLE " +
            ""+ TABLE_OUTFIT_CLOTHES +" ("+ ID_OUTFIT_OC +" TEXT,"
            + ID_CLOTHES_OC +" TEXT)";


    //Constantes campos tabla OUTFIT_OTHER
    public static final String TABLE_OUTFIT_OTHER ="Outfit_other";
    public static final String ID_OUTFIT_OO ="id_outfit";
    public static final String ID_OTHER_OO ="id_other";

    public static final String CREATE_TABLE_OUTFIT_OTHER ="CREATE TABLE " +
            ""+ TABLE_OUTFIT_OTHER +" ("+ ID_OUTFIT_OO +" TEXT,"
            + ID_OTHER_OO +" TEXT)";



    //Constantes campos tabla SEASON
    public static final String TABLE_SEASON ="Season";
    public static final String NAME_SEASON ="name_season";


    public static final String CREATE_TABLE_SEASON ="CREATE TABLE " +
            ""+ TABLE_SEASON +" ("+ NAME_SEASON +" TEXT)";


    //Constantes campos tabla STYLE
    public static final String TABLE_STYLE ="Style";
    public static final String ID_STYLE ="id_style";
    public static final String ID_COLOR_STYLE ="id_color";
    public static final String NAME_TEXTURE_STYLE ="name_texture";


    public static final String CREATE_TABLE_STYLE ="CREATE TABLE " +
            ""+ TABLE_STYLE +" ("+ ID_STYLE +"INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ID_COLOR_STYLE +" TEXT,"
            + NAME_TEXTURE_STYLE+" TEXT)";



    //Constantes campos tabla SUBTYPE
    public static final String TABLE_SUBTYPE ="SubType";
    public static final String NAME_SUBTYPE ="name_subType";



    public static final String CREATE_TABLE_SUBTYPE ="CREATE TABLE "
            + TABLE_SUBTYPE +" ("+ NAME_SUBTYPE +" TEXT)";




    //Constantes campos tabla SUBTYPEOTHER
    public static final String TABLE_SUBTYPEOTHER ="SuvTypeOther";
    public static final String NAME_SUBTYPEOTHER ="name_typeOther";



    public static final String CREATE_TABLE_SUBTYPEOTHER ="CREATE TABLE "
            + TABLE_SUBTYPEOTHER +" ("+ NAME_SUBTYPEOTHER +" TEXT)";


    //Constantes campos tabla TEXTURE
    public static final String TABLE_TEXTURE ="Texture";
    public static final String NAME_TEXTURE ="name_texture";


    public static final String CREATE_TABLE_TEXTURE ="CREATE TABLE "
            + TABLE_TEXTURE +" ("+ NAME_TEXTURE +" TEXT)";

    

    //Constantes campos tabla TYPE
    public static final String TABLE_TYPE ="Type";
    public static final String NAME_TYPE ="name_type";
    public static final String NAME_SUBTYPE_TYPE ="name_subtype";



    public static final String CREATE_TABLE_TYPE ="CREATE TABLE "
            + TABLE_TYPE +" ("+ NAME_TYPE +" TEXT,"
            + NAME_SUBTYPE_TYPE +" TEXT)";


    //Constantes campos tabla TYPEOTHER
    public static final String TABLE_TYPEOTHER ="TypeOther";
    public static final String NAME_TYPEOTHER ="name_typeOther";
    public static final String NAME_SUBTYPEOTHER_TYPEOTHER ="name_subtypeOther";



    public static final String CREATE_TABLE_TYPEOTHER ="CREATE TABLE "
            + TABLE_TYPEOTHER +" ("+ NAME_TYPEOTHER +" TEXT,"
            + NAME_SUBTYPEOTHER_TYPEOTHER +" TEXT)";



}
