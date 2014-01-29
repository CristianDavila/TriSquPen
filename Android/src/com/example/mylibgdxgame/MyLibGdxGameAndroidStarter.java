package com.example.mylibgdxgame;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.example.mylibgdxgame.interfaces.ActionResolver;


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
}
