package com.example.mylibgdxgame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.example.mylibgdxgame.MyLibgdxGame;
import com.example.mylibgdxgame.controllers.SettingsController;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by Dídac on 25/01/14.
 */
public class SettingsMenu implements Screen {

    private Stage stage;
    private Skin skin;
    private Label heading;
    private Table table;
    private TextField levelDir;
    private CheckBox vSync, fullScreen;
    private TextButton backButton;
    private SpriteBatch batch;
    private Sprite background;
    private Texture texture;
    private int width, height;


    private void configTable() {

        table.setFillParent(true);
        table.add(heading);
        table.row();
        table.add(vSync);
        table.add(levelDir).fillX();
        table.row();
        table.add(fullScreen);
        table.row();
        table.add(backButton).colspan(2).right();

        stage.addActor(table);

    }

    private void arrangeTable() {

        table.clear();
        configTable();

    }

    private void initializeComponents() {

        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/atlas.pack"));

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        heading = new Label("settings", skin);

        table = new Table(skin);
        table.debug();

        texture = new Texture("img/settingsBackground.jpg");

        background = new Sprite(texture);
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        vSync = new CheckBox("vSync", skin);
        vSync.setChecked(vSync());

        fullScreen = new CheckBox("Full Screen",skin);
        fullScreen.setChecked(Gdx.graphics.isFullscreen());

        levelDir = new TextField(levelDirectory().path(), skin); // creating a new TextField with the current level directory already written in it
        levelDir.setMessageText("level directory"); // set the text to be shown when nothing is in the TextField

        backButton = new TextButton("back",skin);
        backButton.pad(15);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(Gdx.gl20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        batch.end();

        stage.act(delta);
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

        ClickListener buttonHandler = new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                // event.getListenerActor() returns the source of the event, e.g. a button that was clicked
                if(event.getListenerActor() == vSync) {
                    // save vSync
                    Gdx.app.getPreferences(MyLibgdxGame.title).putBoolean("vsync", vSync.isChecked());

                    // set vSync
                    Gdx.graphics.setVSync(vSync.isChecked());

                    Gdx.app.log(MyLibgdxGame.title, "vSync " + (vSync() ? "enabled" : "disabled"));
                }

                else if(event.getListenerActor() == fullScreen) {

                    Gdx.app.getPreferences(MyLibgdxGame.title).putBoolean("fullScreen",fullScreen.isChecked());

                    if(fullScreen.isChecked()) {
                        width = Gdx.graphics.getWidth();
                        height = Gdx.graphics.getHeight();
                        Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width,Gdx.graphics.getDesktopDisplayMode().height,true);
                    }
                    else {
                        Gdx.graphics.setDisplayMode(width,height,false);
                    }

                    Gdx.app.log(MyLibgdxGame.title, "fullScreen " + (Gdx.graphics.isFullscreen() ? "enabled" : "disabled"));
                }

                else if(event.getListenerActor() == backButton) {
                // save level directory
                    String actualLevelDirectory = levelDir.getText().trim().equals("") ? Gdx.files.getExternalStoragePath() + MyLibgdxGame.title + "/levels" : levelDir.getText().trim();
                    // shortened form of an if-statement: [boolean] ? [if true] : [else] // String#trim() removes spaces on both sides of the string
                    Gdx.app.getPreferences(MyLibgdxGame.title).putString("leveldirectory", actualLevelDirectory);

                // save the settings to preferences file (Preferences#flush() writes the preferences in memory to the file)
                    Gdx.app.getPreferences(MyLibgdxGame.title).flush();

                    Gdx.app.log(MyLibgdxGame.title, "settings saved");

                    //stage.addAction(sequence(moveTo(0, stage.getHeight(), .5f), run(new Runnable() {

                    //    @Override
                    //    public void run() {
                    //        ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
                    //    }
                    //})));

                    SettingsController.mainMenu();
                }
            }
        };

        vSync.addListener(buttonHandler);
        fullScreen.addListener(buttonHandler);
        backButton.addListener(buttonHandler);

        //stage.addAction(sequence(moveTo(0, stage.getHeight()), moveTo(0, 0, .25f))); // coming in from top animation

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

    }


    public static FileHandle levelDirectory() {
        String prefsDir = Gdx.app.getPreferences(MyLibgdxGame.title).getString("leveldirectory").trim();
        if(prefsDir != null && !prefsDir.equals(""))
            return Gdx.files.absolute(prefsDir);
        else
            return Gdx.files.absolute(Gdx.files.external(MyLibgdxGame.title + "/levels").path()); // return default level directory
            //external is from the root of the SD card or the HOME directory
    }

    /** @return if vSync is enabled */
    public static boolean vSync() {
        return Gdx.app.getPreferences(MyLibgdxGame.title).getBoolean("vsync");
    }
}
