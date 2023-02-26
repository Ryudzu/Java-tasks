package redblacktree;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RedBlackTree {

    private static final Logger logger = Logger.getLogger(RedBlackTree.class.getName());

    private Node root;
    private static final String BLACK = "BLACK";
    private static final String RED = "RED";

    class Node {
        private final char data;

        private Node left;
        private Node right;
        private Node parent;

        private String color;

        public Node(char data) {
            this.data = data;
        }
    }

    // Немного теории о создании и балансировки красно-черного дерева: https://habr.com/ru/post/557328/

    public void addNode(char key) {
        Node currentNode = root;
        Node parent = null;

        while (currentNode != null) {
            parent = currentNode;
            if (key < currentNode.data)
                currentNode = currentNode.left;
            else if (key > currentNode.data)
                currentNode = currentNode.right;
            else
                throw new IllegalArgumentException("Этот ключ уже существует: " + key);
        }

        Node newNode = new Node(key);
        newNode.color = RED;
        if (parent == null)
            root = newNode;
        else if (key < parent.data)
            parent.left = newNode;
        else
            parent.right = newNode;

        newNode.parent = parent;

        colorSwap(newNode);
    }

    // Смена цвета узлов и вращения происходят в следующих случаях:
    // Если левый и правый потомок являются красными узлами, то происходит обмен цвета потомков с их родителем, поскольку корень не может быть
    // красным, оба потомка каждого красного узла и листья, не содержащие данных, тоже не могут быть красными.
    // Если левый потомок является красным, а правый - черным, то происходит левое малое вращение.
    // Если правый потомок является красным, а левый - черным, то происходит правое малое вращение.

    public void colorSwap(Node currentNode) {
        Node parent = currentNode.parent;

        if (parent == null)
            return;

        if (parent.color.equals(BLACK))
            return;

        Node grandparent = parent.parent;
        if (grandparent == null) {
            parent.color = BLACK;
            return;
        }

        Node uncle = getUncle(parent);
        if (uncle != null && uncle.color.equals(RED)) {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;

            colorSwap(grandparent);
        } else if (parent == grandparent.left) {
            if (currentNode == parent.right) {
                rotateLeft(parent);
                parent = currentNode;
            }
            rotateRight(grandparent);

            parent.color = BLACK;
            grandparent.color = RED;
        } else {
            if (currentNode == parent.left) {
                rotateRight(parent);
                parent = currentNode;
            }
            rotateLeft(grandparent);

            parent.color = BLACK;
            grandparent.color = RED;
        }
    }

    public Node getUncle(Node parent) {
        Node grandParent = parent.parent;
        if (grandParent.left == parent)
            return grandParent.right;
        else if (grandParent.right == parent)
            return grandParent.left;
        else
            throw new IllegalStateException("Родитель не является предком своего прородителя");
    }

    // Метод, осуществляющий правое малое вращение.

    public void rotateRight(Node currentNode) {
        Node parent = currentNode.parent;
        Node leftChild = currentNode.left;

        currentNode.left = leftChild.right;
        if (leftChild.right != null)
            leftChild.right.parent = currentNode;

        leftChild.right = currentNode;
        currentNode.parent = leftChild;

        replaceParentsChild(parent, currentNode, leftChild);
    }

    // Метод, осуществляющий левое малое вращение.

    public void rotateLeft(Node currentNode) {
        Node parent = currentNode.parent;
        Node rightChild = currentNode.right;

        currentNode.right = rightChild.left;
        if (rightChild.left != null)
            rightChild.left.parent = currentNode;

        rightChild.left = currentNode;
        currentNode.parent = rightChild;

        replaceParentsChild(parent, currentNode, rightChild);
    }

    // Замена узлов потомка и его родителя при вращениях.

    public void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null)
            root = newChild;
        else if (parent.left == oldChild)
            parent.left = newChild;
        else if (parent.right == oldChild)
            parent.right = newChild;
        else
            throw new IllegalStateException("Узел не является предком своего родителя");

        if (newChild != null)
            newChild.parent = parent;
    }

    // Метод, позволяющий получить визуал красно-черного дерева.

    public void printTree() {
        printTree(this.root, "", true);
    }

    private String result = "\n";
    private void printTree(Node currentNode, String indent, boolean last) {
        if (currentNode != null) {
            result = result.concat(indent);
            if (last) {
                result = result.concat("R----");
                indent += "     ";
            } else {
                result = result.concat("L----");
                indent += "|    ";
            }

            if (currentNode == root)
                currentNode.color = BLACK;

            String sColor = currentNode.color.equals(RED) ? RED : BLACK;
            result = result.concat(currentNode.data + " (" + sColor + ")\n");
            printTree(currentNode.left, indent, false);
            printTree(currentNode.right, indent, true);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // EASYQUTION

        tree.addNode('E');
        tree.addNode('A');
        tree.addNode('S');
        tree.addNode('Y');
        tree.addNode('Q');
        tree.addNode('U');
        tree.addNode('T');
        tree.addNode('I');
        tree.addNode('O');
        tree.addNode('N');

        // Результат выполнения программы.
        // L---- - левое поддерево, а R---- - правое.

        tree.printTree();
        logger.log(Level.INFO, "{0}", tree.result);
    }
}
