package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.example.mylibgdxgame.MyLibgdxGame;
import com.example.mylibgdxgame.interfaces.ActionResolver;

/**
 * Created by Dídac on 26/01/14.
 */
public class FrontController {
    private static LwjglApplicationConfiguration config;
    private static MainController mainController;
    private static LevelSelectorController levelSelectorController;
    private static SettingsController settingsController;
    private static StaminaController staminaController;
    private static ActionResolver actionResolver;

    public FrontController(LwjglApplicationConfiguration config, ActionResolver actionResolver) {
        this.config = config;
        mainController = new MainController(this);
        levelSelectorController = new LevelSelectorController(this);
        settingsController = new SettingsController(this);
        staminaController = new StaminaController();
        this.actionResolver = actionResolver;
    }

    public static void main(){
        new LwjglApplication(new MyLibgdxGame(actionResolver),config);
    }

    public static void mainMenu() {
        MainController.main();
    }

    public static void levelSelectorMenu() {
        LevelSelectorController.main();
    }

    public static void settingsMenu() {
        SettingsController.main();
    }

    public static void exit() {
        Gdx.app.exit();
    }

}
