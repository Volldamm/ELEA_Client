package com.android.elea.utils;

import android.util.Log;

/**
 * Created by Borja on 01/05/2015.
 */
public class EleaException {

    private static final String LOGTAG = "LogsAndroid";
    Exception e;

//    Log.e(LOGTAG, "Mensaje de error");
//    Log.w(LOGTAG, "Mensaje de warning");
//    Log.i(LOGTAG, "Mensaje de información");
//    Log.d(LOGTAG, "Mensaje de depuración");
//    Log.v(LOGTAG, "Mensaje de verbose");

    public EleaException(Exception e){
        Log.e(LOGTAG, "Error en ", e);
        e.printStackTrace();
    }


}
