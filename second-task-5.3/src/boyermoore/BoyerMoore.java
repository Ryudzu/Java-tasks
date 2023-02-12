package boyermoore;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoyerMoore {

    private static final Logger logger = Logger.getLogger(BoyerMoore.class.getName());

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

    // Алгоритм Бойера-Мура. Данный алгоритм позволяет определить: существует ли такая подстрока в такой-то строке. Принцип работы этого
    // алгоритма заключается в том, что поиск в строке подстроки осуществляется с последнего элемента подстроки (справа-налево) и что также
    // нужно учитывать отдаленность, повторяемость символов в этой подстроке от ее последнего символа. Поэтому в этом случае удобнее всего
    // применить HashMap, записать все символы с 0 по 255 согласно таблице ASCII в качестве ключей и у всех этих ключей будет константная
    // длина переданной подстроки. После чего среди всех этих ключей необходимо изменить значение тем ключам, которые встречаются в подстроке
    // начиная с ее первого символа, который в свою очередь находится дальше всех от самого последнего, следовательно, его значение будет
    // больше предыдущих. При этом последний символ учитывать не нужно, поскольку его значение и так максимально по умолчанию после прохода
    // первого цикла, даже если самый последний символ повторяется при проходе подстроки, то его значение должно быть таким же, как у символа,
    // который с ним совпадет. Далее, имея уже правильные значения, достаточно просто реализовать сам алгоритм на их основе. Поскольку идет
    // просмотр символов справа-налево, то вначале подстроку необходимо сравнивать с основной строкой начиная с длины самой подстроки.
    // В случае несовпадения символов, то подстрока будет сравниваться с символами, чье значение по ключу будет прибавлено к предыдущему.
    // В случае совпадения символов будет осуществляться проход по основной строке и подстроке до того момента, пока либо j
    // не будет меньше нуля или если символы перестанут совпадать.

    public static HashMap<Character, Integer> prefixMapValues(String subWord) {
        HashMap<Character, Integer> values = new HashMap<>();

        for (int i = 0; i < 256; i++)
            values.put((char) i, subWord.length());

        for (int i = 0; i < subWord.length() - 1; i++)
            values.put(subWord.charAt(i), subWord.length() - i - 1);

        return values;
    }

    // Метод searchAll показывает все вхождения подстроки.

    public static Integer[] searchAll(String word, String subWord) {
        HashMap<Character, Integer> values = prefixMapValues(subWord);
        List<Integer> entries = new ArrayList<>();

        int i = subWord.length() - 1;
        int j = i;

        while (j >= 0 && i <= word.length() - 1) {
            j = subWord.length() - 1;
            int k = i;
            while (j >= 0 && word.charAt(k) == subWord.charAt(j)) {
                k--;
                j--;
            }

            if (j == -1) {
                entries.add(k + 1);
                j = 0;
            }

            i += values.get(word.charAt(i));
        }
        return entries.toArray(new Integer[0]);
    }

    // Метод count показывает количество вхождений подстроки.

    public static int count(String word, String subWord) {
        HashMap<Character, Integer> values = prefixMapValues(subWord);
        int counter = 0;

        int i = subWord.length() - 1;
        int j = i;

        while (j >= 0 && i <= word.length() - 1) {
            j = subWord.length() - 1;
            int k = i;
            while (j >= 0 && word.charAt(k) == subWord.charAt(j)) {
                k--;
                j--;
            }

            if (j == -1) {
                counter++;
                j = 0;
            }

            i += values.get(word.charAt(i));
        }
        return counter;
    }
}