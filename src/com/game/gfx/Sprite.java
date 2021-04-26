package com.game.gfx;

public class Sprite {

        // TODO: 23/04/2021 create Sprites

        public static final int TILE_SIZE = 16;

        // TILESET
        public static final Sprite HEAD_PILLAR = new Sprite(0,0,16,16,SpriteSheet.Tiles);
        public static final Sprite BODY_PILLAR = new Sprite(0,1,16,16,SpriteSheet.Tiles);
        public static final Sprite FOOT_PILLAR = new Sprite(0,2,16,16,SpriteSheet.Tiles);

        public static final Sprite  WALL =  new Sprite(1,0,16,16,SpriteSheet.Tiles);

        // TOP CARPET
        public static final Sprite CARPETTL = new Sprite(3,0,16,16,SpriteSheet.Tiles);
        public static final Sprite CARPETR = new Sprite(6,0,16,16,SpriteSheet.Tiles);
        public static final Sprite CARPETM = new Sprite(4,0,16,16,SpriteSheet.Tiles);

        // BODY CARPET

        public static final Sprite BORDERRIGHT   = new Sprite(3,1,16,16,SpriteSheet.Tiles);;
        public static final Sprite BORDERLEFT  = new Sprite(6,1,16,16,SpriteSheet.Tiles);
        public static final Sprite CARPET = new Sprite(4,1,16,16,SpriteSheet.Tiles);

        // BOTTOM CARPET

        public static final Sprite CARPETBL  = new Sprite(3,3,16,16,SpriteSheet.Tiles);;
        public static final Sprite BORDERBR = new Sprite(6,3,16,16,SpriteSheet.Tiles);
        public static final Sprite CARPETB = new Sprite(4,3,16,16,SpriteSheet.Tiles);


        //ITEMS


        //CARPET 1

        public static final Sprite CP1_TL = new Sprite(0,0,16,16,SpriteSheet.Items);
        public static final Sprite CP1_BL = new Sprite(0,1,16,16,SpriteSheet.Items);
        public static final Sprite CP1_MT = new Sprite(1,0,16,16,SpriteSheet.Items);
        public static final Sprite CP1_MB = new Sprite(1,1,16,16,SpriteSheet.Items);
        public static final Sprite CP1_TR = new Sprite(2,0,16,16,SpriteSheet.Items);
        public static final Sprite CP1_BR  = new Sprite(2,1,16,16,SpriteSheet.Items);


        //CARPET 2

        public static final Sprite CP2_TL = new Sprite(3,0,16,16,SpriteSheet.Items);
        public static final Sprite CP2_BL = new Sprite(3,1,16,16,SpriteSheet.Items);
        public static final Sprite CP2_MT = new Sprite(4,0,16,16,SpriteSheet.Items);
        public static final Sprite CP2_MB = new Sprite(4,1,16,16,SpriteSheet.Items);
        public static final Sprite CP2_TR = new Sprite(5,0,16,16,SpriteSheet.Items);
        public static final Sprite CP2_BR = new Sprite(5,1,16,16,SpriteSheet.Items);


        //WOOD

        public static final Sprite WOOD  = new Sprite(6,0,16,16,SpriteSheet.Items);;

        //UP CHAIR

        public static final Sprite UP_CHAIR = new Sprite(0,3,16,16,SpriteSheet.Items);;

        //DOWN CHAIR

        public static final Sprite DOWN_CHAIR0 = new Sprite(1,2,16,16,SpriteSheet.Items);;
        public static final Sprite DOWN_CHAIR1 = new Sprite(1,3,16,16,SpriteSheet.Items);;

        //LEFT CHAIR
        public static final Sprite LEFT_CHAIR0 = new Sprite(2,2,16,16,SpriteSheet.Items);
        public static final Sprite LEFT_CHAIR1 = new Sprite(2,3,16,16,SpriteSheet.Items);

        //RIGHT CHAIR
        public static final Sprite RIGHT_CHAIR0 = new Sprite(3,2,16,16,SpriteSheet.Items);
        public static final Sprite RIGHT_CHAIR1 = new Sprite(3,3,16,16,SpriteSheet.Items);

        //TABLE

        public static final Sprite TL_TABLE = new Sprite(4,2,16,16,SpriteSheet.Items);
        public static final Sprite TR_TABLE = new Sprite(5,2,16,16,SpriteSheet.Items);
        public static final Sprite BL_TABLE = new Sprite(4,3,16,16,SpriteSheet.Items);
        public static final Sprite BR_TABLE = new Sprite(5,3,16,16,SpriteSheet.Items);


        //LEFT FIRE

        public static final Sprite LEFT_FIRE0 = new Sprite(6,1,16,16,SpriteSheet.Items);
        public static final Sprite LEFT_FIRE1 = new Sprite(6,2,16,16,SpriteSheet.Items);

        //RIGHT FIRE

        public static final Sprite RIGHT_FIRE0 = new Sprite(6,3,16,16,SpriteSheet.Items);
        public static final Sprite RIGHT_FIRE1 = new Sprite(6,4,16,16,SpriteSheet.Items);

        //UP FIRE

        public static final Sprite UP_FIRE0 = new Sprite(6,5,16,16,SpriteSheet.Items);
        public static final Sprite UP_FIRE1 = new Sprite(6,6,16,16,SpriteSheet.Items);

        //ARMOR

         public static final Sprite ARMOR_UP = new Sprite(3,4,16,16,SpriteSheet.Items);
         public static final Sprite ARMOR_BOTTOM = new Sprite(3,5,16,16,SpriteSheet.Items);

        //BED

        public static final Sprite BED_UP = new Sprite(4,4,16,16,SpriteSheet.Items);
        public static final Sprite BED_BOTTOM = new Sprite(4,5,16,16,SpriteSheet.Items);

        //DOWNSTAIR

        public static final Sprite DOWNSTAIR_UP = new Sprite(5,4,16,16,SpriteSheet.Items);
        public static final Sprite DOWNSTAIR_BOTTOM = new Sprite(5,5,16,16,SpriteSheet.Items);

        //UPSTAIR

        public static final Sprite UPSTAIRUP = new Sprite(5,6,16,16,SpriteSheet.Items);

        //BIBILIOTHEQUE

        public static final Sprite BIBLIO_TL = new Sprite(3,6,16,16,SpriteSheet.Items);
        public static final Sprite BIBLIO_TR = new Sprite(4,6,16,16,SpriteSheet.Items);
        public static final Sprite BIBLIO_BL = new Sprite(3,7,16,16,SpriteSheet.Items);
        public static final Sprite BIBLIO_BR = new Sprite(4,7,16,16,SpriteSheet.Items);

        //BILLIARD

        public static final Sprite BILLIARD_TL = new Sprite(5,7,16,16,SpriteSheet.Items);
        public static final Sprite BILLIARD_BL = new Sprite(5,8,16,16,SpriteSheet.Items);
        public static final Sprite BILLIARD_TR  = new Sprite(6,7,16,16,SpriteSheet.Items);
        public static final Sprite BILLIARD_BR  = new Sprite(6,8,16,16,SpriteSheet.Items);

        //SWORDS

        public static final Sprite AXE   = new Sprite(0,7,16,16,SpriteSheet.Items);
        public static final Sprite SWORD = new Sprite(1,7,16,16,SpriteSheet.Items);
        public static final Sprite SWORD1  = new Sprite(2,7,16,16,SpriteSheet.Items);

        /*
        public static final Sprite CMPT_TL;
        public static final Sprite CMPT_L0;
        public static final Sprite CMPT_L1;
        public static final Sprite CMPT_BL;

        public static final Sprite CMPT_BL0;
        public static final Sprite CMPT_BL1;
        public static final Sprite CMPT_BL2;
        public static final Sprite CMPT_BR;

        public static final Sprite CMPT_TR;
        public static final Sprite CMPT_R0;
        public static final Sprite CMPT_R1;*/

         // DOOR

        public static final Sprite DOOR0 = new Sprite(6,10,16,16,SpriteSheet.Items);
        public static final Sprite DOOR1 = new Sprite(6,11,16,16,SpriteSheet.Items);



        private int x,y;
        private int width,height;
        private int pixels[];
        private SpriteSheet sheet;


                public Sprite(int x,int y,int width,int height,SpriteSheet sheet){
                     this.x = x * width;
                     this.y = y * height;
                     this.width = width;
                     this.height = height;
                     this.pixels = new int[width * height];
                     this.sheet = sheet;
                     loadSprite();
                }

        private void loadSprite(){
             for(int y=0;y<height;y++) {
                 for (int x = 0; x < width; x++) {
                     pixels[x + y * width] = sheet.getPixels()[(x + this.x) + (y + this.y) * sheet.getWidth()];
                 }
            }
        }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int[] getPixels() {
        return pixels;
    }
    public SpriteSheet getSheet() {
        return sheet;
    }


}
