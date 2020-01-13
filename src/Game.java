import entity.ComputerPlayer;
import entity.HumanPlayer;
import entity.Player;
import game.GameService;
import repository.PlayerRepository;
import service.CurrentPlayerManager;

public class Game {
    public static void main(String[] args) {
        Player humanPlayer = new HumanPlayer("Human");
        Player computerPlayer = new ComputerPlayer();
        PlayerRepository repository = new PlayerRepository();
        repository.addNewPlayer(humanPlayer);
        repository.addNewPlayer(computerPlayer);
        CurrentPlayerManager.setCurrentPlayer(computerPlayer);
        GameService gameService = new GameService(repository);
        gameService.play();
    }
}
