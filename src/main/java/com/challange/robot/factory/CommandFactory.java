package com.challange.robot.factory;

import com.challange.robot.command.*;
import com.challange.robot.exception.CommandFormatException;
import com.challange.robot.exception.CommandNotFoundException;

public class CommandFactory {

    private static final String SPACE = " ";

    public static Command create(String command) {
        String[] commandParts = command.split(SPACE);
        try {
            String commandName = commandParts[0];
            switch (commandName) {
                case "POSITION":
                    return new PositionCommand(Integer.valueOf(commandParts[1]), Integer.valueOf(commandParts[2]),
                            commandParts[3]);
                case "FORWARD":
                    return new ForwardCommand(Integer.valueOf(commandParts[1]));
                case "BACKWARD":
                    return new BackwardCommand(Integer.valueOf(commandParts[1]));
                case "LEFT":
                    return new LeftCommand();
                case "RIGHT":
                    return new RightCommand();
                case "TURNAROUND":
                    return new TurnaroundCommand();
                case "WAIT":
                    return new WaitCommand();
                default:
                    throw new CommandNotFoundException(String.format("Command [%s] cannot be executed. " +
                            "Command not found.", command));
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            throw new CommandFormatException(String.format("Command [%s] is not properly formatted.",
                    command), e);
        }
    }
}
