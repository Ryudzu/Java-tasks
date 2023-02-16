package cyclepermutation;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclePermutation {

    private static final Logger logger = Logger.getLogger(CyclePermutation.class.getName());

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        logger.log(Level.INFO, "Введите строку: ");
        String word = input.nextLine();

        logger.log(Level.INFO, "Введите строку, в котором циклическая перестановка будет совпадать с первой строкой: ");
        String cycleWord = input.nextLine();

        // Результат выполнения программы.

        logger.log(Level.INFO, "{0}", isCycleWord(word, cycleWord));
    }

    // Метод isCycleWord проверяет, является ли строка циклической перестановкой другой строки. Первым делом необходимо разбить строку на
    // массив символов и создать пустую результирующую переменную типа String. Далее создать цикл while, который будет отслежить является ли
    // полученный результат циклической перестановкой другой строки и является ли результат равным первоначальной строке, с которой производилась
    // циклическая перестановка. Если первое условие false, значит было найдено слово с циклической перестановкой, если второе условие false, то
    // не найдено. Сам алгоритм циклической перестановки заключается в том, чтобы значение предыдущего элемента в массиве менять на значение
    // последующего, при этом важно сохранять самый первый элемент в массиве, поскольку его нужно записывать в самый конец. После чего в конце
    // происходит конвертация массива типа char в строку.

    public static boolean isCycleWord(String word, String cycleWord) {
        char[] charsCycleWord = cycleWord.toCharArray();
        String result = "";
        while (!result.equals(word) && !result.equals(cycleWord)) {
            char first = charsCycleWord[0];
            for (int i = 1; i < cycleWord.length(); i++)
                charsCycleWord[i - 1] = charsCycleWord[i];

            charsCycleWord[cycleWord.length() - 1] = first;
            result = String.valueOf(charsCycleWord);
        }

        if (result.equals(word)) {
            logger.log(Level.INFO, "Слово является циклической перестановкой другого.");
            return true;
        }
        else {
            logger.log(Level.INFO, "Слово не является циклической перестановкой другого.");
            return false;
        }
    }
}

