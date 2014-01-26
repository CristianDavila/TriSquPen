package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.example.mylibgdxgame.screens.MainMenu;

/**
 * Created by Dídac on 26/01/14.
 */
public class MainController {

    public static void main() {
        ((Game) (Gdx.app.getApplicationListener())).setScreen(new MainMenu());
    }

    public static void playScreen() {
        new LevelSelectorController();
        LevelSelectorController.main();
    }

    public static void settingsScreen() {
        new SettingsController();
        SettingsController.main();
    }

    public static void exit() {
        Gdx.app.exit();
    }

}
