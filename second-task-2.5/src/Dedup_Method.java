import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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

        // Создание TreeSet, который помимо того, что убирает дубликаты, так еще и сортирует элементы по заданному критерию.
        // В этот Set копируются все значения из изначального, переданного массива строк путем преобразования массива в список
        // и после копирования элементы сортируются и убираются дубликаты. Так как согласно заданию метод должен возвращать String[],
        // то все значения Set необходимо поместить в новый массив строк. Для упрощения задачи можно превратить Set в поток
        // и с помощью терминального метода toArray(String[]::new) записать значения из Set в новый массив строк.

        Set<String> sort_noduplicate = new TreeSet<>(Arrays.asList(a));
        String[] updated_a = sort_noduplicate.stream().toArray(String[]::new);
        return updated_a;
    }
}
