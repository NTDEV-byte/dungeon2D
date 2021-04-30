package com.game.utils;

import com.game.entity.npcs.Girl;
import com.game.entity.npcs.Hero;
import com.game.entity.npcs.King;
import com.game.entity.particals.Partical;
import com.game.levels.Level;

import java.util.Random;

import static com.game.gfx.SpriteSheet.Hero;

public class Generator {

        private Generator(){

        }

            public enum MOBS_TYPES {GIRL,KING,MASTER,HERO};

            public static void generateParticals(int amount,int x, int y, Level level){
                    for(int i=0;i<amount;i++) {
                      Partical p =  new Partical(x,y,5);
                      level.addEntity(p);
                    }
                }

            public static void generateParticals(int amount,int x, int y, Level level,boolean Randcolor){
                for(int i=0;i<amount;i++) {
                    Partical p =   new Partical(x,y,5,Randcolor);
                    level.addEntity(p);
                }
            }

            public static void generateMobs(int amount ,int x,int y,Level level){
                Random random = new Random();
                for(int i=0;i<amount;i++){
                     int index = random.nextInt(MOBS_TYPES.values().length);
                     MOBS_TYPES type = MOBS_TYPES.values()[index];
                     if(type == MOBS_TYPES.GIRL){
                        level.addEntity(new Girl(x,y));
                     }
                     else if(type == MOBS_TYPES.KING){
                         level.addEntity(new King(x,y));
                     }
                     else if(type == MOBS_TYPES.HERO){
                         level.addEntity(new Hero(x,y));
                     }
                     else{
                         level.addEntity(new Girl(x,y));
                     }
                }
            }

}
