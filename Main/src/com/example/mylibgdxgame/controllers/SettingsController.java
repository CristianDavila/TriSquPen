package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.example.mylibgdxgame.screens.SettingsMenu;

/**
 * Created by Dídac on 26/01/14.
 */
public class SettingsController {

    public static void main() {
        ((Game) Gdx.app.getApplicationListener()).setScreen(new SettingsMenu());

    }

}
