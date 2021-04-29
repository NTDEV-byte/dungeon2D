package com.game.gfx;

public class SpriteAnimator {

    private int timer;
    private int rate;
    private int image;
    private Sprite sprite;
    private SpriteSheet spriteSheet;

         public SpriteAnimator(SpriteSheet sheet){
                    this.spriteSheet = sheet;
                    this.rate = 15;
                    this.sprite = sheet.getSprites()[0];
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
