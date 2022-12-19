package com.example.melim.cloutfit.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.melim.cloutfit.Model.DayNight;
import com.example.melim.cloutfit.Model.Occasion;
import com.example.melim.cloutfit.Model.Season;
import com.example.melim.cloutfit.Model.Texture;
import com.example.melim.cloutfit.Model.Type;
import com.example.melim.cloutfit.R;
import com.example.melim.cloutfit.SQlite.ConexionSQLiteHelper;
import com.example.melim.cloutfit.Utilities.UtilitiesDB;


import java.io.File;
import java.util.ArrayList;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.app.Activity.RESULT_OK;


public class NewClothesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //Conexion SqLite
    private ConexionSQLiteHelper conn;

    //Listas
    private Spinner spSeason;
    private Spinner spOccasion;
    private Spinner spDayNight;
    private Spinner spTexture;
    private Spinner spType;

    //Texto
    private EditText editxNameClothes;

    //Botones
    private Button btColor;
    private Button btPhoto;
    private Button btAddNewClothes;

    //Textos
    private TextView txColor;
    private TextView txtIdClothes;
    private TextView txtIdStyle;

    //Listas
    private ArrayList<String> listSeasonString;
    private ArrayList<Season> listSeason;

    private ArrayList<String> listOccasionString;
    private ArrayList<Occasion> listOccasion;

    private ArrayList<String> listDayNightString;
    private ArrayList<DayNight> listDayNight;

    private ArrayList<String> listTextureString;
    private ArrayList<Texture> listTexture;

    private ArrayList<String> listTypeString;
    private ArrayList<Type> listType;

    //Rutras
    private final String ROOT_FOLDER = "cloutfit/";
    private final String IMAGE_ROUTE = ROOT_FOLDER +"myClothes";

    //Cod
    private final int COD_SELECT =10;
    private final int COD_PHOTO =20;

    //Imagenes
    private ImageView imagen;
    private String path;

    //Intentos
    private Intent ipd;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    //Variables para registro
    private String idClothes, nameClothes, photoClothes;
    private String nameDayNight, nameSeason, nameOccasion;
    private String nameType;
    private String idStyle, idColor, nameTexture;

    //-----------------[CONSTRUCTORES]----------------------

    public NewClothesFragment() {
        // Required empty public constructor
    }

    public static NewClothesFragment newInstance(String param1, String param2) {
        NewClothesFragment fragment = new NewClothesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    //-----------------[METODOS DE FRAGMENTO]----------------------

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_new_clothes, container, false);

        //Se inicia la conexion
        conn=new ConexionSQLiteHelper(getContext(),"bd_cloutfit",null,1);

        idClothes="CLO"; //+ UUID.randomUUID().toString();
        idStyle="STY"; //+ UUID.randomUUID().toString();

        //Se Identifican las variables.
        //Imagen
        imagen= (ImageView) vista.findViewById(R.id.imagePhoto_newclothes);

        //Texto Editable
        editxNameClothes = (EditText) vista.findViewById(R.id.nameclothes_newclothes);

        //Textos Estaticos
        txColor = (TextView) vista.findViewById(R.id.idColor_newclothes);

        txtIdClothes = (TextView) vista.findViewById(R.id.idclothes_newclothes);
        txtIdClothes.setText(idClothes);

        txtIdStyle = (TextView) vista.findViewById(R.id.idStyle_newclothes);
        txtIdStyle.setText(idStyle);


        //Botones
        btColor = (Button) vista.findViewById(R.id.btColorAddClothes);
        btPhoto = (Button) vista.findViewById(R.id.btPhotoAddClothes);
        btAddNewClothes = (Button) vista.findViewById(R.id.btNewClothes);

        //Spinners
        spSeason = (Spinner) vista.findViewById(R.id.nameSeason_newclothes);
        spOccasion = (Spinner) vista.findViewById(R.id.nameOccasion_newclothes);
        spDayNight = (Spinner) vista.findViewById(R.id.nameDaynight_newclothes);
        spTexture = (Spinner) vista.findViewById(R.id.nameTexture_newclothes);
        spType = (Spinner) vista.findViewById(R.id.nameType_newclothes);

        //Acciones de Botones y Spiners
       // pushSpinner();
        pushButtons();
        
        return vista;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    //-----------------[BOTONES Y SPINERS]----------------------

    //Metodo Botones
    public void pushButtons() {

        if(validaPermisos()){
            btPhoto.setEnabled(true);
        }else{
            btPhoto.setEnabled(false);
        }


        btPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagen();
            }
        });


        btColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findColorClothes();
            }
        });

        btAddNewClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarColor();
                registrarStyle();
                registrarClothes();
                //deleteClothes();
            }
        });
    }

    //Metodo Spiners
    public void pushSpinner(){

        checkListSeason();
        checkListOccasion();
        checkListDayNight();
        checkListTexture();
        checkListType();

        //Season

        ArrayAdapter<CharSequence> adapterSeason=new ArrayAdapter
                (getContext(),android.R.layout.simple_spinner_item, listSeasonString);

        spSeason.setAdapter(adapterSeason);
        spSeason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

                if (position!=0){
                    nameSeason=listSeason.get(position-1).getName_season().toString();
                }else{
                    nameSeason="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        //Occasion

        ArrayAdapter<CharSequence> adapterOccasion=new ArrayAdapter
                (getContext(),android.R.layout.simple_spinner_item, listOccasionString);

        spOccasion.setAdapter(adapterOccasion);
        spOccasion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

                if (position!=0){
                    nameOccasion=listOccasion.get(position-1).getName_occasion().toString();
                }else{
                    nameOccasion="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        //DayNight

        ArrayAdapter<CharSequence> adapterDayNight=new ArrayAdapter
                (getContext(),android.R.layout.simple_spinner_item, listDayNightString);

        spDayNight.setAdapter(adapterDayNight);
        spDayNight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

                if (position!=0){
                    nameDayNight=listDayNight.get(position-1).getName_dayNight().toString();
                }else{
                    nameDayNight="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        //Texture

        ArrayAdapter<CharSequence> adapterTexture=new ArrayAdapter
                (getContext(),android.R.layout.simple_spinner_item, listTextureString);

        spTexture.setAdapter(adapterTexture);
        spTexture.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

                if (position!=0){
                    nameTexture=listTexture.get(position-1).getName_texture().toString();
                }else{
                    nameTexture="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        //Type

        ArrayAdapter<CharSequence> adapterType=new ArrayAdapter
                (getContext(),android.R.layout.simple_spinner_item, listTypeString);

        spType.setAdapter(adapterType);
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

                if (position!=0){
                    nameType=listType.get(position-1).getName_type().toString();
                }else{
                    nameType="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });




    }


    //-----------------[LISTAS]----------------------

    // LISTA DE SEASON
    private void checkListSeason() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Season persona=null;
        listSeason =new ArrayList<Season>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+UtilitiesDB.TABLE_SEASON,null);

        while (cursor.moveToNext()){
            persona=new Season();
            persona.setName_season(cursor.getString(0));
            //persona.setNombre(cursor.getString(1));
            //persona.setTelefono(cursor.getString(2));

            Log.i("name_season",persona.getName_season().toString());
            //Log.i("Nombre",persona.getNombre());
            //Log.i("Tel",persona.getTelefono());

            listSeason.add(persona);

        }
        getListSeason();
    }

    private void getListSeason() {
        listSeasonString =new ArrayList<String>();
        listSeasonString.add("Seleccione");

        for(int i = 0; i< listSeason.size(); i++){
            listSeasonString.add(listSeason.get(i).getName_season()+"");
        }

    }

    // LISTA DE OCCASION
    private void checkListOccasion() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Occasion persona=null;
        listOccasion =new ArrayList<Occasion>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+UtilitiesDB.TABLE_OCCASION,null);

        while (cursor.moveToNext()){
            persona=new Occasion();
            persona.setName_occasion(cursor.getString(0));
            //persona.setNombre(cursor.getString(1));
            //persona.setTelefono(cursor.getString(2));

            Log.i("name_occasion",persona.getName_occasion().toString());
            //Log.i("Nombre",persona.getNombre());
            //Log.i("Tel",persona.getTelefono());

            listOccasion.add(persona);

        }
        getListOccasion();
    }

    private void getListOccasion() {
        listOccasionString =new ArrayList<String>();
        listOccasionString.add("Seleccione");

        for(int i = 0; i< listOccasion.size(); i++){
            listOccasionString.add(listOccasion.get(i).getName_occasion()+"");
        }

    }

    // LISTA DE DAYNIGHT
    private void checkListDayNight() {

        SQLiteDatabase db=conn.getReadableDatabase();

        DayNight persona=null;
        listDayNight =new ArrayList<DayNight>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+UtilitiesDB.TABLE_DAYNIGHT,null);

        while (cursor.moveToNext()){
            persona=new DayNight();
            persona.setName_dayNight(cursor.getString(0));
            //persona.setNombre(cursor.getString(1));
            //persona.setTelefono(cursor.getString(2));

            Log.i("name_dayNight",persona.getName_dayNight().toString());
            //Log.i("Nombre",persona.getNombre());
            //Log.i("Tel",persona.getTelefono());

            listDayNight.add(persona);

        }
        getListDayNight();
    }

    private void getListDayNight() {
        listDayNightString =new ArrayList<String>();
        listDayNightString.add("Seleccione");

        for(int i = 0; i< listDayNight.size(); i++){
            listDayNightString.add(listDayNight.get(i).getName_dayNight()+"");
        }

    }

    // LISTA DE TEXTURE
    private void checkListTexture() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Texture persona=null;
        listTexture =new ArrayList<Texture>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+UtilitiesDB.TABLE_TEXTURE,null);

        while (cursor.moveToNext()){
            persona=new Texture();
            persona.setName_texture(cursor.getString(0));
            //persona.setNombre(cursor.getString(1));
            //persona.setTelefono(cursor.getString(2));

            Log.i("name_texture",persona.getName_texture().toString());
            //Log.i("Nombre",persona.getNombre());
            //Log.i("Tel",persona.getTelefono());

            listTexture.add(persona);

        }
        getListTexture();
    }

    private void getListTexture() {
        listTextureString =new ArrayList<String>();
        listTextureString.add("Seleccione");

        for(int i = 0; i< listTexture.size(); i++){
            listTextureString.add(listTexture.get(i).getName_texture()+"");
        }

    }

    // LISTA DE TYPE
    private void checkListType() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Type persona=null;
        listType =new ArrayList<Type>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+UtilitiesDB.TABLE_TYPE,null);

        while (cursor.moveToNext()){
            persona=new Type();
            persona.setName_type(cursor.getString(0));
            persona.setName_subType(cursor.getString(1));

            Log.i("name_type",persona.getName_type().toString());
            Log.i("name_subType",persona.getName_subType().toString());

            listType.add(persona);

        }
        getListType();
    }

    private void getListType() {
        listTypeString =new ArrayList<String>();
        listTypeString.add("Seleccione");

        for(int i = 0; i< listType.size(); i++){
            listTypeString.add(listType.get(i).getName_type()+" - "+listType.get(i).getName_subType());
        }

    }



    //-----------------[REGISTROS]----------------------

    private void registrarColorSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(getContext(),"bd_cloutfit",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')

        String insert="INSERT INTO "+ UtilitiesDB.TABLE_COLOR
                +" ( " +UtilitiesDB.ID_COLOR+")" +
                " VALUES ("+txColor.getText().toString()+"')";
        //   " VALUES ("+campoId.getText().toString()+"')";
        db.execSQL(insert);


        db.close();
    }

    private void registrarColor() {
        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_cloutfit",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UtilitiesDB.ID_COLOR,txColor.getText().toString());
        Long idResultante=db.insert(UtilitiesDB.TABLE_COLOR,UtilitiesDB.ID_COLOR,values);
        Toast.makeText(getContext(),"Id Registro Color: "+idResultante,Toast.LENGTH_SHORT).show();

        db.close();
    }

    private void registrarStyle() {

        idColor =txColor.getText().toString();
        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_cloutfit",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        //values.put(UtilitiesDB.ID_STYLE,1);
        //NO ES NECESARIO EL ID, ES IN INTERNER AUTOINGREMENTABLE
        values.put(UtilitiesDB.ID_COLOR_STYLE,idColor.toString());
        values.put(UtilitiesDB.NAME_TEXTURE_STYLE,nameTexture.toString());
        Long idResultante=db.insert(UtilitiesDB.TABLE_STYLE,UtilitiesDB.ID_STYLE,values);
        idStyle=idResultante+"";
        Toast.makeText(getContext(),"Id Registro Style: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void registrarClothes(){
        nameClothes =editxNameClothes.getText().toString();

        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_cloutfit",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        //NO ES NECESARIO EL ID, ES IN INTERNER AUTOINGREMENTABLE
        // values.put(UtilitiesDB.ID_CLOTHES,1);
        values.put(UtilitiesDB.NAME_CLOTHES,nameClothes);
        values.put(UtilitiesDB.PHOTO_CLOTHES,photoClothes);
        //ARREGLAR ID
        values.put(UtilitiesDB.ID_STYLE_CLOTHES,idStyle);
        values.put(UtilitiesDB.NAME_TYPE_CLOTHES,nameType);
        values.put(UtilitiesDB.NAME_DAYNIGHT_CLOTHES,nameDayNight);
        values.put(UtilitiesDB.NAME_SEASON_CLOTHES,nameSeason);
        values.put(UtilitiesDB.NAME_OCCASION_CLOTHES,nameOccasion);

        Long idResultante=db.insert(UtilitiesDB.TABLE_CLOTHES,UtilitiesDB.ID_CLOTHES,values);

        Toast.makeText(getContext(),"Id Registro Clothes: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();

    }

    private void deleteClothes(){

        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_cloutfit",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        //NO ES NECESARIO EL ID, ES IN INTERNER AUTOINGREMENTABLE
        //


        db.delete(UtilitiesDB.TABLE_CLOTHES,null,null);
        Toast.makeText(getContext(),"Borras Filas de Clothes: ",Toast.LENGTH_SHORT).show();
        db.close();

    }

    //-----------------[PERMISOS]----------------------

    //Validar Permisos
    private boolean validaPermisos() {

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if((getContext().checkSelfPermission(CAMERA)== PackageManager.PERMISSION_GRANTED)&&
                (getContext().checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))){
            cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
        }

        return false;
    }

    //Dialogo para Validacion
    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(getContext());
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        });
        dialogo.show();
    }

    //Si se aprobaron los requisitos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                btPhoto.setEnabled(true);
            }else{
                solicitarPermisosManual();
            }
        }

    }

    //solicitud de permisos
    private void solicitarPermisosManual() {
        final CharSequence[] opciones={"si","no"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(getContext());
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")){
                    Intent intent=new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri=Uri.fromParts("package",getContext().getPackageName(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext().getApplicationContext(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }

    //-----------------[FUNCIONES CAMARA]----------------------

    //Carga imagenn
    private void cargarImagen() {

        final CharSequence[] opciones={"Tomar Foto","Cargar Imagen","Cancelar"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(getContext());
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")){
                    tomarFotografia();
                }else{
                    if (opciones[i].equals("Cargar Imagen")){
                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"), COD_SELECT);
                    }else{
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }

    //Toma la foto
    private void tomarFotografia() {
        File fileImagen=new File(Environment.getExternalStorageDirectory(), IMAGE_ROUTE);
        boolean isCreada=fileImagen.exists();
        String nombreImagen="";
        if(isCreada==false){
            isCreada=fileImagen.mkdirs();
        }

        if(isCreada==true){
            nombreImagen=(System.currentTimeMillis()/1000)+".jpg";
        }


        path=Environment.getExternalStorageDirectory()+
                File.separator+ IMAGE_ROUTE +File.separator+nombreImagen;

        File imagen=new File(path);

        Intent intent=null;
        intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ////


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {

            String authorities= getContext().getApplicationContext().getPackageName()+".provider";
            Uri imageUri= FileProvider.getUriForFile(getContext(),authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent, COD_PHOTO);

    }

    //La mierda del la camara
    @Override
    //protect
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){

            switch (requestCode){
                case COD_SELECT:
                    Uri miPath=data.getData();
                    imagen.setImageURI(miPath);
                    photoClothes = miPath.toString();
                    break;

                case COD_PHOTO:
                    MediaScannerConnection.scanFile(getContext(), new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento","Path: "+path);
                                }
                            });

                    Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);
                    photoClothes=path.toString();


                    break;
            }


        }
    }

    //-----------------[DETERMINAR COLOR]----------------------

    //Obtener color predominante de prenda
    public void findColorClothes(){
        //Imagen
        View nn =  imagen;

        //La conbierte a formato bitmap
        nn.buildDrawingCache();
        Bitmap bmap = nn.getDrawingCache();

        //Obtiene el color dominante de la imagen
        int colorP= getDominantColor(bmap);

        //En formato texto vizualiza el color dominante
        txColor.setText(""+colorP);
        txColor.setBackgroundColor(colorP);





    }

    //Obtiene el color dominante
    public static int getDominantColor(Bitmap bitmap) {
        if (null == bitmap) {
            return android.graphics.Color.TRANSPARENT;
        }

        int redBucket    = 0;
        int greenBucket  = 0;
        int blueBucket   = 0;
        int alphaBucket  = 0;

        boolean hasAlpha = bitmap.hasAlpha();
        int pixelCount   = bitmap.getWidth() * bitmap.getHeight();
        int[] pixels     = new int[pixelCount];

        bitmap.getPixels(
                pixels,
                0,
                bitmap.getWidth(),
                0,
                0,
                bitmap.getWidth(),
                bitmap.getHeight()
        );

        for (int y = 0, h = bitmap.getHeight(); y < h; y++){
            for (int x = 0, w = bitmap.getWidth(); x < w; x++){
                int color   =  pixels[x + y * w];            // x + y * width
                redBucket   += (color >> 16) & 0xFF;         // Color.red
                greenBucket += (color >> 8) & 0xFF;          // Color.greed
                blueBucket  += (color & 0xFF);               // Color.blue
                if (hasAlpha) alphaBucket += (color >>> 24); // Color.alpha
            }
        }

        return android.graphics.Color.argb(
                (hasAlpha) ? (alphaBucket / pixelCount) : 255,
                redBucket / pixelCount,
                greenBucket / pixelCount,
                blueBucket / pixelCount
        );
    }

}
