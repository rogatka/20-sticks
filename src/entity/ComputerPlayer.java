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
        /*
        switch (GameLogic.getNumberOfSticks()) {
            case 2: case 6: case 10: case 14: case 18:
                ConsoleHelper.writeMessage("Компьютер взял спичек: " + 1);
                return 1;
            case 3: case 7: case 11: case 15: case 19:
                ConsoleHelper.writeMessage("Компьютер взял спичек: " + 2);
                return 2;
            case 4: case 8: case 12: case 16: case 20:
                ConsoleHelper.writeMessage("Компьютер взял спичек: " + 3);
                return 3;
            default:
                int someNumber = (int) (Math.random()*4);
                ConsoleHelper.writeMessage("Компьютер взял спичек: " + someNumber);
                return someNumber;
        }

         */
    }
}
