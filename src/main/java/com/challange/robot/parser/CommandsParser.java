package com.challange.robot.parser;

import com.challange.robot.command.Command;
import com.challange.robot.factory.CommandFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandsParser {

    public List<Command> parse(String commandsString) {
        String[] commandsArray = commandsString.split(System.lineSeparator());
        List<Command> commands = new ArrayList<>();
        for (String command : commandsArray) {
            commands.add(CommandFactory.create(command));
        }
        return commands;
    }
}
