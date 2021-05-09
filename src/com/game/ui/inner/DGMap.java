package com.game.ui.inner;

import com.game.Game;
import com.game.entity.Entity;
import com.game.entity.npcs.Mob;
import com.game.levels.Level;
import com.game.levels.MappedLevel;
import com.game.utils.Vector2i;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class DGMap extends DGComponent{

    public static final int PLAYER_LOCATION = 0;
    public static final int COLOR_PLAYER_LOCATION = 0x00ff00;
    public static final int COLOR_NPCS_LOCATIONS = 0;
    private BufferedImage image;
    private List<MapLocation> locations;
    private int originalPixels[];
    private int width,height;

    public DGMap(){
        super(new Rectangle(0,0,0,0));
        loadIMG();
        locations = new ArrayList<>();
        locations.add(new MapLocation(Game.player));
        for(int i=0;i<level.getMobs().size();i++){
         locations.add(new MapLocation(level.getMobs().get(i)));
        }
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

    private void trackPlayerPosition(){
        Vector2i player = Game.player.getWorldPosition();
        if(locations.get(PLAYER_LOCATION).hasChangedLocation(Game.player)){
            clearMobPaths();
        }
        if(inBounds(player)) {
            image.setRGB(player.x , player.y , COLOR_PLAYER_LOCATION);
        }
        locations.get(PLAYER_LOCATION).updateLocation(Game.player);
    }

    private void trackMobsPosition(){
        List<Mob> mobs = level.getMobs();
        System.out.println(mobs.size());
        if(mobs.size() >= 2){
            for(int i=1;i<mobs.size();i++){
                if(locations.get(i).hasChangedLocation(mobs.get(i))){
                    clearMobPaths();
                }
                Vector2i position = new Vector2i(mobs.get(i).getX() , mobs.get(i).getY());
                if(inBounds(position)) {
                    image.setRGB(position.x , position.y , COLOR_NPCS_LOCATIONS);
                }
                locations.get(i).updateLocation(mobs.get(i));
            }
        }
    }

    // clean path
    private void clearMobPaths(){
            image.setRGB(0,0,width,height,originalPixels,0 , width);
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

    // every tracked entity on the map is represented with this class
    public class MapLocation{
        float x,y;

        public MapLocation(float x,float y){
            this.x = x;
            this.y = y;
        }

        public MapLocation(Entity e){
            this.x = e.getX();
            this.y = e.getY();
        }

        public void updateLocation(Entity e){
            this.x = e.getX();
            this.y = e.getY();
        }

        public boolean hasChangedLocation(Entity e){
            return x != e.getX() || y != e.getY();
        }

        public void updateLocation(float x,float y){
            this.x = x;
            this.y = y;
        }

        public float getX(){return x;}
        public float getY(){return y;}
    }

    public void setIMG(BufferedImage image){
         this.image = image;
    }

}
