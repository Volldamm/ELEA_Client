package com.android.elea.db;

/**
 * Created by Borja on 02/06/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.elea.utils.EleaException;

public class EleaSQLiteHelper extends SQLiteOpenHelper {

    private static EleaSQLiteHelper sInstance;
    private static final String DATABASE_NAME = "myDB";
    private static final int DATABASE_VERSION = 3;

    public static synchronized EleaSQLiteHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new EleaSQLiteHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private EleaSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            //Se ejecuta la sentencia SQL de creación de la tabla
//            db.execSQL(sqlCreate);
        }catch (Exception e){
            new EleaException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        try{
        //Se elimina la versión anterior de la tabla
//            db.execSQL("DROP TABLE IF EXISTS Usuarios");

            //Se crea la nueva versión de la tabla
//            db.execSQL(sqlCreate);
        }catch (Exception e){
            new EleaException(e);
        }
    }
}
