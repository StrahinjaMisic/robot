package com.challange.robot.entity;

import com.challange.robot.command.Command;
import com.challange.robot.exception.RobotOutOfGridException;

import java.util.List;

public class Game {

    private Grid grid;

    private Robot robot;

    public Game() {
        this.grid = new Grid();
        this.robot = new Robot();
    }

    public Grid getGrid() {
        return grid;
    }

    public Robot getRobot() {
        return robot;
    }

    public Robot play(List<Command> commands) {
        for (Command command : commands) {
            command.execute(getRobot());
            if (getGrid().isRobotOutOfGrid(getRobot())) {
                throw new RobotOutOfGridException("Robot moved out of the grid. Try again.");
            }
        }
        return getRobot();
    }
}
