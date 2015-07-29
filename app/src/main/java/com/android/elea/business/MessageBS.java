package com.android.elea.business;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.elea.beans.Job;
import com.android.elea.beans.Message;
import com.android.elea.beans.User;
import com.android.elea.db.EleaSQLiteHelper;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Borja on 13/07/2015.
 */
public class MessageBS {

    public static List<Message> searchMessagesByUser(Context context, User userIn){
        List<Message> messageList = null;
        try{
            StringBuilder sql = new StringBuilder("SELECT m.id, m.message_text, m.subject, m.is_read, m.date_created, m.date_modified,m.date_deleted,");
            sql.append(" sender.id, sender.email, sender.mail_notif_active, sender.device_notif_active, sender.device_id, ");
            sql.append(" receiver.id, receiver.email, receiver.mail_notif_active, receiver.device_notif_active, receiver.device_id, m.job_id ");

            sql.append(" FROM message m ");
            sql.append(" LEFT JOIN user receiver on m.receiver_id = receiver.id ");
            sql.append(" LEFT JOIN user sender on m.sender_id = sender.id ");

            sql.append(" WHERE m.sender_id = ");
            sql.append(userIn.getId());
            sql.append(" OR m.receiver_id = ");
            sql.append(userIn.getId());

            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null) {
                Cursor c = db.rawQuery(sql.toString(),null);
                if (c.moveToFirst()) {
                    Message msg;
                    User sender;
                    User receiver;
                    Job job;
                    messageList = new ArrayList<Message>();

                    do {
                        msg = new Message();
                        sender = new User();
                        receiver = new User();
                        job = new Job();

                        msg.setId(c.getInt(0));
                        msg.setMessageText(c.getString(1));
                        msg.setSubject(c.getString(2));
                        msg.setIsRead(c.getInt(3) == 1);

                        msg.setDateCreated(Utils.stringToDate(c.getString(4)));
                        msg.setDateModified(Utils.stringToDate(c.getString(5)));
                        msg.setDateDeleted(Utils.stringToDate(c.getString(6)));

                        sender.setId(c.getInt(7));
                        sender.setEmail(c.getString(8));
                        sender.setMailNotifActive(c.getInt(9) == 1);
                        sender.setDeviceNotifActive(c.getInt(10) == 1);
                        sender.setDeviceId(c.getString(11));

                        msg.setSender(sender);

                        receiver.setId(c.getInt(12));
                        receiver.setEmail(c.getString(13));
                        receiver.setMailNotifActive(c.getInt(14) == 1);
                        receiver.setDeviceNotifActive(c.getInt(15) == 1);
                        receiver.setDeviceId(c.getString(16));

                        msg.setReceiver(receiver);

                        job.setId(c.getInt(17));

                        msg.setJob(job);

                        messageList.add(msg);

                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return messageList;
    }

    public static List<Message> searchSentMessagesByUser(Context context, User userIn){
        List<Message> messageList = null;
        try{
            StringBuilder sql = new StringBuilder("SELECT m.id, m.message_text, m.subject, m.is_read, m.date_created, m.date_modified,m.date_deleted,");
            sql.append(" sender.id, sender.email, sender.mail_notif_active, sender.device_notif_active, sender.device_id, ");
            sql.append(" receiver.id, receiver.email, receiver.mail_notif_active, receiver.device_notif_active, receiver.device_id, m.job_id ");

            sql.append(" FROM message m ");
            sql.append(" LEFT JOIN user receiver on m.receiver_id = receiver.id ");
            sql.append(" WHERE m.sender_id = ");
            sql.append(userIn.getId());

            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null)
            {
                Cursor c = db.rawQuery(sql.toString(),null);
                if (c.moveToFirst()) {
                    Message msg;
                    User sender;
                    User receiver;
                    Job job;
                    messageList = new ArrayList<Message>();

                    do {
                        msg = new Message();
                        sender = new User();
                        receiver = new User();
                        job = new Job();

                        msg.setId(c.getInt(0));
                        msg.setMessageText(c.getString(1));
                        msg.setSubject(c.getString(2));
                        msg.setIsRead(c.getInt(3) == 1);

                        msg.setDateCreated(Utils.stringToDate(c.getString(4)));
                        msg.setDateModified(Utils.stringToDate(c.getString(5)));
                        msg.setDateDeleted(Utils.stringToDate(c.getString(6)));

                        sender.setId(c.getInt(7));
                        sender.setEmail(c.getString(8));
                        sender.setMailNotifActive(c.getInt(9) == 1);
                        sender.setDeviceNotifActive(c.getInt(10) == 1);
                        sender.setDeviceId(c.getString(11));

                        msg.setSender(sender);

                        receiver.setId(c.getInt(12));
                        receiver.setEmail(c.getString(13));
                        receiver.setMailNotifActive(c.getInt(14) == 1);
                        receiver.setDeviceNotifActive(c.getInt(15) == 1);
                        receiver.setDeviceId(c.getString(16));

                        msg.setReceiver(receiver);

                        job.setId(c.getInt(17));

                        msg.setJob(job);

                        messageList.add(msg);

                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return messageList;
    }

    public static List<Message> searchReceivedMessagesByUser(Context context, User userIn){
        List<Message> messageList = null;
        try{
            StringBuilder sql = new StringBuilder("SELECT m.id, m.message_text, m.subject, m.is_read, m.date_created, m.date_modified,m.date_deleted,");
            sql.append(" sender.id, sender.email, sender.mail_notif_active, sender.device_notif_active, sender.device_id, ");
            sql.append(" receiver.id, receiver.email, receiver.mail_notif_active, receiver.device_notif_active, receiver.device_id, m.job_id ");

            sql.append(" FROM message m ");
            sql.append(" LEFT JOIN user receiver on m.receiver_id = receiver.id ");
            sql.append(" WHERE m.receiver_id = ");
            sql.append(userIn.getId());

            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null)
            {
                Cursor c = db.rawQuery(sql.toString(),null);
                if (c.moveToFirst()) {
                    Message msg;
                    User sender;
                    User receiver;
                    Job job;
                    messageList = new ArrayList<Message>();

                    do {
                        msg = new Message();
                        sender = new User();
                        receiver = new User();
                        job = new Job();

                        msg.setId(c.getInt(0));
                        msg.setMessageText(c.getString(1));
                        msg.setSubject(c.getString(2));
                        msg.setIsRead(c.getInt(3) == 1);

                        msg.setDateCreated(Utils.stringToDate(c.getString(4)));
                        msg.setDateModified(Utils.stringToDate(c.getString(5)));
                        msg.setDateDeleted(Utils.stringToDate(c.getString(6)));

                        sender.setId(c.getInt(7));
                        sender.setEmail(c.getString(8));
                        sender.setMailNotifActive(c.getInt(9) == 1);
                        sender.setDeviceNotifActive(c.getInt(10) == 1);
                        sender.setDeviceId(c.getString(11));

                        msg.setSender(sender);

                        receiver.setId(c.getInt(12));
                        receiver.setEmail(c.getString(13));
                        receiver.setMailNotifActive(c.getInt(14) == 1);
                        receiver.setDeviceNotifActive(c.getInt(15) == 1);
                        receiver.setDeviceId(c.getString(16));

                        msg.setReceiver(receiver);

                        job.setId(c.getInt(17));

                        msg.setJob(job);

                        messageList.add(msg);

                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return messageList;
    }

    public static long insertMessage(Context context, Message msg){
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null){
                ContentValues newReg = new ContentValues();
                newReg.put("id", getNextMessageId(context));
                newReg.put("sender_id",msg.getSender().getId());
                newReg.put("receiver_id",msg.getReceiver().getId());
                newReg.put("message_text",msg.getMessageText());
                newReg.put("is_read",msg.getIsRead());
                newReg.put("date_created", Utils.dateToString(msg.getDateCreated()));

                //Insertamos el registro en la base de datos
                res = db.insert("Message", null, newReg);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }

    public static long deleteMessage(Context context, Message msg){ //solo se trata de un borrado l�gico
        long res = -1;
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getWritableDatabase();

            if(db != null){
                ContentValues updateReg = new ContentValues();

                updateReg.put("date_deleted",Utils.dateToString(new Date()));

                //Actualizamos el registro en la base de datos
                res = db.update("Job", updateReg, "id=" + msg.getId(), null);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return res;
    }

    public static int getNextMessageId(Context context){
        int max = 0;
        String sql = "SELECT MAX(id) AS max_id FROM Message";
        try{
            SQLiteDatabase db = EleaSQLiteHelper.getInstance(context).getReadableDatabase();
            if(db != null) {
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
