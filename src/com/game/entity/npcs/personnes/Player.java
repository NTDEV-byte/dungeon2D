package com.game.entity.npcs.personnes;

import com.game.Game;
import com.game.entity.npcs.Mob;
import com.game.entity.projectiles.FuryDefense;
import com.game.gfx.Screen;
import com.game.gfx.Sprite;
import com.game.input.InputHandler;
import com.game.utils.IMGFilter;
import com.game.utils.Vector2f;

import java.awt.event.MouseEvent;
import java.awt.image.ImageFilter;

public class Player extends Mob {

        public static final int FURYDEFENSE_TOTAL = 20;

    private InputHandler input;

    public Player(InputHandler input){
        this.x = 0.0f;
        this.y = 0.0f;
        this.input = input;
        this.sprite = Sprite.MASTER_DOWN0;
    }

    public Player(int x,int y,InputHandler input){
        this.x = x;
        this.y = y;
        this.input = input;
        this.sprite = Sprite.MASTER_DOWN0;
    }

    @Override
    public void update() {
       if(timer < 1000) timer++;else timer = 0;
        xDir = 0; yDir = 0;
        if(input.up){
            yDir--;
        }
        if(input.right){
            xDir++;
        }
        if(input.down){
            yDir++;
        }
        if(input.left){
            xDir--;
        }
        if(xDir != 0 || yDir != 0) {
            move(xDir, yDir);
            moving = true;
        }
        else{
            moving = false;
        }

        updateShoot();
        updateSprite();
        openPortal();

    }

    public void updateShoot(){
        if(input.mButton == MouseEvent.BUTTON1){
              double dx = input.x - Game.getWidthWindow() / 2;
              double dy = input.y - Game.getHeightWindow() / 2;
              double angle = Math.atan2(dy,dx);
              shoot(angle);
        }
        if(input.mButton == MouseEvent.BUTTON3) {
               level.addEntity(new FuryDefense(getX(),getY(),FURYDEFENSE_TOTAL));
        }
    }

    protected void updateSprite(){
        switch (direction){
            case UP:
                sprite = Sprite.MASTER_UP0;
                if(moving){
                    if(timer % RATE_ANIMATION >= 10) {
                        sprite = Sprite.MASTER_UP1;
                    }
                    else {
                        sprite = Sprite.MASTER_UP2;
                    }
                }
                break;
            case RIGHT:
                sprite = Sprite.MASTER_RIGHT0;
                if(moving){
                    if(timer % RATE_ANIMATION >= 10) {
                        sprite = Sprite.MASTER_RIGHT1;
                    }
                    else {
                        sprite = Sprite.MASTER_RIGHT2;
                    }
                }
                break;
            case DOWN:
                sprite = Sprite.MASTER_DOWN0;
                if(moving){
                    if(timer % RATE_ANIMATION >= 10) {
                        sprite = Sprite.MASTER_DOWN1;
                    }
                    else {
                        sprite = Sprite.MASTER_DOWN2;
                    }
                }
                break;
            case LEFT:
                sprite = Sprite.MASTER_LEFT0;
                if(moving){
                    if(timer % RATE_ANIMATION >= 10) {
                        sprite = Sprite.MASTER_LEFT1;
                    }
                    else {
                        sprite = Sprite.MASTER_LEFT2;
                    }
                }
                break;
        }
    }

    public void render(Screen screen){
        screen.renderMob(this, getX() - 16 , getY() - 16);
    }



}

