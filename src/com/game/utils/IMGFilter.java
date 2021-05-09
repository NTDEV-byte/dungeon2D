package com.game.utils;

import com.game.gfx.Sprite;

import java.awt.image.BufferedImage;

public class IMGFilter {


            private void ImageUtils(){

            }

            public static void brighten(BufferedImage image , float factor){
                int width = image.getWidth();
                int height = image.getHeight();
                int pixels[] = new int[width * height];
                // we get the pixels of the image
                image.getRGB(0,0,width,height,pixels,0,width);

                for(int i=0;i<pixels.length;i++){

                    int pixel = pixels[i];
                    int r = (pixel & 0xff0000) >> 16;
                    int g = (pixel & 0xff00) >> 8;
                    int b = (pixel & 0xff);

                    r*=factor;
                    g*=factor;
                    b*=factor;

                    // we make sure than the values are between 0 - 255
                    r = clamp(r , 0x0 , 0xff);
                    g = clamp(g , 0x0 , 0xff);
                    b = clamp(b , 0x0 , 0xff);

                    pixels[i] = (r << 16 | g << 8 | b);
                }
            }


            public static void brighten(int pixels[] , float factor) {
                for (int i = 0; i < pixels.length; i++) {

                    int pixel = pixels[i];
                    int r = (pixel & 0xff0000) >> 16;
                    int g = (pixel & 0xff00) >> 8;
                    int b = (pixel & 0xff);

                    r *= factor;
                    g *= factor;
                    b *= factor;

                    // we make sure than the values are between 0 - 255
                    r = clamp(r, 0x0, 0xff);
                    g = clamp(g, 0x0, 0xff);
                    b = clamp(b, 0x0, 0xff);

                    pixels[i] = (r << 16 | g << 8 | b);
                }
            }

            public static void brighten(Sprite sprite,float factor){
                int pixels[] = sprite.getPixels();
                for (int i = 0; i < pixels.length; i++) {
                    int pixel = pixels[i];
                    int r = (pixel & 0xff0000) >> 16;
                    int g = (pixel & 0xff00) >> 8;
                    int b = (pixel & 0xff);

                    r *= factor;
                    g *= factor;
                    b *= factor;

                    // we make sure than the values are between 0 - 255
                    r = clamp(r, 0x0, 0xff);
                    g = clamp(g, 0x0, 0xff);
                    b = clamp(b, 0x0, 0xff);

                    pixels[i] = (r << 16 | g << 8 | b);
                }
            }

            public static int calculateColor(int color , int r,int g,int b){
                int rc = (color & 0xff0000) >> 16;
                int gc = (color & 0xff00) >> 8;
                int bc = (color & 0xff);

                rc+=r;
                gc+=g;
                bc+=b;

                rc = clamp(rc , 0  , 255);
                gc = clamp(gc , 0 , 255);
                bc = clamp(bc , 0 , 255);

                return rc << 16 | gc << 8 | bc;
            }

            private static int clamp(int value , int min , int max){
                if(value < min) value = min;
                if(value > max) value = max;
                return value;
            }
}
