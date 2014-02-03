package com.example.mylibgdxgame;

/**
 * Created by salamandra on 3/02/14.
 */
public class DBManager {



    public DBManager(){
    }

    public String createTable(String table_name){
        String TABLE_NAME = table_name;
        String CN_LEVEL = "Level";
        String CN_NAME = "Name";
        String CREATE_TABLE = "create table " + TABLE_NAME + " ("
                        + CN_NAME + " text primary key not null,"
                        + CN_LEVEL + " integer autoincrement);";
        return CREATE_TABLE;

    }

    public void insert(String table_name, int new_level, String new_name, int new_punt){
        String  TABLE_NAME = table_name;
        int     LEVEL = new_level;
        String  NAME = new_name;
        int     PUNTUATION = new_punt;
        String  INSERT_ON_TABLE = "create table " + TABLE_NAME + " ("
                + NAME + " text primary key not null,"
                + LEVEL + " integer autoincrement);";
    }



}
