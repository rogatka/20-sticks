package repository;

import consolehelper.ConsoleHelper;
import entity.Player;
import exception.ThereIsOnlyOnePlayer;
import service.CurrentPlayerManager;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private List<Player> playerDatabase = new ArrayList<>();

    public void addNewPlayer(Player player) {
        if (playerDatabase.contains(player)) {
            ConsoleHelper.writeMessage("Такой игрок уже есть!");
        }
        else {
            playerDatabase.add(player);
        }
    }

    public void getNextPlayer(Player thisPlayer) throws ThereIsOnlyOnePlayer {
        if (playerDatabase.size() == 1) throw new ThereIsOnlyOnePlayer("В базе есть только один игрок");
        int thisPlayerIndex = playerDatabase.indexOf(thisPlayer);
        Player nextPlayer;
        if (thisPlayerIndex == playerDatabase.size() - 1) {
            nextPlayer = playerDatabase.get(0);
        }
        else {
            nextPlayer = playerDatabase.get(thisPlayerIndex + 1);
        }
        CurrentPlayerManager.setCurrentPlayer(nextPlayer);
    }
}
