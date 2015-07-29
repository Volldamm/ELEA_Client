package com.android.elea.activities.login;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.elea.R;
import com.android.elea.beans.User;
import com.android.elea.business.UserBS;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.Utils;

public class RegisterActivity extends Activity {

    private TextView lblGotoLogin;
    private Button btnRegister;
    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputEmailConfirm;
    private EditText inputPasswordConfirm;

    String email;
    String password;
    String emailConfirm;
    String passwordConfirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputEmail = (EditText) findViewById(R.id.registerEmail);
        inputEmailConfirm = (EditText) findViewById(R.id.registerEmailConfirm);
        inputPassword = (EditText) findViewById(R.id.registerPassword);
        inputPasswordConfirm = (EditText) findViewById(R.id.registerPasswordConfirm);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                email = inputEmail.getText().toString();
                password = inputPassword.getText().toString();
                emailConfirm = inputEmailConfirm.getText().toString();
                passwordConfirm = inputPasswordConfirm.getText().toString();

                if(validateFields()) {
                    if(!UserBS.checkExistingEmail(getApplicationContext(),email)) {
                        User user = new User();
                        user.setEmail(email);
                        user.setKey(password);
                        long res = UserBS.insertUser(getApplicationContext(), user);
                        if (res != -1) { //ok -> vamos a login
                            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.title_activity_register), getResources().getString(R.string.register_successful), NumericConstants.REGISTER_OK_FRAGMENT_ID);
                            newFragment.show(getFragmentManager(), null);
                        } else {//error
                            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.register_error_title), getResources().getString(R.string.register_error_db),-1);
                            newFragment.show(getFragmentManager(), null);
                        }
                    }else{//error, ya existe una cuenta con ese email
                        DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.register_error_title), getResources().getString(R.string.register_error_existing_email),-1);
                        newFragment.show(getFragmentManager(), null);
                    }
                }
            }
        });

        lblGotoLogin = (TextView) findViewById(R.id.link_to_login);
        lblGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemintent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(itemintent);
            }
        });

    }

    public void goToLogin(){
        Intent itemintent = new Intent(RegisterActivity.this, LoginActivity.class);
        RegisterActivity.this.startActivity(itemintent);
    }

   private boolean validateFields(){
       String fragmentTitle = getResources().getString(R.string.register_error_title);
       String fragmentText;

       //validamos que todos los campos tengan valor
       if (email.trim().length() == 0 || emailConfirm.trim().length() == 0 || password.trim().length() == 0 || passwordConfirm.trim().length() == 0){
           fragmentText = getResources().getString(R.string.register_error_blank_fields);
           DialogFragment newFragment = MessageDialog.newInstance(fragmentTitle, fragmentText,-1);
           newFragment.show(getFragmentManager(), null);
           return false;
       }
       //validamos el formato de los emails
       if(!Utils.validateEmail(email) || !Utils.validateEmail(emailConfirm)){
           fragmentText = getResources().getString(R.string.register_error_email_format);
           DialogFragment newFragment = MessageDialog.newInstance(fragmentTitle, fragmentText,-1);
           newFragment.show(getFragmentManager(), null);
           return false;
       }
       //validamos que los email coincidan
       if(!email.equals(emailConfirm)){
           fragmentText = getResources().getString(R.string.register_error_email_no_match);
           DialogFragment newFragment = MessageDialog.newInstance(fragmentTitle, fragmentText,-1);
           newFragment.show(getFragmentManager(), null);
           return false;
       }
       //validamos que las contraseñas coincidan
       if(!password.equals(passwordConfirm)){
           fragmentText = getResources().getString(R.string.register_error_password_no_match);
           DialogFragment newFragment = MessageDialog.newInstance(fragmentTitle, fragmentText,-1);
           newFragment.show(getFragmentManager(), null);
           return false;
       }

       return true;
   }
}
