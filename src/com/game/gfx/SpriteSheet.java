package com.game.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

        // TODO: 23/04/2021 createSpriteSheet

        //TileSets
        public static final SpriteSheet Tiles = new SpriteSheet("/res/spritesheets/stuff.png");
        public static final SpriteSheet Items = new SpriteSheet("/res/spritesheets/items.png");
        public static final SpriteSheet Base =  new SpriteSheet("/res/spritesheets/base.png");

        //Mobs
        public static final SpriteSheet Player = new SpriteSheet("/res/spritesheets/mobs/personnes/master.png");
        public static final SpriteSheet Girl = new SpriteSheet("/res/spritesheets/mobs/personnes/girl.png");
        public static final SpriteSheet Hero = new SpriteSheet("/res/spritesheets/mobs/personnes/hero.png");
        public static final SpriteSheet King = new SpriteSheet("/res/spritesheets/mobs/personnes/king.png");

        // Monsters

        public static final SpriteSheet GHOST = new SpriteSheet("/res/spritesheets/mobs/monsters/ghost.png");
        public static final SpriteSheet LUCIFER = new SpriteSheet("/res/spritesheets/mobs/monsters/lucifer.png");

        //Projectiles
        public static final SpriteSheet Projectiles = new SpriteSheet("/res/spritesheets/projectiles.png");


        //SpriteSheets Croped




        private String path;
        private int pixels[];
        private Sprite sprites[];
        private int width,height;

                public SpriteSheet(String path){
                    this.path = path;
                    loadSpriteSheet();
                    if(pixels == null) System.err.println("Erreur lors de la récupération des pixels de l'image");
                }



    public SpriteSheet(int x, int y, int width, int height, int wSprite, int hSprite, SpriteSheet sheet){
                       int xOffset = x * wSprite;
                       int yOffset = y * hSprite;
                       this.width = width * wSprite;
                       this.height = height * hSprite;
                       this.pixels = new int[this.width * this.height];

                       for(int y0=0;y0<this.height;y0++){
                            for(int x0=0;x0<this.width;x0++) {
                                this.pixels[x0 + y0 * this.width] = sheet.getPixels()[(xOffset + x0) + (yOffset + y0) * sheet.getWidth()];
                                  }
                            }

                       sprites = new Sprite[width * height];
                       int spritePixels[];
                       int spriteIndex = 0;

                        for(int y0=0;y0<height;y0++) {
                            for(int x0=0;x0<width;x0++){
                              spritePixels = new int[wSprite * hSprite];
                            for(int y1=0;y1<hSprite;y1++){
                                 for(int x1=0;x1<wSprite;x1++){
                                     spritePixels[x1 + y1 * wSprite] = pixels[(x1 + (x0 * wSprite)) + (y1 + (y0 * hSprite)) * this.width];
                                 }
                               }
                                sprites[spriteIndex++] = new Sprite(wSprite,hSprite,spritePixels);
                            }
                        }
                }



    private void loadSpriteSheet(){
        try {
            System.out.println(getClass().getResource(path));
            BufferedImage image = ImageIO.read(getClass().getResource(path));

            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0,0,width,height,pixels,0,width);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sprite[] getSprites() {
        return sprites;
    }

    public void setSprites(Sprite[] sprites) {
        this.sprites = sprites;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
