package com.challange.robot.controller;

import com.challange.robot.RobotTestFactory;
import com.challange.robot.command.Command;
import com.challange.robot.command.ForwardCommand;
import com.challange.robot.exception.CommandFormatException;
import com.challange.robot.exception.CommandNotFoundException;
import com.challange.robot.exception.GlobalExceptionHandler;
import com.challange.robot.parser.CommandsParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RobotControllerTest {

    @Mock
    private CommandsParser commandsParser;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RobotController(commandsParser))
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    public void testMoveRobot() throws Exception {
        when(commandsParser.parse(anyString())).thenReturn(RobotTestFactory.createCommands());
        this.mockMvc.perform(post("/robot/move")
                .contentType(MediaType.TEXT_PLAIN)
                .content(RobotTestFactory.getCommands()))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"position\":{\"x\":3,\"y\":1}, \"direction\":\"NORTH\"}"));
    }

    @Test
    public void testMoveRobotWhenRobotOutOfGridExceptionIsThrown() throws Exception {
        List<Command> commands = RobotTestFactory.createCommands();
        commands.add(new ForwardCommand(10));
        when(commandsParser.parse(anyString())).thenReturn(commands);
        this.mockMvc.perform(post("/robot/move")
                .contentType(MediaType.TEXT_PLAIN)
                .content(RobotTestFactory.getCommands()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMoveRobotWhenCommandNotFoundExceptionIsThrown() throws Exception {
        when(commandsParser.parse(anyString())).thenThrow(CommandNotFoundException.class);
        this.mockMvc.perform(post("/robot/move")
                .contentType(MediaType.TEXT_PLAIN)
                .content(RobotTestFactory.getCommands()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMoveRobotWhenCommandFormatException() throws Exception {
        when(commandsParser.parse(anyString())).thenThrow(CommandFormatException.class);
        this.mockMvc.perform(post("/robot/move")
                .contentType(MediaType.TEXT_PLAIN)
                .content(RobotTestFactory.getCommands()))
                .andExpect(status().isBadRequest());
    }
}
