package com.game.levels;

import com.game.Game;
import com.game.effects.Effect;
import com.game.entity.Entity;
import com.game.entity.npcs.Mob;
import com.game.entity.particals.Partical;
import com.game.entity.projectiles.Projectile;
import com.game.font.DGFont;
import com.game.gfx.Screen;
import com.game.levels.tiles.Tile;
import com.game.utils.IMGFilter;

import java.util.ArrayList;
import java.util.List;

public class Level {

    // well le temps est relatif
    public static final int ONE_HOUR_PASSED = 15;
    public static final float DAY = 0.95F;
    public static final float NIGHT = 0.3F;
    public static final float RATE_NIGHT_COMING = 0.01f;
    public static final float RATE_DAY_COMING = 0.01f;
    public static final int TILE_SIZE = 16;
    public static final Level SPAWN = new MappedLevel("/res/levels/spawn.png");

    protected int width;
    protected int height;
    protected int tiles[];
    protected List<Partical> particals;
    protected List<Projectile> projectiles;
    protected List<Mob> mobs;
    protected List<Effect> effects;
    protected float brightnessFactor = 1.0f;
    protected int timer;
    protected boolean day = true;

            public Level(int width,int height){
                this.width = width;
                this.height = height;
                this.tiles = new int[width * height];
                generateLevel();
            }

            public Level(String path){
                loadLevel(path);
                initialize();
            }

            private void initialize(){
                particals = new ArrayList<>();
                projectiles = new ArrayList<>();
                mobs = new ArrayList<>();
                effects = new ArrayList<>();
            }


            protected void loadLevel(String path){}
            protected void generateLevel(){}

            public void addEntity(Entity e){
                if(e instanceof Partical){
                    particals.add((Partical) e);
                }
                else if(e instanceof Projectile) {
                    projectiles.add((Projectile)e);
                }
                else if(e instanceof  Mob){
                    mobs.add((Mob) e);
                }
                else if(e instanceof  Effect){
                    effects.add((Effect) e);
                }
            }

            public void update(){
                for(Partical p: particals) {
                    p.update();
                }
                for(Projectile p: projectiles) {
                    p.update();
                }
                for(Mob m: mobs) {
                    m.update();
                }
                for(Effect e: effects) {
                    e.update();
                }
                clean();
                dayNightCycle();
            }


            private void dayNightCycle(){
                if(timer < 7500) timer++; else timer = 0;

                if(timer % ONE_HOUR_PASSED == 0){
                    if(day){
                        brightnessFactor-=RATE_NIGHT_COMING;
                    }
                    else{
                        brightnessFactor+=RATE_DAY_COMING;
                    }
                }
                if(brightnessFactor <= NIGHT){
                    day = false;
                }
                if(brightnessFactor >= DAY){
                    day = true;
                }
            }

            private void clean(){
                //remove dead particals
                for(int i=0;i<particals.size();i++){
                    if(particals.get(i).isDead()){
                        particals.remove(i);
                    }
                }
                for(int i=0;i<projectiles.size();i++){
                    if(projectiles.get(i).isDead()){
                        projectiles.remove(i);
                    }
                }
                for(int i=0;i<mobs.size();i++) {
                    if (mobs.get(i).isDead()) {
                        mobs.remove(i);
                    }
                }
                    for(int i=0;i<effects.size();i++){
                        if(effects.get(i).isDead()){
                            effects.remove(i);
                        }
                }
            }



    public void render(Screen screen, int xScroll, int yScroll){
                screen.setOffset(xScroll,yScroll);
                int x0 = xScroll >> 4;
                int x1 = xScroll + screen.getWidth() + TILE_SIZE >> 4;
                int y0 = yScroll >> 4;
                int y1 = yScroll + screen.getHeight() + TILE_SIZE >> 4;
                for(int y=y0;y<y1;y++){
                    for(int x=x0;x<x1;x++){
                        getBlockUsingColor(x,y).render(x,y,screen);
                    }
                }
                renderEntities(screen);
                renderEffects(screen);
                renderMessages(screen);

            }

            private void renderEntities(Screen screen){
                for(Partical p: particals) {
                    p.render(screen);
                }
                for(Projectile p: projectiles) {
                    p.render(screen);
                }
                for(Mob m: mobs) {
                    m.render(screen);
                    if(m.isCollidingWithMob()){
                        DGFont.WorldMessage(screen , "oupsi !" , m.getX() >> 4, m.getY() >> 4);
                    }
                }
                for(Effect e: effects) {
                        e.render(screen);
                }
            }

            private void renderMessages(Screen screen){
                DGFont.WorldMessage(screen , "ntdev-byte" , 6,5);
                DGFont.WorldMessage(screen , "ntdev-byte" , 37,51);
                if(brightnessFactor <= 0.5f){
                    DGFont.showMessage(screen , "hold on it will be too long " , 2,2);
                }
            }


            private void renderEffects(Screen screen){
                //dayNightEffect
                IMGFilter.brighten(screen.getPixels(), brightnessFactor);
            }

            public boolean collision(int xa,int ya){
               return getBlockUsingColor(xa >> 4 , ya >> 4).isSolid();
            }


            private Tile getBlockUsingID(int x, int y)
            {
                if(x < 0 || x >= width || y < 0 || y >= height) {return Tile.WALL;}

                else if(tiles[x + y * width] == DiceLevel.HEAD_PILLAR) {return Tile.HEAD_PILLAR;}
                else if(tiles[x + y * width] == DiceLevel.BODY_PILLAR) {return Tile.BODY_PILLAR;}
                else if(tiles[x + y * width] == DiceLevel.FOOT_PILLAR) {return Tile.FOOT_PILLAR;}
                else if(tiles[x + y * width] == DiceLevel.CARPET) {return Tile.CARPET;}
                else if(tiles[x + y * width] == DiceLevel.CARPETB) {return Tile.CARPETB;}
                else if(tiles[x + y * width] == DiceLevel.CARPETBL) {return Tile.CARPETBL;}
                else if(tiles[x + y * width] == DiceLevel.WALL) {return Tile.WALL;}
                else if(tiles[x + y * width] == DiceLevel.BORDERLEFT) {return Tile.BORDERLEFT;}

                return Tile.CARPETTL;
            }



    public Tile getBlockUsingColor(int x, int y)
            {
                if(x < 0 || x >= width || y < 0 || y >= height) {return Tile.PARQUET1;}

                else if(tiles[x + y * width] == MappedLevel.HEAD_PILLAR) {return Tile.HEAD_PILLAR;}
                else if(tiles[x + y * width] == MappedLevel.BODY_PILLAR) {return Tile.BODY_PILLAR;}
                else if(tiles[x + y * width] == MappedLevel.FOOT_PILLAR) {return Tile.FOOT_PILLAR;}
                else if(tiles[x + y * width] == MappedLevel.CARPETTL) {return Tile.CARPETTL;}
                else if(tiles[x + y * width] == MappedLevel.CARPETR) {return Tile.CARPETR;}
                else if(tiles[x + y * width] == MappedLevel.CARPETM) {return Tile.CARPETM;}
                else if(tiles[x + y * width] == MappedLevel.BORDERRIGHT) {return Tile.BORDERRIGHT;}
                else if(tiles[x + y * width] == MappedLevel.BORDERLEFT) {return Tile.BORDERLEFT;}
                else if(tiles[x + y * width] == MappedLevel.CARPET) {return Tile.CARPET;}
                else if(tiles[x + y * width] == MappedLevel.CARPETBL) {return Tile.CARPETBL;}
                else if(tiles[x + y * width] == MappedLevel.BORDERBR) {return Tile.BORDERBR;}
                else if(tiles[x + y * width] == MappedLevel.CARPETB) {return Tile.CARPETB;}
                else if(tiles[x + y * width] == MappedLevel.WALL) {return Tile.WALL;}

                // CARPET 1
                else if(tiles[x + y * width] == MappedLevel.CP1_TL) {return Tile.CP1_TL;}
                else if(tiles[x + y * width] == MappedLevel.CP1_BL) {return Tile.CP1_BL;}
                else if(tiles[x + y * width] == MappedLevel.CP1_MT) {return Tile.CP1_MT;}
                else if(tiles[x + y * width] == MappedLevel.CP1_MB) {return Tile.CP1_MB;}
                else if(tiles[x + y * width] == MappedLevel.CP1_TR) {return Tile.CP1_TR;}
                else if(tiles[x + y * width] == MappedLevel.CP1_BR) {return Tile.CP1_BR;}


                //CARPET 2
                else if(tiles[x + y * width] == MappedLevel.CP2_TL) {return Tile.CP2_TL;}
                else if(tiles[x + y * width] == MappedLevel.CP2_BL) {return Tile.CP2_BL;}
                else if(tiles[x + y * width] == MappedLevel.CP2_MT) {return Tile.CP2_MT;}
                else if(tiles[x + y * width] == MappedLevel.CP2_MB) {return Tile.CP2_MB;}
                else if(tiles[x + y * width] == MappedLevel.CP2_TR) {return Tile.CP2_TR;}
                else if(tiles[x + y * width] == MappedLevel.CP2_BR) {return Tile.CP2_BR;}


                //WOOD

                else if(tiles[x + y * width] == MappedLevel.WOOD) {return Tile.WOOD;}

                //UP CHAIR

                else if(tiles[x + y * width] == MappedLevel.UP_CHAIR) {return Tile.UP_CHAIR;}

                //DOWN CHAIR

                else if(tiles[x + y * width] == MappedLevel.DOWN_CHAIR0) {return Tile.DOWN_CHAIR0;}
                else if(tiles[x + y * width] == MappedLevel.DOWN_CHAIR1) {return Tile.DOWN_CHAIR1;}

                //LEFT CHAIR
                else if(tiles[x + y * width] == MappedLevel.LEFT_CHAIR0) {return Tile.LEFT_CHAIR0;}
                else if(tiles[x + y * width] == MappedLevel.LEFT_CHAIR1) {return Tile.LEFT_CHAIR1;}

                //RIGHT CHAIR

                else if(tiles[x + y * width] == MappedLevel.RIGHT_CHAIR0) {return Tile.RIGHT_CHAIR0;}
                else if(tiles[x + y * width] == MappedLevel.RIGHT_CHAIR1) {return Tile.RIGHT_CHAIR1;}

                //TABLE


                else if(tiles[x + y * width] == MappedLevel.TL_TABLE) {return Tile.TL_TABLE;}
                else if(tiles[x + y * width] == MappedLevel.TR_TABLE) {return Tile.TR_TABLE;}
                else if(tiles[x + y * width] == MappedLevel.BL_TABLE) {return Tile.BL_TABLE;}
                else if(tiles[x + y * width] == MappedLevel.BR_TABLE) {return Tile.BR_TABLE;}


                //LEFT FIRE


                else if(tiles[x + y * width] == MappedLevel.LEFT_FIRE0) {return Tile.LEFT_FIRE0;}
                else if(tiles[x + y * width] == MappedLevel.LEFT_FIRE1) {return Tile.LEFT_FIRE1;}

                //RIGHT FIRE

                else if(tiles[x + y * width] == MappedLevel.RIGHT_FIRE0) {return Tile.RIGHT_FIRE0;}
                else if(tiles[x + y * width] == MappedLevel.RIGHT_FIRE1) {return Tile.RIGHT_FIRE1;}

                //UP FIRE

                else if(tiles[x + y * width] == MappedLevel.UP_FIRE0) {return Tile.UP_FIRE0;}
                else if(tiles[x + y * width] == MappedLevel.UP_FIRE1) {return Tile.UP_FIRE1;}

                //ARMOR

                else if(tiles[x + y * width] == MappedLevel.ARMOR_UP) {return Tile.ARMOR_UP;}
                else if(tiles[x + y * width] == MappedLevel.ARMOR_BOTTOM) {return Tile.ARMOR_BOTTOM;}

                //BED

                else if(tiles[x + y * width] == MappedLevel.BED_UP) {return Tile.BED_UP;}
                else if(tiles[x + y * width] == MappedLevel.BED_BOTTOM) {return Tile.BED_BOTTOM;}

                //DOWNSTAIR

                else if(tiles[x + y * width] == MappedLevel.DOWNSTAIR_RIGHT0) {return Tile.DOWNSTAIR_UP;}
                else if(tiles[x + y * width] == MappedLevel.DOWNSTAIR_RIGHT1) {return Tile.DOWNSTAIR_BOTTOM;}
                else if(tiles[x + y * width] == MappedLevel.UPSTAIRLEFT) {return Tile.UPSTAIRUP;}


                //BIBILIOTHEQUE

                else if(tiles[x + y * width] == MappedLevel.BIBLIO_TL) {return Tile.BIBLIO_TL;}
                else if(tiles[x + y * width] == MappedLevel.BIBLIO_TR) {return Tile.BIBLIO_TR;}
                else if(tiles[x + y * width] == MappedLevel.BIBLIO_BL) {return Tile.BIBLIO_BL;}
                else if(tiles[x + y * width] == MappedLevel.BIBLIO_BR) {return Tile.BIBLIO_BR;}

                //BILLIARD

                else if(tiles[x + y * width] == MappedLevel.BILLIARD_TL) {return Tile.BILLIARD_TL;}
                else if(tiles[x + y * width] == MappedLevel.BILLIARD_BL) {return Tile.BILLIARD_BL;}
                else if(tiles[x + y * width] == MappedLevel.BILLIARD_TR) {return Tile.BILLIARD_TR;}
                else if(tiles[x + y * width] == MappedLevel.BILLIARD_BR) {return Tile.BILLIARD_BR;}

                //SWORDS

                else if(tiles[x + y * width] == MappedLevel.AXE) {return Tile.AXE;}
                else if(tiles[x + y * width] == MappedLevel.SWORD) {return Tile.SWORD;}
                else if(tiles[x + y * width] == MappedLevel.SWORD1) {return Tile.SWORD1;}

                else if(tiles[x + y * width] == MappedLevel.DOOR0) {return Tile.SWORD;}
                else if(tiles[x + y * width] == MappedLevel.DOOR1) {return Tile.SWORD1;}

                //BASE

                else if(tiles[x + y * width] == MappedLevel.WATER) {return Tile.WATER;}
                else if(tiles[x + y * width] == MappedLevel.WALLB) {return Tile.WALLB;}
                else if(tiles[x + y * width] == MappedLevel.WALLF) {return Tile.WALLF;}

                else if(tiles[x + y * width] == MappedLevel.PARQUET0) {return Tile.PARQUET0;}
                else if(tiles[x + y * width] == MappedLevel.WALLG) {return Tile.WALLG;}
                else if(tiles[x + y * width] == MappedLevel.WALLR) {return Tile.WALLR;}

                else if(tiles[x + y * width] == MappedLevel.PARQUET1) {return Tile.PARQUET1;}
                else if(tiles[x + y * width] == MappedLevel.WALLO) {return Tile.WALLO;}
                else if(tiles[x + y * width] == MappedLevel.SEWER) {return Tile.SEWER;}

                return Tile.PARQUET1;
            }

    public List<Partical> getParticals() {
        return particals;
    }
    public void setParticals(List<Partical> particals) {
        this.particals = particals;
    }
    public List<Projectile> getProjectiles() {
        return projectiles;
    }
    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }
    public List<Mob> getMobs() {
        return mobs;
    }
    public void setMobs(List<Mob> mobs) {
        this.mobs = mobs;
    }


}
