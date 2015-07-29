package com.android.elea.business;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.elea.beans.User;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.utils.EleaException;

/**
 * Created by Borja on 02/06/2015.
 */
public class UserBS {


    public static long insertUser(Context context, User user){
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null)
            {
                ContentValues newReg = new ContentValues();
                newReg.put("id", getNextUserId(context));
                newReg.put("email", user.getEmail());
                newReg.put("key",user.getKey());
                newReg.put("mail_notif_active",1);  //notificaciones activadas por defecto
                newReg.put("device_notif_active",1);
                res = db.insert("User", null, newReg);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }

    public static long updateUser(Context context, User user){
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null)
            {
                ContentValues editReg = new ContentValues();
                editReg.put("email", user.getEmail());
                if(user.getKey() != null && user.getKey().trim().length()>0)
                    editReg.put("key", user.getKey());
                editReg.put("mail_notif_active", user.getMailNotifActive());
                editReg.put("device_notif_active", user.getDeviceNotifActive());
                res = db.update("User", editReg, "id=" + user.getId(),null);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }

    public static boolean checkExistingEmail(Context context,String email){
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();

            if(db != null)
            {
                Cursor c = db.rawQuery(" SELECT * FROM User WHERE email='"+email+"'", null);

                int emailExist = c.getCount();
                if(emailExist == 1) {
                    return true;
                }else {
                    return false;
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return false;
    }

    public static User getUserByEmail(Context context,String email){
        User user = null;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();

            if(db != null)
            {
                Cursor c = db.rawQuery(" SELECT u.id, u.email, u.mail_notif_active," +
                        " u.device_notif_active, u.device_id " +
                        " FROM User u WHERE email='"+email+"'", null);

                if (c.moveToFirst()){
                    user = new User();
                    user.setId(c.getInt(0));
                    user.setEmail(c.getString(1));
                    user.setMailNotifActive(c.getInt(2)==1);
                    user.setDeviceNotifActive(c.getInt(3)==1);
                    user.setDeviceId(c.getString(4));
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return user;
    }

    public static boolean checkLogin(Context context,String email, String password){
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();

            if(db != null)
            {
                Cursor c = db.rawQuery(" SELECT * FROM User WHERE email='"+email+"' AND key='"+password+"' ", null);

                int userOk = c.getCount();
                if(userOk == 1) {
                    return true;
                }else {
                    return false;
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return false;
    }

    public static int getNextUserId(Context context){
        int max = 0;
        String sql = "SELECT MAX(id) AS max_id FROM User";
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null)
            {
                Cursor c = db.rawQuery(sql,null);
                if (c.moveToFirst())
                    max = c.getInt(0);
            }
        } catch (Exception e) {
            new EleaException(e);
        }

        return max+1;
    }

}
