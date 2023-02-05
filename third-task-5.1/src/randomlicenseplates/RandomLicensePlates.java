package randomlicenseplates;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomLicensePlates {

    private static final Logger logger = Logger.getLogger(RandomLicensePlates.class.getName());
    private static Random rand = new Random();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logger.log(Level.INFO, "Введите размер массива: ");
        int N = input.nextInt();

        // Результат выполнения программы.

        String[] result = randomPlatesCA(N);
        logger.log(Level.INFO, "Случайно сгенерированные калифорнийские номера автомобилей: {0}", Arrays.toString(result));
    }

    // В данном разделе (5.1) рассматривались калифорнийские номера автомобилей поэтому данная программа заточена именно под их генерацию.
    // Для удобной генерации номеров автомобилей использовался метод format класса String, он позволяет конвертировать любые типы данных в строку
    // и, помещая их в нужную позицию благодаря спецификаторам, и заранее задать шаблон, то есть как должна выглядеть строка на выходе. В качестве
    // аргументов можно помещать даже сами методы, которые будут возвращать значения. Пока цикл не достигнет предела массива - будут генерироваться
    // случайные номерные знаки автомобилей. Так как этот массив необходимо еще и отсортировать, то для удобства он был конвертирован в поток,
    // где был вызван метод sorted() позволяющий отсортировать его по заданному критерию и на выходе идет преобразование этого потока обратно
    // в массив строк.

    public static String[] randomPlatesCA(int N) {
        String[] result = new String[N];
        for (int i = 0; i < result.length; i++)
            result[i] = String.format("%d%s%s", randomFirstNumber(), randomString(), randomLastNumbers());

        return Arrays.stream(result).sorted().toArray(String[]::new);
    }

    // Генерация случайного первого числа.

    public static int randomFirstNumber() {
        return rand.nextInt(1, 9);
    }

    // Генерация случайных трех букв после первого числа.

    public static String randomString() {
        StringBuilder rStr = new StringBuilder();

        for (int i = 0; i < 3; i++)
            rStr.append((char)(rand.nextInt(26) + 'A'));

        return rStr.toString();
    }

    // Генерация оставшихся случайных трех чисел после генерации случайных трех букв.

    public static String randomLastNumbers() {
        StringBuilder rNumsStr = new StringBuilder();

        for (int i = 0; i < 3; i++)
            rNumsStr.append(rand.nextInt(10));

        return rNumsStr.toString();
    }
}
