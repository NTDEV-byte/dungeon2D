package com.game.gfx;

import com.game.Game;
import com.game.levels.Level;
import com.game.levels.tiles.Tile;

import java.util.Random;

public class Screen {

    public static final int MASK_ALPHA = 0xffff00ff;

    private int width;
    private int height;
    private int pixels[];
    private int tiles[] = new int[64 * 64];
    private Random random = new Random();
    private int xOffset,yOffset;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
        generateTiles();
    }

    private void generateTiles(){
        for(int i=0;i<tiles.length;i++){
                tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void render(int xa,int ya) {
        for (int y = 0; y < height; y++) {
            int yp = y + ya;
            for (int x = 0; x < width; x++) {
                int xp = x + xa;
                // out of bounds
                int index = (xp  >> 4 & 7) + (yp >> 4 & 7) * 64;
                    pixels[x + y * width] = tiles[index];
            }
        }
    }

    public void renderTile(int xa, int ya, Tile tile) {
        xa-=xOffset;
        ya-=yOffset;
        for (int y = 0; y < tile.getSprite().getHeight(); y++) {
                int yp = y + ya;
            for (int x = 0; x < tile.getSprite().getWidth(); x++) {
                int xp = x + xa;
                if(xp < -Level.TILE_SIZE || xp >= width || yp < 0 || yp >= height) break;
                if(xp < 0) xp = 0;
                int col = tile.getSprite().getPixels()[x + y * tile.getSprite().getWidth()];
                if(col != 0xffff00ff) pixels[xp + yp * width] = col;
            }
        }
    }

    public void renderSpriteSheet(SpriteSheet sheet,int xa,int ya){
        for(int y=0;y<sheet.getHeight();y++){
            int yp = y + ya;
             for(int x=0;x<sheet.getWidth();x++){
                 int xp = x + xa;
                 if(xp < 0 || xp >= width || yp < 0 || yp >= height) continue;
                 pixels[xp + yp * width] = sheet.getPixels()[x + y * sheet.getWidth()];
             }
        }
    }
    
   // TODO: 23/04/2021 renderSprite

    public void renderSprite(Sprite sprite,int xa,int ya){
        for(int y=0;y<sprite.getHeight();y++){
            int yp = y + ya;
            for(int x=0;x<sprite.getWidth();x++){
                int xp = x + xa;
                if(xp < 0 || xp >= width || yp < 0 || yp >= height) continue;
                pixels[xp + yp * width] = sprite.getPixels()[x + y * sprite.getWidth()];
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0x0;
        }
    }

    public void flipBuffer(Game game) {
        int screenPixels[] = game.getPixels();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                screenPixels[x + y * width] = pixels[x + y * width];
            }
        }
    }

    public void setOffset(int xOffset,int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    public int[] getTiles() {
        return tiles;
    }

    public void setTiles(int[] tiles) {
        this.tiles = tiles;
    }
}
