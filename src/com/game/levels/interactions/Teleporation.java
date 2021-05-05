package com.game.levels.interactions;

import com.game.Game;
import com.game.entity.Entity;
import com.game.levels.Level;
import com.game.levels.MappedLevel;
import com.game.ui.inner.DGInnerLook;

public class Teleporation{

            public static final int TO_SPAWN = 0;
            public static final int TO_FIREWORLD = 1;

            public Teleporation(){

            }

            public void teleportate(Entity e ,int location){
                prepareWorld(e , location);
            }

            private void prepareWorld(Entity e , int location){
                Game.level = getWorld(location);
                Game.game.getCamera().setLevel(Game.level);
                e.setLevel(Game.level);
                if(Game.level instanceof  MappedLevel){
                    DGInnerLook.map.setIMG(((MappedLevel) Game.level).getImage());
                }
                else{
                    System.err.println("Game.level is not an instance of MappedLevel !");
                }

            }

            private Level getWorld(int location){
                switch (location){
                    case TO_SPAWN:

                        return Level.SPAWN;


                    case TO_FIREWORLD:
                         return Level.FIREWORLD;


                }
                return null;
            }
}
