package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    private boolean keys[] = new boolean[2048];
    public boolean up,right,down,left,space;


    public void update(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_Z];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_Q];
        space = keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
