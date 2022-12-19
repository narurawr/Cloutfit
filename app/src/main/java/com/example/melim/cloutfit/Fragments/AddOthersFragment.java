package com.example.melim.cloutfit.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.melim.cloutfit.Adapters.SectionsAdapter;
import com.example.melim.cloutfit.Others.Utilities;
import com.example.melim.cloutfit.R;


public class AddOthersFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    View vista;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public AddOthersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContenedorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddOthersFragment newInstance(String param1, String param2) {
        AddOthersFragment fragment = new AddOthersFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_add_others, container, false);



        if(Utilities.rotacion==0){
            View parent= (View) container.getParent();

            if(appBar==null){
                appBar= (AppBarLayout) parent.findViewById(R.id.appBar);
                pestanas=new TabLayout(getActivity());
                pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
                appBar.addView(pestanas);


                viewPager= (ViewPager) vista.findViewById(R.id.idViewPagerAddOthers);
                llenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestanas.setupWithViewPager(viewPager);
            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else{
            Utilities.rotacion=1;
        }


        return vista;
    }

    private void llenarViewPager(ViewPager viewPager) {
        SectionsAdapter adapter=new SectionsAdapter(getFragmentManager());
        adapter.addFragment(new GreenFragment(),"VERDE");
        adapter.addFragment(new NewSeasonFragment(),"SEASON");
        adapter.addFragment(new RedFragment(),"ROJO");

        viewPager.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(Utilities.rotacion==0){
            appBar.removeView(pestanas);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
