package com.android.elea.utils;

import java.util.HashMap;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.android.elea.activities.MainMenuActivity;
import com.android.elea.activities.login.LoginActivity;

public class SessionManager {

    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(TextConstants.PREF_NAME, TextConstants.PRIVATE_MODE);
        editor = pref.edit();
    }
    /**
          * Create login session
          * */
    public void createLoginSession(String name, String email){
        // Storing login value as TRUE
        editor.putBoolean(TextConstants.IS_LOGIN, true);
        // Storing name in pref
        editor.putString(TextConstants.KEY_NAME, name);
        // Storing email in pref
        editor.putString(TextConstants.KEY_EMAIL, email);
        // commit changes
        editor.commit();
    }

     /**
          * Check login method wil check user login status
          * If false it will redirect user to login page
          * Else won't do anything
          * */
     public void checkLogin(){
        //     Check login status
            if(!this.isLoggedIn()){
                // user is not logged in redirect him to Login Activity
                Intent i = new Intent(_context, LoginActivity.class);
                //Closing all the Activities
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //Add new Flag to start new Activity
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // Staring Login Activity
                _context.startActivity(i);
            }
     }



    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(TextConstants.KEY_NAME, pref.getString(TextConstants.KEY_NAME, null));
        // user email id
        user.put(TextConstants.KEY_EMAIL, pref.getString(TextConstants.KEY_EMAIL, null));
        // return user
        return user;
    }


    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // Despues del logout vamos al MainMenu
        Intent i = new Intent(_context, MainMenuActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Staring Login Activity
        _context.startActivity(i);
    }


    public boolean isLoggedIn(){
        return pref.getBoolean(TextConstants.IS_LOGIN, false);
    }
}
