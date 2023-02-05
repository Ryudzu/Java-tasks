package randomfixedlength;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomFixedLengthWords {

    private static final Logger logger = Logger.getLogger(RandomFixedLengthWords.class.getName());
    private static Random rand = new Random();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logger.log(Level.INFO, "Введите размер массива: ");
        int size = input.nextInt();
        logger.log(Level.INFO, "Введите длину слова: ");
        int wordLength = input.nextInt();

        // Результат выполнения программы.

        String[] result = randomFixedLengthWords(size, wordLength);
        logger.log(Level.INFO, "Случайно сгенерированные слова: {0}", Arrays.toString(result));
    }

    // Метод randomFixedLengthWords, принимающий в себя размер массива и фиксированную длину слова. Для каждой ячейки вызывается
    // метод randomString, который генерирует случайное слово.

    public static String[] randomFixedLengthWords(int size, int wordLength) {
        String[] result = new String[size];
        for (int i = 0; i < result.length; i++)
            result[i] = randomString(wordLength);

        return Arrays.stream(result).sorted().toArray(String[]::new);
    }

    // Генерация слова фиксированной длины.

    public static String randomString(int wordLength) {
        StringBuilder rStr = new StringBuilder();

        for (int i = 0; i < wordLength; i++)
            rStr.append((char) (rand.nextInt(26) + 'a'));

        return rStr.toString();
    }
}
