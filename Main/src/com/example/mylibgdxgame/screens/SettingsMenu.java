package com.example.mylibgdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Dídac on 25/01/14.
 */
public class SettingsMenu implements Screen {

    private Stage stage;
    private Skin skin;
    private Sprite sprite;
    private Label heading;
    private SpriteBatch batch;
    private Table table;
    private TextField textField;
    private CheckBox checkBox;

    private void configTable() {

        table.setFillParent(true);
        table.add(heading);
        table.row();
        table.add(checkBox);
        //table.add(textField);

        stage.addActor(table);

    }

    private void arrangeTable() {

        table.clear();
        configTable();

    }

    private void initializeComponents() {

        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/atlas.pack"));

        stage = new Stage();

        heading = new Label("settings", skin);

        table = new Table();
        table.debug();

        checkBox = new CheckBox("vSync", skin);
        checkBox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                checkBox.setChecked(true);
            }
        });

        textField = new TextField("set Directory", skin);


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(Gdx.gl20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

        Table.drawDebug(stage);

    }

    @Override
    public void resize(int width, int height) {

        stage.setViewport(width,height);
        arrangeTable();

    }

    @Override
    public void show() {

        initializeComponents();

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
