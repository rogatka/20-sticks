package exception;

public class ThereIsOnlyOnePlayer extends Exception {
    String message;
    public ThereIsOnlyOnePlayer(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
