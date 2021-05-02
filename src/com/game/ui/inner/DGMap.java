package com.game.ui.inner;

import com.game.Game;
import com.game.entity.npcs.Mob;
import com.game.levels.MappedLevel;
import com.game.utils.Vector2i;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class DGMap extends DGComponent{

    private BufferedImage image;
    private int originalPixels[];
    private int width,height;

    public DGMap(){
        super(new Rectangle(0,0,0,0));
        loadIMG();
    }

    public DGMap(Rectangle bounds){
         super(bounds);
         loadIMG();
    }

    @Override
    protected void update() {
        trackPlayerPosition();
        trackMobsPosition();
    }

    @Override
    protected void render(Graphics g) {
        if(image != null){
            g.drawImage(image , bounds.x , bounds.y , image.getWidth() * (Game.SCALE + 2), image.getHeight() * Game.SCALE , null);
        }
    }

    private void cleanIMG(){

    }

    private void trackPlayerPosition(){
        Vector2i player = Game.player.getWorldPosition();
        if(inBounds(player)) image.setRGB(player.x , player.y , 0xff0000);
    }

    private void trackMobsPosition(){
        List<Mob> mobs = level.getMobs();
        if(mobs != null){
            for(int i=0;i<mobs.size();i++){
                Vector2i position = mobs.get(i).getWorldPosition();
                if(inBounds(position)) image.setRGB(position.x , position.y , 0x00ff00);
            }
        }

    }

    private void loadIMG(){
        if(level instanceof MappedLevel) {
            image = ((MappedLevel) level).getImage();
        }
        savePixels();
    }

    private boolean inBounds(Vector2i position){
        return position.x > 0 && position.x < width && position.y > 0 && position.y < height;
    }

    private void savePixels(){
        if(image != null){
            width = image.getWidth();
            height  = image.getHeight();
            originalPixels = new int[width * height];
            image.getRGB(0,0,width , height , originalPixels, 0 , width );
        }
        else{
            System.err.println("Error while getting level image !");
        }

    }

}
