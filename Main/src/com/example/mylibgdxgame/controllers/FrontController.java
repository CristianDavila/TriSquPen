package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.example.mylibgdxgame.MyLibgdxGame;

/**
 * Created by Dídac on 26/01/14.
 */
public class FrontController {
    private static LwjglApplicationConfiguration config;

    public FrontController(LwjglApplicationConfiguration config) {
        this.config = config;
    }

    public static void main(){
        new LwjglApplication(new MyLibgdxGame(),config);

    }

}
