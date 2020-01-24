package entity;

import consolehelper.ConsoleHelper;
import game.GameService;

public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        super("Computer");
    }

    @Override
    public int makeMove() {
        int numberOfSticksLeft = GameService.getNumberOfSticks();
        int numberOfSticksToTakeByComputer;
        if (numberOfSticksLeft % 4 == 2) {
            numberOfSticksToTakeByComputer = 1;
        }
        else if (numberOfSticksLeft % 4 == 3) {
            numberOfSticksToTakeByComputer = 2;
        }
        else if (numberOfSticksLeft % 4 == 0) {
            numberOfSticksToTakeByComputer = 3;
        }
        else {
            numberOfSticksToTakeByComputer = (int) (Math.random()*3 + 1);
        }
        ConsoleHelper.writeMessage(" - Количество выбранных компьютером спичек: " + numberOfSticksToTakeByComputer);
        return numberOfSticksToTakeByComputer;
    }
}
