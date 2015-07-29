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
import com.android.elea.activities.MainMenuActivity;
import com.android.elea.business.UserBS;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.SessionManager;

public class LoginActivity extends Activity {

    private TextView lblGotoRegister;
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginErrorMsg;
    private SessionManager session;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        inputEmail = (EditText) findViewById(R.id.loginEmail);
        inputPassword = (EditText) findViewById(R.id.loginPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                checkLogin();
            }
        });

        lblGotoRegister = (TextView) findViewById(R.id.link_to_register);
        lblGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }


    private void checkLogin(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if(UserBS.checkLogin(this,email,password)){
            session.createLoginSession("user", email);
            //guardamos el usuario en cache
            CacheManager.setUser(UserBS.getUserByEmail(this,email));
            startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
        }else{
            DialogFragment newFragment = MessageDialog.newInstance(
                    getResources().getString(R.string.login_error_title), getResources().getString(R.string.login_error_text),-1);

            newFragment.show(getFragmentManager(),"loginErrorFragment");
        }
    }


}
