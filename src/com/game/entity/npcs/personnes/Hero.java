package com.game.entity.npcs.personnes;

import com.game.entity.npcs.Mob;
import com.game.gfx.SpriteSheet;
import com.game.gfx.VisualAspect;

public class Hero extends Mob {

    public Hero(int x,int y){
        this.x = x;
        this.y = y;
        this.vAspect = new VisualAspect(SpriteSheet.Hero);
        this.sprite = vAspect.getSprite();
    }


    public void update(){
        super.moveRandomlly();
    }
}
