package com.game.levels;

import com.game.gfx.Sprite;
import com.game.gfx.SpriteSheet;
import com.game.levels.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MappedLevel extends Level{

    public static final int HEAD_PILLAR = 0xff8d9783;
    public static final int BODY_PILLAR = 0xff868c7f;
    public static final int FOOT_PILLAR = 0xff7f8579;

    public static final int  WALL = 0xff0f0fa4;

    // TOP CARPET
    public static final int CARPETTL = 0xffe9b71b;
    public static final int CARPETR = 0xffc6a53c;
    public static final int CARPETM = 0xfff5540f;

    // BODY CARPET

    public static final int BORDERRIGHT =  0xff8e340d;
    public static final int BORDERLEFT = 0xff995538;
    public static final int CARPET = 0xffb29a43;

    // BOTTOM CARPET

    public static final int CARPETBL  = 0xff698143;
    public static final int BORDERBR = 0xff40610e;
    public static final int CARPETB = 0xff394c1b;

    //ITEMS

    //CARPET 1

    public static final int CP1_TL = 0xffffc900;
    public static final int CP1_BL = 0xffdbc05e;
    public static final int CP1_MT = 0xff91b828;
    public static final int CP1_MB = 0xff6e9011;
    public static final int CP1_TR = 0xff11c186;
    public static final int CP1_BR  = 0xff297c60;

    //CARPET 2

    public static final int CP2_TL = 0xffd36911;
    public static final int CP2_BL = 0xff81420d;
    public static final int CP2_MT = 0xffb46727;
    public static final int CP2_MB = 0xff804310;
    public static final int CP2_TR = 0xffa57d5b;
    public static final int CP2_BR = 0xff685749;

    //WOOD

    public static final int WOOD  = 0xff663206;

    //UP CHAIR

    public static final int UP_CHAIR = 0xffb3723b;

    //DOWN CHAIR

    public static final int DOWN_CHAIR0 = 0xff904b0f;
    public static final int DOWN_CHAIR1 = 0xff753a08;

    //LEFT CHAIR
    public static final int LEFT_CHAIR0 = 0xffc26a1e;
    public static final int LEFT_CHAIR1 = 0xffc17a3d;

    //RIGHT CHAIR
    public static final int RIGHT_CHAIR0 = 0xff764011;
    public static final int RIGHT_CHAIR1 = 0xffae6e38;

    //TABLE

    public static final int TL_TABLE = 0xff75451d;
    public static final int TR_TABLE = 0xff894710;
    public static final int BL_TABLE = 0xffad6d38;
    public static final int BR_TABLE = 0xffe4ac7c;


    //LEFT FIRE

    public static final int LEFT_FIRE0 = 0xffe7f932;
    public static final int LEFT_FIRE1 = 0xffcbde13;

    //RIGHT FIRE

    public static final int RIGHT_FIRE0 = 0xffbdca39;
    public static final int RIGHT_FIRE1 = 0xffb8c535;

    //UP FIRE

    public static final int UP_FIRE0 = 0xffcbd843;
    public static final int UP_FIRE1 = 0xffb7c619;

    //ARMOR

    public static final int ARMOR_UP = 0xff7598e8;
    public static final int ARMOR_BOTTOM = 0xff5f85de;

    //BED

    public static final int BED_UP = 0xfff3223c;
    public static final int BED_BOTTOM = 0xff492a2e;

    //DOWNSTAIR

    public static final int DOWNSTAIR_RIGHT0 = 0xff71b3ea;
    public static final int DOWNSTAIR_RIGHT1 = 0xff367bb4;
    public static final int UPSTAIRLEFT = 0xff56115a;


    //BIBILIOTHEQUE

    public static final int BIBLIO_TL = 0xffad3f3f;
    public static final int BIBLIO_TR = 0xff950d0d;
    public static final int BIBLIO_BL = 0xffbc5a5a;
    public static final int BIBLIO_BR = 0xffa56060;

    //BILLIARD

    public static final int BILLIARD_TL = 0xffad3f3f;
    public static final int BILLIARD_BL = 0xff950d0d;
    public static final int BILLIARD_TR  = 0xffbc5a5a;
    public static final int BILLIARD_BR  = 0xffa56060;

    //SWORDS

    public static final int AXE   = 0xff8de9ec;
    public static final int SWORD  = 0xff6d8485;
    public static final int SWORD1 = 0xff2f4040;


    public static final int DOOR0 = 0xffc87a28;
    public static final int DOOR1 = 0xff492a08;


    //BASE SPRITESHEET

    public static final int WATER = 0xff0000ff;
    public static final int WALLB = 0xff0000f0;
    public static final int WALLF = 0xffff0000;
    public static final int PARQUET0 = 0xff1f3400;
    public static final int WALLG = 0xff123400;
    public static final int WALLR =  0xfff90000;
    public static final int PARQUET1 =  0xff179325;
    public static final int WALLO =  0xff1234f8;
    public static final int SEWER  =  0xff123404;;

    private BufferedImage image;

    public MappedLevel(String path){
            super(path);
        }

        public void loadLevel(String path){
            image = null;
            try {
                image = ImageIO.read(getClass().getResource(path));

            } catch (IOException e) {
               System.out.println("Erreur lors du chargement du level: "+path);
            }
            width = image.getWidth();
            height = image.getHeight();
            tiles = new int[width * height];
            image.getRGB(0,0,width,height,tiles,0,width);
        }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
