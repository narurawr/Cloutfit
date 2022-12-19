package com.example.melim.cloutfit.Interfaces;


import com.example.melim.cloutfit.Fragments.AddOthersFragment;
import com.example.melim.cloutfit.Fragments.ContainerFragment;
import com.example.melim.cloutfit.Fragments.GreenFragment;
import com.example.melim.cloutfit.Fragments.MainFragment;
import com.example.melim.cloutfit.Fragments.NewClothesFragment;
import com.example.melim.cloutfit.Fragments.NewSeasonFragment;
import com.example.melim.cloutfit.Fragments.RedFragment;


/**
 * Created by CHENAO on 5/08/2017.
 */

public interface IFragments extends RedFragment.OnFragmentInteractionListener,
        GreenFragment.OnFragmentInteractionListener,
        ContainerFragment.OnFragmentInteractionListener,
        AddOthersFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener,
        NewClothesFragment.OnFragmentInteractionListener,
        NewSeasonFragment.OnFragmentInteractionListener{

}

