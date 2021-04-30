package com.game.font;

import com.game.gfx.Screen;
import com.game.gfx.Sprite;
import com.game.gfx.SpriteSheet;

public class DGFont {

        private static int SIZE_ALPHA = 8;
        private static SpriteSheet font = new SpriteSheet("/res/fonts/font.png");
        private static String alphabets = "abcdefgh"+//
                                          "ijklmnop"+//
                                          "qrstuvwx"+//
                                          "yz012345"+//
                                          "6789-*!$";
        private static Sprite alphaSprites[] = Sprite.crop(font , 8 , 8);

        private DGFont(){
        }


        public static void showMessage(Screen screen, String message, int xp, int yp){
                for(int i=0;i<message.length();i++){
                        char c = message.charAt(i);
                        int indexAlpha =  alphabets.indexOf(c);
                        if(indexAlpha != -1){
                                screen.renderFont(alphaSprites[indexAlpha] , (xp << 4) + i * SIZE_ALPHA , (yp << 4));
                        }
                }
        }

        public static void WorldMessage(Screen screen, String message, int xp, int yp){
                for(int i=0;i<message.length();i++){
                        char c = message.charAt(i);
                        int indexAlpha =  alphabets.indexOf(c);
                        if(indexAlpha != -1){
                                screen.renderFontWorld(alphaSprites[indexAlpha] , (xp << 4)  + i * SIZE_ALPHA , (yp << 4));
                        }
                }
        }


}
