package heightmethods;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HeightMethods {

    private static final Logger logger = Logger.getLogger(HeightMethods.class.getName());

    // Создание класса Node, который позволит хранить данные и ссылаться на левого предка и правого предка бинарного дерева.

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

    // Создание корня дерева и рекурсивного метода addNode, с помощью которого можно построить дерево бинарного поиска.

    private Node root;
    public void addNode (int key, String name) {
        if (root == null)
            root = new Node(key, name);
        else
            spotToAdd(key, name, root);
    }

    public Node spotToAdd(int key, String name, Node currentNode) {
        if (currentNode == null)
            return new Node(key, name);

        if (key == currentNode.key) {
            currentNode.name = name;
            return new Node(key, currentNode.name);
        }

        if (key < currentNode.key)
            currentNode.leftChild = spotToAdd(key, name, currentNode.leftChild);
        else if (key > currentNode.key)
            currentNode.rightChild = spotToAdd(key, name, currentNode.rightChild);

        return currentNode;
    }

    // Рекурсивный метод вычисления высоты дерева.

    public int heightRec(Node currentNode) {
        if (currentNode == null)
            return -1;

        return 1 + Math.max(heightRec(currentNode.leftChild), heightRec(currentNode.rightChild));
    }

    // Нерекурсивный метод вычисления высоты дерева.

    public int heightSize(Node currentNode) {
        if (currentNode == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(currentNode);

        Node front;
        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                front = queue.poll();

                if (front.leftChild != null)
                    queue.add(front.leftChild);

                if (front.rightChild != null)
                    queue.add(front.rightChild);

                size--;
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {

        HeightMethods tree = new HeightMethods();

        /*
            Дерево будет выглядеть следующим образом:

                                               50
                                              /  \
                                             /    \
                                           25      75  ------------------ 1
                                          /  \       \
                                         /    \       \
                                       15     30       85  -------------- 2

            Данное дерево имеет высоту, равную 2 (не считая корень дерева).
         */

        tree.addNode(50, "A");
        tree.addNode(25, "B");
        tree.addNode(15, "C");
        tree.addNode(30, "D");
        tree.addNode(75, "E");
        tree.addNode(85, "F");

        // Результат выполнения методов.

        logger.log(Level.INFO, "Результат выполнения рекурсивного метода: {0}", tree.heightRec(tree.root));
        logger.log(Level.INFO, "Результат выполнения метода наподобии size(): {0}", tree.heightSize(tree.root));
    }
}