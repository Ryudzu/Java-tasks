package nonrecursivemethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NonRecursive {

    private static final Logger logger = Logger.getLogger(NonRecursive.class.getName());

    class Node {

        private final int key;
        private String name;

        private Node leftChild;
        private Node rightChild;

        public Node (int key, String name) {
            this.key = key;
            this.name = name;
        }
    }

    private Node root;

    // Нерекурсивный метод put().
    public void put(int key, String name) {
        Node parent = null;
        Node currentNode = root;
        while (currentNode != null) {
            parent = currentNode;
            if (key < currentNode.key)
                currentNode = currentNode.leftChild;
            else if (key > currentNode.key)
                currentNode = currentNode.rightChild;
            else
                return;
        }

        Node newNode = new Node(key, name);

        if (parent == null)
            root = newNode;
        else if (key < parent.key)
            parent.leftChild = newNode;
        else if (key > parent.key)
            parent.rightChild = newNode;
    }

    // Нерекурсивный метод get().

    public String get(int key) {
        Node currentNode = root;
        while (currentNode.key != key) {

            if (key < currentNode.key)
                currentNode = currentNode.leftChild;
            else if (key > currentNode.key)
                currentNode = currentNode.rightChild;

            if (currentNode == null)
                return "Такой ключ не был найден.";

            if (currentNode.key == key)
                return currentNode.name;
        }

        return currentNode.name;
    }

    public static void main(String[] args) {

        NonRecursive tree = new NonRecursive();

        /*
            Дерево будет выглядеть следующим образом:

                                               50
                                              /  \
                                             /    \
                                           25      75
                                          /  \       \
                                         /    \       \
                                       15     30       85

         */

        // Результат выполнения нерекурсивного метода put.

        tree.put(50, "A");
        tree.put(25, "B");
        tree.put(15, "C");
        tree.put(30, "D");
        tree.put(75, "E");
        tree.put(85, "F");

        // Результат выполнения нерекурсивного метода get.

        String a = tree.get(30);
        logger.log(Level.INFO, "Первое значение: {0}", a);
        String b = tree.get(124);
        logger.log(Level.INFO, "Второе значение: {0}", b);
        String c = tree.get(85);
        logger.log(Level.INFO, "Третье значение: {0}", c);
    }
}