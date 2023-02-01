package linearprobing;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearProbing {

    private static final Logger logger = Logger.getLogger(LinearProbing.class.getName());

    private char[] keys;
    private int[] values;
    private int maxSize;
    private int counter;

    public LinearProbing(int capacity) {
        this.maxSize = capacity;
        this.counter = 0;
        this.keys = new char[maxSize];
        this.values = new int[maxSize];
    }

    // Метод для высчитывания индекса ключа по формуле (хеш-функция), предусмотренной в задании (11*k)%M.

    public int hashIndex(char key) {
        return (11*key) % maxSize;
    }

    // Метод для увеличения массива в два раза чтобы предотвратить его переполнение, данный метод необходим, поскольку в задании необходимо
    // проверить работоспособность линейного пробирования как с размером массива равному 5 (M = 5), так и равному 10 (M = 10).
    // Данный метод работает таким образом, что создается временный объект на основе класса LinearProbing и так как у каждого объекта свои
    // значения, то изначальные поля не будут переписаны при вызове конструктора класса во второй раз, и, соответственно, можно записать ранее
    // найденное в новый увеличенный массив. После чего идет присвоение первоначальным полям, чей размер массива равен 5, уже обновленного
    // массива объекта temp, который равен 10 со всеми сохраненными значениями исходных массивов, следовательно, работа метода put() может продолжаться.

    public void resize(int doubledSize) {
        LinearProbing temp = new LinearProbing(doubledSize);

        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != 0)
                temp.put(keys[i], values[i]);
        }

        keys = temp.keys;
        values = temp.values;
        maxSize = temp.maxSize;
    }

    // Данный метод put() отличается от того, который был сделан ранее под метод цепочек. Линейное пробирование реализуется намного проще,
    // поскольку в случае коллизии достаточно увеличить индекс на единицу и проверять, является ли в массиве значение равное 0 (пустое место).
    // Если то самое пустое место было найдено, то в эту позицию записывается ключ и значение.

    public void put(char key, int value) {

        if (counter == maxSize)
            resize(2*maxSize);

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

    // Метод, для вывода на экран того, как сформировалась в результате таблица.

    public void showHashTable() {
        String draw = "";

        for (int i = 0; i < maxSize; i++)
            draw = draw.concat(i + ": " + keys[i] + " - " + values[i] + "\n");

        logger.log(Level.INFO, "Вид созданной хэш-таблицы линейным пробированием по формуле (11*k)%M:\n{0}", draw);
    }

    public static void main(String[] args) {

        // Проверка для M = 5, после для M = 10

        LinearProbing hashTable = new LinearProbing(5);

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

        // Результат выполненной программы.

        hashTable.showHashTable();
    }
}
