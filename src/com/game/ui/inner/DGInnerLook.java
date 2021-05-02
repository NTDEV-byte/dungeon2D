package com.game.ui.inner;

import com.game.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DGInnerLook {

            public static final int PANEL_WIDTH = 200;
            public static final int PANEL_HEIGHT = Game.getHeightWindow();

            public static DGInnerLook look = new DGInnerLook();
            private static DGPanel panel;

            static{
                panel = new DGPanel(new Rectangle(Game.getWidthWindow()  - PANEL_WIDTH , 0 , PANEL_WIDTH , PANEL_HEIGHT) ,  Color.DARK_GRAY);
                panel.addComponent(new DGMap());
                look.addPanel(panel);
            }


           private List<DGPanel> panels = new ArrayList<DGPanel>();


            private DGInnerLook(){

            }

            public void update(){
                for(DGPanel p : panels){
                    p.update();
                }
            }

            public void render(Graphics g){
                for(DGPanel p : panels){
                    p.render(g);
                }
            }

            public void addPanel(DGPanel panel){
                    panels.add(panel);
            }


    public List<DGPanel> getPanels() {
        return panels;
    }

    public void setPanels(List<DGPanel> panels) {
        this.panels = panels;
    }
}
