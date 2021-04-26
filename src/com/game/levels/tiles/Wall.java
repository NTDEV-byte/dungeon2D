package com.game.levels.tiles;

import com.game.gfx.Sprite;

public class Wall extends Tile{


        public Wall(Sprite sprite){
            super(sprite);
        }


        public boolean isSolid(){return true;}
}
