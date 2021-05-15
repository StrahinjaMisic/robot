package com.challange.robot.controller;

import com.challange.robot.command.Command;
import com.challange.robot.entity.Game;
import com.challange.robot.entity.Robot;
import com.challange.robot.parser.CommandsParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/robot")
public class RobotController {

    private final CommandsParser commandsParser;

    public RobotController(CommandsParser commandsParser) {
        this.commandsParser = commandsParser;
    }

    @PostMapping(path = "/move", consumes = MediaType.TEXT_PLAIN_VALUE)
    public Robot move(@RequestBody String commandsString) {
        List<Command> commands = commandsParser.parse(commandsString);
        Game game = new Game();
        return game.play(commands);
    }
}
