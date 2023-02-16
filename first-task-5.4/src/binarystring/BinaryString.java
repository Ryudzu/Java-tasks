package binarystring;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryString {

    private static final Logger logger = Logger.getLogger(BinaryString.class.getName());

    public static void main(String[] args) {

        // Результат выполнения первого случая для проверки на наличие трех и более последовательных единиц.

        Pattern pt1 = Pattern.compile("([^0]{3,})");
        String firstWord = "111";
        Matcher mt1 = pt1.matcher(firstWord);
        logger.log(Level.INFO, "a) {0}", mt1.matches());

        // Результат выполнения второго случая для проверки на наличие подстроки 110.

        Pattern pt2 = Pattern.compile("(1{2}0)");
        String secondWord = "110";
        Matcher mt2 = pt2.matcher(secondWord);
        logger.log(Level.INFO, "б) {0}", mt2.matches());

        // Результат выполнения третьего случая для проверки на наличие подстроки 1101100.

        Pattern pt3 = Pattern.compile("(1{2}01{2}0{2})");
        String thirdWord = "1101100";
        Matcher mt3 = pt3.matcher(thirdWord);
        logger.log(Level.INFO, "в) {0}", mt3.matches());

        // Результат выполнения четвертого случая для проверки всех двоичных подстрок, кроме 110.

        Pattern pt4 = Pattern.compile("(0{3})|(0{2}1)|(010)|(01{2})|(10{2})|(101)|(1{3})");
        String fourthWord = "110";
        Matcher mt4 = pt4.matcher(fourthWord);
        logger.log(Level.INFO, "г) {0}", mt4.matches());
    }
}
