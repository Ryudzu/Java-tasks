package certification;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Certification {

    private static final Logger logger = Logger.getLogger(Certification.class.getName());

    // Создание метода isBST, который будет проверять, является ли дерево бинарным.
    // Проверка идет следующим образом: если значение дочернего элемента слева будет больше, чем значение его родителя, то вывод False,
    // а если значение дочернего элемента справа меньше, чем значение родителя, то также False.

    private Node currentNode = null;
    public boolean isBST(Node root) {
        if (root != null) {
            if (!isBST(root.leftChild))
                return false;

            if (currentNode != null && currentNode.key >= root.key)
                return false;

            currentNode = root;
            return isBST(root.rightChild);
        }
        return true;
    }

    // Необязательный метод inOrder, который выводит все значения (ключи) в дереве по возрастанию, для понимания того
    // как работает метод isBST.

    public void inOrder(Node currentNode) {
        if (currentNode != null) {
            inOrder(currentNode.leftChild);
            logger.log( Level.INFO, " -> {0}", currentNode.key);
            inOrder(currentNode.rightChild);
        }
    }

    public static void main(String[] args) {

        Certification tree = new Certification();

        /*
            Дерево будет строится в ручную при помощи указателей на следующие элементы, чтобы можно было проверить работоспособность метода.
            По итогу дерево приобретет такой вид и результат будет True поскольку данное дерево является бинарным:

                                               50
                                              /  \
                                             /    \
                                           25      75
                                          /  \       \
                                         /    \       \
                                       15     30       85

         */

        Node root = new Node(50, "A");
        root.leftChild = new Node(25, "B");
        root.rightChild = new Node(75, "C");
        root.leftChild.leftChild = new Node(15, "D");
        root.leftChild.rightChild = new Node(30, "E");
        root.rightChild.rightChild = new Node(85, "F");

        tree.inOrder(root);

        // Проверка работоспособности метода isBST.

        logger.log(Level.INFO, "{0}", tree.isBST(root));
    }
}

class Node {

    int key;
    String name;

    Node leftChild;
    Node rightChild;

    public Node (int key, String name) {
        this.key = key;
        this.name = name;
    }
}
