package com.game.gfx;

import com.game.Game;
import com.game.effects.Effect;
import com.game.entity.npcs.Mob;
import com.game.entity.particals.Partical;
import com.game.entity.projectiles.Projectile;
import com.game.levels.Level;
import com.game.levels.tiles.Tile;
import com.game.utils.IMGFilter;

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

    public void renderTile(int xa, int ya, Tile tile,int mask) {
        xa-=xOffset;
        ya-=yOffset;
        for (int y = 0; y < tile.getSprite().getHeight(); y++) {
                int yp = y + ya;
            for (int x = 0; x < tile.getSprite().getWidth(); x++) {
                int xp = x + xa;
                if(xp < -Level.TILE_SIZE || xp >= width || yp < 0 || yp >= height) break;
                if(xp < 0) xp = 0;
                int col = tile.getSprite().getPixels()[x + y * tile.getSprite().getWidth()];
                if(col == MASK_ALPHA) col = mask;
                pixels[xp + yp * width] = col;
            }
        }
    }

    public void renderLightSourceTile(int xa, int ya,Tile tile,int mask ,int r,int g,int b,double intensity) {
        xa-=xOffset;
        ya-=yOffset;
        for (int y = 0; y < tile.getSprite().getHeight(); y++) {
            int yp = y + ya;
            for (int x = 0; x < tile.getSprite().getWidth(); x++) {
                int xp = x + xa;
                if(xp < -Level.TILE_SIZE || xp >= width || yp < 0 || yp >= height) break;
                if(xp < 0) xp = 0;
                int col = tile.getSprite().getPixels()[x + y * tile.getSprite().getWidth()];
                int ri = (int)(r * intensity);
                int gi = (int)(g * intensity);
                int bi = (int)(b * intensity);
                col = IMGFilter.calculateColor(col , ri, gi,bi);
                pixels[xp + yp * width] = col;
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

    public void renderMob(Mob mob, int xa,int ya){
        xa-=xOffset;
        ya-=yOffset;
        for(int y=0;y<mob.getSprite().getHeight();y++){
            int yp = y + ya;
            for(int x=0;x<mob.getSprite().getWidth();x++) {
                int xp = x + xa;
                if(xp < 0 || xp >= width || yp <0  || yp >= height) continue;
                int pixel =  mob.getSprite().getPixels()[x + y * mob.getSprite().getWidth()];
                if(pixel != MASK_ALPHA) pixels[xp + yp * width] = pixel;
            }
        }
    }

    public void renderProjectile(Projectile projectile, int xa, int ya){
        xa-=xOffset;
        ya-=yOffset;
        for(int y=0;y<projectile.getSprite().getHeight();y++){
            int yp = y + ya;
            for(int x=0;x<projectile.getSprite().getWidth();x++) {
                int xp = x + xa;
                if(xp < 0 || xp >= width || yp <0  || yp >= height) continue;
                int pixel = projectile.getSprite().getPixels()[x + y * projectile.getSprite().getWidth()];
                if(pixel != MASK_ALPHA) pixels[xp + yp * width] = pixel;
            }
        }
    }

    public void renderPartical(Partical partical, int xa, int ya){
        xa-=xOffset;
        ya-=yOffset;
        for(int y=0;y<partical.getSprite().getHeight();y++){
            int yp = y + ya;
            for(int x=0;x<partical.getSprite().getWidth();x++) {
                int xp = x + xa;
                if(xp < 0 || xp >= width || yp <0  || yp >= height) continue;
                 pixels[xp + yp * width] =  partical.getSprite().getPixels()[x + y * partical.getSprite().getWidth()];
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
                int pixel = sprite.getPixels()[x + y * sprite.getWidth()];
                if(pixel!=MASK_ALPHA) pixels[xp + yp * width] = pixel;
            }
        }
    }

//af6b26

    public void renderSprite(Effect effect, int xa, int ya , int color){
        xa-=xOffset;
        ya-=yOffset;
        for(int y=0;y<effect.getSprite().getHeight();y++){
            int yp = y + ya;
            for(int x=0;x<effect.getSprite().getWidth();x++){
                int xp = x + xa;
                if(xp < 0 || xp >= width || yp < 0 || yp >= height) continue;
                int pixel = effect.getSprite().getPixels()[x + y * effect.getSprite().getWidth()];
                if(pixel!=color) pixels[xp + yp * width] = pixel;
            }
        }
    }


    //Font rendering

    public void renderFont(Sprite sprite,int xa,int ya){
        for(int y=0;y<sprite.getHeight();y++){
            int yp = y + ya;
            for(int x=0;x<sprite.getWidth();x++){
                int xp = x + xa;
                if(xp < 0 || xp >= width || yp < 0 || yp >= height) continue;
                int pixel = sprite.getPixels()[x + y * sprite.getWidth()];
                if(pixel != MASK_ALPHA ) pixels[xp + yp * width] = pixel;
            }
        }
    }

    public void renderFontWorld(Sprite sprite,int xa,int ya){
        xa-=xOffset;
        ya-=yOffset;
        for(int y=0;y<sprite.getHeight();y++){
            int yp = y + ya;
            for(int x=0;x<sprite.getWidth();x++){
                int xp = x + xa;
                if(xp < 0 || xp >= width || yp < 0 || yp >= height) continue;
                int pixel = sprite.getPixels()[x + y * sprite.getWidth()];
                if(pixel != MASK_ALPHA ) pixels[xp + yp * width] = pixel;
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
                screenPixels[x + y * width] =  pixels[x + y * width] ;
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
