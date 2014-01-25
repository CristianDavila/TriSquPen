package com.example.mylibgdxgame.tween;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Dídac on 20/01/14.
 */
public class ActorAccessor implements TweenAccessor<Actor> {

    public static final int x = 0, y = 1, rgb = 2, alpha = 3;

    @Override
    public int getValues(Actor target, int tweenType, float[] returnValues) {

        switch (tweenType){

            case x:
                returnValues[0] = target.getX();
                return 1;

            case y:
                returnValues[0] = target.getY();
                return 1;

            case rgb:
                returnValues[0] = target.getColor().r;
                returnValues[1] = target.getColor().g;
                returnValues[2] = target.getColor().b;
                return 3;

            case alpha:
                returnValues[0] = target.getColor().a;
                return 1;

            default:
                assert false;
                return -1;

        }

    }

    @Override
    public void setValues(Actor target, int tweenType, float[] newValues) {

        switch (tweenType){

            case x:
                target.setX(newValues[0]);
                break;

            case y:
                target.setY(newValues[0]);
                break;

            case rgb:
                target.setColor(newValues[0],newValues[1],newValues[2],target.getColor().a);
                break;

            case alpha:
                target.setColor(target.getColor().r,target.getColor().g,target.getColor().b,newValues[0]);
                break;

            default:
                assert false;

        }

    }

}
