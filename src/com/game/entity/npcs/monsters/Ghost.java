package com.game.entity.npcs.monsters;

import com.game.entity.npcs.Mob;
import com.game.gfx.SpriteAnimator;
import com.game.gfx.SpriteSheet;
import com.sun.source.tree.ArrayTypeTree;

public class Ghost extends Mob {

        public enum GHOST_STATES{ATTACK_MODE, VANISH_MODE, MOVEMENT};

        public static final SpriteSheet GHOST_MOVEMENT = new SpriteSheet(0,2,4,1,32,32, SpriteSheet.GHOST);
        public static final SpriteSheet GHOST_VANISH = new SpriteSheet(0,0,9,1,32,32, SpriteSheet.GHOST);
        public static final SpriteSheet GHOST_ATTACK = new SpriteSheet(0,1,6,1,32,32, SpriteSheet.GHOST);



            private SpriteAnimator animator;
            private GHOST_STATES state = GHOST_STATES.MOVEMENT;

                    public Ghost(int x,int y){
                        this.x  = x << 4 ;
                        this.y = y << 4;
                        this.animator = new SpriteAnimator(GHOST_VANISH);
                        this.sprite = GHOST_VANISH.getSprites()[0];
                    }

                    public void updateSprite(){
                        animator.update();
                        sprite = animator.getSprite();
                        changeState();
                    }


                    private void changeState(){
                            int Randstate = (int)(Math.random() * GHOST_STATES.values().length);
                            GHOST_STATES statePicked = GHOST_STATES.values()[Randstate];
                            state = statePicked;

                            if(state ==  GHOST_STATES.ATTACK_MODE){
                                    animator.setSpriteSheet(GHOST_ATTACK);
                            }
                            else if(state == GHOST_STATES.MOVEMENT){
                                    animator.setSpriteSheet(GHOST_MOVEMENT);
                            }

                            else{
                                 animator.setSpriteSheet(GHOST_VANISH);
                            }

                    }


                        public boolean collision(int xDir,int yDir){return false;}

}
