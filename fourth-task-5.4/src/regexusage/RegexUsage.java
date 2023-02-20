package regexusage;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUsage {

    private static final Logger logger = Logger.getLogger(RegexUsage.class.getName());

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logger.log(Level.INFO, "Введите номер телефона: ");
        String phoneNumber = input.nextLine();

        Pattern phone = Pattern.compile("^((\\([0-9]{3}\\)) ([0-9]{3})-([0-9]{4}))$");
        Matcher phoneCheck = phone.matcher(phoneNumber);
        logger.log(Level.INFO, "{0}\n", phoneCheck.matches());

        logger.log(Level.INFO, "Введите номер карточки социального страхования: ");
        String cardNumber = input.nextLine();

        Pattern card = Pattern.compile("^(([0-9]{3})-([0-9]{2})-([0-9]{4}))$");
        Matcher cardCheck = card.matcher(cardNumber);
        logger.log(Level.INFO, "{0}\n", cardCheck.matches());

        logger.log(Level.INFO, "Введите дату: ");
        String dateNumber = input.nextLine();

        Pattern date = Pattern.compile("^(([JFMASNOD][a-z]+) ([0-9]{1,2}), ([0-9]{4}))$");
        Matcher dateCheck = date.matcher(dateNumber);
        logger.log(Level.INFO, "{0}\n", dateCheck.matches());

        logger.log(Level.INFO, "Введите IPv4 адрес: ");
        String ipAddress = input.nextLine();

        Pattern ip = Pattern.compile("^(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))$");
        Matcher ipCheck = ip.matcher(ipAddress);
        logger.log(Level.INFO, "{0}\n", ipCheck.matches());

        logger.log(Level.INFO, "Введите автомобильный номер: ");
        String autoNumber = input.nextLine();

        Pattern auto = Pattern.compile("\\d{4}[A-Z]{2}");
        Matcher autoCheck = auto.matcher(autoNumber);
        logger.log(Level.INFO, "{0}", autoCheck.matches());
    }
}
