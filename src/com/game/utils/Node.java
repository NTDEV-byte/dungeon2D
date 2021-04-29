package com.game.utils;

public class Node {


        private Node parent;
        private Vector2i position;
        private double gCost,hCost,fCost;


            public Node(Node parent,Vector2i position,double gCost,double hCost){
                 this.parent = parent;
                 this.position = position;
                 this.gCost = gCost;
                 this.hCost = hCost;
                 this.fCost = gCost + hCost;
            }


    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Vector2i getPosition() {
        return position;
    }

    public void setPosition(Vector2i position) {
        this.position = position;
    }

    public double getgCost() {
        return gCost;
    }

    public void setgCost(double gCost) {
        this.gCost = gCost;
    }

    public double gethCost() {
        return hCost;
    }

    public void sethCost(double hCost) {
        this.hCost = hCost;
    }

    public double getfCost() {
        return fCost;
    }

    public void setfCost(double fCost) {
        this.fCost = fCost;
    }
}
