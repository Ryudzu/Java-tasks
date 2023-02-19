package binarystringzerocheck;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryStringZeroCheck {

    private static final Logger logger = Logger.getLogger(BinaryStringZeroCheck.class.getName());

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logger.log(Level.INFO, "Введите двоичную строку: ");
        String binaryString = input.nextLine();

        // Результат выполнения программы, которая выводит строки с двумя и более непоследовательными нулями.

        Pattern pt = Pattern.compile("(1*01+0(1+0?)*)");
        Matcher mt = pt.matcher(binaryString);

        while (mt.find()) {
            String result = String.format("Найдено на позиции с %d по %d: %s", mt.start(), mt.end(), binaryString.substring(mt.start(), mt.end()));
            logger.log(Level.INFO, "{0}\n", result);
        }
    }
}
