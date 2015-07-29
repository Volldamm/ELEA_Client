package com.android.elea.business;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.elea.beans.Country;
import com.android.elea.beans.Favorite;
import com.android.elea.beans.Job;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;
import com.android.elea.beans.User;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.db.SearchFilters;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Borja on 02/06/2015.
 */
public class JobBS {

    public static List<Job> searchJobsByUser(Context context, User userIn){
        List<Job> jobList = null;
        try{
            StringBuilder sql = new StringBuilder("SELECT j.id, j.user_id, j.title, j.description, j.province_id, j.town_id, j.is_offer, j.is_active, j.payment_mode, j.amount, j.date_created, j.date_modified,j.date_deleted,");
            sql.append(" u.email, u.mail_notif_active, u.device_notif_active, u.device_id, ");
            sql.append(" p.name, ");
            sql.append(" t.name, ");
            sql.append(" f.id ");

            sql.append(" FROM job j ");
            sql.append(" LEFT JOIN user u on j.user_id = u.id ");
            sql.append(" LEFT JOIN province p on j.province_id = p.id ");
            sql.append(" LEFT JOIN town t on j.town_id = t.id ");
            sql.append(" LEFT JOIN favorites f on j.id = f.job_id AND f.user_id = ");
            sql.append(userIn.getId());
            sql.append(" WHERE j.user_id = ");
            sql.append(userIn.getId());

            sql.append(" AND j.date_deleted IS NULL ");

            Country country = CacheManager.getDefaultCountry();

            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null)
            {
                Cursor c = db.rawQuery(sql.toString(),null);
                if (c.moveToFirst()) {
                    Job job;
                    User user;
                    Province province;
                    Town town;
                    jobList = new ArrayList<Job>();

                    do {
                        job = new Job();
                        user = new User();
                        province = new Province();
                        town = new Town();

                        job.setId(c.getInt(0));
                        user.setId(c.getInt(1));
                        job.setTitle(c.getString(2));
                        job.setDescription(c.getString(3));
                        province.setId(c.getInt(4));
                        town.setId(c.getInt(5));
                        job.setOffer(c.getInt(6) == 1);
                        job.setActive(c.getInt(7) == 1);
                        job.setPaymentMode(c.getString(8));
                        job.setAmount(c.getInt(9));
                        job.setDateCreated(Utils.stringToDate(c.getString(10)));
                        job.setDateModified(Utils.stringToDate(c.getString(11)));
                        job.setDateDeleted(Utils.stringToDate(c.getString(12)));
                        user.setEmail(c.getString(13));
                        user.setMailNotifActive(c.getInt(14)==1);
                        user.setDeviceNotifActive(c.getInt(15) == 1);
                        user.setDeviceId(c.getString(16));
                        province.setName(c.getString(17));
                        province.setCountry(country);
                        town.setName(c.getString(18));
                        town.setProvince(province);

                        if(c.getInt(19) > 0){
                            job.setIsFavourite(true);
                        }else{
                            job.setIsFavourite(false);
                        }
                        job.setUser(user);
                        job.setCountry(country);
                        job.setProvince(province);
                        job.setTown(town);

                        jobList.add(job);

                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return jobList;
    }


    public static List<Job> searchJobsByCriteria(Context context, SearchFilters filters){
        List<Job> jobList = null;
        try{
            StringBuilder sql = new StringBuilder("SELECT j.id, j.user_id, j.title, j.description, j.province_id, j.town_id, j.is_offer, j.is_active, j.payment_mode, j.amount, j.date_created, j.date_modified,j.date_deleted, ");
            sql.append(" u.email, u.mail_notif_active, u.device_notif_active, u.device_id, ");
            sql.append(" p.name, ");
            sql.append(" t.name,");
            sql.append(" f.id ");

            sql.append(" FROM job j ");
            sql.append(" LEFT JOIN user u on j.user_id = u.id ");
            sql.append(" LEFT JOIN province p on j.province_id = p.id ");
            sql.append(" LEFT JOIN town t on j.town_id = t.id ");
            sql.append(" LEFT JOIN favorites f on j.id = f.job_id");

            if(CacheManager.getUser() != null){
                sql.append(" AND f.user_id = ");
                sql.append(CacheManager.getUser().getId());
            }


            sql.append(" WHERE j.is_active = 1 "); //buscamos siempre ofertas activas
            sql.append(" AND j.country_id = ");     //en el pais por defecto
            Country country = CacheManager.getDefaultCountry();
            sql.append(country.getId());

            sql.append(" AND j.date_deleted IS NULL ");

            if(filters.getText() != null && filters.getText().trim().length()>0){
                sql.append(" AND (lower(j.title) like '%");
                sql.append(filters.getText().toLowerCase());
                sql.append("%' OR lower(j.description) like '%");
                sql.append(filters.getText().toLowerCase());
                sql.append("%') ");
            }
            if(filters.getProvince() != null && filters.getProvince().getName().trim().length()>0){
                sql.append(" AND j.province_id = ");
                sql.append(filters.getProvince().getId());
            }
            if(filters.getTown() != null&& filters.getTown().getName().trim().length()>0){
                sql.append(" AND j.town_id = ");
                sql.append(filters.getTown().getId());
            }


            if(filters.isFavorite()){
                sql.append(" AND EXISTS (SELECT * FROM favorites f2 where f2.job_id = j.id AND f2.user_id = "+CacheManager.getUser().getId()+") ");
            }else{
                if(filters.isOffer()){
                    sql.append(" AND j.is_offer = 1");
                }else{
                    sql.append(" AND j.is_offer = 0");
                }
            }

            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null)
            {
                Cursor c = db.rawQuery(sql.toString(),null);
                if (c.moveToFirst()) {
                    Job job;
                    User user;
                    Province province;
                    Town town;
                    jobList = new ArrayList<Job>();

                    do {
                        job = new Job();
                        user = new User();
                        province = new Province();
                        town = new Town();

                        job.setId(c.getInt(0));
                        user.setId(c.getInt(1));
                        job.setTitle(c.getString(2));
                        job.setDescription(c.getString(3));
                        province.setId(c.getInt(4));
                        town.setId(c.getInt(5));
                        job.setOffer(c.getInt(6) == 1);
                        job.setActive(c.getInt(7) == 1);
                        job.setPaymentMode(c.getString(8));
                        job.setAmount(c.getInt(9));
                        job.setDateCreated(Utils.stringToDate(c.getString(10)));
                        job.setDateModified(Utils.stringToDate(c.getString(11)));
                        job.setDateDeleted(Utils.stringToDate(c.getString(12)));
                        user.setEmail(c.getString(13));
                        user.setMailNotifActive(c.getInt(14)==1);
                        user.setDeviceNotifActive(c.getInt(15) == 1);
                        user.setDeviceId(c.getString(16));
                        province.setName(c.getString(17));
                        province.setCountry(country);
                        town.setName(c.getString(18));
                        town.setProvince(province);

                        if(c.getInt(19) > 0){
                            job.setIsFavourite(true);
                        }else{
                            job.setIsFavourite(false);
                        }
                        job.setUser(user);
                        job.setCountry(country);
                        job.setProvince(province);
                        job.setTown(town);

                        jobList.add(job);

                    } while (c.moveToNext());
                }
            }

        } catch (Exception e) {
            new EleaException(e);
        }
        return jobList;
    }


    public static long insertJob(Context context, Job job){
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null){
                ContentValues newReg = new ContentValues();
                newReg.put("id", getNextJobId(context));
                newReg.put("user_id",job.getUser().getId());
                newReg.put("title",job.getTitle());
                newReg.put("description",job.getDescription());
                if(job.getCountry() != null )
                    newReg.put("country_id",job.getCountry().getId());
                if(job.getTown() != null )
                    newReg.put("town_id",job.getTown().getId());
                if(job.getProvince() != null )
                    newReg.put("province_id",job.getProvince().getId());
                newReg.put("is_offer",job.isOffer());
                newReg.put("is_active",job.isActive());
                newReg.put("payment_mode",job.getPaymentMode());
                newReg.put("amount",job.getAmount());
                newReg.put("date_created", Utils.dateToString(job.getDateCreated()));

                //Insertamos el registro en la base de datos
                res = db.insert("Job", null, newReg);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }


    public static long updateJob(Context context, Job job){
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null){
                ContentValues updateReg = new ContentValues();
//                updateReg.put("id", job.getId());
                updateReg.put("user_id", job.getUser().getId());
                updateReg.put("title", job.getTitle());
                updateReg.put("description", job.getDescription());
                if(job.getCountry() != null )
                    updateReg.put("country_id",job.getCountry().getId());
                if(job.getTown() != null )
                    updateReg.put("town_id",job.getTown().getId());
                if(job.getProvince() != null )
                    updateReg.put("province_id",job.getProvince().getId());
                updateReg.put("is_offer", job.isOffer());
                updateReg.put("is_active", job.isActive());
                updateReg.put("payment_mode", job.getPaymentMode());
                updateReg.put("amount", job.getAmount());
                updateReg.put("date_modified", Utils.dateToString(job.getDateCreated()));

                //Actualizamos el registro en la base de datos
                res = db.update("Job", updateReg, "id=" + job.getId(), null);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }

    public static long deleteJob(Context context, Job job){ //solo se trata de un borrado lógico
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null){
                ContentValues updateReg = new ContentValues();

                updateReg.put("date_deleted", Utils.dateToString(new Date()));

                //Actualizamos el registro en la base de datos
                res = db.update("Job",updateReg,"id="+job.getId(),null);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }

    public static Job getJobById(Context context, int id){
        Job job = null;
        try{
            StringBuilder sql = new StringBuilder("SELECT j.id, j.user_id, j.title, j.description, j.province_id, j.town_id, j.is_offer, j.is_active, j.payment_mode, j.amount, j.date_created, j.date_modified,j.date_deleted, ");
            sql.append(" u.email, u.mail_notif_active, u.device_notif_active, u.device_id, ");
            sql.append(" p.name, ");
            sql.append(" t.name,");
            sql.append(" f.id ");

            sql.append(" FROM job j ");
            sql.append(" LEFT JOIN user u on j.user_id = u.id ");
            sql.append(" LEFT JOIN province p on j.province_id = p.id ");
            sql.append(" LEFT JOIN town t on j.town_id = t.id ");
            sql.append(" LEFT JOIN favorites f on j.id = f.job_id AND f.user_id = ");
            sql.append(CacheManager.getUser().getId());
            sql.append(" WHERE j.id = ");
            sql.append(id);
            sql.append(" AND j.country_id = ");     //en el pais por defecto
            Country country = CacheManager.getDefaultCountry();
            sql.append(country.getId());

//            sql.append(" AND j.date_deleted IS NULL ");

            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null)
            {
                Cursor c = db.rawQuery(sql.toString(),null);
                if (c.moveToFirst()) {
                    User user;
                    Province province;
                    Town town;

                    do {
                        job = new Job();
                        user = new User();
                        province = new Province();
                        town = new Town();

                        job.setId(c.getInt(0));
                        user.setId(c.getInt(1));
                        job.setTitle(c.getString(2));
                        job.setDescription(c.getString(3));
                        province.setId(c.getInt(4));
                        town.setId(c.getInt(5));
                        job.setOffer(c.getInt(6) == 1);
                        job.setActive(c.getInt(7) == 1);
                        job.setPaymentMode(c.getString(8));
                        job.setAmount(c.getInt(9));
                        job.setDateCreated(Utils.stringToDate(c.getString(10)));
                        job.setDateModified(Utils.stringToDate(c.getString(11)));
                        job.setDateDeleted(Utils.stringToDate(c.getString(12)));
                        user.setEmail(c.getString(13));
                        user.setMailNotifActive(c.getInt(14)==1);
                        user.setDeviceNotifActive(c.getInt(15) == 1);
                        user.setDeviceId(c.getString(16));
                        province.setName(c.getString(17));
                        province.setCountry(country);
                        town.setName(c.getString(18));
                        town.setProvince(province);

                        if(c.getInt(19) > 0){
                            job.setIsFavourite(true);
                        }else{
                            job.setIsFavourite(false);
                        }
                        job.setUser(user);
                        job.setCountry(country);
                        job.setProvince(province);
                        job.setTown(town);

                    } while (c.moveToNext());
                }
            }

        } catch (Exception e) {
            new EleaException(e);
        }
        return job;
    }


    public static int getNextJobId(Context context){
        int max = 0;
        String sql = "SELECT MAX(id) AS max_id FROM Job";
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
