package com.example.melim.cloutfit.SQlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.melim.cloutfit.Utilities.UtilitiesDB;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {



    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilitiesDB.CREATE_TABLE_CLOTHES);
        db.execSQL(UtilitiesDB.CREATE_TABLE_COLOR);
        db.execSQL(UtilitiesDB.CREATE_TABLE_DAYNIGHT);
        db.execSQL(UtilitiesDB.CREATE_TABLE_OCCASION);
        db.execSQL(UtilitiesDB.CREATE_TABLE_OTHER);
        db.execSQL(UtilitiesDB.CREATE_TABLE_OUTFIT);
        db.execSQL(UtilitiesDB.CREATE_TABLE_OUTFIT_CLOTHES);
        db.execSQL(UtilitiesDB.CREATE_TABLE_OUTFIT_OTHER);
        db.execSQL(UtilitiesDB.CREATE_TABLE_SEASON);
        db.execSQL(UtilitiesDB.CREATE_TABLE_STYLE);
        db.execSQL(UtilitiesDB.CREATE_TABLE_SUBTYPE);
        db.execSQL(UtilitiesDB.CREATE_TABLE_SUBTYPEOTHER);
        db.execSQL(UtilitiesDB.CREATE_TABLE_TEXTURE);
        db.execSQL(UtilitiesDB.CREATE_TABLE_TYPE);
        db.execSQL(UtilitiesDB.CREATE_TABLE_TYPEOTHER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_COLOR);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_CLOTHES);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_DAYNIGHT);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_OCCASION);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_OTHER);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_OUTFIT);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_OUTFIT_CLOTHES);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_OUTFIT_OTHER);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_SEASON);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_STYLE);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_SUBTYPE);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_SUBTYPEOTHER);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_TEXTURE);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDB.TABLE_TYPEOTHER);
        onCreate(db);
    }
}

