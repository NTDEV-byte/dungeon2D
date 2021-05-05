package com.game.levels;

import com.game.Game;
import com.game.entity.npcs.Mob;
import com.game.entity.npcs.personnes.Player;
import com.game.gfx.Screen;

import java.util.List;
import java.util.Random;

public class Camera {

    private Level level;
    private Screen screen;
    private int index;

            public Camera(Level level , Screen screen){
                 this.level = level;
                 this.screen = screen;
            }

            public void followPlayer(){
                Player p = Game.player;
                level.render(screen , p.getCenterX() , p.getCenterY());
            }

            public void followRandomlly(){
                List<Mob> mobs = level.getMobs();
                int mobIndex =  new Random().nextInt(mobs.size());
                Mob choosen = mobs.get(mobIndex);
                level.render(screen, choosen.getCenterX() , choosen.getCenterY());
            }

            public void next(){
                if(Game.input.n){
                    if(inBound()) {
                        index++;
                    }
                        Mob mob = level.getMobs().get(index);
                        level.render(screen,mob.getCenterX(),mob.getCenterY());
                    }
            }



    public void previous(){
                if(Game.input.p) {
                    if (inBound()) {
                        index--;
                    }
                        Mob mob = level.getMobs().get(index);
                        level.render(screen, mob.getCenterX(), mob.getCenterY());
                }
            }

            public void update(){
                previous();
                next();
            }

            private boolean inBound(){
                return index >= 0 && index <= level.getMobs().size();
            }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
