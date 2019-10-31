package com.pruebaq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SqlHelper extends SQLiteOpenHelper
{
    private static int version = 1;
    private static String name = "HipotecaDb" ;
    private static CursorFactory factory = null;

    public SqlHelper(Context context)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL( "CREATE TABLE USUARIOS(" +
                " _id INTEGER PRIMARY KEY," +
                " db_nombre TEXT NOT NULL, " +
                " db_telefono INT," +
                " db_email TEXT)"
                 );

        db.execSQL( "CREATE UNIQUE INDEX db_nombre ON USUARIOS(db_nombre ASC)" );

        Log.i(this.getClass().toString(), "Tabla HIPOTECA creada");

        /*
         * Insertamos datos iniciales
         */
        db.execSQL("INSERT INTO USUARIOS(_id, db_nombre) VALUES(1,'Andres')");
        db.execSQL("INSERT INTO USUARIOS(_id, db_nombre) VALUES(2,'Felipe')");
        db.execSQL("INSERT INTO USUARIOS(_id, db_nombre) VALUES(3,'Andrea')");
        db.execSQL("INSERT INTO USUARIOS(_id, db_nombre) VALUES(4,'Marian')");
        db.execSQL("INSERT INTO USUARIOS(_id, db_nombre) VALUES(5,'Marina')");
        db.execSQL("INSERT INTO USUARIOS(_id, db_nombre) VALUES(6,'Jose')");

        Log.i(this.getClass().toString(), "Nombres ingresados");

        Log.i(this.getClass().toString(), "Base de datos creada");
    }
}
