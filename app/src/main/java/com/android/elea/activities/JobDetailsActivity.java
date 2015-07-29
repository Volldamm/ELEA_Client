package com.android.elea.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.elea.R;
import com.android.elea.activities.account.UserProfileActivity;
import com.android.elea.activities.messages.MessagesMenuActivity;
import com.android.elea.beans.Job;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;
import com.android.elea.business.JobBS;
import com.android.elea.business.ProvinceBS;
import com.android.elea.business.TownBS;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.ConfirmDialog;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.SessionManager;
import com.android.elea.utils.TextConstants;
import com.android.elea.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobDetailsActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private String operation;
    private Spinner spProvincias;
    private Spinner spLocalidades;
    private Spinner spPaymentModes;

    private RadioButton offerRadioButton;
    private RadioButton demandRadioButton;

    private Button saveButton;

    private TextView title;
    private EditText jobTitle;
    private EditText jobDescription;
    private EditText amount;
    private CheckBox isActive;
    private Job job;

    private int townPosition = -1;


    private List<Province> provinceList = null;
    private List<Town> townList = null;

    //control variables
    private boolean isOffer = false; //because search toggle button is selected by default

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_job_details);

            session = new SessionManager(getApplicationContext());

            townPosition = -1;

            Bundle bundle = this.getIntent().getExtras();
            operation = bundle.getString(TextConstants.BUNDLE_PARAMETER_OPERATION);
            job = bundle.getParcelable(TextConstants.BUNDLE_PARAMETER_JOB);

            title = (TextView) findViewById(R.id.jobDetailsMainTitle);

            spProvincias = (Spinner) findViewById(R.id.sp_provincia);
            spLocalidades = (Spinner) findViewById(R.id.sp_localidad);

            loadSpinnerProvincias();
            loadSpinnerPaymentModes();
            intiListeners();

            if(operation.equals(TextConstants.OPERATION_NEW_JOB)){
                title.setVisibility(View.GONE);//title.setText(getResources().getString(R.string.job_details_new_job_title));
                getActionBar().setTitle(getResources().getString(R.string.job_details_new_job_title));
            }
            else if(operation.equals(TextConstants.OPERATION_MODIFY_JOB)){
                title.setVisibility(View.GONE);//setText(getResources().getString(R.string.job_details_modify_job_title));
                getActionBar().setTitle(getResources().getString(R.string.job_details_modify_job_title));
                loadValuesFromJob(job);
            }

        } catch (Exception e) {
            new EleaException(e);
        }
    }


    private void intiListeners() throws Exception{
        try{
            jobTitle = (EditText) findViewById(R.id.jobDetailsTitleValue);
            jobDescription = (EditText) findViewById(R.id.jobDetailsDescriptionValue);
            isActive = (CheckBox)findViewById(R.id.isActiveCheckBox);
            amount = (EditText) findViewById(R.id.jobDetailsAmountValue);

            saveButton = (Button)findViewById(R.id.jobDetailsSaveButton);
            saveButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        if(checkJobValues())
                            saveButtonAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

            offerRadioButton = (RadioButton)findViewById(R.id.jobDetailsOfferRadioButton);
            offerRadioButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        offerRadioAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

            demandRadioButton = (RadioButton)findViewById(R.id.jobDetailsDemandRadioButton);
            demandRadioButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        demandRadioAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void loadValuesFromJob(Job job){
        try{
            jobTitle.setText(job.getTitle());
            jobDescription.setText(job.getDescription());

            int provincePosition = -1;

            if(job.getProvince() != null) {
                for (Province prov : provinceList) {
                    provincePosition++;
                    if (prov.getId() == job.getProvince().getId())
                        break;
                }
                if(provincePosition != -1)
                    spProvincias.setSelection(provincePosition);

                if(job.getTown() != null){
                    if(CacheManager.getTownsMap().containsKey(job.getProvince().getId())){
                        townList = CacheManager.getTownsMap().get(job.getProvince().getId());
                    }else{
                        townList = TownBS.getTownsByProvince(getApplicationContext(),job.getProvince());
                        townList.add(0, CacheManager.getBlankTown());

                        CacheManager.getTownsMap().put(job.getProvince().getId(), townList);
                    }

                    for(Town town:townList){
                        townPosition++;
                        if (town.getId() == job.getTown().getId()) {
                            break;
                        }
                    }
                }
            }
            if(job.isOffer()){
                offerRadioButton.setChecked(true);
                demandRadioButton.setChecked(false);
            }else{
                offerRadioButton.setChecked(false);
                demandRadioButton.setChecked(true);
            }
            if(job.isActive()){
                isActive.setChecked(true);
            }else{
                isActive.setChecked(false);
            }

            if(job.getPaymentMode().equals(getResources().getString(R.string.job_details_payment_mode_H_text)))
                spPaymentModes.setSelection(0);
            else if(job.getPaymentMode().equals(getResources().getString(R.string.job_details_payment_mode_D_text)))
                spPaymentModes.setSelection(1);
            else if(job.getPaymentMode().equals(getResources().getString(R.string.job_details_payment_mode_J_text)))
                spPaymentModes.setSelection(2);
            else if(job.getPaymentMode().equals(getResources().getString(R.string.job_details_payment_mode_C_text)))
                spPaymentModes.setSelection(3);

            amount.setText("" + job.getAmount());
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private Job loadValuesToJob(){
        try{
            job.setUser(CacheManager.getUser());
            job.setTitle(jobTitle.getText().toString());
            job.setDescription(jobDescription.getText().toString());
            job.setCountry(CacheManager.getDefaultCountry());
            job.setProvince((Province) spProvincias.getSelectedItem());
            job.setTown((Town) spLocalidades.getSelectedItem());
            job.setOffer(isOffer);
            job.setActive(isActive.isChecked());

            String pMode = (String)spPaymentModes.getSelectedItem();

            if(pMode.equals(getResources().getString(R.string.job_details_payment_mode_H_text)))
                job.setPaymentMode("H");
            else if(pMode.equals(getResources().getString(R.string.job_details_payment_mode_D_text)))
                job.setPaymentMode("D");
            else if(pMode.equals(getResources().getString(R.string.job_details_payment_mode_J_text)))
                job.setPaymentMode("J");
            else if(pMode.equals(getResources().getString(R.string.job_details_payment_mode_C_text)))
                job.setPaymentMode("C");
            if(amount.getText().toString().trim().length()>0)
                job.setAmount(new Integer(amount.getText().toString()));
            job.setDateCreated(new Date());
        } catch (Exception e) {
            new EleaException(e);
        }
        return job;
    }

    private boolean checkJobValues(){

        //checkeamos que exista el titulo y que no supere el tamaño maximo
        if(jobTitle.getText().toString().trim().length() == 0){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.job_error_title), getResources().getString(R.string.job_error_no_title),-1);
            newFragment.show(getFragmentManager(),"job_error_no_title");
            return false;
        }else if(jobTitle.getText().toString().trim().length() > 50){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.job_error_title), getResources().getString(R.string.job_error_max_title),-1);
            newFragment.show(getFragmentManager(),"job_error_max_title");
            return false;
        }
        //checkeamos que exista la descripcion y que no supere el tamaño maximo
        else if(jobDescription.getText().toString().trim().length() == 0){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.job_error_title), getResources().getString(R.string.job_error_no_description),-1);
            newFragment.show(getFragmentManager(),"job_error_no_title");
            return false;
        }else if(jobDescription.getText().toString().trim().length() > 4000){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.job_error_title), getResources().getString(R.string.job_error_max_description),-1);
            newFragment.show(getFragmentManager(),"job_error_max_description");
            return false;
        }


        return true;
    }

    private void saveButtonAction(){
        try{
            if(job == null)
                job = new Job();
            job = loadValuesToJob();

            if(operation.equals(TextConstants.OPERATION_NEW_JOB)){
                long res = JobBS.insertJob(this,job);

                if(res != -1) {
                    Utils.showToast(getApplicationContext(), getResources().getString(R.string.job_details_job_inserted));
                    Intent intent = new Intent(JobDetailsActivity.this, SearchResultListActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_MY_JOBS);
                    intent.putExtras(b);
                    startActivity(intent);
                }else
                    Utils.showToast(getApplicationContext(), getResources().getString(R.string.job_details_job_inserted_KO));
            }
            else if(operation.equals(TextConstants.OPERATION_MODIFY_JOB)){
                long res = JobBS.updateJob(this, job);
                if(res != -1) {
                    Utils.showToast(getApplicationContext(), getResources().getString(R.string.job_details_job_modified));
                    Intent intent = new Intent(JobDetailsActivity.this, SearchResultListActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_MY_JOBS);
                    intent.putExtras(b);
                    startActivity(intent);
                }else
                    Utils.showToast(getApplicationContext(), getResources().getString(R.string.job_details_job_modified_KO));
            }
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void loadSpinnerPaymentModes(){
        try {
            spPaymentModes = (Spinner) findViewById(R.id.paymentModeSpinner);
            ArrayList<String> paymentModes = new ArrayList<String>();
            paymentModes.add(getResources().getString(R.string.job_details_payment_mode_H_text));
            paymentModes.add(getResources().getString(R.string.job_details_payment_mode_D_text));
            paymentModes.add(getResources().getString(R.string.job_details_payment_mode_J_text));
            paymentModes.add(getResources().getString(R.string.job_details_payment_mode_C_text));

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, paymentModes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spPaymentModes.setAdapter(adapter);
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

                    if(townPosition != -1)
                        spLocalidades.setSelection(townPosition);

                    break;
                case R.id.sp_localidad:
                    break;
            }
        } catch (Resources.NotFoundException e) {
            new EleaException(e);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Callback method to be invoked when the selection disappears from this
        // view. The selection can disappear for instance when touch is
        // activated or when the adapter becomes empty.
    }

    private void demandRadioAction() throws Exception{
        try {
            isOffer = false;
            demandRadioButton.setChecked(true);
            offerRadioButton.setChecked(false);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void offerRadioAction() throws Exception{
        try {
            isOffer = true;
            offerRadioButton.setChecked(true);
            demandRadioButton.setChecked(false);
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    ////////////////////////////////////////////////////////    MENU SUPERIOR    ////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_job_details, menu);

        if(!session.isLoggedIn()) {
            MenuItem item = menu.findItem(R.id.upperMenuLogout);
            item.setVisible(false);
            this.invalidateOptionsMenu();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
                logoutUpperMenu();
            }else if(id == R.id.upperMenuExit) {
                exitUpperMenu();
            }else if(id == R.id.upperMenuSearch) {
                upperMenuSearch();
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
            Intent intent = new Intent(JobDetailsActivity.this, MessagesMenuActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void logoutUpperMenu(){
        DialogFragment newFragment = ConfirmDialog.newInstance(getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_text), NumericConstants.LOGOUT_FRAGMENT_ID);
        newFragment.show(getFragmentManager(), "logoutConfirmacion");
    }

    private void exitUpperMenu(){
        DialogFragment newFragment = ConfirmDialog.newInstance(getResources().getString(R.string.exit_app_title),getResources().getString(R.string.exit_app_text), NumericConstants.EXIT_APP_FRAGMENT_ID);
        newFragment.show(getFragmentManager(), "exitAppConfirmacion");
    }

    private void myProfile(){
        try {
            Intent intent = new Intent(JobDetailsActivity.this, UserProfileActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void myJobs(){
        try {
            Intent intent = new Intent(JobDetailsActivity.this, SearchResultListActivity.class);
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
            Intent intent = new Intent(JobDetailsActivity.this, SearchResultListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_FAVORITES);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void jobDetails(String operation){
        try {
            //Creamos el Intent
            Intent intent = new Intent(JobDetailsActivity.this, JobDetailsActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,operation);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void upperMenuSearch(){
        startActivity(new Intent(JobDetailsActivity.this, MainMenuActivity.class));
    }

}
