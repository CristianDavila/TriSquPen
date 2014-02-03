package com.example.mylibgdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.example.mylibgdxgame.controllers.FrontController;
import com.example.mylibgdxgame.interfaces.ActionResolver;
import com.example.mylibgdxgame.screens.Splash;


/**
 * Created by Dídac on 18/01/14.
 */

public class MyLibgdxGame extends Game {

    private ActionResolver actionResolver;

    public static String title = "TriSquPen", version = "0.0.0.1";

    public MyLibgdxGame(ActionResolver actionResolver) {
        this.actionResolver = actionResolver;
    }

    @Override
    public void create() {
        switch (Gdx.app.getType()) {
            case Android:
                new FrontController(actionResolver);
                break;
        }

        setScreen(new Splash());
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width,height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

}
