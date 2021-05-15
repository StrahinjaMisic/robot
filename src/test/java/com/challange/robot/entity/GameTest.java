package com.challange.robot.entity;

import com.challange.robot.RobotTestFactory;
import com.challange.robot.command.Command;
import com.challange.robot.command.ForwardCommand;
import com.challange.robot.exception.RobotOutOfGridException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    public void testPlay() {
        List<Command> commands = RobotTestFactory.createCommands();
        Game game = new Game();
        Robot robot = game.play(commands);
        Assertions.assertEquals(3, robot.getPosition().getX());
        Assertions.assertEquals(1, robot.getPosition().getY());
        Assertions.assertEquals(Robot.Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testPlayWhenRobotIsMovedOutOfGrid() {
        List<Command> commands = RobotTestFactory.createCommands();
        commands.add(new ForwardCommand(10));
        Game game = new Game();
        Assertions.assertThrows(RobotOutOfGridException.class, () -> game.play(commands));
    }
}
