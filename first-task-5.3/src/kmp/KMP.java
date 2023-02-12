package kmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KMP {

    private static final Logger logger = Logger.getLogger(KMP.class.getName());

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        logger.log(Level.INFO, "Введите строку: ");
        String word = input.nextLine();

        logger.log(Level.INFO, "Введите подстроку, которую хотите найти: ");
        String subWord = input.nextLine();

        // Результат выполнения программы.

        Integer[] entries = searchAll(word, subWord);
        logger.log(Level.INFO, "Все индексы вхождения подстроки: {0}", Arrays.toString(entries));

        int amount = count(word, subWord);
        logger.log(Level.INFO, "Количество вхождений подстроки: {0}", amount);
    }

    // Алгоритм Кнута — Морриса — Пратта (КМП-алгоритм). Данный алгоритм позволяет определить, существует ли такая подстрока в такой-то
    // строке. В первую очередь задачей алгоритма является определить количество повторяющихся символов/строк в самой подстроке и записать
    // их целочисленные значения в массив. Например, если есть подстрока abcaby, то ее массив будет выглядить таким образом [0,0,0,1,2,0],
    // поскольку начиная с 3 индекса этой подстроки повторяется символ 'a', который был в самом начале (индекс 0), следовательно, происходит
    // увеличение числа j на 1 и его запись в массив, и он уже будет указывать на символ 'b' в 1 индексе, а i будет указывать на 'b', но
    // уже в 4 индексе. Иначе, если символы не совпадают, то j будет обнуляться. То есть в этой подстроке были найдены длины и символа 'a',
    // и строки 'ab'. Это нужно для того, чтобы в случае несовпадений не перемещаться в самое начало подстроки, а лишь сразу в ту часть, где
    // нужно произвести сравнения. Таким образом и происходит поиск.

    public static int[] prefixIntValues(String subWord) {
        int n = subWord.length();
        int[] values = new int[n];

        for (int i = 1; i < subWord.length(); i++) {
            int j = values[i - 1];
            while (j > 0 && subWord.charAt(i) != subWord.charAt(j))
                j = values[j - 1];

            if (subWord.charAt(i) == subWord.charAt(j))
                j++;

            values[i] = j;
        }
        return values;
    }

    // Метод searchAll показывает все вхождения подстроки.

    public static Integer[] searchAll(String word, String subWord) {
        List<Integer> entries = new ArrayList<>();
        int[] values = prefixIntValues(subWord);
        int j = 0;

        for (int i = 0; i < word.length(); i++) {
            while (j > 0 && word.charAt(i) != subWord.charAt(j))
                j = values[j - 1];

            if (word.charAt(i) == subWord.charAt(j))
                j++;

            if (j >= subWord.length()) {
                entries.add(i - j + 1);
                j = 0;
            }
        }
        return entries.toArray(new Integer[0]);
    }

    // Метод count показывает количество вхождений подстроки.

    public static int count(String word, String subWord) {
        int counter = 0;
        int[] values = prefixIntValues(subWord);
        int j = 0;

        for (int i = 0; i < word.length(); i++) {
            while (j > 0 && word.charAt(i) != subWord.charAt(j))
                j = values[j - 1];

            if (word.charAt(i) == subWord.charAt(j))
                j++;

            if (j >= subWord.length()) {
                counter++;
                j = 0;
            }
        }
        return counter;
    }
}
