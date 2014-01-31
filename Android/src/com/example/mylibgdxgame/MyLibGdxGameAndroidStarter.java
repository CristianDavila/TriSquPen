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
    public void openURL(String url) {
        System.out.print(url+"android");
    }

    Handler uiThread;
    Context appContext;

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
