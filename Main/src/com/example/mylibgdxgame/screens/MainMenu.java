package com.example.mylibgdxgame.screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.example.mylibgdxgame.MyLibgdxGame;
import com.example.mylibgdxgame.controllers.MainController;
import com.example.mylibgdxgame.tween.ActorAccessor;

/**
 * Created by Dídac on 19/01/14.
 */

public class MainMenu implements Screen {

    private Stage stage;
    private SpriteBatch batch;
    private Sprite background;
    private Skin skin;
    private Table table;
    private TextButton playButton, exitButton, settingsButton;
    private Label heading;
    private TweenManager tweenManager;
    private Music mainTheme;
    private MainController mainController;

    public MainMenu(MainController controller){
        mainController = controller;
    }

    private void initializeComponents() {

        stage = new Stage();
        Gdx.input.setInputProcessor(stage); // needed for user input handling

        // atlas is the texture of the buttons, selections, scrolls...
        skin = new Skin( Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/atlas.pack") ); //contains all the styles(fonts, colours, alignment) of the User Interface components

        table = new Table(skin); //used to align the components on the screen
        table.debug();// we enable the debug lines

        mainTheme = Gdx.audio.newMusic(Gdx.files.internal("audio/mainTheme.mp3"));
        mainTheme.isLooping(); //we make the music repeat itself

        batch = new SpriteBatch(); //the "canvas"

        background = new Sprite(new Texture("img/fondo.png")); //what we want to paint in the canvas
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()); // the background should be the size of the screen

        heading = new Label(MyLibgdxGame.title,skin);

        playButton = new TextButton("Play", skin);

        exitButton = new TextButton("Exit", skin);

        settingsButton = new TextButton("Settings", skin);

        tweenManager = new TweenManager(); // The controller of the animations
        Tween.registerAccessor(Actor.class,new ActorAccessor()); // we must register which specific accessor handles the class to control

    }

    private void configTable() {

        table.setFillParent(true);
        table.add(heading).colspan(2).expand().center();
        table.row().height(Gdx.graphics.getHeight()/9);
        table.add().colspan(2).expandX();
        table.add(playButton).left().expandX().padRight(Gdx.graphics.getHeight()/8).spaceBottom(20).fill();
        table.row().height(Gdx.graphics.getHeight()/9);
        table.add().colspan(2).expandX();
        table.add(settingsButton).left().expandX().padRight(Gdx.graphics.getHeight()/8).spaceBottom(20).fill();
        table.row().height(Gdx.graphics.getHeight()/9);
        table.add().colspan(2).expandX();
        table.add(exitButton).left().expandX().padRight(Gdx.graphics.getHeight()/8).fill();
        table.row().height(Gdx.graphics.getHeight()/9);
        table.add();

        stage.addActor(table);

    }

    private void arrangeTable() {

        table.clear(); //we "erase" the table components
        configTable(); //and configure them with the new graphics size

    }

    private void tweenAnimations() {
        //The title goes from white to purple and purple to white until the end of time
        Timeline.createSequence().beginSequence()
                .push(Tween.to(heading, ActorAccessor.rgb, 1).target(0.6f, 0.1f, 0.6f))
                .end().repeatYoyo(Tween.INFINITY,0).start(tweenManager);

        //Title and buttons go from invisible to visible gradually
        Timeline.createSequence().beginSequence()
                .push(Tween.set(playButton,ActorAccessor.alpha).target(0))
                .push(Tween.set(settingsButton,ActorAccessor.alpha).target(0))
                .push(Tween.set(exitButton,ActorAccessor.alpha).target(0))
                .push(Tween.from(heading, ActorAccessor.alpha, 0.5f).target(0))
                .push(Tween.to(playButton, ActorAccessor.alpha, 0.25f).target(1))
                .push(Tween.to(settingsButton, ActorAccessor.alpha, 0.25f).target(1))
                .push(Tween.to(exitButton, ActorAccessor.alpha, 0.25f).target(1))
                .end().start(tweenManager);

        //The entire table appears falling
        Tween.from(table,ActorAccessor.y,0.5f).target(Gdx.graphics.getHeight()/8).start(tweenManager);

    }

    private void configButtons() {
        //When the play button is pressed the level selector screen is displayed
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainTheme.stop();
                mainController.playScreen();
            }
        });
        playButton.pad(15);//if we didn't pad, the button would be of the same size as the text

        //When the exit button is pressed the execution is terminated
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainController.exit();
            }
        });
        exitButton.pad(15);//if we didn't pad, the button would be of the same size as the text

        //When the settings button is pressed the execution is terminated
        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainTheme.stop();
                mainController.settingsScreen();
            }
        });
        settingsButton.pad(15);

    }

    @Override
    public void render(float delta) {
        // The color of the screen must be cleared for obvious reasons
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //to paint in the batch we have to open it, and then the object paints itself on it
        batch.begin();
        background.draw(batch);
        batch.end();

        tweenManager.update(delta);

        stage.act(delta);
        stage.draw(); //if the stage is not drown nothing is displayed beside the sprite


        Table.drawDebug(stage); //being the debug of the table enabled, we now can draw the debug lines

    }

    @Override
    public void resize(int width, int height) {

        stage.setViewport(width, height, true); //we set the viewport to the new size, the aspect ratio being the same
        arrangeTable();

    }

    @Override
    public void show() {

        initializeComponents();

        configButtons();
        //configTable() is not called here because the resize method is called when the screen starts, so we call it only in the resize method.
        tweenAnimations();

        mainTheme.play();

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
        background.getTexture().dispose();
        skin.getAtlas().dispose();
        stage.dispose();
        skin.dispose();

    }
}
