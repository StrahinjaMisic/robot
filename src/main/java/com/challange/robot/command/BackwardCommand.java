package com.challange.robot.command;

import com.challange.robot.entity.Robot;

public class BackwardCommand implements Command {

    private int steps;

    public BackwardCommand(int steps) {
        this.steps = steps;
    }

    @Override
    public void execute(Robot robot) {
        switch (robot.getDirection()) {
            case EAST:
                robot.getPosition().subtractX(steps);
                break;
            case WEST:
                robot.getPosition().addX(steps);
                break;
            case NORTH:
                robot.getPosition().addY(steps);
                break;
            case SOUTH:
                robot.getPosition().subtractY(steps);
                break;
        }
    }
}
