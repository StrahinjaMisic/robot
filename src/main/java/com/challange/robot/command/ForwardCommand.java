package com.challange.robot.command;

import com.challange.robot.entity.Robot;

public class ForwardCommand implements Command {

    private int steps;

    public ForwardCommand(int steps) {
        this.steps = steps;
    }

    @Override
    public void execute(Robot robot) {
        switch (robot.getDirection()) {
            case EAST:
                robot.getPosition().addX(steps);
                break;
            case WEST:
                robot.getPosition().subtractX(steps);
                break;
            case NORTH:
                robot.getPosition().subtractY(steps);
                break;
            case SOUTH:
                robot.getPosition().addY(steps);
                break;
        }
    }
}
