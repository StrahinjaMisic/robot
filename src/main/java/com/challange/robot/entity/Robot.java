package com.challange.robot.entity;

public class Robot {

    private Position position;

    private Direction direction;

    public Robot() {
        this.position = new Position(0, 0);
        this.direction = Direction.EAST;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public enum Direction {
        EAST, WEST, NORTH, SOUTH
    }
}
