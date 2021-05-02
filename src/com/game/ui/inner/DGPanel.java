package com.game.ui.inner;

import java.awt.*;
import java.rmi.dgc.DGC;
import java.util.ArrayList;
import java.util.List;

public class DGPanel extends DGComponent{

    private List<DGComponent> components;


    public DGPanel(Rectangle bounds, Color back){
        super(bounds,back);
        components = new ArrayList<>();
    }

    public void addComponent(DGComponent component){
            makeRelatif(component);
            components.add(component);
    }

    private void makeRelatif(DGComponent component){
        component.getBounds().x+=this.bounds.x;
        component.getBounds().y+=this.bounds.y;
    }

    @Override
    protected void update() {
        for(DGComponent dgc: components){
            dgc.update();
        }
    }

    @Override
    protected void render(Graphics g) {
        g.setColor(back);
        g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
        for(DGComponent dgc: components){
                dgc.render(g);
        }
    }
}
