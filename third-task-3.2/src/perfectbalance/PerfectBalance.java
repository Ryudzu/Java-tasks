package perfectbalance;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerfectBalance {

    private static final Logger logger = Logger.getLogger(PerfectBalance.class.getName());

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
                if (currentNode.key < key) {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                } else if (currentNode.key > key) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }

                if (currentNode.key == key) {
                    currentNode.name = name;
                    return;
                }
            }
        }

    }

    public static void sortingWords(PerfectBalance tree, String[] a) {

        // Сортировка массива слов с помощью Arrays.sort и вызов метода perfectBalance, в который передается само пустое дерево,
        // отсортированный массив слов, левая часть массива (начинающаяся от нуля) и правая часть массива (конец массива).

        Arrays.sort(a);
        logger.log(Level.INFO, () -> Arrays.toString(a));

        perfectBalance(tree, a, 0, a.length - 1);
    }

    public static void perfectBalance(PerfectBalance tree, String[] a, int left, int right) {

        // Если левая сторона обладает значением больше, чем правая, то рекурсия завершается и происходит возврат значений.

        if (right < left)
            return;

        // Вычисление середины массива.

        int mid = left + (right - left) / 2;

        // Добавление в пустое ДБП середины списка слов, тем самым первый элемент в дереве будет корневым. А также вывод его в консоль.

        tree.addNode(mid, a[mid]);

        // N E B A C H F I R R P R T S Y
        
        logger.log(Level.INFO, "Идеальная балансировка: {0}", a[mid]);

        // Рекурсии, где сначала вычисляются середины левой стороны массива от середины изначального массива и строится левая часть дерева.
        // После завершения первой рекурсии, начинается вторая рекурсия, которая вычисляет середины правого массива от середины
        // изначального массива и строится правая часть дерева.

        perfectBalance(tree, a, left, mid - 1);
        perfectBalance(tree, a, mid + 1, right);

        /*
            По итогу дерево приобретает такой вид:

                                                  N
                                                /   \
                                               /     \
                                              /       \
                                             /         \
                                            E           R
                                           / \         / \
                                          /   \       /   \
                                         B     H     R     T
                                        / \   / \   / \   / \
                                       A   C F   I P   R S   Y
         */
    }

    public static void main(String[] args) {

        // Создание изначального пустого ДБП и списка слов (букв), не содержащий дубликатов. Вызов метода sortingWords, чтобы
        // отсортировать массив и передать из этого метода значения уже в другой метод perfectBalance. В результате из
        // P E R F C T B I N A R Y S R H должно получиться N E B A C H F I R R P R T S Y.

        PerfectBalance tree = new PerfectBalance();
        String[] a = {"P", "E", "R", "F", "C", "T", "B", "I", "N", "A", "R", "Y", "S", "R", "H"};

        sortingWords(tree, a);
    }
}

class Node {

    protected String name;
    protected int key;

    protected Node leftChild;
    protected Node rightChild;

    public Node (int key, String name) {
        this.name = name;
        this.key = key;
    }

}
