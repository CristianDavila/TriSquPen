package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.example.mylibgdxgame.screens.MainMenu;

/**
 * Created by Dídac on 26/01/14.
 */
public class MainController {

    private static  MainMenu mainMenu;

    public MainController() {
        mainMenu = new MainMenu();
    }

    public static void main() {
        ((Game) (Gdx.app.getApplicationListener())).setScreen(mainMenu);
    }

    public static void playScreen() {
        FrontController.levelSelectorMenu();
    }

    public static void settingsScreen() {
        FrontController.settingsMenu();
    }

    public static void exit() {
        FrontController.exit();
    }

}
