package com.game.entity;

import com.game.Game;
import com.game.entity.npcs.Player;
import com.game.gfx.Screen;
import com.game.levels.Level;
import com.game.utils.Vector2i;

import java.util.Random;

public abstract class Entity {

    protected float x,y;
    protected float xDir,yDir;
    protected boolean dead;
    protected Level level = Game.level;
    protected Player player = Game.player;
    protected Random random;
    protected int timer;



    public abstract void update();
    public abstract void render(Screen screen);

    public void remove(){
        dead = true;
    }

    public int getX() {
        return (int)x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getY() {
        return (int)y;
    }

    public int getCenterX(){
        return getX() - (Game.WIDTH) / 2;
    }

    public int getCenterY(){
        return getY() - (Game.HEIGHT) / 2;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Vector2i getWorldPosition(){
        return new Vector2i(getX() >> 4 , getY() >> 4);
    }


}
