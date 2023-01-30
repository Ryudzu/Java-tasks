package heightmethods;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HeightMethods {

    private static final Logger logger = Logger.getLogger(HeightMethods.class.getName());

    // Создание корня дерева и метода addNode, с помощью которого можно построить дерево бинарного поиска.

    Node root;
    public void addNode (int key, String name) {

        Node newNode = new Node(key, name);

        if (root == null)
            root = newNode;
        else {
            
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
                }

                if (key == currentNode.key) {
                    currentNode.name = name;
                    return;
                }
            }
        }
    }

    // Рекурсивный метод вычисления высоты дерева.

    public int heightRec(Node currentNode) {
        if (currentNode == null)
            return -1;

        return 1 + Math.max(heightRec(currentNode.leftChild), heightRec(currentNode.rightChild));
    }

    // Нерекурсивный метод вычисления высоты дерева.

    public static int heightSize(Node currentNode) {
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

// Создание класса Node, который позволит хранить данные и ссылаться на левого предка и правого предка бинарного дерева.

class Node {

    protected int key;
    protected int height;
    protected String name;

    protected Node leftChild;
    protected Node rightChild;

    public Node (int key, String name) {
        this.key = key;
        this.name = name;
        this.height = 0;
    }
}
