package com.android.elea.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.elea.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Borja on 02/05/2015.
 */
public class Utils {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static void showToast(Context context, String message){

        Toast toast1 =
                Toast.makeText(context,
                        message, Toast.LENGTH_SHORT);

        toast1.show();

    }


    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher;
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String dateToString(Date date) {
        if(date != null)
            return dateFormat.format(date);
        else
            return null;
    }

    public static Date stringToDate(String date) {
        try {
            if(date != null)
                return dateFormat.parse(date);
        } catch (ParseException e) {
            new EleaException(e);
        }
        return null;
    }

    public static String calculateSinceWhen(Date date){
        String sinceWhen = TextConstants.BLANK;
        try {
            long millis = date.getTime();
            String difType = null;
            long diff = System.currentTimeMillis() - millis;
            int dif = -1;

            int diffDay = (int)(diff / (24 * 60 * 60 * 1000));
            if(diffDay > 7){
                int diffWeeks = (int)(diff / (7*24 * 60 * 60 * 1000));
                if(diffWeeks > 4){
                    int diffMonths = (int)(diff / (30*24 * 60 * 60 * 1000));
                    if(diffMonths > 12){
                        int diffYears = (int)(diff / (365*24 * 60 * 60 * 1000));
                        dif = diffYears;
                        difType = "Y";
                    }else{
                        dif = diffMonths;
                        difType = "M";
                    }
                }else{
                    dif = diffWeeks;
                    difType = "W";
                }
            }else{
                dif = diffDay;
                difType = "D";
            }


            if(dif != -1){
                if(difType.compareTo("D")==0) {
                    if (dif > 1) {
                        sinceWhen = "Hace " + dif + " días";
                    } else if (dif == 0){
                        sinceWhen = "Hoy";
                    }else{
                        sinceWhen = "Hace " + dif + " día";
                    }
                }else if(difType.compareTo("W")==0){
                    if(dif > 1){
                        sinceWhen = "Hace " + dif + " semanas";
                    }else{
                        sinceWhen = "Hace " + dif + " semana";
                    }
                }else if(difType.compareTo("M")==0){
                    if(dif > 1){
                        sinceWhen = "Hace " + dif + " meses";
                    }else{
                        sinceWhen = "Hace " + dif + " mes";
                    }
                }else if(difType.compareTo("Y")==0){
                    if(dif > 1){
                        sinceWhen = "Hace " + dif + " años";
                    }else{
                        sinceWhen = "Hace " + dif + " año";
                    }
                }
            }

        } catch (Exception e) {
            new EleaException(e);
        }
        return sinceWhen;
    }


//    public static void invalidateUpperMenuOption(Activity act, Menu menu){
//
//        MenuItem upperMenuLogout = menu.findItem(R.id.upperMenuLogout);
//        upperMenuLogout.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuMyJobs);
//        upperMenuMyJobs.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuSearch);
//        upperMenuMyJobs.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuFavorites);
//        upperMenuMyJobs.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuMyMessages);
//        upperMenuMyJobs.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuMyProfile);
//        upperMenuMyJobs.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuNewJob);
//        upperMenuMyJobs.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuMyJobs);
//        upperMenuMyJobs.setVisible(false);
//
//        MenuItem upperMenuMyJobs = menu.findItem(R.id.upperMenuMyJobs);
//        upperMenuMyJobs.setVisible(false);
//        act.invalidateOptionsMenu();
//
//
//    }

}
