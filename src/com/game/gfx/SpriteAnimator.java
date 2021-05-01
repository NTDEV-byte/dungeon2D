package com.game.gfx;

public class SpriteAnimator {

    protected int timer;
    protected int rate;
    protected int image;
    protected Sprite sprite;
    protected SpriteSheet spriteSheet;
    protected Sprite sprites[];



         public SpriteAnimator(SpriteSheet sheet){
                    this.spriteSheet = sheet;
                    this.rate = 15;
                    this.sprite = sheet.getSprites()[0];
                }

                public SpriteAnimator(Sprite sprites[]){
                    this.rate = 5;
                    this.sprites = sprites;
                    this.sprite = sprites[0];
                }

            public void update(){
                    if(timer < 7500) timer++; else timer = 0;
                    if(timer % rate == 0) {
                        if(image < spriteSheet.getSprites().length - 1) {
                                sprite = spriteSheet.getSprites()[image];
                                image++;
                        }
                        else{
                            image = 0;
                        }
                    }
                }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }
    public void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }
    public void setRate(int rate){
        this.rate = rate;
    }
    public Sprite getSprite(){
        return sprite;
    }
}
