package lsdsorting;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LSDsorting {

    private static final Logger logger = Logger.getLogger(LSDsorting.class.getName());

    public static void main(String[] args) {

        String[] strKeys = {"no", "is", "th", "ti", "fo", "al", "go", "pe", "to", "co", "to", "th", "ai", "of", "th", "pa"};
        logger.log(Level.INFO, "До применения LSD-сортировки: {0}", Arrays.toString(strKeys));

        strKeys = LSDsort(strKeys);
        logger.log(Level.INFO, "После применения LSD-сортировки: {0}", Arrays.toString(strKeys));
    }

    public static String[] countSort(String[] strKeys, int pos) {

        // Для определения того, как будет происходить сортировка по символам необходимо взять стандартный размер таблицы ASCII для определения
        // целочисленных значений символов и создать массив, индексы которого будут совпадать с найденным кодом символа и записывать единицу в эту ячейку
        // тем самым если суммировать все значения в этом массиве получится то число, совпадающее с количеством символов в исходном массиве. Это необходимо
        // для будущей расстановки строк в правильной последовательности.

        int asciiTableSize = 256;
        int[] asciiSupport = new int[asciiTableSize];
        for (String strKey : strKeys)
            asciiSupport[strKey.codePointAt(pos)] += 1;

        // Далее идет та часть, с помощью которой в будущем можно в правильной последовательности расставить строки. Смысл таков, что при попадании
        // в ту ячейку, где стоит единица (поскольку идет отсчет с конца до начала, то будут вычисляться сначала позиции с большим индексом, то есть
        // для символов, чей код по ASCII больше), то значение size, чье значение равно размеру исходного массива, будет уменьшаться на единицу и в эту же
        // ячейку массива ASCII будет записываться эта переменная size и так вплоть до того, пока size не станет равным нулю или не закончится цикл.

        int size = strKeys.length;
        for (int i = asciiSupport.length - 1; i >= 0; i--) {
            size -= asciiSupport[i];
            asciiSupport[i] = size;
        }

        // После всех манипуляций идет запись строк в правильной последовательности в результирующий массив и передается тем самым обновленный массив
        // в метод LSDsort до тех пор, пока не будет проверен каждый символ в строке.
        // asciiSupport[strKey.codePointAt(pos)] получает значение, которое было определено в цикле выше по коду символа, который совпал с этой ячейкой,
        // следовательно, если значение в этой ячейке равно 7, тогда в result[7] записывается соответствующая строка. Также в случае символов, чей
        // ASCII код может совпасть, то значение в ячейке, совпадающее с кодом, увеличивается на единицу, то есть следующая строка с аналогичным символом будет
        // записываться после той, которая была первее записана в результирующий массив.

        String[] result = new String[strKeys.length];
        for (String strKey : strKeys) {
            result[asciiSupport[strKey.codePointAt(pos)]] = strKey;
            asciiSupport[strKey.codePointAt(pos)] += 1;
        }

        return result;
    }

    // Метод LSDsort, работающий по принципу поразрядной сортировки. Суть LSD-метода состоит в том, чтобы сортировать строки от младшего
    // разряда к большему (без сравнений с другими строками в массиве), причем длина всех строк должна быть одинаковой. Младшим разрядом
    // считается последний символ строки, поэтому для вычисления его позиции используется цикл, идущий в обратную сторону. Тем самым вызывая метод
    // countSort, в который передается сам массив строковых ключей, а также их общая позиция последних символов поскольку размер строк одинаковый.
    // countSort выполняется такое количество раз, равное длине строкового ключа и каждый раз обновляет массив.

    public static String[] LSDsort(String[] strKeys) {
        int strMaxSize = strKeys[0].length();
        for (int i = strMaxSize - 1; i >= 0; i--)
            strKeys = countSort(strKeys, i);

        return strKeys;
    }
}
