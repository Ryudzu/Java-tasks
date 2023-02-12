package uniquesubstring;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniqueSubStrings {

    private static final Logger logger = Logger.getLogger(UniqueSubStrings.class.getName());

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        logger.log(Level.INFO, "Введите строку: ");
        String word = input.nextLine();

        logger.log(Level.INFO,"Введите длину уникальных подстрок: ");
        int size = input.nextInt();

        // Результат выполнения программы.

        String[] subWordsArr = uniqueSubstrings(word, size);
        logger.log(Level.INFO, Arrays.toString(subWordsArr));
    }

    // Метод uniqueSubstrings, который принимает в себя строку и длину подстрок. В этом методе цикл проходит практически каждую
    // букву переданной строки и записывает в строковую переменную subWord подстроку, чья длина равна длине переданной подстроки.
    // Далее идет проверка на то, содержится ли уже эта подстрока в списке subList, если нет - идет добавление ее в список. В
    // добавок вся эта часть с добавлением подстрок была окутана в обработчик исключений поскольку i + size рано или поздно
    // превысит предел самой переданной строки. После цикла идет возврат этого списка подстрок, но уже в качестве отсортированного
    // массива.

    public static String[] uniqueSubstrings(String word, int size) {
        List<String> subList = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            String subWord = "";
            try {
                subWord = subWord.concat(word.substring(i, i + size));
                if (!subList.contains(subWord))
                    subList.add(subWord);
            } catch (Exception e) {
                break;
            }
        }

        return subList.stream().sorted().toArray(String[]::new);
    }
}
