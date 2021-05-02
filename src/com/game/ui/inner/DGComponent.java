package com.game.ui.inner;

import com.game.Game;
import com.game.levels.Level;

import java.awt.*;

public abstract class DGComponent {

        protected Level level = Game.level;
        protected Rectangle bounds;
        protected Color back,fore;
        protected DGLabel label;

                            public DGComponent(){

                            }


                            public DGComponent(Rectangle bounds,Color back){
                                this.bounds = bounds;
                                this.back = back;
                            }


                            public DGComponent(Rectangle bounds){
                                this.bounds = bounds;
                            }

                            protected abstract void update();
                            protected abstract void render(Graphics g);




    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Color getBack() {
        return back;
    }

    public void setBack(Color back) {
        this.back = back;
    }

    public Color getFore() {
        return fore;
    }

    public void setFore(Color fore) {
        this.fore = fore;
    }

    public DGLabel getLabel() {
        return label;
    }

    public void setLabel(DGLabel label) {
        this.label = label;
    }

}
