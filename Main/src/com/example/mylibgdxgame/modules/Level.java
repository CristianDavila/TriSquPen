package com.example.mylibgdxgame.modules;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.example.mylibgdxgame.screens.LevelScreen;

/**
 * Created by Dídac on 27/01/14.
 */
public class Level {

    private static TiledMap map;

    public Level() {

    }

    public static void setMap(TiledMap newMap) {
        map = newMap;
        LevelScreen.setMap(map);
    }



}
