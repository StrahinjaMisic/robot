package com.challange.robot.entity;

public class Grid {

    private int maxX;

    private int maxY;
    
    public Grid() {
        this.maxX = 4;
        this.maxY = 4;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
    
    public boolean isRobotOutOfGrid(Robot robot) {
        return getMaxX() < robot.getPosition().getX() || getMaxY() < robot.getPosition().getY() ||
                0 > robot.getPosition().getX() || 0 > robot.getPosition().getY();
    }
}
