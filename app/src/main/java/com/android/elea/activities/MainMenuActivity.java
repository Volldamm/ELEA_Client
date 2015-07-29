package com.android.elea.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.elea.R;
import com.android.elea.activities.account.UserProfileActivity;
import com.android.elea.activities.login.LoginActivity;
import com.android.elea.activities.messages.MessagesMenuActivity;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;
import com.android.elea.beans.User;
import com.android.elea.business.CountryBS;
import com.android.elea.business.ProvinceBS;
import com.android.elea.business.TownBS;
import com.android.elea.business.UserBS;
import com.android.elea.db.DBUtils;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.ConfirmDialog;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.SessionManager;
import com.android.elea.utils.TextConstants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;

import java.util.List;


public class MainMenuActivity extends Activity implements View.OnClickListener,AdapterView.OnItemSelectedListener, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {


    //visual components
    private ToggleButton btnDemandToggle;
    private ToggleButton btnOfferToggle;
    private Spinner spProvincias;
    private Spinner spLocalidades;
    private EditText searchText;
    private SignInButton btnSignIn;
    private GoogleApiClient mGoogleApiClient;
    private Button btnSearch,initSessionButton;
    private ProgressDialog connectionProgressDialog;
    private ConnectionResult connectionResult;

    private static final int REQUEST_CODE_RESOLVE_ERR = 9000;
    private SessionManager session;
    private SQLiteDatabase db;

    private List<Province> provinceList = null;
    private List<Town> townList = null;

    //control variables
    private boolean isOffer = true; //al estar seleccionado por defecto la opcion busco trabajo, marcamos para que se busquen ofertas



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_menu);

            initCache();
//            createDB();
//            updateDB();
            session = new SessionManager(getApplicationContext());

            if(session.isLoggedIn()){  //cargamos usuario a cache
                SharedPreferences sp = getApplicationContext().getSharedPreferences(TextConstants.PREF_NAME, TextConstants.PRIVATE_MODE);
                if(sp.contains(TextConstants.KEY_EMAIL)){
                    User user = UserBS.getUserByEmail(this, sp.getString(TextConstants.KEY_EMAIL, ""));
                    if(user == null){
                        session.logoutUser();
                    }else
                        CacheManager.setUser(user);
                }
            }else{
                //ocultamos las opciones que no procedan

            }

            spProvincias = (Spinner) findViewById(R.id.sp_provincia);
            spLocalidades = (Spinner) findViewById(R.id.sp_localidad);
            searchText = (EditText)findViewById(R.id.searchText);
            btnSearch = (Button)findViewById(R.id.searchButton);
            initSessionButton = (Button)findViewById(R.id.initSessionButton);
            btnSignIn = (SignInButton)findViewById(R.id.sign_in_button);

            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(Plus.API)
                    .addScope(new Scope("profile"))
                    .build();

            connectionProgressDialog = new ProgressDialog(this);
            connectionProgressDialog.setMessage("Conectando...");

            loadSpinnerProvincias();

            if(session.isLoggedIn()){
                initSessionButton.setVisibility(View.INVISIBLE);
                btnSignIn.setVisibility(View.INVISIBLE);
            }else{
                initSessionButton.setVisibility(View.VISIBLE);
                btnSignIn.setVisibility(View.VISIBLE);
            }

            initListeners();

            CacheManager.setMainMenuActivity(this);

        }catch (Exception e){
            new EleaException(e);
        }
    }



    ///////////////////////////////////////////////   GESTION CONEXION GOOGLE    ////////////////////////////////////////////////////////////////
    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
        SQLiteDatabase db = EleaSQLiteHelper.getInstance(getApplicationContext()).getReadableDatabase();
        db.close();
    }

    @Override
    public void onClick(View v) {
        // ...
    }

    @Override
    public void onConnectionFailed(ConnectionResult result){
        if (connectionProgressDialog.isShowing()){
            if (result.hasResolution()){
                try {
                    result.startResolutionForResult(MainMenuActivity.this, REQUEST_CODE_RESOLVE_ERR);
                }
                catch (IntentSender.SendIntentException e){
                    mGoogleApiClient.connect();
                }
            }
        }
        connectionResult = result;
    }

    @Override
    public void onConnected(Bundle connectionHint){
        connectionProgressDialog.dismiss();
        Toast.makeText(this, "Conectado!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent)
    {
        if (requestCode == REQUEST_CODE_RESOLVE_ERR &&
                responseCode == RESULT_OK)
        {
            connectionResult = null;
            mGoogleApiClient.connect();
        }
    }
    /////////////////////////////////////////////////////////////////////////////


    private void jobDetails(String operation){
        try {
            //Creamos el Intent
            Intent intent = new Intent(MainMenuActivity.this, JobDetailsActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,operation);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    private void initListeners() throws Exception{
        try{
            btnSearch.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0)
                {
                    try {
                        searchButtonAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });
            initSessionButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0)
                {
                    try {
                        InitSessionButtonAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

            btnDemandToggle = (ToggleButton)findViewById(R.id.demandToggleButton);
            btnDemandToggle.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0)
                {
                    try {
                        DemandToggleAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

            btnOfferToggle = (ToggleButton)findViewById(R.id.offerToggleButton);
            btnOfferToggle.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        OfferToggleAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

            btnSignIn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (!mGoogleApiClient.isConnected()) {
                        if (connectionResult == null) {
                            connectionProgressDialog.show();
                        } else {
                            try {
                                connectionResult.startResolutionForResult(MainMenuActivity.this, REQUEST_CODE_RESOLVE_ERR);
                            } catch (IntentSender.SendIntentException e) {
                                connectionResult = null;
                                mGoogleApiClient.connect();
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            new EleaException(e);
        }
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void DemandToggleAction() throws Exception{
        try {
            isOffer = true;
            btnDemandToggle.setChecked(true);
            btnOfferToggle.setChecked(false);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    private void OfferToggleAction() throws Exception{
        try {
            isOffer = false;
            btnOfferToggle.setChecked(true);
            btnDemandToggle.setChecked(false);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    public void exitApplicationAction() throws Exception{
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        try {

            if(!session.isLoggedIn()) {
                MenuItem item = menu.findItem(R.id.upperMenuLogout);
                item.setVisible(false);
                this.invalidateOptionsMenu();
            }

        } catch (Exception e) {
            new EleaException(e);
        }
        return true;
    }


    ////////////////////////////////////////////////////////    MENU SUPERIOR    ////////////////////////////////////////////////////////
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        try {
            int id = item.getItemId();

            if (id == R.id.upperMenuNewJob) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    jobDetails(TextConstants.OPERATION_NEW_JOB);
            }else if (id == R.id.upperMenuFavorites) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    favorites();
            }else if (id == R.id.upperMenuMyJobs) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    myJobs();
            }else if (id == R.id.upperMenuMyProfile) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    myProfile();
            }else if(id == R.id.upperMenuLogout) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    logoutUpperMenu();
            }else if(id == R.id.upperMenuExit) {
                exitUpperMenu();
            }else if (id == R.id.upperMenuMyMessages) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    myMessages();
            }
        } catch (Exception e) {
            new EleaException(e);
        }

        return super.onOptionsItemSelected(item);
    }

    private void myMessages(){
        try {
            Intent intent = new Intent(MainMenuActivity.this, MessagesMenuActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    private void logoutUpperMenu(){
        DialogFragment newFragment = ConfirmDialog.newInstance(getResources().getString(R.string.logout_title),getResources().getString(R.string.logout_text),NumericConstants.LOGOUT_FRAGMENT_ID);
        newFragment.show(getFragmentManager(), "logoutConfirmacion");
    }

    private void exitUpperMenu(){
        DialogFragment newFragment = ConfirmDialog.newInstance(getResources().getString(R.string.exit_app_title),getResources().getString(R.string.exit_app_text), NumericConstants.EXIT_APP_FRAGMENT_ID);
        newFragment.show(getFragmentManager(), "exitAppConfirmacion");
    }

    private void myProfile(){
        try {
            Intent intent = new Intent(MainMenuActivity.this, UserProfileActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void myJobs(){
        try {
            Intent intent = new Intent(MainMenuActivity.this, SearchResultListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_MY_JOBS);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void favorites(){
        try {
            Intent intent = new Intent(MainMenuActivity.this, SearchResultListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_FAVORITES);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Callback method to be invoked when the selection disappears from this
        // view. The selection can disappear for instance when touch is
        // activated or when the adapter becomes empty.
    }


    private void InitSessionButtonAction() throws Exception{
        try {
            Intent intent = new Intent(MainMenuActivity.this, LoginActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    private void searchButtonAction() throws Exception{
        try {
            //Creamos el Intent
            Intent intent = new Intent(MainMenuActivity.this, SearchResultListActivity.class);

            //Creamos la información a pasar entre actividades
            Bundle b = new Bundle();
            b.putString(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_MAIN_SEARCH);

            b.putBoolean(TextConstants.BUNDLE_PARAMETER_IS_OFFER,isOffer);

            String searchTextStr = searchText.getText().toString();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_SEARCH_TEXT,searchTextStr);

            Province province = (Province)spProvincias.getSelectedItem();
            b.putParcelable(TextConstants.BUNDLE_PARAMETER_PROVINCE, province);

            Town town = (Town)spLocalidades.getSelectedItem();
            b.putParcelable(TextConstants.BUNDLE_PARAMETER_TOWN, town);

            //Añadimos la información al intent
            intent.putExtras(b);

            //Iniciamos la nueva actividad
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    private void loadSpinnerProvincias() {

        try {
            if(CacheManager.getProvinceList() == null) {
                provinceList = ProvinceBS.getProvinces(getApplicationContext());
                provinceList.add(0,CacheManager.getBlankProvince());

                //guardamos las provincias en cache
                CacheManager.setProvinceList(provinceList);
            }else{
                provinceList = CacheManager.getProvinceList();
            }

//            spProvincias.setAdapter(new ArrayAdapter<Province>(this, android.R.layout.simple_spinner_item, provinceList));

            ArrayAdapter<Province> adapter = new ArrayAdapter<Province>(this, android.R.layout.simple_spinner_item, provinceList);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spProvincias.setAdapter(adapter);

            // This activity implements the AdapterView.OnItemSelectedListener
            spProvincias.setOnItemSelectedListener(this);
            spLocalidades.setOnItemSelectedListener(this);

        } catch (Exception e) {
            new EleaException(e);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        try {
            switch (parent.getId()) {
                case R.id.sp_provincia:

                    Province prov = provinceList.get(pos);

                    if(CacheManager.getTownsMap().containsKey(prov.getId())){
                        townList = CacheManager.getTownsMap().get(prov.getId());
                    }else{
                        townList = TownBS.getTownsByProvince(getApplicationContext(),prov);
                        townList.add(0,CacheManager.getBlankTown());

                        CacheManager.getTownsMap().put(prov.getId(),townList);
                    }

                    // Create an ArrayAdapter using the string array and a default
                    // spinner layout
                    ArrayAdapter<Town> adapter = new ArrayAdapter<Town>(this, android.R.layout.simple_spinner_item, townList);

                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    // Apply the adapter to the spinner
                    this.spLocalidades.setAdapter(adapter);
                    break;
                case R.id.sp_localidad:
                    break;
            }
        } catch (Resources.NotFoundException e) {
            new EleaException(e);
        }
    }


    public void logout(){
        session.logoutUser();
        startActivity(new Intent(MainMenuActivity.this,MainMenuActivity.class));
    }

    private void initCache(){

        CacheManager.setDefaultCountry(CountryBS.getDefaultCountry(getApplicationContext()));

        Province prov = new Province();
        prov.setName(TextConstants.BLANK);
        CacheManager.setBlankProvince(prov);

        Town town = new Town();
        town.setName(TextConstants.BLANK);
        CacheManager.setBlankTown(town);
    }



    /////////////////////////////////////////////////  BASE DE DATPS SQLITE     ////////////////////////////////////

    private void createDB(){
        try{
            db = EleaSQLiteHelper.getInstance(this).getWritableDatabase();
            if(db != null)
            {
                DBUtils.executeSqlScript(this, db, R.raw.mydb);
                //Cerramos la base de datos
            }
        }catch (Exception e){
            new EleaException(e);
        }
    }

    private void updateDB(){
        try{

            db = EleaSQLiteHelper.getInstance(this).getWritableDatabase();

            if(db != null)
            {
                DBUtils.executeSqlScript(this, db, R.raw.messages);
//                DBUtils.executeSqlScript(this, db, R.raw.updates);
                //Cerramos la base de datos
            }
        }catch (Exception e){
            new EleaException(e);
        }
    }
}
