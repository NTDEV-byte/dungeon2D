package com.game.utils;

import com.game.entity.particals.Partical;
import com.game.levels.Level;

public class Generator {

        private Generator(){

        }

            public static void generateParticals(int amount,int x, int y, Level level){
                    for(int i=0;i<amount;i++) {
                      Partical p =   new Partical(x,y,5);
                      p.setLevel(level);
                      level.addEntity(p);
                    }
                }

}
