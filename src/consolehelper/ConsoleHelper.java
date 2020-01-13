package consolehelper;

import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        ConsoleHelper.writeMessage(" - Ход игрока. Введите количество спичек: ");
        int number = 0;
        boolean isCorrect = false;
        while (!isCorrect) {
            String line = scanner.nextLine();
            try {
                number = Integer.parseInt(line);
            }
            catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Вы ввели не число. Повторите попытку.");
                number = readInt();
            }
            isCorrect = true;
        }
        return number;
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

}
