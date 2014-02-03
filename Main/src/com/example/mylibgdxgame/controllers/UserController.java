package com.example.mylibgdxgame.controllers;

import com.example.mylibgdxgame.interfaces.ActionResolver;

/**
 * Created by salamandra on 3/02/14.
 */
public class UserController {

    public static String user = "";
    public static String pass = "";
    public static String userTablaPuntuation = "";

    private static ActionResolver actionResolver;

    public UserController(ActionResolver new_ActionResolver) {
        actionResolver = new_ActionResolver;
    }

    public boolean initSesion(String new_user, String new_pass){
        String[] userData = actionResolver.selectTableUser(new_user);
        if(userData[0] != "null" && userData[1] == new_pass){
            user = userData[0];
            pass = userData[1];
            userTablaPuntuation = userData[2];
            return true;
        }
        else{
            return false;
        }
    }



}
