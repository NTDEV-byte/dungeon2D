package com.game.levels.tiles;

import com.game.gfx.Screen;
import com.game.gfx.Sprite;
import com.game.gfx.SpriteSheet;

public class Tile {

    public static final Tile HEAD_PILLAR = new Wall(Sprite.HEAD_PILLAR);
    public static final Tile BODY_PILLAR = new Wall(Sprite.BODY_PILLAR);
    public static final Tile FOOT_PILLAR = new Wall(Sprite.FOOT_PILLAR);

    public static final Tile  WALL = new Wall(Sprite.WALL);

    // TOP CARPET
    public static final Tile CARPETTL = new Tile(Sprite.CARPETTL);
    public static final Tile CARPETR = new Tile(Sprite.CARPETR);
    public static final Tile CARPETM = new Tile(Sprite.CARPETM);

    // BODY CARPET

    public static final Tile BORDERRIGHT = new Tile(Sprite.BORDERRIGHT);
    public static final Tile BORDERLEFT = new Tile(Sprite.BORDERLEFT);
    public static final Tile CARPET = new Tile(Sprite.CARPET);

    // BOTTOM CARPET

    public static final Tile CARPETBL  =  new Tile(Sprite.CARPETBL);
    public static final Tile BORDERBR = new Tile(Sprite.BORDERBR);
    public static final Tile CARPETB = new Tile(Sprite.CARPETB);


    //ITEMS


    //CARPET 1

    public static final Tile CP1_TL =  new Tile(Sprite.CP1_TL);
    public static final Tile CP1_BL =  new Tile(Sprite.CP1_BL);
    public static final Tile CP1_MT = new Tile(Sprite.CP1_MT);
    public static final Tile CP1_MB =  new Tile(Sprite.CP1_MB);
    public static final Tile CP1_TR =  new Tile(Sprite.CP1_TR);
    public static final Tile CP1_BR  =  new Tile(Sprite.CP1_BR);


    //CARPET 2

    public static final Tile CP2_TL  =  new Tile(Sprite.CP2_TL);
    public static final Tile CP2_BL =  new Tile(Sprite.CP2_BL);
    public static final Tile CP2_MT =  new Tile(Sprite.CP2_MT);
    public static final Tile CP2_MB =  new Tile(Sprite.CP2_MB);
    public static final Tile CP2_TR =  new Tile(Sprite.CP2_TR);
    public static final Tile CP2_BR =  new Tile(Sprite.CP2_BR);


    //WOOD

    public static final Tile WOOD  =  new Tile(Sprite.WOOD);

    //UP CHAIR

    public static final Tile UP_CHAIR =  new Tile(Sprite.UP_CHAIR);
    //DOWN CHAIR

    public static final Tile DOWN_CHAIR0=  new Tile(Sprite.DOWN_CHAIR0);
    public static final Tile DOWN_CHAIR1 =  new Tile(Sprite.DOWN_CHAIR1);

    //LEFT CHAIR
    public static final Tile LEFT_CHAIR0 =  new Tile(Sprite.LEFT_CHAIR0);
    public static final Tile LEFT_CHAIR1=  new Tile(Sprite.LEFT_CHAIR1);

    //RIGHT CHAIR
    public static final Tile RIGHT_CHAIR0 =  new Tile(Sprite.RIGHT_CHAIR0);
    public static final Tile RIGHT_CHAIR1 =  new Tile(Sprite.RIGHT_CHAIR1);

    //TABLE

    public static final Tile TL_TABLE =  new Tile(Sprite.TL_TABLE);
    public static final Tile TR_TABLE =  new Tile(Sprite.TR_TABLE);
    public static final Tile BL_TABLE =  new Tile(Sprite.BL_TABLE);
    public static final Tile BR_TABLE =  new Tile(Sprite.BR_TABLE);


    //LEFT FIRE

    public static final Tile LEFT_FIRE0 =  new Tile(Sprite.LEFT_FIRE0);
    public static final Tile LEFT_FIRE1 =  new Tile(Sprite.LEFT_FIRE1);

    //RIGHT FIRE

    public static final Tile RIGHT_FIRE0 =  new Tile(Sprite.RIGHT_FIRE0);
    public static final Tile RIGHT_FIRE1 =  new Tile(Sprite.RIGHT_FIRE1);

    //UP FIRE

    public static final Tile UP_FIRE0 =  new Tile(Sprite.UP_FIRE0);
    public static final Tile UP_FIRE1 =  new Tile(Sprite.UP_FIRE1);

    //ARMOR

    public static final Tile ARMOR_UP =  new Tile(Sprite.ARMOR_UP);
    public static final Tile ARMOR_BOTTOM =  new Tile(Sprite.ARMOR_BOTTOM);

    //BED

    public static final Tile BED_UP=  new Tile(Sprite.BED_UP);
    public static final Tile BED_BOTTOM =  new Tile(Sprite.BED_BOTTOM);

    //DOWNSTAIR

    public static final Tile DOWNSTAIR_UP =  new Tile(Sprite.DOWNSTAIR_UP);
    public static final Tile DOWNSTAIR_BOTTOM =  new Tile(Sprite.DOWNSTAIR_BOTTOM);
    public static final Tile UPSTAIRUP=  new Tile(Sprite.UPSTAIRUP);

    //UPSTAIR



    //BIBILIOTHEQUE

    public static final Tile BIBLIO_TL =  new Tile(Sprite.BIBLIO_TL);
    public static final Tile BIBLIO_TR =  new Tile(Sprite.BIBLIO_TR);
    public static final Tile BIBLIO_BL =  new Tile(Sprite.BIBLIO_BL);
    public static final Tile BIBLIO_BR =  new Tile(Sprite.BIBLIO_BR);

    //BILLIARD

    public static final Tile BILLIARD_TL =  new Tile(Sprite.BILLIARD_TL);
    public static final Tile BILLIARD_BL =  new Tile(Sprite.BILLIARD_BL);
    public static final Tile BILLIARD_TR  =  new Tile(Sprite.BILLIARD_TR);
    public static final Tile BILLIARD_BR =  new Tile(Sprite.BILLIARD_BR);

    //SWORDS

    public static final Tile AXE   =  new Tile(Sprite.AXE);
    public static final Tile SWORD =  new Tile(Sprite.SWORD);
    public static final Tile SWORD1  =  new Tile(Sprite.SWORD1);

    public static final Tile DOOR0 =  new Tile(Sprite.DOOR0);
    public static final Tile DOOR1 =  new Tile(Sprite.DOOR1);


    //BASE



    public static final Tile WATER   =  new Tile(Sprite.WATER);
    public static final Tile WALLB =  new Wall(Sprite.WALLB);
    public static final Tile WALLF  =  new Wall(Sprite.WALLF);


    public static final Tile PARQUET0   =  new Tile(Sprite.PARQUET0);
    public static final Tile WALLG =  new Wall(Sprite.WALLG);
    public static final Tile WALLR  =  new Wall(Sprite.WALLR);


    public static final Tile PARQUET1   =  new Tile(Sprite.PARQUET1);
    public static final Tile WALLO =  new Wall(Sprite.WALLO);
    public static final Tile SEWER  =  new Tile(Sprite.SEWER);


    	protected boolean solid;
        protected Sprite sprite;

                public Tile(Sprite sprite){
                     this.sprite = sprite;
                }

                public void render(int xa,int ya,Screen screen){
                    screen.renderTile(xa << 4,ya << 4,this);
                }


        public Sprite getSprite() {
             return sprite;
        }

        public boolean isSolid() {
             return false;
         }

}
