package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.example.mylibgdxgame.modules.Level;
import com.example.mylibgdxgame.modules.Levels;
import com.example.mylibgdxgame.screens.LevelScreen;
import com.example.mylibgdxgame.screens.LevelSelectorMenu;
import com.example.mylibgdxgame.screens.MainMenu;

import java.util.ArrayList;


/**
 * Created by Dídac on 26/01/14.
 */
public class LevelSelectorController {
    private static TmxMapLoader loader;
    private static ArrayList<Level> levelsSet;

    private static FrontController frontController;

    private static LevelScreen levelScreen;
    private static LevelSelectorMenu levelSelectorMenu;

    public LevelSelectorController(FrontController controller) {
        frontController = controller;
        levelScreen = new LevelScreen();
        levelSelectorMenu = new LevelSelectorMenu();

        loader = new TmxMapLoader();
        levelsSet = new ArrayList<Level>();
    }

    public static void main() {
        String[] image = new String[] {"1", "2", "3"};
        TiledMap map = loader.load("maps/firstlvl.tmx");

        Level level1 = new Level();
        level1.setMap(map);

        levelsSet.add(0,level1);

        new Levels();
        Levels.setLevels(image,levelsSet);

        ((Game) Gdx.app.getApplicationListener()).setScreen(levelSelectorMenu);

    }

    public static void mainMenuScreen() {
        frontController.mainMenu();
    }

    public static void levelScreen() {
        //int current = Levels.getCurrent();
        ((Game) Gdx.app.getApplicationListener()).setScreen(levelScreen);
    }

    public static void applySelection(int num){
        Levels.setCurrent(num);
        Levels.update();
    }

}
