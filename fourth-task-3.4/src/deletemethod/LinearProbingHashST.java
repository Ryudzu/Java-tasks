package deletemethod;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearProbingHashST {

    private static final Logger logger = Logger.getLogger(LinearProbingHashST.class.getName());

    private int maxSize;
    private int counter;
    private char[] keys;
    private int[] values;

    public LinearProbingHashST(int capacity) {
        this.maxSize = capacity;
        this.counter = 0;
        this.keys = new char[capacity];
        this.values = new int[capacity];
    }

    public int hashIndex(char key) {
        return key % maxSize;
    }

    public void resize(int doubledSize) {
        LinearProbingHashST temp = new LinearProbingHashST(doubledSize);

        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != 0)
                temp.put(keys[i], values[i]);
        }
        keys = temp.keys;
        values = temp.values;
        maxSize = temp.maxSize;
    }

    public void put(char key, int value) {

        if (counter >= maxSize)
            resize(maxSize*2);

        int i;
        for (i = hashIndex(key); keys[i] != 0; i = (i + 1) % maxSize) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        counter++;
    }

    // Метод delete(), который обращает ключ, который необходимо удалить, в ноль, а значение в -1. Но так как вычисленный при помощи хеш-функции
    // индекс у других последующих ключей может совпадать с индексом удаленного ключа, то необходимо делать перезапись (перехеширование).
    // Если количество удаленных элементов будет равно половине размера массива, то происходит сокращение размера этого массива в 2 раза,
    // чтобы не держать большое количество пустых ячеек.

    public void delete(char key) {
        int i = hashIndex(key);

        while (keys[i] != key)
            i = (i + 1) % maxSize;

        keys[i] = 0;
        values[i] = -1;

        i = (i + 1) % maxSize;
        while (keys[i] != 0) {
            char reHashKey = keys[i];
            int reHashValue = values[i];

            keys[i] = 0;
            values[i] = -1;
            counter--;

            put(reHashKey, reHashValue);
            i = (i + 1) % maxSize;
        }

        counter--;

        if (counter > 0 && counter <= maxSize/2)
            resize(maxSize/2);
    }

    public void showHashTable() {
        String draw = "";

        for (int i = 0; i < maxSize; i++)
            draw = draw.concat(i + ": " + keys[i] + " - " + values[i] + "\n");

        logger.log(Level.INFO, "Вид созданной хэш-таблицы линейным пробированием по формуле (11*k)%M:\n{0}", draw);
    }

    public static void main(String[] args) {
        LinearProbingHashST hashTable = new LinearProbingHashST(5);

        //EASYQUTION

        hashTable.put('E', 0);
        hashTable.put('A', 1);
        hashTable.put('S', 2);
        hashTable.put('Y', 3);
        hashTable.put('Q', 4);
        hashTable.put('U', 5);
        hashTable.put('T', 6);
        hashTable.put('I', 7);
        hashTable.put('O', 8);
        hashTable.put('N', 9);

        // Результат выполненной программы без вызова метода delete().

        hashTable.showHashTable();

        // Результат выполненной программы с вызовом метода delete().

        hashTable.delete('Q');
        hashTable.delete('A');
        hashTable.showHashTable();
    }
}
