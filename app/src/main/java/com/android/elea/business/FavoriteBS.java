package com.android.elea.business;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.elea.beans.Job;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.EleaException;

/**
 * Created by Borja on 02/06/2015.
 */
public class FavoriteBS {



    public static long addFavorite(Context context, Job job){
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null){
                ContentValues newReg = new ContentValues();
                newReg.put("id", getNextFavoriteId(context));
                newReg.put("job_id", job.getId());
                newReg.put("user_id", CacheManager.getUser().getId());

                //Insertamos el registro en la base de datos
                res = db.insert("Favorites", null, newReg);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }

    public static void removeFavorite(Context context, Job job){
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null){
                //Insertamos el registro en la base de datos
                db.execSQL("DELETE FROM Favorites WHERE job_id= " + job.getId() + " AND user_id=" + CacheManager.getUser().getId());
            }
        } catch (Exception e) {
            new EleaException(e);
        }
    }


    public static int getNextFavoriteId(Context context){
        int max = 0;
        String sql = "SELECT MAX(id) AS max_id FROM Favorites";
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
