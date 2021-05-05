package com.game.entity.npcs.personnes;

import com.game.entity.npcs.Mob;
import com.game.gfx.SpriteSheet;
import com.game.gfx.VisualAspect;

public class Girl extends Mob {

        public Girl(int x,int y){
                this.x = x;
                this.y = y;
                this.vAspect = new VisualAspect(SpriteSheet.Girl);
                this.sprite = vAspect.getSprite();
        }


        public void update(){
         super.moveRandomlly();
        }

}
