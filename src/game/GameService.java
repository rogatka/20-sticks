package game;

import consolehelper.ConsoleHelper;
import entity.Player;
import exception.ThereIsOnlyOnePlayer;
import repository.PlayerRepository;
import service.CurrentPlayerManager;

public class GameService {
    private static int numberOfSticks = 20;
    private static boolean isGameOver;
    PlayerRepository playerRepository;
    private static Player player;

    public GameService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void play() {
        ConsoleHelper.writeMessage("- Игра началась!");
        while (!isGameOver) {
            player = CurrentPlayerManager.getCurrentPlayer();
            int numberOfSticksToTake = player.makeMove();
            while (!checkValidate(numberOfSticksToTake)) {
                ConsoleHelper.writeMessage("Некорректное количество спичек!");
                numberOfSticksToTake = player.makeMove();
            }
            decreaseNumberOfSticks(numberOfSticksToTake);
            checkWin();
            switchPlayer(player);
        }
        ConsoleHelper.writeMessage("Игра окончена! Игрок " + CurrentPlayerManager.getCurrentPlayer().getName() + " проиграл!");
    }

    private boolean checkValidate(int numberOfSticksToTake) {
        return  (numberOfSticksToTake >= 1 &&
                numberOfSticksToTake <= 3 &&
                (GameService.getNumberOfSticks() - numberOfSticksToTake >= 1));
    }

    private void decreaseNumberOfSticks(int number) {
        numberOfSticks -= number;
    }

    private void checkWin() {
        if (numberOfSticks == 1) {
            isGameOver = true;
        }
        else {
            ConsoleHelper.writeMessage("На столе осталось " + numberOfSticks + " спичек.");
        }
    }

    private void switchPlayer(Player thisPlayer) {
        try {
            playerRepository.getNextPlayer(thisPlayer);
        } catch (ThereIsOnlyOnePlayer e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    public static int getNumberOfSticks() {
        return numberOfSticks;
    }

}
