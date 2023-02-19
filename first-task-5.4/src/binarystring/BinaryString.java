package binarystring;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryString {

    private static final Logger logger = Logger.getLogger(BinaryString.class.getName());

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logger.log(Level.INFO, "Введите двоичную строку: ");
        String binaryString = input.nextLine();

        // Результат выполнения первого случая для поиска подстрок, с 3 и более повторяющимися подряд единицами.

        Pattern pt1 = Pattern.compile("((0+1{3,})|(10+1{3,}))");
        Matcher mt1 = pt1.matcher(binaryString);
        while (mt1.find()) {
            String result = String.format("a) Найдено на позиции с %d по %d: %s", mt1.start(), mt1.end(), binaryString.substring(mt1.start(), mt1.end()));
            allPos(result);
        }

        // Результат выполнения второго случая для поиска подстрок, с наличием подстроки 110.

        Pattern pt2 = Pattern.compile("((0*1{2,}0)|(10*1{2,}0))");
        Matcher mt2 = pt2.matcher(binaryString);

        while (mt2.find()) {
            String result = String.format("б) Найдено на позиции с %d по %d: %s", mt2.start(), mt2.end(), binaryString.substring(mt2.start(), mt2.end()));
            allPos(result);
        }

        // Результат выполнения третьего случая для поиска подстрок, с наличием подстроки 1101100.

        Pattern pt3 = Pattern.compile("((0*1{2,}01{2}0{2})|(10*1{2,}01{2}0{2}))");
        Matcher mt3 = pt3.matcher(binaryString);

        while (mt3.find()) {
            String result = String.format("в) Найдено на позиции с %d по %d: %s", mt3.start(), mt3.end(), binaryString.substring(mt3.start(), mt3.end()));
            allPos(result);
        }

        // Результат выполнения четвертого случая для поиска подстрок, в которые не должна входить подстрока 110.

        Pattern pt4 = Pattern.compile("(((0|10)*+1*)|(1+))");
        Matcher mt4 = pt4.matcher(binaryString);

        while (mt4.find()) {
            String result = String.format("г) Найдено на позиции с %d по %d: %s", mt4.start(), mt4.end(), binaryString.substring(mt4.start(), mt4.end()));
            allPos(result);
        }
    }

    public static void allPos(String result) {
        logger.log(Level.INFO, "{0}\n", result);
    }
}
