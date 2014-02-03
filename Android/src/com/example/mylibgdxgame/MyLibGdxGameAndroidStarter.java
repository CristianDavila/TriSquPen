package com.example.mylibgdxgame;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.example.mylibgdxgame.interfaces.ActionResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyLibGdxGameAndroidStarter extends AndroidApplication implements ActionResolver{


    private DBManager DataBaseManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        cfg.useWakelock = true;
        cfg.useGL20 = true;
        initialize(new MyLibgdxGame(this), cfg);
    }



    @Override
    public void getDB(){
        DataBaseManager= new DBManager(this);
    }

    @Override
    public void createTablePuntuaciones(String TABLE_NAME) {
       DataBaseManager.createTablePuntuaciones(TABLE_NAME);
    }

    @Override
    public void createTableUsers() {
        DataBaseManager.createTableUsers();
    }

    @Override
    public void insertTablePuntuaciones(String TABLE_NAME, String new_name, int new_level, int new_punt) {
        DataBaseManager.insertTablePuntuaciones(TABLE_NAME, new_name, new_level, new_punt);
    }

    @Override
    public void insertTableUsers(String user_name, String user_pass) {
        DataBaseManager.insertTableUser(user_name,user_pass);
    }

    @Override
    public String[] selectTableUser(String new_user) {
        return DataBaseManager.selectTableUser(new_user);
    }

    Handler uiThread;
    Context appContext;

    public MyLibGdxGameAndroidStarter() {

    }

    public MyLibGdxGameAndroidStarter(Context appContext) {
        uiThread = new Handler();
        this.appContext = appContext;
    }



    public Connection getConnection() {
        String url = "jdbc:sqldroid:/data/data/my.app.name/databases/data.sqlite";
        try {
            Class.forName("org.sqldroid.SQLDroidDriver").newInstance();
            return DriverManager.getConnection(url);
        } catch (InstantiationException e) {
            Log.e("sql", e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e("sql", e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("sql", e.getMessage());
        } catch (SQLException e) {
            Log.e("sql", e.getMessage());
        }
        return null;
    }
}
