package com.android.elea.business;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.elea.beans.Country;
import com.android.elea.beans.Province;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.utils.EleaException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borja on 02/06/2015.
 */
public class ProvinceBS {

    public static Province getProvinceByName(Context context, String nameIn){
        Province province = null;

        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            String sql = "SELECT p.id, p.name, c.id, c.name, c.available " +
                    " FROM Province p " +
                    " JOIN Country c ON p.country_id = c.id " +
                    " WHERE p.name like '"+nameIn+"'";

            if(db != null)
            {
                Cursor c = db.rawQuery(sql,null);
                if (c.moveToFirst()){

                    province = new Province();
                    province.setId(c.getInt(0));
                    province.setName(c.getString(1));

                    Country country = new Country();
                    country.setId(c.getInt(2));
                    country.setName(c.getString(3));
                    country.setAvailable(c.getInt(4)==1);

                    province.setCountry(country);
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }

        return province;
    }

    public static List<Province> getProvinces(Context context){
        List<Province> provinceList = new ArrayList<Province>();
        Province province = null;
        try{

            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            String sql = "SELECT p.id, p.name FROM Province p ORDER by p.name ASC ";

            if(db != null) {
                Cursor c = db.rawQuery(sql, null);
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        province = new Province();
                        province.setId(c.getInt(0));
                        province.setName(c.getString(1));
                        provinceList.add(province);
                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }

        return provinceList;
    }
}
