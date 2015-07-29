package com.android.elea.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.elea.R;
import com.android.elea.activities.messages.MessagesMenuActivity;
import com.android.elea.beans.Job;
import com.android.elea.utils.ConfirmDialog;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.SessionManager;
import com.android.elea.utils.TextConstants;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class JobViewActivity extends Activity {

    private SessionManager session;
    private TextView jobViewTitleText;
    private TextView jobViewDescriptionText;
    private TextView jobViewLocationText;
    private TextView jobViewPaymentModeText;
    private TextView jobViewPublishDate;

    private TextView jobViewOfferDemand;

    private Job job;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_job_view);
            session = new SessionManager(getApplicationContext());

            Bundle bundle = this.getIntent().getExtras();
            operation = bundle.getString(TextConstants.BUNDLE_PARAMETER_OPERATION);
            job = bundle.getParcelable(TextConstants.BUNDLE_PARAMETER_JOB);

            initListeners();
            loadJobValues();

        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void loadJobValues(){
        try{


            if(job.isOffer()){
                jobViewOfferDemand.setText(getResources().getString(R.string.job_details_offer_title));
            }else{
                jobViewOfferDemand.setText(getResources().getString(R.string.job_details_search_title));
            }

            jobViewTitleText.setText(job.getTitle());

            jobViewDescriptionText.setText(job.getDescription());

            StringBuilder location = new StringBuilder();
            if(job.getTown() != null && job.getTown().getName() != null && job.getTown().getName().trim().length()>0){
                location.append(job.getTown().getName());
                location.append(TextConstants.COMMA);
                location.append(TextConstants.WHITE_SPACE);
            }
            if(job.getProvince() != null && job.getProvince().getName() != null && job.getProvince().getName().trim().length()>0){
                location.append(job.getProvince().getName());
                location.append(TextConstants.COMMA);
                location.append(TextConstants.WHITE_SPACE);
            }
            jobViewLocationText.setText(location.toString());

            StringBuilder paymentMode = new StringBuilder();
            if(job.getPaymentMode() != null){
                if(job.getPaymentMode().compareTo("H")==0){
                    paymentMode.append(job.getAmount());
                    paymentMode.append(getResources().getString(R.string.common_currency));
                    paymentMode.append(TextConstants.SLASH);
                    paymentMode.append(getResources().getString(R.string.job_details_payment_mode_H_text));
                }
                if(job.getPaymentMode().compareTo("D")==0){
                    paymentMode.append(job.getAmount());
                    paymentMode.append(getResources().getString(R.string.common_currency));
                    paymentMode.append(TextConstants.SLASH);
                    paymentMode.append(getResources().getString(R.string.job_details_payment_mode_D_text));
                }
                if(job.getPaymentMode().compareTo("J")==0){
                    paymentMode.append(job.getAmount());
                    paymentMode.append(getResources().getString(R.string.common_currency));
                    paymentMode.append(TextConstants.SLASH);
                    paymentMode.append(getResources().getString(R.string.job_details_payment_mode_J_text));
                }
                if(job.getPaymentMode().compareTo("C")==0){//los trabajos a convenir no tienen cantidad
                    paymentMode.append(getResources().getString(R.string.job_details_payment_mode_C_text));
                }
            }
            jobViewPaymentModeText.setText(paymentMode.toString());

            SimpleDateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",new Locale("es"));
            jobViewPublishDate.setText(format.format(job.getDateCreated()));
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void initListeners(){
        try{
            jobViewOfferDemand = (TextView) findViewById(R.id.jobViewOfferDemand);

            jobViewTitleText = (TextView) findViewById(R.id.jobViewTitleText);
            jobViewDescriptionText = (TextView) findViewById(R.id.jobViewDescriptionText);
            jobViewLocationText = (TextView) findViewById(R.id.jobViewLocationText);
            jobViewPaymentModeText = (TextView) findViewById(R.id.jobViewPaymentModeText);
            jobViewPublishDate = (TextView) findViewById(R.id.jobViewPublishDate);

//            btnProfileSave.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View arg0) {
//                    try {
//                        saveButtonAction();
//                    } catch (Exception e) {
//                        new EleaException(e);
//                    }
//                }
//            });
//
//            btnProfileCancel.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View arg0) {
//                    try {
//                        cancelButtonAction();
//                    } catch (Exception e) {
//                        new EleaException(e);
//                    }
//                }
//            });
        } catch (Exception e) {
            new EleaException(e);
        }
    }




    ////////////////////////////////////////////////////////    MENU SUPERIOR    ////////////////////////////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try{
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_job_view, menu);

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
            Intent intent = new Intent(JobViewActivity.this, MessagesMenuActivity.class);
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

    private void myJobs(){
        try {
            Intent intent = new Intent(JobViewActivity.this, SearchResultListActivity.class);
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
            Intent intent = new Intent(JobViewActivity.this, SearchResultListActivity.class);
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
            Intent intent = new Intent(JobViewActivity.this, JobDetailsActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,operation);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void upperMenuSearch(){
        startActivity(new Intent(JobViewActivity.this, MainMenuActivity.class));
    }
}
