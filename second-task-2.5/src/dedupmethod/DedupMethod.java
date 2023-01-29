package dedupmethod;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DedupMethod {

    private static final Logger logger = Logger.getLogger(DedupMethod.class.getName());

    public static void main(String[] args) {

        // Создание массива строк, который необходимо отсортировать и исключить дубликаты.

        Scanner input = new Scanner(System.in);
        logger.log(Level.INFO, () -> "Введите размер массива: ");
        int size = input.nextInt();
        String[] a = new String[size];

        logger.log(Level.INFO, () -> "Введите строковые элементы, чтобы заполнить массив:");
        input.nextLine();
        for (int i = 0; i < size; i++)
            a[i] = input.nextLine();

        logger.log(Level.INFO, "Исходный массив строк: {0}", Arrays.toString(a));

        // Вызов метода dedup() согласно заданию и замена исходного массива строк a[] на обновленный.

        a = dedup(a);

        // Результат выполнения программы.
        logger.log(Level.INFO, "Массив строк после dedup(): {0}", Arrays.toString(a));
    }

    public static String[] dedup(String[] a) {

        // Для более простого решения задачи можно превратить массив строк в поток и воспользоваться промежуточными методами
        // Streams, такими как sorted(), который сортирует элементы по заданному критерию и distinct(), позволяющий убрать
        // дубликаты. И чтобы эти методы сработали необходимо в конце прописать терминальный метод, который будет превращать
        // поток обратно в массив строк и возвращать результат.

        return Arrays.stream(a).sorted().distinct().toArray(String[]::new);
    }
}
