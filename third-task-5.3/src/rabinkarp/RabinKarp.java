package rabinkarp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RabinKarp {

    private static final Logger logger = Logger.getLogger(RabinKarp.class.getName());

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

    // Алгоритм Рабина-Карпа. Данный алгоритм позволяет определить: существует ли такая подстрока в такой-то строке. Принцип работы этого алгоритма
    // заключается в том, что поиск подстроки осуществляется по вычисленному хешу через определенные формулы. Первым делом необходимо вычислить
    // хеш самой подстроки и хеш начала строки, равной длине подстроки. При этом, чтобы избежать большое количество коллизий, было взято R = 256,
    // которое будет умножаться на этот хеш и mod = word.length(), чтобы не было переполнения, но, желательно, чтобы это число было достаточно большим
    // и простым. Далее идет сравнение хешей и подстрок, если хеши совпали - идет сравнение подстрок, в противном случае - высчитывается хеш для
    // следующей подстроки, для этого достаточно из изначального хеша подстроки вычесть хеш первого символа и после чего прибавить хеш следующего, тем
    // самым находится хеш следующей подстроки и таким образом идет проверка на совпадение по всей строке.

    public static Integer[] searchAll(String word, String subWord) {
        List<Integer> entries = new ArrayList<>();

        int R = 256;
        int firstSymbolHash = 1;
        int mod = word.length();

        int subWordHash = subWord.charAt(0) % mod;
        int wordHash = word.charAt(0) % mod;

        for (int i = 1; i < subWord.length(); i++) {
            subWordHash *= R;
            subWordHash += subWord.charAt(i);
            subWordHash %= mod;

            wordHash *= R;
            wordHash += word.charAt(i);
            wordHash %= mod;

            firstSymbolHash *= R;
            firstSymbolHash %= mod;
        }

        for (int i = 0; i <= word.length() - subWord.length(); i++) {
            if (subWordHash == wordHash && textComparison(word, subWord, i))
                entries.add(i);

            if (i == word.length() - subWord.length())
                return entries.toArray(new Integer[0]);

            wordHash -= (word.charAt(i) * firstSymbolHash) % mod;
            wordHash += mod;
            wordHash *= R;
            wordHash += word.charAt(subWord.length() + i);
            wordHash %= mod;
        }

        return entries.toArray(new Integer[0]);
    }

    public static int count(String word, String subWord) {
        int counter = 0;

        int R = 256;
        int firstSymbolHash = 1;
        int mod = word.length();

        int subWordHash = subWord.charAt(0) % mod;
        int wordHash = word.charAt(0) % mod;

        for (int i = 1; i < subWord.length(); i++) {
            subWordHash *= R;
            subWordHash += subWord.charAt(i);
            subWordHash %= mod;

            wordHash *= R;
            wordHash += word.charAt(i);
            wordHash %= mod;

            firstSymbolHash *= R;
            firstSymbolHash %= mod;
        }

        for (int i = 0; i <= word.length() - subWord.length(); i++) {
            if (subWordHash == wordHash && textComparison(word, subWord, i))
                counter++;

            if (i == word.length() - subWord.length())
                return counter;

            wordHash -= (word.charAt(i) * firstSymbolHash) % mod;
            wordHash += mod;
            wordHash *= R;
            wordHash += word.charAt(subWord.length() + i);
            wordHash %= mod;
        }

        return counter;
    }

    public static boolean textComparison(String word, String subWord, int index) {
        for (int i = 0; i < subWord.length(); i++) {
            if (subWord.charAt(i) != word.charAt(i + index))
                return false;
        }
        return true;
    }
}
