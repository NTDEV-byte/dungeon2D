package com.game.entity.npcs;

import com.game.entity.Entity;
import com.game.entity.projectiles.MasterProjectile;
import com.game.entity.projectiles.Projectile;
import com.game.gfx.Screen;
import com.game.gfx.Sprite;

public abstract class Mob extends Entity {

        public static final int UP = 0;
        public static final int RIGHT = 1;
        public static final int DOWN = 2;
        public static final int LEFT = 3;
        public static final int RATE_ANIMATION = 30;

        protected Sprite sprite;
        protected int direction;
        protected int xDir,yDir;
        protected boolean moving;


    public void shoot(double angle){
         level.addEntity(new MasterProjectile(x,y,angle));
     }

    public void move(int xDir, int yDir){
            if(xDir < 0){
                direction = LEFT;
            }
            if(xDir > 0){
                direction = RIGHT;
            }
            if(yDir < 0){
                direction = UP;
            }
            if(yDir > 0){
                direction = DOWN;
            }
            if(!collision(xDir,yDir)){
                 x+=xDir;
                 y+=yDir;
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

        public boolean collision(int xa,int ya){
            return false;
        }


    @Override
    public void render(Screen screen) {
        screen.renderMob(this,(int)(x - 16),(int)(y - 16));
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }



}
