package com.challange.robot;

import com.challange.robot.command.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RobotTestFactory {

    public static List<Command> createCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new PositionCommand(1, 3, "EAST"));
        commands.add(new ForwardCommand(3));
        commands.add(new WaitCommand());
        commands.add(new TurnaroundCommand());
        commands.add(new ForwardCommand(1));
        commands.add(new RightCommand());
        commands.add(new ForwardCommand(2));
        return commands;
    }

    public static String getCommands() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/data/commands.txt")));
    }
}
