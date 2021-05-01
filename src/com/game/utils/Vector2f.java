package com.game.utils;

import com.game.entity.Entity;

public class Vector2f {

    public float x,y;


    public Vector2f(float x,float y){
        this.x = x;
        this.y = y;
    }

    public Vector2f(Vector2i vector){
        this.x = vector.x;
        this.y = vector.y;
    }

    public Vector2f(Entity e){
        this.x = e.getX();
        this.y = e.getY();
    }


    public Vector2f add(float amnt){
        return new Vector2f(x + amnt, y + amnt);
    }

    public Vector2f add(Vector2f vector){
        return new Vector2f(x + vector.x , y + vector.y);
    }

    public Vector2f substract(float amnt){
        return new Vector2f(x - amnt, y - amnt);
    }


    public Vector2f substract(Vector2f vector){
        return new Vector2f(x - vector.x , y - vector.y);
    }


    public float distance(Vector2f vector){
        float dx = vector.x - this.x;
        float dy = vector.y - this.y;
        return (float)(Math.sqrt(dx * dx + dy * dy));
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
