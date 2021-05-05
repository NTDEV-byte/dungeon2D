package com.game.entity.npcs.monsters;

import com.game.entity.npcs.Mob;
import com.game.gfx.SpriteSheet;
import com.game.gfx.SpriteSheetModular;
import com.game.gfx.VisualAspect;

public class Lucifer extends Mob {




            public Lucifer(int x,int y){
                 this.x = x << 4;
                 this.y = y << 4;
                 this.vAspect = new VisualAspect(new SpriteSheetModular(
                         new SpriteSheet(0 , 1 , 4 , 1 , 64 , 64 , SpriteSheet.LUCIFER) ,
                         new SpriteSheet(0,2,4,1,64,64,SpriteSheet.LUCIFER),
                         new SpriteSheet(0,0,4,1,64,64,SpriteSheet.LUCIFER),
                         new SpriteSheet(0,3,4,1,64,64,SpriteSheet.LUCIFER)));
                 this.sprite = vAspect.getSprite();
            }








}
