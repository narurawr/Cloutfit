package com.example.melim.cloutfit.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENAO on 15/06/2017.
 */

public class SectionsAdapter extends FragmentStatePagerAdapter{

    private final List<Fragment> listaFragments=new ArrayList<>();
    private final List<String> listaTitulos=new ArrayList<>();

    public SectionsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment,String titulo){
        listaFragments.add(fragment);
        listaTitulos.add(titulo);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }
}
