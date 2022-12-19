package com.example.melim.cloutfit.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.melim.cloutfit.R;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

// Actividad inicial que posee solo un boton

public class Home extends AppCompatActivity {
    Intent ipd;
    Button btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pushButtons();
    }

    public void pushButtons(){
        //Botones
        btHome = (Button) findViewById(R.id.btHome);

        //Apretar Botones
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipd = new Intent(getApplicationContext(),NewSeason.class);
                startActivity(ipd);
            }
        });


    }


}
