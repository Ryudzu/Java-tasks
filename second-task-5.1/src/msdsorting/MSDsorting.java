package msdsorting;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MSDsorting {

    private static final Logger logger = Logger.getLogger(MSDsorting.class.getName());

    public static void main(String[] args) {

        // Результат выполнения программы.

        String[] strKeys = {"no", "is", "th", "ti", "fo", "al", "go", "pe", "to", "co", "to", "th", "ai", "of", "th", "pa"};
        logger.log(Level.INFO, "До применения MSD-сортировки: {0}", Arrays.toString(strKeys));

        strKeys = msdSort(strKeys);
        logger.log(Level.INFO, "После применения MDS-сортировки: {0}", Arrays.toString(strKeys));
    }

    // Метод msdSort, работающий по принципу поразрядной сортировки. Суть MSD-метода состоит в том, чтобы сортировать строки от старшего
    // разряда к младшему (без сравнений с другими строками в массиве), причем длина всех строк должна быть одинаковой. Старшим разрядом
    // считается первый символ строки, то есть символ, чья позиция в строке равна 0. Для удобства массив строковых ключей был преобразован
    // в список, после получения результата будет опять преобразован в массив строк.

    public static String[] msdSort(String[] strKeys) {
        List<String> strKeysList = new ArrayList<>(Arrays.asList(strKeys));
        List<String> result = countSort(strKeysList, 0);
        return result.stream().toArray(String[]::new);
    }

    public static List<String> countSort(List<String> strKeysList, int pos) {

        // Поскольку в методе countSort используется рекурсия, то должно быть условие после выполнения которого рекурсия начнет возвращать
        // значения. Если значение pos, которое отвечает за индекс в строке больше или равное длине слова (поскольку размер строк одинаковый,
        // то можно взять первый элемент в списке), то идет возврат списка, это значит, что все символы строки совпадают с другой с которой
        // она сравнивалась или если длина списка равна 1.

        if (pos >= strKeysList.get(0).length() || strKeysList.size() == 1)
            return strKeysList;

        // Создание результирующего списка, куда будут записываться отсортированные строки. Метод stableSort позволяет отсортировать строки
        // по первому символу, тем самым можно будет создавать подмассивы, которые будут содержать в себе строки с одинаковой первой буквой
        // и в дальнейшем сравниваться по остальным буквам.

        List<String> result = new ArrayList<>();
        stableSort(strKeysList, pos);

        // Создание самого цикла, который поможет правильно отсортировать строки с одинаковой первой буквой, делая уклон на следующие буквы в слове.
        // В качестве start выступает первое слово в списке, чья первая буква будет сравниваться с первой буквой других слов, если буквы равны
        // между собой, то идет сравнение с первой буквой уже следующего слова. В случае обнаружения, что первая буква слова не совпадает с
        // первой буквой другого, то создается список subL, который принимает в себя подмассив от start до end не включительно из основного
        // списка strKeysList. Далее идет добавление в список result этих значений, но перед этим должна выполниться рекурсия, которая принимает этот
        // подмассив и увеличивает позицию на единицу. Так как функция уже обновила свои значения в связи с вызванной рекурсией, то дальше будет
        // происходить сортировка, но уже по второй букве, а потом также в цикле сравниваться по третьей букве, если не равны, то опять создается
        // подмассив и вызывается рекурсия, и так до тех пор, пока подмассив окончательно не станет равным единице или пока pos не будет больше или
        // равно длине слова, как только выполниться условие в начале функции будет происходить возврат значений и добавляться в список result,
        // а return result вернет те значения которые были занесены туда ранее и тем самым опять перекинет обратно в цикл в строку с рекурсией
        // и там уже обновляется переменная start в соответствии со значением end, чтобы можно было сравнивать другие слова по первым буквам
        // и тем самым повтрять все выше описанное.

        int start = 0;
        for (int end = 1; end <= strKeysList.size(); end++) {
            if (end == strKeysList.size() || strKeysList.get(start).charAt(pos) != strKeysList.get(end).charAt(pos)) {
                List<String> subL = strKeysList.subList(start, end);
                result.addAll(countSort(subL, pos + 1));
                start = end;
            }
        }
        return result;
    }

    public static void stableSort(List<String> strKeysList, int pos) {
        strKeysList.sort(Comparator.comparingInt(x -> x.charAt(pos)));
    }
}
