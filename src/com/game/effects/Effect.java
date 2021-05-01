package com.game.effects;

import com.game.entity.Entity;
import com.game.entity.VisibleObj;
import com.game.gfx.*;

public class Effect extends Entity {

        public static Effect CIRCLE = new Explosion("/res/effects/Explosion.png" , 0 , 0 , 96 , 96);


        private SpriteSheet sheet;
        private Sprite sprites[];
        private EffectAnimator animator;
        private int maskColor = 0xffff00ff;


                public Effect(String path ,int x,int y,int width,int height){
                    this.x = x;
                    this.y = y;
                    sheet = new SpriteSheet(path);
                    sprites = Sprite.crop(sheet,width,height);
                    animator = new EffectAnimator(sprites);
                }

                public Effect(String path ,  int x,int y,int width,int height,int maskColor){
                    this.x = x;
                    this.y = y;
                    sheet = new SpriteSheet(path);
                    sprites = Sprite.crop(sheet,width,height);
                    animator = new EffectAnimator(sprites);
                    this.maskColor = maskColor;
                }

                public void update(){
                    animator.update();
                    if(animator.isAnimationEnded()) remove();
                }


    @Override
    public void render(Screen screen) {
        screen.renderSprite(this, getX() , getY() , maskColor);
    }

    public Sprite getSprite(){
         return animator.getSprite();
    }

}
