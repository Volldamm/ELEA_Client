package com.android.elea.business;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.elea.beans.Country;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.utils.EleaException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borja on 02/06/2015.
 */
public class TownBS {



    public static Town getTownByName(Context context, String nameIn){
        Town town = null;

        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            String sql = "SELECT t.id, t.name, p.id, p.name  " +
                    " FROM Town t " +
                    " JOIN Province p ON t.province_id = p.id " +
                    " WHERE t.name like '"+nameIn+"'";

            if(db != null)
            {
                Cursor c = db.rawQuery(sql,null);
                if (c.moveToFirst()){

                    town = new Town();
                    town.setId(c.getInt(0));
                    town.setName(c.getString(1));

                    Province prov = new Province();
                    prov.setId(c.getInt(2));
                    prov.setName(c.getString(3));

                    town.setProvince(prov);
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }

        return town;
    }


    public static List<Town> getTownsByProvince(Context context,Province province){
        List<Town> townList = new ArrayList<Town>();
        Town town = null;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            String sql = "SELECT t.id, t.name FROM Town t " +
                    " WHERE t.province_id = " + province.getId() +
                    " ORDER by t.name ASC ";

            if(db != null) {
                Cursor c = db.rawQuery(sql, null);
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        town = new Town();
                        town.setId(c.getInt(0));
                        town.setName(c.getString(1));
                        townList.add(town);
                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return townList;
    }

    public static List<Town> getTowns(Context context){
        List<Town> townList = new ArrayList<Town>();
        Town town = null;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            String sql = "SELECT t.id, t.name FROM Town t ORDER by t.name ASC ";

            if(db != null) {
                Cursor c = db.rawQuery(sql, null);
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        town = new Town();
                        town.setId(c.getInt(0));
                        town.setName(c.getString(1));
                        townList.add(town);
                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return townList;
    }
}
