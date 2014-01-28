package com.example.mylibgdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.openal.Mp3;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Dídac on 27/01/14.
 */
public class LevelScreen implements Screen {

    private OrthogonalTiledMapRenderer renderer;
    private static TiledMap map;
    private OrthographicCamera camera;
    private static int mapWidth, mapHeight;
    private SpriteBatch batch;
    private Sprite background;
    private Texture texture;
    private Music music;

    @Override
    public void render(float delta) {
        // The color of the screen must be cleared for obvious reasons
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        batch.end();

        renderer.setView(camera);
        renderer.render();

    }

    @Override
    public void resize(int width, int height) {
        camera.update();

    }

    @Override
    public void show() {

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        camera.viewportWidth = mapWidth;
        camera.viewportHeight = mapHeight;
        camera.position.set(mapWidth/2,mapHeight/2,0);

        batch = new SpriteBatch();

        texture = new Texture("maps/bglvl1.jpg");
        background = new Sprite(texture);
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        music = Gdx.audio.newMusic(Gdx.files.internal("audio/chozo.mp3"));
        music.play();
        music.isLooping();

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
        map.dispose();
        renderer.dispose();

    }

    public static void setMap(TiledMap newMap) {
        map = newMap;

        mapWidth = map.getProperties().get("width",Integer.class) * map.getProperties().get("tilewidth",Integer.class);
        mapHeight = map.getProperties().get("height",Integer.class) * map.getProperties().get("tileheight",Integer.class);
    }
}
