package com.game.entity.projectiles;

public class MasterProjectile extends Projectile{

        public MasterProjectile(float x,float y,double angle){
             super(x,y,angle);
             this.range = 400;
             this.speed = 20;
             this.damage = 100;
        }
}
