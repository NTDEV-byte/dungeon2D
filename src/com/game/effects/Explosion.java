package com.game.effects;

public class Explosion extends Effect{

        public static final int EXPLOSION_MASK = 0xffaf6b26;

        public Explosion(String path , int x,int y, int width,int height){
                super(path,x,y,width,height);
        }

        public Explosion(String path , int x,int y,int width,int height , int maskColor){
                super(path,x,y,width,height,maskColor);
        }



}
