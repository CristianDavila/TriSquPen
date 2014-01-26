package com.example.mylibgdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.example.mylibgdxgame.controllers.LevelSelectorController;

/**
 * Created by Dídac on 19/01/14.
 */
public class LevelSelectorMenu implements Screen {

    private Skin skin;
    private Stage stage;
    private Table table;
    private static Label number;
    private static List list;
    private ScrollPane scrollPane;
    private TextButton play, back;

    private void initializeComponents() {

        stage = new Stage();
        Gdx.input.setInputProcessor(stage); // needed for user input handling

        // atlas is the texture of the buttons, selections, scrolls...
        skin = new Skin( Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/atlas.pack") ); //contains all the styles(fonts, colours, alignment) of the User Interface components

        table = new Table(skin); //used to align the components on the screen
        table.debug(); // we enable the debug lines

        number = new Label("",skin); // label which represents the level currently selected

        list = new List( new String[] { "one", "two", "three" }, skin ); // the list of levels displayed in the scrollPane
        list.setSelectable(true);
        list.setSelectedIndex(-1);

        scrollPane = new ScrollPane(list,skin);
        play = new TextButton("SELECT",skin);
        back = new TextButton("BACK",skin);

    }

    private void configTable() {

        table.setFillParent(true);
        table.add("SELECT LEVEL").colspan(3).expandX().pad(30);
        table.row();
        table.add(scrollPane).fillX().padLeft(20).expand();
        table.add(number).colspan(2).expand();
        table.row();
        table.add();
        table.add(back).fillX().top().expandX().pad(10);
        table.add(play).fillX().top().expandX().pad(10);

    }

    private void arrangeTable() {
        table.clear();
        configTable();
    }

    private void configButtons() {

        play.pad(10);

        // When the back button is pressed the execution is terminated
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LevelSelectorController.mainMenuScreen();
            }
        });
        back.pad(10);
    }

    private void configNumber() {
        number.setFontScale(2);
        number.setColor(0.6f, 0.1f, 0.6f, 1);
    }

    private void configList() {
        list.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                LevelSelectorController.applySelection(list.getSelectedIndex());
            }
        });
    }

    @Override
    public void render(float delta) {
        // The color of the screen must be cleared for obvious reasons
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw(); //if the stage is not drown nothing is displayed beside the color we cleared at the beginning
        Table.drawDebug(stage); //being the debug of the table enabled, we now can draw the debug lines

    }

    @Override
    public void resize(int width, int height) {

        stage.setViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        arrangeTable();

    }

    @Override
    public void show() {

        initializeComponents();

        configNumber();
        configButtons();
        configList();

        //configTable() is not called here because the resize method is called when the screen starts, so we call it only in the resize method.
        stage.addActor(table);

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

        stage.dispose();
        skin.getAtlas().dispose();
        skin.dispose();

    }

    public static void setImage(String image) {
        number.setText(image);
    }

}
