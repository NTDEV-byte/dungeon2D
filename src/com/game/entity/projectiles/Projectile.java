package com.game.entity.projectiles;

import com.game.Game;
import com.game.effects.Effect;
import com.game.effects.Explosion;
import com.game.entity.Entity;
import com.game.gfx.Screen;
import com.game.gfx.Sprite;
import com.game.utils.Generator;

public class Projectile extends Entity {


    protected float xOrigin,yOrigin;
    protected double angle;
    protected float speed,range,damage;
    protected Sprite sprite;


        public Projectile(float x,float y,double angle){
                this.x = x;
                this.y = y;
                this.xOrigin = x;
                this.yOrigin = y;
                this.speed = 3;
                this.sprite = Sprite.PROJECTILE;
                this.xDir = (float)(Math.cos(angle) * speed);
                this.yDir = (float)(Math.sin(angle) * speed);
                this.angle = angle;
        }

        public Projectile(float x,float y){
            this.x = x;
            this.y = y;
            this.xOrigin = x;
            this.yOrigin = y;
        }
    @Override
    public void update() {
            if(level.collision((int)(x + xDir) , (int)(y+yDir))){
                remove();
                level.addEntity(new Effect( Effect.EXPLOSION ,(int) ((x - 20) + xDir - 20) , (int) ((y - 20) + yDir) , 96 , 96 , 0xffaf6b26));
               // Generator.generateParticals(20,(int)x,(int)y, Game.level,false);
            }
            else{
                x+=xDir;
                y+=yDir;
            }
            if(getDistanceTraveled() >= range){
                remove();
                Generator.generateParticals(10,(int)x,(int)y, Game.level);
            }
    }

    protected double getDistanceTraveled(){
            double dx = x - xOrigin;
            double dy = y - yOrigin;
            return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void render(Screen screen) {
        screen.renderProjectile(this,(int)x,(int)y);
    }

    public float getxOrigin() {
        return xOrigin;
    }

    public void setxOrigin(float xOrigin) {
        this.xOrigin = xOrigin;
    }

    public float getyOrigin() {
        return yOrigin;
    }

    public void setyOrigin(float yOrigin) {
        this.yOrigin = yOrigin;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
