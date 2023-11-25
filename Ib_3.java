import java.util.Random;
import java.util.Scanner;

public class Ib_3 {
    public static void main(String[] args) {
        printAlphabets();

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        StringBuilder resultAlphabet = new StringBuilder();

        for (int i = 0; i < userInput.length(); i++) {
            String str = generateSymbol(userInput.charAt(i));
            resultAlphabet.append(str);
            userInput = userInput.replaceAll(String.valueOf(userInput.charAt(i)), "");
        }

        if (resultAlphabet.isEmpty()){
            System.out.println("\nОшибка: не обнаружен ни один алфавит. Перезапустите программу и ведите корректные значения.");
            System.exit(0);
        }

        System.out.println("\nКонечный алфавит: " + resultAlphabet);

        float P = (float) Math.pow(10, -7);
        byte V = 15;
        byte T = 20;
        long S = (long) Math.ceil((V * T * 60 * 24) / P);

        int A = resultAlphabet.length();
        int L = 0;
        while (Math.pow(A, L) < S) {
            L++;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < L; i++){
            char currentChar = resultAlphabet.charAt(random.nextInt(A));
            password.append(currentChar);
        }

        System.out.println("Пароль: " + password);

    }

    private static String generateSymbol(char number) {
        return switch (number) {
            case '1' -> "abcdefghijklmnopqrstuvwxyz";
            case '2' -> "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            case '3' -> "1234567890";
            case '4' -> "!@=#?/.,;:$%^&*";
            case '5' -> "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            case '6' -> "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
            default -> "";
        };
    }

    public static void printAlphabets(){
        System.out.println("Выберите хотя бы один алфавит для генерации пароля:");
        System.out.println("1 - Маленькие латинские буквы");
        System.out.println("2 - Большие латинские буквы");
        System.out.println("3 - Цифры");
        System.out.println("4 - Символы");
        System.out.println("5 - Маленькие русские буквы");
        System.out.println("6 - Большие русские буквы");
        System.out.print("Введите номера выбранных алфавитов без пробелов: ");
    }
}
