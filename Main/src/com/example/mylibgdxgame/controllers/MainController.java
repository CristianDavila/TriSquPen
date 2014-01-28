package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.example.mylibgdxgame.screens.MainMenu;

/**
 * Created by Dídac on 26/01/14.
 */
public class MainController {

    private static MainMenu mainMenu;
    private static FrontController frontController;

    public MainController(FrontController controller) {
        frontController = controller;
        mainMenu = new MainMenu(this);
    }

    public static void main() {
        ((Game) (Gdx.app.getApplicationListener())).setScreen(mainMenu);
    }

    public static void playScreen() {
        frontController.levelSelectorMenu();
    }

    public static void settingsScreen() {
        frontController.settingsMenu();
    }

    public static void exit() {
        frontController.exit();
    }

}
