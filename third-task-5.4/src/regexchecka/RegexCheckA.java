package regexchecka;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheckA {

    private static final Logger logger = Logger.getLogger(RegexCheckA.class.getName());

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logger.log(Level.INFO, "Введите строку: ");
        String stringWord = input.nextLine();

        Pattern pt1 = Pattern.compile("(([^A])*+A{4})");
        Matcher mt1 = pt1.matcher(stringWord);

        while (mt1.find()) {
            String result = String.format("a) Найдено на позиции с %d по %d: %s", mt1.start(), mt1.end(), stringWord.substring(mt1.start(), mt1.end()));
            logger.log(Level.INFO, "{0}\n", result);
        }

        Pattern pt2 = Pattern.compile("(([^A])*+A{2,4})");
        Matcher mt2 = pt2.matcher(stringWord);

        while (mt2.find()) {
            String result = String.format("б) Найдено на позиции с %d по %d: %s", mt2.start(), mt2.end(), stringWord.substring(mt2.start(), mt2.end()));
            logger.log(Level.INFO, "{0}\n", result);
        }

        Pattern pt3 = Pattern.compile("(([^A])*+A{4})");
        Matcher mt3 = pt3.matcher(stringWord);

        int counter = 0;
        while (mt3.find())
            counter++;

        if (counter >= 1)
            logger.log(Level.INFO, "в) Количество вхождений 4-х последовательных А равно: {0}", counter);
        else
            logger.log(Level.INFO, "в) Вхождения не найдены.");
    }
}
