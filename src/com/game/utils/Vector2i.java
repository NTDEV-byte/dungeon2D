package com.game.utils;

import java.util.Vector;

public class Vector2i {

        public int x,y;


            public Vector2i(int x,int y){
                this.x = x;
                this.y = y;
            }

            public Vector2i(Vector2i vector){
                 this.x = vector.x;
                 this.y = vector.y;
            }

            public Vector2i add(int amnt){
                return new Vector2i(x + amnt, y + amnt);
            }

            public Vector2i add(Vector2i vector){
                return new Vector2i(x + vector.x , y + vector.y);
            }

            public Vector2i substract(int amnt){
                return new Vector2i(x - amnt, y - amnt);
            }

            public Vector2i substract(Vector2i vector){
                return new Vector2i(x - vector.x , y - vector.y);
            }


            public boolean equals(Object obj){
                if(!(obj instanceof Vector2i)) return false;

                Vector2i vector = (Vector2i)    obj;

                return this.x == vector.x && this.y == vector.y;
             }
}
