package com.game.levels;

import com.game.gfx.Sprite;
import com.game.gfx.SpriteSheet;

import java.util.Random;

public class DiceLevel extends Level{


    public static final int HEAD_PILLAR = 0;
    public static final int BODY_PILLAR = 1;
    public static final int FOOT_PILLAR = 3;

    public static final int  WALL = 4;

    // TOP CARPET
    public static final int CARPETTL = 5;
    public static final int CARPETR = 6;
    public static final int CARPETM = 7;

    // BODY CARPET

    public static final int BORDERRIGHT =  8;
    public static final int BORDERLEFT = 9;
    public static final int CARPET = 10;

    // BOTTOM CARPET

    public static final int CARPETBL  = 11;
    public static final int BORDERBR = 12;
    public static final int CARPETB = 13;

    public static final int TOTAL = 14;

    private static Random random = new Random();


    public DiceLevel(int width, int height){
             super(width,height);
        }

        public void generateLevel() {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    tiles[x + y * width] = random.nextInt(TOTAL);
                }
            }
        }

}
