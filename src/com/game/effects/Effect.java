package com.game.effects;

import com.game.entity.Entity;
import com.game.gfx.*;

public class Effect extends Entity {

        public static Effect EXPLOSION_EFFECT = new Explosion("/res/effects/Explosion.png" , 0 , 0 , 96 , 96);
        public static Effect TELEPORTAION_EFFECT = new Teleportation("/res/effects/portal.png", 0 , 0 ,127,64);

        private SpriteSheet sheet;
        private Sprite sprites[];
        private EffectAnimator animator;
        private int maskColor = 0xffff00ff;

                protected Effect(String path ,int x,int y,int width,int height){
                    this.x = x;
                    this.y = y;
                    sheet = new SpriteSheet(path);
                    sprites = Sprite.crop(sheet,width,height);
                    animator = new EffectAnimator(sprites);
                }


                 protected Effect(String path , int x,int y,int width,int height,int maskColor){
                        this.x = x;
                        this.y = y;
                        sheet = new SpriteSheet(path);
                        sprites = Sprite.crop(sheet,width,height);
                        animator = new EffectAnimator(sprites);
                        this.maskColor = maskColor;
                    }

                public Effect(Effect effect , int x, int y, int width,int height){
                    this.x = x;
                    this.y = y;
                    sheet = effect.sheet;
                    sprites = Sprite.crop(sheet,width,height);
                    animator = new EffectAnimator(sprites);
                    this.maskColor = maskColor;
                }

                public Effect(Effect effect , int x, int y, int width,int height ,int maskColor){
                    this.x = x;
                    this.y = y;
                    sheet = effect.sheet;
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

    public SpriteSheet getSheet() {
        return sheet;
    }

    public void setSheet(SpriteSheet sheet) {
        this.sheet = sheet;
    }

    public Sprite[] getSprites() {
        return sprites;
    }

    public void setSprites(Sprite[] sprites) {
        this.sprites = sprites;
    }

    public EffectAnimator getAnimator() {
        return animator;
    }

    public void setAnimator(EffectAnimator animator) {
        this.animator = animator;
    }

    public int getMaskColor() {
        return maskColor;
    }

    public void setMaskColor(int maskColor) {
        this.maskColor = maskColor;
    }


}
