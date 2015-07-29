package com.android.elea.business;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.elea.beans.Country;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.utils.EleaException;

/**
 * Created by Borja on 02/06/2015.
 */
public class CountryBS {

    public static Country getDefaultCountry(Context context){

        Country country = null;

        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            String sql = "SELECT c.id, c.name, c.available   " +
                    " FROM Country c " +
                    " WHERE c.name like 'España'";

            if(db != null)
            {
                Cursor c = db.rawQuery(sql,null);
                if (c.moveToFirst()){

                    country = new Country();
                    country.setId(c.getInt(0));
                    country.setName(c.getString(1));
                    country.setAvailable(c.getInt(2)==1);

                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }

        return country;
    }


}
