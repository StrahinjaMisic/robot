package com.challange.robot.command;

import com.challange.robot.RobotTestFactory;
import com.challange.robot.exception.CommandFormatException;
import com.challange.robot.exception.CommandNotFoundException;
import com.challange.robot.parser.CommandsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CommandParserTest {

    @InjectMocks
    private CommandsParser commandsParser;

    @Test
    public void testParse() throws IOException {
        String commandsString = RobotTestFactory.getCommands();
        List<Command> commands = commandsParser.parse(commandsString);
        Assertions.assertEquals(7, commands.size());
    }

    @Test
    public void testParseWhenUnknownCommandIsPassed() {
        String commandsString = "SOME COMMAND";
        Assertions.assertThrows(CommandNotFoundException.class, () -> commandsParser.parse(commandsString));
    }

    @Test
    public void testParseWhenPositionCommandFormattingIsIncorrect() {
        Assertions.assertThrows(CommandFormatException.class, () ->
                commandsParser.parse("POSITION 3 N NORTH"));

        Assertions.assertThrows(CommandFormatException.class, () ->
                commandsParser.parse("POSITION 3 1 BB"));

        Assertions.assertThrows(CommandFormatException.class, () ->
                commandsParser.parse("POSITION"));
    }

    @Test
    public void testParseWhenForwardCommandIsMissingNumberOfSteps() {
        Assertions.assertThrows(CommandFormatException.class, () ->
                commandsParser.parse("FORWARD"));

        Assertions.assertThrows(CommandFormatException.class, () ->
                commandsParser.parse("FORWARD N"));
    }

    @Test
    public void testParseWhenBackwardCommandIsMissingNumberOfSteps() {
        Assertions.assertThrows(CommandFormatException.class, () ->
                commandsParser.parse("BACKWARD"));

        Assertions.assertThrows(CommandFormatException.class, () ->
                commandsParser.parse("BACKWARD N"));
    }
}
