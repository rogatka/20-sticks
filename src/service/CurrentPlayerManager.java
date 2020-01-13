package service;

import entity.Player;

public class CurrentPlayerManager {

    private static Player currentPlayer;

    private CurrentPlayerManager() {}

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        CurrentPlayerManager.currentPlayer = currentPlayer;
    }
}
