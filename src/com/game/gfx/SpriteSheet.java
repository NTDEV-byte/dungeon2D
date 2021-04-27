package com.game.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.IOException;

public class SpriteSheet {

        // TODO: 23/04/2021 createSpriteSheet

        public static SpriteSheet Tiles = new SpriteSheet("/res/stuff.png");
        public static SpriteSheet Items = new SpriteSheet("/res/items.png");

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

            System.out.println("Image Path: "+path+" Type: "+image.getType());
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
