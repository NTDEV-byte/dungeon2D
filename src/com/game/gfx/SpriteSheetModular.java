package com.game.gfx;

public class SpriteSheetModular {

            // createSpriteSheet with respecting the order up , right , down , left
            // even if the spriteSheet is setUp differently
            // see example in lucifer class Constructor

            private SpriteSheet up;
            private SpriteSheet right;
            private SpriteSheet down;
            private SpriteSheet left;

                        public SpriteSheetModular(SpriteSheet up , SpriteSheet right,SpriteSheet down,SpriteSheet left){
                             this.up = up;
                             this.right = right;
                             this.down = down;
                             this.left = left;
                        }


    public SpriteSheet getUp() {
        return up;
    }

    public void setUp(SpriteSheet up) {
        this.up = up;
    }

    public SpriteSheet getRight() {
        return right;
    }

    public void setRight(SpriteSheet right) {
        this.right = right;
    }

    public SpriteSheet getDown() {
        return down;
    }

    public void setDown(SpriteSheet down) {
        this.down = down;
    }

    public SpriteSheet getLeft() {
        return left;
    }

    public void setLeft(SpriteSheet left) {
        this.left = left;
    }
}
