package com.game.entity.particals;

import com.game.entity.Entity;
import com.game.gfx.Screen;
import com.game.gfx.Sprite;

import java.util.Random;

public class Partical extends Entity {

    public static final int MAX_DURATION = 10;
    public static final int LIFE_CYCLE = 35;
    protected Sprite sprite;
    protected int time;
    protected int life;

        public Partical(float x,float y,int life){
                this.x = x;
                this.y = y;
                this.sprite = Sprite.PARTICAL;
                this.random = new Random();
                this.xDir = (float)random.nextGaussian();
                this.yDir = (float)random.nextGaussian();
                this.life = life + random.nextInt(MAX_DURATION);
        }


    public Partical(float x,float y,int life,boolean randColorOnce){
        this.x = x;
        this.y = y;
        this.random = new Random();
        this.sprite = (randColorOnce) ? Sprite.RAND_PARTICAL : new Sprite(2,random.nextInt(0xffffff));
        this.xDir = (float)random.nextGaussian();
        this.yDir = (float)random.nextGaussian();
        this.life = life + random.nextInt(MAX_DURATION);
    }


    @Override
    public void update(){
     if(timer < 7500) timer++; else timer = 0;
        if(timer % LIFE_CYCLE == 0){
         life--;
         if(life <= 0){
             remove();
            }
        }
        x+=xDir;
        y+=yDir;
    }

    @Override
    public void render(Screen screen) {
        screen.renderPartical(this,(int)x,(int)y);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }


}
