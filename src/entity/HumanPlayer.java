package entity;

import consolehelper.ConsoleHelper;

public class HumanPlayer extends Player{

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int makeMove() {
        return ConsoleHelper.readInt();
    }


}
