package com.game.entity.projectiles;

import com.game.gfx.Screen;
import com.game.gfx.Sprite;

import java.util.ArrayList;
import java.util.List;

public class FuryDefense extends Projectile{

            protected int amount;
            protected float angleStep;
            protected List<Projectile> projectiles;

                public FuryDefense(int x,int y ,int amount){
                        super(x,y);
                        this.amount = amount;
                        this.angleStep = 360 / amount;
                        super.sprite = Sprite.AXE;
                        this.projectiles = new ArrayList<>();
                        generate();
                }

                private void generate(){
                    float angle = 0.0f;
                    for(int i=0;i<amount;i++){
                        projectiles.add(new MasterProjectile(x , y ,Math.toRadians(angle)));
                        angle+=angleStep;
                    }
                }

                public void update(){
                    for(int i=0;i<projectiles.size();i++){
                            projectiles.get(i).update();
                            if(projectiles.get(i).isDead()) projectiles.remove(i);
                    }
                }

                public void render(Screen screen){
                    for(Projectile p : projectiles){
                        p.render(screen);
                    }
                }

                public boolean isDead(){
                     return projectiles.size() == 0;
                }
}
