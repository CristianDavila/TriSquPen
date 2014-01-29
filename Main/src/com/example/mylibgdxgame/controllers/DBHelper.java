package com.example.mylibgdxgame.controllers;

import com.badlogic.gdx.Game;


public class DBHelper extends Game/ApplicationListener {
        public ActionResolver mNativeFunctions;

        public MyGame(ActionResolver nativeFunctions) {
            mNativeFunctions = nativeFunctions;
        }
        // Exemplary function call, of course this doesn't make sense in render() ;)
        public void render() {
            mNativeFunctions.openURL("http://www.example.com");
        }
}