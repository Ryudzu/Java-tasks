import java.util.Arrays;

public class Dedup_Method {

    public static void main(String[] args) {

        // Создание массива строк, который необходимо отсортировать и исключить дубликаты.

        String[] a = {"бпва", "вонке", "афыув", "гсячйфц", "ервапыфв", "афыув", "дорапке"};
        System.out.println("Исходный массив строк: " + Arrays.toString(a));

        // Вызов метода dedup() согласно заданию и замена исходного массива строк a[] на обновленный.

        a = dedup(a);

        // Результат выполнения программы.

        System.out.println("Массив строк после dedup(): " + Arrays.toString(a));
    }

    public static String[] dedup(String[] a) {

        // Для более простого решения задачи можно превратить массив строк в поток и воспользоваться промежуточными методами
        // Streams, такими как sorted(), который сортирует элементы по заданному критерию и distinct(), позволяющий убрать
        // дубликаты. И чтобы эти методы сработали необходимо в конце прописать терминальный метод, который будет превращать
        // поток обратно в массив строк и возвращать результат.

        return Arrays.stream(a).sorted().distinct().toArray(String[]::new);
    }
}
