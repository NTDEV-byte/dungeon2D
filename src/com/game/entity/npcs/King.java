package com.game.entity.npcs;

import com.game.gfx.SpriteSheet;
import com.game.gfx.VisualAspect;

public class King extends Mob{

    public King(int x,int y){
        this.x = x;
        this.y = y;
        this.vAspect = new VisualAspect(SpriteSheet.King);
        this.sprite = vAspect.getSprite();
    }

    public void update(){
        super.moveRandomlly();
    }
}
