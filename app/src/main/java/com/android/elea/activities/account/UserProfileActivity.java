package com.android.elea.activities.account;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.android.elea.R;
import com.android.elea.activities.JobDetailsActivity;
import com.android.elea.activities.MainMenuActivity;
import com.android.elea.activities.SearchResultListActivity;
import com.android.elea.activities.messages.MessagesMenuActivity;
import com.android.elea.beans.User;
import com.android.elea.business.UserBS;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.ConfirmDialog;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.SessionManager;
import com.android.elea.utils.TextConstants;
import com.android.elea.utils.Utils;

public class UserProfileActivity extends Activity {

    private User me;

    private EditText profileEmail;
    private EditText profilePassword;
    private EditText profilePasswordConfirm;
    private CheckBox emailNotifCheckBox;
    private CheckBox deviceNotifCheckBox;
    private Button btnProfileSave;
    private Button btnProfileCancel;

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_profile);

            session = new SessionManager(getApplicationContext());
            me = CacheManager.getUser();
            initListeners();
            loadValues();
        } catch (Exception e) {
            new EleaException(e);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try{
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_user_profile, menu);
        } catch (Exception e) {
            new EleaException(e);
        }
        return true;
    }


    private void initListeners(){
        try{
            profileEmail = (EditText) findViewById(R.id.profileEmail);
            profilePassword = (EditText) findViewById(R.id.profilePassword);
            profilePasswordConfirm = (EditText) findViewById(R.id.profilePasswordConfirm);

            emailNotifCheckBox = (CheckBox) findViewById(R.id.emailNotifCheckBox);
            deviceNotifCheckBox = (CheckBox) findViewById(R.id.deviceNotifCheckBox);

            btnProfileSave = (Button) findViewById(R.id.btnProfileSave);
            btnProfileCancel = (Button) findViewById(R.id.btnProfileCancel);

            btnProfileSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        saveButtonAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

            btnProfileCancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        cancelButtonAction();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void loadValues(){
        try{
            profileEmail.setText(me.getEmail());

            if(me.getDeviceNotifActive())
                deviceNotifCheckBox.setChecked(Boolean.TRUE);
            else
                deviceNotifCheckBox.setChecked(Boolean.FALSE);

            if(me.getMailNotifActive())
                emailNotifCheckBox.setChecked(Boolean.TRUE);
            else
                emailNotifCheckBox.setChecked(Boolean.FALSE);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void saveButtonAction(){
        try{
            if(validateFields()) {
                if(!UserBS.checkExistingEmail(getApplicationContext(), profileEmail.getText().toString()) || profileEmail.getText().toString().compareTo(me.getEmail())==0) {
                    me.setEmail(profileEmail.getText().toString());

                    if(profilePassword.getText().toString().trim().length() > 0) //en caso del que el password no este vacio -> lo han cambiado
                        me.setKey(profilePassword.getText().toString().trim());

                    me.setDeviceNotifActive(deviceNotifCheckBox.isChecked());
                    me.setMailNotifActive(emailNotifCheckBox.isChecked());

                    long res = UserBS.updateUser(getApplicationContext(), me);
                    if (res != -1) { //ok
                        session.createLoginSession("user", profileEmail.getText().toString());
                        //guardamos el usuario en cache
                        CacheManager.setUser(UserBS.getUserByEmail(this,profileEmail.getText().toString()));
                        startActivity(new Intent(UserProfileActivity.this, MainMenuActivity.class));

                        Intent itemintent = new Intent(UserProfileActivity.this, MainMenuActivity.class);
                        startActivity(itemintent);
                    } else {//error
                        DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.user_profile_error_title), getResources().getString(R.string.user_profile_error_db),-1);
                        newFragment.show(getFragmentManager(), null);
                    }
                }else{//error, ya existe una cuenta con ese email
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.user_profile_error_title), getResources().getString(R.string.user_profile_error_existing_email),-1);
                    newFragment.show(getFragmentManager(), null);
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void cancelButtonAction(){
        startActivity(new Intent(UserProfileActivity.this, MainMenuActivity.class));
    }

    private boolean validateFields(){
        try{
            String fragmentTitle = getResources().getString(R.string.register_error_title);
            String fragmentText;

            //validamos que el email
            if (profileEmail.getText().toString().trim().length() == 0){
                fragmentText = getResources().getString(R.string.user_profile_blank_email);
                DialogFragment newFragment = MessageDialog.newInstance(fragmentTitle, fragmentText,-1);
                newFragment.show(getFragmentManager(), null);
                return false;
            }
            //validamos el formato de los emails
            if(!Utils.validateEmail(profileEmail.getText().toString()) ){
                fragmentText = getResources().getString(R.string.user_profile_error_email_format);
                DialogFragment newFragment = MessageDialog.newInstance(fragmentTitle, fragmentText,-1);
                newFragment.show(getFragmentManager(), null);
                return false;
            }

            //validamos que las contrasenas coincidan
            if(!profilePassword.getText().toString().equals(profilePasswordConfirm.getText().toString())){
                fragmentText = getResources().getString(R.string.user_profile_error_password_no_match);
                DialogFragment newFragment = MessageDialog.newInstance(fragmentTitle, fragmentText,-1);
                newFragment.show(getFragmentManager(), null);
                return false;
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return true;
    }

    ////////////////////////////////////////////////////////    MENU SUPERIOR    ////////////////////////////////////////////////////////
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
            Intent intent = new Intent(UserProfileActivity.this, MessagesMenuActivity.class);
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
            Intent intent = new Intent(UserProfileActivity.this, SearchResultListActivity.class);
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
            Intent intent = new Intent(UserProfileActivity.this, SearchResultListActivity.class);
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
            Intent intent = new Intent(UserProfileActivity.this, JobDetailsActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,operation);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void upperMenuSearch(){
        startActivity(new Intent(UserProfileActivity.this, MainMenuActivity.class));
    }
}
