package com.game.utils;

import com.game.entity.Entity;

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

            public Vector2i(Entity e){
                 this.x = e.getX();
                 this.y = e.getY();
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


            public int distance(Vector2i vector){
                int dx = vector.x - this.x;
                int dy = vector.y - this.y;
                return (int)(Math.sqrt(dx * dx + dy * dy));
            }



            public boolean colliding(Vector2i entity){
                  return this.x == entity.x && this.y == entity.y;
            }

            public boolean equals(Object obj){
                if(!(obj instanceof Vector2i)) return false;
                Vector2i vector = (Vector2i)    obj;
                return this.x == vector.x && this.y == vector.y;
             }
}
