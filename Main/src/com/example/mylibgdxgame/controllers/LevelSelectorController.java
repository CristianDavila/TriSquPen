package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.example.mylibgdxgame.modules.Levels;
import com.example.mylibgdxgame.screens.LevelSelectorMenu;
import com.example.mylibgdxgame.screens.MainMenu;


/**
 * Created by Dídac on 26/01/14.
 */
public class LevelSelectorController {

    public static void main() {
        String[] aux = new String[] {"1", "2", "3"};

        new Levels();
        Levels.setLevels(aux);

        ((Game) Gdx.app.getApplicationListener()).setScreen(new LevelSelectorMenu());

    }

    public static void mainMenuScreen() {
        ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
    }

    public static void applySelection(int num){
        Levels.setCurrent(num);
        Levels.update();
    }

}
