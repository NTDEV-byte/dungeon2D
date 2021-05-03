package com.game.levels.interactions;

import com.game.Game;
import com.game.entity.Entity;
import com.game.levels.MappedLevel;

public class Teleporation implements Interaction{

            public Teleporation(){

            }

            public void teleportate(Entity e){
                Game.level = MappedLevel.FIREWORLD;
                Game.game.getCamera().setLevel(Game.level);
                e.setLevel(Game.level);
            }

                @Override
                public void interact(Entity e) {

                }
}
