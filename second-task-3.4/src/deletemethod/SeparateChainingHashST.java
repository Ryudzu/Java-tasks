package deletemethod;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SeparateChainingHashST {

    public static final Logger logger = Logger.getLogger(SeparateChainingHashST.class.getName());

    private final HashNode[] buckets;
    private final int numOfBuckets;

    public SeparateChainingHashST(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[capacity];
    }

    public int getIndex(char key) {
        return key % numOfBuckets;
    }

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

    // Реализация метода delete() для цепочного метода создания хеш-таблицы (класс SeparateChainingHashST).

    public void delete(char key) {
        int bucketIndex = getIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;

        while (head != null) {
            if (head.key == key) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null)
            return;

        if (prev != null)
            prev.next = head.next;
        else
            buckets[bucketIndex] = head.next;
    }

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
        logger.log(Level.INFO, "Вид созданной хэш-таблицы методом цепочек по формуле:\n{0}", draw);
    }

    public static void main(String[] args) {
        SeparateChainingHashST hashTable = new SeparateChainingHashST(5);

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

        // Результат выполненной программы без удаления.

        hashTable.showHashTable();

        // Результат выполненной программы с удалением.

        hashTable.delete('T');

        hashTable.showHashTable();
    }
}

class HashNode {

    protected char key;
    protected int value;
    protected HashNode next;

    public HashNode(char key, int value) {
        this.key = key;
        this.value = value;
    }

}
