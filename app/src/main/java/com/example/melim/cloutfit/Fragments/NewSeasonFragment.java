package com.example.melim.cloutfit.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.melim.cloutfit.R;
import com.example.melim.cloutfit.SQlite.ConexionSQLiteHelper;
import com.example.melim.cloutfit.Utilities.UtilitiesDB;

import java.io.IOException;


public class NewSeasonFragment extends Fragment {

    //Botones
    private EditText txSeason;
    private Button btAddSeason;

    private ConexionSQLiteHelper conn;
    private SQLiteDatabase db;
    private ContentValues values;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private MiTareaAsincrona tarea1;

    public NewSeasonFragment() {
        // Required empty public constructor
    }

    public static NewSeasonFragment newInstance(String param1, String param2) {
        NewSeasonFragment fragment = new NewSeasonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        conn = new ConexionSQLiteHelper(getActivity(),"bd_clt",null,1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_new_season, container, false);


        txSeason = (EditText) vista.findViewById(R.id.nameseason_newseason);
        btAddSeason = (Button) vista.findViewById(R.id.btAddSeason);



        btAddSeason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarea1 = new MiTareaAsincrona();
                tarea1.execute();
            }
        });




    return vista;
    }

    private class MiTareaAsincrona extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            for(int i=1; i<=10; i++) {
                registrarSeason();

                publishProgress(i*10);

                if(isCancelled())
                    break;
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();

            //pbarProgreso.setProgress(progreso);
        }

        @Override
        protected void onPreExecute() {
            // pbarProgreso.setMax(100);
            // pbarProgreso.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result)
                Toast.makeText(getContext(), "Tarea finalizada!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(getContext(), "Tarea cancelada!", Toast.LENGTH_SHORT).show();
        }
    }
    private void registrarSeason() {
       db = conn.getWritableDatabase();

        values=new ContentValues();
        values.put(UtilitiesDB.NAME_SEASON,txSeason.getText().toString());
        Long idResultante= db.insert(UtilitiesDB.TABLE_SEASON,UtilitiesDB.NAME_SEASON,values);

        Toast.makeText(getContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
