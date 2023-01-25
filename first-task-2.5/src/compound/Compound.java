package compound;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compound {

    private static final Logger logger = Logger.getLogger(Compound.class.getName());

    public static void main(String[] args) {

        // Создание системы ввода с клавиатуры.
        logger.log(Level.INFO, () -> "Введите строку: ");
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        logger.log(Level.INFO, () -> "Исходная строка: \"" + s + "\"");

        // Вызов функции, которая позволяет находить в строке составные слова, состоящие из двух других слов.

        sorting(s);
    }

    private static void sorting(String str) {

        // Создание массива строк, где в качестве делителя строки на слова выступает продвинутое регулярное выражение,
        // которое не только делит слова по пробелам. А также создание LinkedHashSet, который будет хранить составные слова в том порядке,
        // в котором он их найдет и не допустит повторений этих слов.

        String[] list = str.split("([^а-яА-Я]\\s+)|_|\\s|([^а-яА-Я]+$)");
        Set<String> compoundWords = new LinkedHashSet<>();

        // Данный цикл позволяет пробежать и проверить все комбинации, содержащихся в массиве слов, если в результате конкатенации
        // выбранного слова list[i] со всеми возможными словами list[j] в массиве дадут слово, содержащееся в исходной строке, то идет добавление
        // этого слова в список составных слов.

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (str.contains(list[i] + list[j]))
                    compoundWords.add(list[i] + list[j]);
            }
        }

        // Результат выполнения программы

        if (!compoundWords.isEmpty())
            logger.log(Level.INFO, () -> "Найденные составные слова: " + String.join(", ", compoundWords) + ".");
        else
            logger.log(Level.INFO, () -> "Составные слова не найдены.");
    }
}
