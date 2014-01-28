package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.example.mylibgdxgame.screens.SettingsMenu;

/**
 * Created by Dídac on 26/01/14.
 */
public class SettingsController {
    private static SettingsMenu settingsMenu;
    private static FrontController frontController;

    public SettingsController(FrontController controller) {
        frontController = controller;
        settingsMenu = new SettingsMenu();
    }

    public static void main() {
        ((Game) Gdx.app.getApplicationListener()).setScreen(settingsMenu);
    }

    public static void mainMenu() {
        frontController.mainMenu();
    }

}
