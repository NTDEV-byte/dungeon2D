package com.game.effects;

public class Explosion extends Effect{

        public Explosion(String path , int x,int y, int width,int height){
                super(path,x,y,width,height);
        }

        public Explosion(String path , int x,int y,int width,int height , int maskColor){
                super(path,x,y,width,height,maskColor);
        }



}
