package com.example.mylibgdxgame;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by salamandra on 3/02/14.
 */
public class DBManager {

    private DBHelperAndroid DataBaseHelperAndroid;
    private SQLiteDatabase db;

    public DBManager(Context context){
        DataBaseHelperAndroid = new DBHelperAndroid(context);
        db = DataBaseHelperAndroid.getWritableDatabase(); //Si la base existe, la devuelve, sino la crea y la devuelve
    }

    public void deleteTable(String nameTable){
        db.execSQL("DROP TABLE "+nameTable);
    }

    public void createTableUsers(){
        //deleteTable("Users"); // CUIDADO!!!!!!!!!!!!!!!!!!

        String TABLE_NAME = "Users";
        String CN_ID = "ID";
        String CN_NAME = "Name";
        String CN_PASS = "Pass";
        String CN_NAME_TABLE_PUNT = "NameTable";
        String CREATE_TABLE = "create table IF NOT EXISTS " + TABLE_NAME + " ("
                + CN_NAME + " text primary key not null, "
                + CN_PASS + " text not null, "
                + CN_NAME_TABLE_PUNT + " text not null);";


        db.execSQL(CREATE_TABLE); //si hay error devuelve -1, sino un valor random

    }

    public void createTablePuntuaciones(String table_name){
        //deleteTable(table_name); // CUIDADO!!!!!!!!!!!!!!!!!!

        String TABLE_NAME = table_name;

        String CN_LEVEL = "Level";
        String CN_PUNTUATION = "Puntuation";
        String CREATE_TABLE = "create table IF NOT EXISTS " + TABLE_NAME + " ("
                        + CN_LEVEL + " text primary key not null,"
                        + CN_PUNTUATION + " integer not null);";


        db.execSQL(CREATE_TABLE); //si hay error devuelve -1, sino un valor random

    }

    public void insertTablePuntuaciones(String table_name, int new_level, int new_punt){
        //inserta un una nueva puntuacion en la tabla de puntuaciones que se le da
        String  TABLE_NAME = table_name;
        int     LEVEL = new_level;
        int     PUNTUATION = new_punt;
        String  INSERT_ON_TABLE = "INSERT INTO " + TABLE_NAME + "(Level, Puntuation)" + " VALUES ('"+LEVEL+"', '"+PUNTUATION+"');";

        db.execSQL(INSERT_ON_TABLE); //si hay error devuelve -1, sino un valor random

    }

    public void insertTableUser(String new_user,  String new_pass){
        //inserta un nuevo usuario (user, pass, y el nombre de su tabla de puntuaciones)
        String  TABLE_NAME = "Users";
        String  NAME = new_user;
        String  PASS = new_pass;
        String  NAME_TABLE_PUNT = new_user+"TablePuntuation";
        String  INSERT_ON_TABLE = "INSERT INTO " + TABLE_NAME+ "(Name, Pass, NameTable)" + " VALUES ('"+NAME+"', '"+PASS+"', '"+NAME_TABLE_PUNT+"');";

        db.execSQL(INSERT_ON_TABLE); //si hay error devuelve -1, sino un valor random

    }

    public String[] selectTableUser(String new_user){
        //mira si existe un usuario y lo devuelve si existe, sino devuelve null en sus campos
        String[] user = new String[3];

        String  TABLE_NAME = "Users";
        String  NAME = new_user;
        String  INSERT_ON_TABLE = "SELECT * FROM " + TABLE_NAME + " WHERE Name = '"+NAME+"';";

        Cursor c = db.rawQuery(INSERT_ON_TABLE, null); //si hay error devuelve -1, sino un valor random

        if(c.moveToFirst()){
            user[0] = c.getString(0);
            user[1] = c.getString(1);
            user[2] = c.getString(2);
        }
        else{
            user[0] = "null";
            user[1] = "null";
            user[2] = "null";
        }
        return user;

    }


    public void delete(){
       //falta implementar

    }



}
