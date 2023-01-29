package nonrecursivemethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NonRecursive {
    private static final Logger logger = Logger.getLogger(NonRecursive.class.getName());

    // Создание корня дерева и метода addNode, с помощью которого можно построить дерево бинарного поиска.

    Node root;
    public void put (int key, String name) {

        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parent;
            while (true) {
                parent = currentNode;
                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else if (key > currentNode.key) {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                } else if (key == currentNode.key) {
                    currentNode.name = name;
                    return;
                }
            }
        }
    }

    public void get (int key) {
        Node currentNode = root;
        while (currentNode.key != key) {

            if (key < currentNode.key)
                currentNode = currentNode.leftChild;
            else if (key > currentNode.key)
                currentNode = currentNode.rightChild;

            if (currentNode == null) {
                logger.log(Level.INFO, "Такой ключ не был найден.");
                return;
            }

            if (currentNode.key == key)
                logger.log(Level.INFO, "Значение {0} находится под ключом.", currentNode.name);
        }
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

        tree.get(30);
        tree.get(124);
        tree.get(85);
    }
}

class Node {

    int key;
    int height;
    String name;

    Node leftChild;
    Node rightChild;

    public Node (int key, String name) {
        this.key = key;
        this.name = name;
        this.height = 0;
    }
}