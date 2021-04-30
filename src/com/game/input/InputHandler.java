package com.game.input;

import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {

    private boolean keys[] = new boolean[2048];
    public boolean up,right,down,left,space,n,p;
    public int x,y,mButton;

    public void update(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_Z];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_Q];
        space = keys[KeyEvent.VK_SPACE];
        n =  keys[KeyEvent.VK_N];
        p =  keys[KeyEvent.VK_P];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
            mButton = e.getButton();
            //System.out.println("pressed !");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
            mButton = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
