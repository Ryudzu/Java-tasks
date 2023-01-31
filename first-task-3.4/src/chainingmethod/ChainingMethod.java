package chainingmethod;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainingMethod {

    public final static Logger logger = Logger.getLogger(ChainingMethod.class.getName());

    // Создание массива buckets на основе типа данных HashNode, а также поле, которое будет получать размер этого массива.
    /*
        Массив, на основе такого типа данных будет выглядеть подобным образом:

           0 [] --> null
           1 [] --> null
           2 [] --> null
           3 [] --> null
           ...

        То есть каждая ячейка массива имеет ссылку на следующий элемент в этой ячейке, это и есть принцип создания хэш-таблицы методом цепочек.
        Поскольку в случае попадания элемента в ту ячейку, где уже находится существующий в ней элемент будет происходить сдвиг уже существующего
        элемента дальше вправо, а на его место будет становится новый элемент (то есть в самое начало).
    */

    private final HashNode[] buckets;
    private final int numOfBuckets;

    public ChainingMethod(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[capacity];
    }

    // Метод для высчитывания индекса ключа по формуле, предусмотренной в задании (11*k)%M.

    public int getIndex(char key) {
        return (11*key) % numOfBuckets;
    }

    // Метод, при помощи которого создается хэш-таблица, чей принцип работы описан выше.

    public void put(char key, int value) {
        int bucketIndex = getIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    // Метод, для вывода на экран того, как сформировалась в результате таблица.

    public void showHashTable() {
        String draw = "";

        for (int i = 0; i < buckets.length; i++) {
            HashNode head = buckets[i];
            draw = draw.concat(i + ": ");
            while (head != null) {
                draw = draw.concat(head.key + " ");
                head = head.next;
            }
            draw = draw.trim().concat("\n");
        }
        logger.log(Level.INFO, "Вид созданной хэш-таблицы методом цепочек по формуле (11*k)%M:\n{0}", draw);
    }

    public static void main(String[] args) {
        ChainingMethod hashTable = new ChainingMethod(5);

        // EASYQUTION

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

        // Результат выполненной программы.

        hashTable.showHashTable();

    }
}

// Создание класса HashNode, на котором основан принцип работы LinkedList, данный класс будет необходим для реализации хэш-таблицы
// методом цепочек согласно заданию и в добавок чтобы избежать коллизий.

class HashNode {

    protected char key;
    protected int value;
    protected HashNode next;

    public HashNode(char key, int value) {
        this.key = key;
        this.value = value;
    }

}
