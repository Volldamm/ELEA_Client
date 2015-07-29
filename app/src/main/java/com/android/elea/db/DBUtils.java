package com.android.elea.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.elea.utils.EleaException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** Database utils, for example to execute SQL scripts */

public class DBUtils {


    public static int executeSqlScript(Context context, SQLiteDatabase db, int  fileID) throws IOException {
        return executeSqlScript(context, db, fileID, true);
    }

    public static int executeSqlScript(Context context, SQLiteDatabase db, int  fileID, boolean transactional) throws IOException {
        byte[] bytes = readAsset(context, fileID);
        String sql = new String(bytes, "UTF-8");
        String[] lines = sql.split(";(\\s)*[\n\r]");
        int count;
        if (transactional) {
            count = executeSqlStatementsInTx(db, lines);
        } else {
            count = executeSqlStatements(db, lines);
        }
        Log.i("logsAndroid", "Executed " + count + " statements from SQL script '" + fileID + "'");
        return count;
    }

    public static int executeSqlStatementsInTx(SQLiteDatabase db, String[] statements) {
        db.beginTransaction();
        try {
            int count = executeSqlStatements(db, statements);
            db.setTransactionSuccessful();
            return count;
        } finally {
            db.endTransaction();
        }
    }

    public static int executeSqlStatements(SQLiteDatabase db, String[] statements) {

        int count = 0;
        try {
            for (String line : statements) {
                line = line.trim();
                if (line.length() > 0) {
                    db.execSQL(line);
                    count++;
                }
            }

        } catch (Exception e) {
            new EleaException(e);
        }
        return count;
    }

    public static int copyAllBytes(InputStream in, OutputStream out) throws IOException {
        int byteCount = 0;
        byte[] buffer = new byte[4096];
        while (true) {
            int read = in.read(buffer);
            if (read == -1) {
                break;
            }
            out.write(buffer, 0, read);
            byteCount += read;
        }
        return byteCount;
    }

    public static byte[] readAllBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copyAllBytes(in, out);
        return out.toByteArray();
    }

    public static byte[] readAsset(Context context, int  fileID) throws IOException {
        InputStream in = context.getResources().openRawResource(fileID);
        try {
            return readAllBytes(in);
        } finally {
            in.close();
        }
    }

}
