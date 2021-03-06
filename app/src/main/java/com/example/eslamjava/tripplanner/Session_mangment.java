package com.example.eslamjava.tripplanner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Rania on 2/2/2018.
 */

public class Session_mangment {
    SharedPreferences pref;


    SharedPreferences.Editor editor;


    Context _context;


    int PRIVATE_MODE = 0;


    private static final String PREF_NAME = "login_user_data";


    private static final String IS_LOGIN = "IsLoggedIn";


    public static final String KEY_NAME = "name";


    public static final String KEY_EMAIL = "email";


    public Session_mangment(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLoginSession(String name, String email){

        editor.putBoolean(IS_LOGIN, true);


        editor.putString(KEY_NAME, name);


        editor.putString(KEY_EMAIL, email);


        editor.commit();
    }


    public void checkLogin(){

        if(!this.isLoggedIn()){

            Intent i = new Intent(_context, Login_Activity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


            _context.startActivity(i);
        }

    }





    public void logoutUser(){

        editor.clear();
        editor.commit();


        Intent i = new Intent(_context, Login_Activity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        _context.startActivity(i);
    }


    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_NAME, pref.getString(KEY_NAME, " "));


        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, " "));


        return user;
    }
}

