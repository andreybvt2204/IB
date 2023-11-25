import java.util.Scanner;
import java.util.Random;

public class Ib_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите индефикатор: ");
        String userInput = scanner.nextLine();

        int len = userInput.length();
        int q = len * len * len % 5 + 1;
        int p = len * len % 6 + 1;

        StringBuilder password = new StringBuilder();
        generate(q, 97, 122, password);
        generate(p, 65, 90, password);
        generate(12 - q - p, 48, 57, password);

        System.out.println("Пароль: " + password);

    }

    private static void generate(int count, int start, int end, StringBuilder password) {
        for (int i = 0; i < count; i ++){
            Random random = new Random();
            int randomNumber = random.nextInt(end - start + 1) + start;
            password.append(Character.toChars(randomNumber));
        }
    }
}
