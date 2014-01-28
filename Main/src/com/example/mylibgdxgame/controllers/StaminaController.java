package com.example.mylibgdxgame.controllers;

/**
 * Created by salamandra on 28/01/14.
 */
public class StaminaController {

    private int stamina; // stamina indicates minutes


    public StaminaController(){
        stamina = 100;
    }

    public void updateStamina(){
        //La idea es recordar la ultima hora de actualizacion de stamina, comprobar la actual
        //y la diferencia sera la stamina ganada
        stamina -= 1;
    }

    public int getStamina(){
        return stamina;
    }

    public boolean canPlay(){
        return stamina != 0;
    }


}
