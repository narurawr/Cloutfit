package com.example.melim.cloutfit.Views;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.melim.cloutfit.Fragments.AddOthersFragment;
import com.example.melim.cloutfit.Fragments.ContainerFragment;
import com.example.melim.cloutfit.Fragments.GreenFragment;
import com.example.melim.cloutfit.Fragments.MainFragment;
import com.example.melim.cloutfit.Fragments.NewClothesFragment;
import com.example.melim.cloutfit.Fragments.NewSeasonFragment;
import com.example.melim.cloutfit.Fragments.RedFragment;
import com.example.melim.cloutfit.Interfaces.IFragments;
import com.example.melim.cloutfit.Others.Utilities;
import com.example.melim.cloutfit.R;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,IFragments {

    //Barra de Inicio
    private Toolbar toolbar;

    //-----------------[METODOS DE ACTIVIDAD]----------------------
    @Override
    //Metodo que inizicaliza la actividad
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activar barra de incio
        pushToolbar();

    }

    //Metodo de Barra Inicio
    public void pushToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if (Utilities.validaPantalla==true){
            Fragment fragment=new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            Utilities.validaPantalla=false;
        }



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    //Funcionnes de menus (abrir y cerrar)
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //Crear Opciones del Menu Derecho
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //Simplifica la barra
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Uso de opciones de Menu Derecho
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment=null;
        boolean fragmentSeleccionado=false;


        if (id == R.id.nav_camera) {
           miFragment=new NewClothesFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_gallery) {
            miFragment=new RedFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_slideshow) {
            miFragment=new NewSeasonFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_share) {
            miFragment=new ContainerFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_send) {
           miFragment=new AddOthersFragment();
            fragmentSeleccionado=true;
        }

        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Uso de Fragmento
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
