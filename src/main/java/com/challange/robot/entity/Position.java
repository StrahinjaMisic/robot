package com.challange.robot.entity;

public class Position {

    private int x;

    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addX(int x) {
        this.x += x;
    }

    public void subtractX(int x) {
        this.x -= x;
    }

    public void addY(int y) {
        this.y += y;
    }

    public void subtractY(int y) {
        this.y -= y;
    }
}
