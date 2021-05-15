package com.challange.robot.command;

import com.challange.robot.entity.Robot;

public class PositionCommand implements Command {

    private int x;

    private int y;

    private Robot.Direction direction;

    public PositionCommand(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = Robot.Direction.valueOf(direction);
    }

    @Override
    public void execute(Robot robot) {
        robot.getPosition().addX(x);
        robot.getPosition().setY(y);
        robot.setDirection(direction);
    }
}
