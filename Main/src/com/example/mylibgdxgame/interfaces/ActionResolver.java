package com.example.mylibgdxgame.interfaces;

/**
 * Created by salamandra on 28/01/14.
 */

public interface ActionResolver {


    public void getDB();

    public void createTablePuntuaciones(String TABLE_NAME);

    public void createTableUsers();

    public void insertTablePuntuaciones(String TABLE_NAME, int new_level, int new_punt);

    public void insertTableUsers(String user_name,  String user_pass);

    public String[] selectTableUser(String new_user);

    public void deleteTable(String nameTable);

}