package com.game.ui.inner;

import java.awt.*;

public class DGHealthBar extends DGComponent{

    private float pourcentage = 1.0f;

                public DGHealthBar(Rectangle bounds , Color back){
                     super(bounds , back);
                }

        @Override
        protected void update() {

        }

        private int getProgression(){
        return (int)(bounds.width * pourcentage) ;
        }

        @Override
        protected void render(Graphics g) {
                    g.setColor(back);
                    g.fillRect(bounds.x , bounds.y , getProgression() , bounds.height);
        }
}
