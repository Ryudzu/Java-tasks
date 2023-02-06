package certification;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Certification {

    private static final Logger logger = Logger.getLogger(Certification.class.getName());

    static class Node {

        final int key;
        String name;

        private Node leftChild;
        private Node rightChild;

        public Node (int key, String name) {
            this.key = key;
            this.name = name;
        }
    }

    private static Node root;

    // Проверка на корневой узел.
    public boolean isBST(Node currentNode) {
        return currentNode == root;
    }

    public static void main(String[] args) {

        Certification tree = new Certification();

        /*
            Дерево будет строится в ручную при помощи указателей на следующие элементы, чтобы можно было проверить работоспособность метода.
            По итогу дерево приобретет такой вид:

                                               50
                                              /  \
                                             /    \
                                           25      75
                                          /  \       \
                                         /    \       \
                                       15     30       85

         */

        root = new Node(50, "A");
        root.leftChild = new Node(25, "B");
        root.rightChild = new Node(75, "C");
        root.leftChild.leftChild = new Node(15, "D");
        root.leftChild.rightChild = new Node(30, "E");
        root.rightChild.rightChild = new Node(85, "F");

        // Проверка работоспособности метода isBST().

        logger.log(Level.INFO, "{0}", tree.isBST(root));
        logger.log(Level.INFO, "{0}", tree.isBST(root.leftChild));
        logger.log(Level.INFO, "{0}", tree.isBST(root.leftChild.rightChild));
    }
}
