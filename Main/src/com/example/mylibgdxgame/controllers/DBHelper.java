package com.example.mylibgdxgame.controllers;

import com.example.mylibgdxgame.interfaces.ActionResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class DBHelper implements ActionResolver {

    Handler uiThread;
    Context appContext;

    public DBHelper(Context appContext) {
        uiThread = new Handler();
        this.appContext = appContext;
    }

    @Override
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