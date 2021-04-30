package com.game.utils;

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


            private static int clamp(int value , int min , int max){
                if(value < min) value = min;
                if(value > max) value = max;
                return value;
            }
}
