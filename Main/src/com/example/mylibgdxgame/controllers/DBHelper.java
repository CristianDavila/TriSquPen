package com.example.mylibgdxgame.controllers;

import com.example.mylibgdxgame.interfaces.ActionResolver;


public class DBHelper{

        public ActionResolver mNativeFunctions;

        public DBHelper(ActionResolver nativeFunctions) {
            mNativeFunctions = nativeFunctions;
        }
        // Exemplary function call, of course this doesn't make sense in render() ;)
        public void abrirUrl() {
            mNativeFunctions.openURL("http://www.example.com");
        }
}