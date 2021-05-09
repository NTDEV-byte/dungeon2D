package com.game.levels;

import com.game.Game;
import com.game.gfx.Screen;
import com.game.levels.tiles.Tile;
import com.game.utils.IMGFilter;

public class LightZone {

        public static final float LUMENS_INTENSITY = 5.0f;

        private Tile tile;
        private int x,y;
        private Level level = Game.level;


                public LightZone(int x,int y){
                        this.x = x;
                        this.y = y;
                        this.tile = level.getBlockUsingColor(x , y);
                        if(tile == null){
                            System.err.println("Error while getting the tile at : x "+x + " y: "+y);
                        }
                }

                public void increaseLight(Screen screen){
                    float li = level.getLightIntensity();
                    for(int yy=-10;yy<10;yy++){
                        for(int xx=-10;xx<10;xx++){
                            int xTile = x  + xx ;
                            int yTile = y  + yy ;
                            Tile tile = level.getBlockUsingColor(xTile , yTile);
                            double dx = xx;
                            double dy = yy;
                            // on calcule la distance par rapport au centre (x,y)
                            double r =  Math.sqrt(dx * dx + dy * dy);

                            double intensity = li / r  * LUMENS_INTENSITY;
                            screen.renderLightSourceTile(xTile << 4,yTile << 4,tile,0xffff00ff,60 , 60  , 60 , intensity);

                        }
                    }
                }


}
