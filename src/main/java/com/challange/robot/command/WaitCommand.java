package com.challange.robot.command;

import com.challange.robot.entity.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaitCommand.class);

    @Override
    public void execute(Robot robot) {
        LOGGER.info(String.format("Robot is waiting at position x: %s, y: %s", robot.getPosition().getX(),
                robot.getPosition().getY()));
    }
}
