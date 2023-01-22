import java.util.*;

public class Compound {

    public static void main(String[] args) {

        // Создание системы ввода с клавиатуры.

        System.out.print("Введите строку: ");
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        System.out.println("Исходная строка: \"" + s + "\"");

        // Вызов функции, которая позволяет находить в строке составные слова, состоящие из двух других слов.

        sorting(s);
    }

    private static void sorting(String str) {

        // Создание массива строк, где в качестве делителя строки на слова выступает продвинутое регулярное выражение,
        // которое не только делит слова по пробелам. А также создание LinkedHashSet, который будет хранить составные слова в том порядке,
        // в котором он их найдет и не допустит повторений этих слов.

        String[] list = str.split("([^а-яА-Я]\\s+)|_|\\s|([^а-яА-Я]+$)");
        Set<String> compound_words = new LinkedHashSet<>();

        // Данный цикл позволяет пробежать и проверить все комбинации, содержащихся в массиве слов, если в результате конкатенации
        // выбранного слова list[i] со всеми возможными словами list[j] в массиве дадут слово, содержащееся в исходной строке, то идет добавление
        // этого слова в список составных слов.

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (str.contains(list[i] + list[j]))
                    compound_words.add(list[i] + list[j]);
            }
        }

        // Результат выполнения программы

        if (compound_words.size() > 0)
            System.out.println("Найденные составные слова: " + String.join(", ", compound_words) + ".");
        else
            System.out.println("Составные слова не найдены.");
    }
}
