package com.game.gfx;

public class EffectAnimator extends SpriteAnimator{

    private boolean ended;

    public EffectAnimator(Sprite sprites[]){
        super(sprites);
    }

    public void update(){
        if(timer < 7500) timer++; else timer = 0;
        if(timer % rate == 0) {
            if(image < sprites.length - 1) {
                sprite = sprites[image];
                image++;
                }
            else{
                image = 0;
                ended = true;
            }
        }
    }

    public boolean isAnimationEnded(){
        return ended;
    }

}
