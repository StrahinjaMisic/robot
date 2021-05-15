package com.challange.robot.command;

import com.challange.robot.entity.Robot;

public class LeftCommand implements Command {

    @Override
    public void execute(Robot robot) {
        switch (robot.getDirection()) {
            case EAST:
                robot.setDirection(Robot.Direction.NORTH);
                break;
            case WEST:
                robot.setDirection(Robot.Direction.SOUTH);
                break;
            case NORTH:
                robot.setDirection(Robot.Direction.WEST);
                break;
            case SOUTH:
                robot.setDirection(Robot.Direction.EAST);
                break;
        }
    }
}
