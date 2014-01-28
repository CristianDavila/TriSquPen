package com.example.mylibgdxgame.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.example.mylibgdxgame.controllers.FrontController;
import com.example.mylibgdxgame.controllers.MainController;
import com.example.mylibgdxgame.tween.SpriteAccessor;

/**
 * Created by Dídac on 19/01/14.
 */
public class Splash implements Screen {
    private SpriteBatch batch;
    private Sprite splash;
    private TweenManager tweenManager;

    private void initializeComponents() {

        batch = new SpriteBatch(); // the "canvas"

        splash = new Sprite( new Texture("img/splash.png") ); // what we want to paint in the canvas
        //we could define a private splashTexture, but just putting it in the sprite init is more efficient
        splash.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()); // the splash should be the size of the screen

        tweenManager = new TweenManager(); // The controller of the animations
        Tween.registerAccessor(Sprite.class,new SpriteAccessor()); // we must register which specific accessor handles the class to control

    }

    private void tweenAnimations() {
        //the splash comes in and disappears gradually
        Tween.set(splash, SpriteAccessor.alpha).target(0).start(tweenManager);
        Tween.to(splash,SpriteAccessor.alpha,1).target(1).repeatYoyo(1,1).setCallback(new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                FrontController.mainMenu();
            }
        }).start(tweenManager);

    }

    @Override
    public void render(float delta) {
        // The color of the screen must be cleared for obvious reasons
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //to paint in the batch we have to open it, and then the object paints itself on it
        batch.begin();
        splash.draw(batch);
        batch.end();

        tweenManager.update(delta);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

        initializeComponents();
        tweenAnimations();

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

        batch.dispose();
        splash.getTexture().dispose();

    }
}
