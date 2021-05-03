package com.game.levels.interactions;

import com.game.Game;
import com.game.entity.Entity;
import com.game.font.DGFont;

public class Wondering implements Interaction{

    @Override
    public void interact(Entity entity) {
        DGFont.showMessage(Game.game.getScreen() , "What's the heck is this !" , entity.getX() , entity.getY());
    }

}
