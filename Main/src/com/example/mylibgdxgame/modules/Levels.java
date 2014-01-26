package com.example.mylibgdxgame.modules;


import com.example.mylibgdxgame.screens.LevelSelectorMenu;

import java.util.ArrayList;

/**
 * Created by Dídac on 26/01/14.
 */
public class Levels {

    static class LevelInstance{
        //Level level;
        String image;

        public LevelInstance(String a) {
            image = a;
        }
    }

    private static ArrayList<LevelInstance> levelsSet;
    private static int current;


    //Constructor
    public Levels() {
        levelsSet = new ArrayList<LevelInstance>();
        current = 0;
    }

    //Sets a new set of levels
    public static void setLevels(String[] image) {
        for (int a = 0; a < image.length; a++) {
            levelsSet.add(a,new LevelInstance(image[a]));
        }
    }

    //Deletes a list of levels
    public void deleteLevels(int[] targetLevels) {

        for(int a = 0; a < targetLevels.length; ++a) {
            levelsSet.remove(targetLevels[a]);
        }

    }

    //Returns whereas there is at least one level or not
    public boolean isEmpty(){
        return levelsSet.isEmpty();
    }

    //Returns the current selected level
    public int getCurrent(){
        return current;
    }

    //Sets the current selected level
    public static void setCurrent(int num) {
        current = num;
    }

    public static void update() {
        if (current != -1) {
            String aux = levelsSet.get(current).image;
            LevelSelectorMenu.setImage(aux);
        }
    }





}
