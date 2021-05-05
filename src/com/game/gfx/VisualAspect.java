package com.game.gfx;

import com.game.entity.npcs.Mob;

public class VisualAspect {

        private SpriteSheet up;
        private SpriteSheet right;
        private SpriteSheet down;
        private SpriteSheet left;
        private SpriteAnimator animator;
        private Sprite sprite;

                    public VisualAspect(SpriteSheet spriteSheetBase){
                      up = new SpriteSheet(0,0,4,1,32,32,spriteSheetBase);
                      right = new SpriteSheet(0,1,4,1,32,32,spriteSheetBase);
                      down = new SpriteSheet(0,2,4,1,32,32,spriteSheetBase);
                      left = new SpriteSheet(0,3,4,1,32,32,spriteSheetBase);
                      animator = new SpriteAnimator(down);
                      sprite = animator.getSprite();

                    }


                    public VisualAspect(SpriteSheetModular modular){
                        up =  modular.getUp();
                        right = modular.getRight();
                        down = modular.getDown();
                        left = modular.getLeft();
                        animator = new SpriteAnimator(down);
                        sprite = animator.getSprite();

                    }


                    public void animate(int direction){
                         switch(direction) {
                             case Mob.UP:
                                animator.setSpriteSheet(up);
                                 break;
                             case Mob.RIGHT:
                                 animator.setSpriteSheet(right);
                                 break;
                             case Mob.DOWN:
                                 animator.setSpriteSheet(down);
                                 break;
                             case Mob.LEFT:
                                 animator.setSpriteSheet(left);

                                 break;
                         }
                        animator.update();
                        sprite = animator.getSprite();
                    }


                    public Sprite getSprite(){
                        return sprite;
                    }


}
