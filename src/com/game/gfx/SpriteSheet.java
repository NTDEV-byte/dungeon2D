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
        public static final SpriteSheet Player = new SpriteSheet("/res/spritesheets/mobs/master.png");

        //Projectiles
        public static final SpriteSheet Projectiles = new SpriteSheet("/res/spritesheets/projectiles.png");


        private String path;
        private int pixels[];
        private int width,height;

                public SpriteSheet(String path){
                    this.path = path;
                    loadSpriteSheet();
                    if(pixels == null) System.err.println("Erreur lors de la récupération des pixels de l'image");
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
