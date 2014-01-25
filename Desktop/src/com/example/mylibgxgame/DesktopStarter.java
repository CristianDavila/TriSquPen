package com.example.mylibgxgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.example.mylibgdxgame.MyLibgdxGame;

/**
 * Created by Dídac on 18/01/14.
 */
public class DesktopStarter {
    public static void main(String[] args) {
        System.setProperty("user.name","Development Team");
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = MyLibgdxGame.title + " v" + MyLibgdxGame.version;
        cfg.vSyncEnabled = true;
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 480;
        new LwjglApplication(new MyLibgdxGame(), cfg);
    }
}
