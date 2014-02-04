package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
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
    private static LwjglApplication application;
    private static UserController userController;

    public FrontController(LwjglApplicationConfiguration config, ActionResolver actionResolver) {
        this.config = config;
        mainController = new MainController(this);
        levelSelectorController = new LevelSelectorController(this);
        settingsController = new SettingsController(this);
        staminaController = new StaminaController();
        this.actionResolver = actionResolver;
        userController = new UserController(actionResolver);
    }

    public FrontController(ActionResolver actionResolver) {
        mainController = new MainController(this);
        levelSelectorController = new LevelSelectorController(this);
        settingsController = new SettingsController(this);
        staminaController = new StaminaController();
        this.actionResolver = actionResolver;
        userController = new UserController(actionResolver);
    }

    public static void main(){
        application = new LwjglApplication(new MyLibgdxGame(actionResolver),config);
    }

    public static void mainMenu() {
        System.out.println("///////////////");
        System.out.println("///////////////");
        for(int i=0; i<10; ++i) System.out.println(".");
        actionResolver.getDB();
        actionResolver.createTableUsers();
        actionResolver.insertTableUsers("eey", "didac_tonto");
        actionResolver.createTablePuntuaciones("eeyTable");
        actionResolver.insertTablePuntuaciones("eeyTable",1,1000);
        String[] aux = actionResolver.selectTableUser("eey");
        for(int i=0; i<aux.length; ++i) System.out.println(aux[i]);
        mainController.main();
    }

    public static void levelSelectorMenu() {
        levelSelectorController.main();
    }

    public static void settingsMenu() {
        settingsController.main();
    }

    public static void exit() {
        switch (Gdx.app.getType()) {
            case Android:
                Gdx.app.exit();
                break;

            case Desktop:
                application.exit();
                break;
        }
    }

}
