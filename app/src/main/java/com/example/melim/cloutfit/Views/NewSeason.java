package com.example.melim.cloutfit.Views;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.melim.cloutfit.R;
import com.example.melim.cloutfit.SQlite.ConexionSQLiteHelper;
import com.example.melim.cloutfit.Utilities.UtilitiesDB;


public class NewSeason extends AppCompatActivity {

    //Barra de Inicio
    private Toolbar toolbar;

    private EditText txSeason;
    private Button btAddSeason;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newseason);

        txSeason = (EditText) findViewById(R.id.nameseason_newseason1);

        pushButtons();
        }

    //Metodo Botones
    public void pushButtons() {

        //Botones
        btAddSeason = (Button) findViewById(R.id.btAddSeason1);
        btAddSeason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarSeason();
            }
        });

    }

    private void registrarSeasonSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_cloutfit",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')

        String insert="INSERT INTO "+ UtilitiesDB.TABLE_SEASON
                +" ( " + UtilitiesDB.NAME_SEASON+")" +
                " VALUES ("+txSeason.getText().toString()+"')";
        //   " VALUES ("+campoId.getText().toString()+"')";
        db.execSQL(insert);


        db.close();
    }

    private void registrarSeason() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_cloutfit",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UtilitiesDB.NAME_SEASON,txSeason.getText().toString());
        // values.put(UtilitiesDB.ID_SEASON,campoId.getText().toString());
        Long idResultante=db.insert(UtilitiesDB.TABLE_SEASON,UtilitiesDB.NAME_SEASON,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }














}

