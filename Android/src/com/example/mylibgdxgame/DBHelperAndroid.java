package com.example.mylibgdxgame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by salamandra on 31/01/14.
 */
public class DBHelperAndroid extends SQLiteOpenHelper {

    private static final String DB_NAME = "users.sqlite";



    private static final int DB_SCHEME_VERSION = 1;
    //la version del scheme sirve para futuras versiones de la base de datos (no le hagais caso)
    //si la app esta acabada y subimos una version, cuando se ejecute, android mira el schema y
    // aplicara los cambios

    public DBHelperAndroid(Context context) {

        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
