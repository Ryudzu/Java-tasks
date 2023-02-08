package ternarysearchtree;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TernarySearchTree {

    private static final Logger logger = Logger.getLogger(TernarySearchTree.class.getName());

    // Создание класса TrieNode, с помощью которого можно будет создать trie-дерево тернарного поиска, где left, middle, right это указатели
    // на левый, серединный и правый узел. Так как при создании такого дерева отсутствует массив, где в качестве его размера выступал размер
    // расширенной таблицы ASCII, как это было в R-частном trie-дереве, то такое дерево частично напоминает дерево бинарного поиска, поскольку
    // в нем корень уже не пустой и узлы расставляются в зависимости от того больше ли символ ключа или меньше тех, которые были
    // добавлены ранее, если меньше - влево, если больше - вправо. Середина строится в том случае, если дерево изначально пустое и если
    // есть похожие друг на друга слова, чьи условно первые 4 символа совпадают, а оставшаяся часть просто дописывается в середину без сравнений
    // поскольку после условных 4-х символов первого добавленного ключа идет значение null.

    private TrieNode root;

    class TrieNode {
        int value;
        private char keyChar;
        private boolean isWord;

        private TrieNode left;
        private TrieNode middle;
        private TrieNode right;

        public TrieNode(char keyChar) {
            this.keyChar = keyChar;
            this.isWord = false;
        }
    }

    // Рекурсивный метод создания trie-дерева тернарного поиска, для удобства была сделана перегрузка методов.

    public void addNode(String word, int value) {
        root = addNode(root, word.toCharArray(), value, 0);
    }

    private TrieNode addNode(TrieNode currentNode, char[] word, int value, int index) {
        if (currentNode == null)
            currentNode = new TrieNode(word[index]);

        if (word[index] < currentNode.keyChar)
            currentNode.left = addNode(currentNode.left, word, value, index);
        else if (word[index] > currentNode.keyChar)
            currentNode.right = addNode(currentNode.right, word, value, index);
        else {
            if (index + 1 < word.length)
                currentNode.middle = addNode(currentNode.middle, word, value, index + 1);
            else {
                currentNode.isWord = true;
                currentNode.value = value;
            }
        }
        return currentNode;
    }

    // Создание визуального trie-дерева тернарного поиска с помощью метода drawTree.
    // Идея визуализации дерева взята отсюда: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java#answer-8948691

    public void drawTree() {
        drawTree(root, "", null, true);
    }

    private void drawTree(TrieNode currentNode, String prefix, String prevString, boolean isTail) {
        String str = "";
        if (prevString != null)
            str = prevString;

        drawPatternForTree(currentNode, prefix, str, isTail);
        drawLeftPart(currentNode, prefix, str, isTail);
        drawMiddlePart(currentNode, prefix, str, isTail);
        drawRightPart(currentNode, prefix, str, isTail);
    }

    // Отдельные методы для упрощения сложности основного метода, в котором они прописаны. Каждый из них отвечает за рисовку дерева.

    private String result = "";
    private void drawPatternForTree(TrieNode currentNode, String prefix, String str, boolean isTail) {
        if (isTail)
            result = result.concat(prefix + "└── ");
        else
            result = result.concat(prefix + "├── ");

        if (currentNode.isWord)
            result = result.concat("(" + currentNode.keyChar + ") " + str + currentNode.keyChar + "\n");
        else
            result = result.concat(currentNode.keyChar + "\n");
    }

    private void drawLeftPart(TrieNode currentNode, String prefix, String str, boolean isTail) {
        if (currentNode.left != null)
            drawTree(currentNode.left, prefix + (isTail ? "    " : "│   "), str, false);
    }

    private void drawMiddlePart(TrieNode currentNode, String prefix, String str, boolean isTail) {
        if (currentNode.middle != null)
            drawTree(currentNode.middle, prefix + (isTail ? "    " : "│   "), str + currentNode.keyChar, false);
    }

    private void drawRightPart(TrieNode currentNode, String prefix, String str, boolean isTail) {
        if (currentNode.right != null)
            drawTree(currentNode.right, prefix + (isTail ? "    " : "│   "), str, true);
    }


    public static void main(String[] args) {
        TernarySearchTree trie = new TernarySearchTree();

        // Ключи, добавленные в дерево согласно заданию.

        trie.addNode("now", 0);
        trie.addNode("is", 1);
        trie.addNode("the", 2);
        trie.addNode("time", 3);
        trie.addNode("for", 4);
        trie.addNode("all", 5);
        trie.addNode("good", 6);
        trie.addNode("people", 7);
        trie.addNode("to", 8);
        trie.addNode("come", 9);
        trie.addNode("to", 10);
        trie.addNode("the", 11);
        trie.addNode("aid", 12);
        trie.addNode("of", 13);

        // Результат выполнения программы.

        trie.drawTree();
        logger.log(Level.INFO, "Визуализированное trie-дерево тернарного поиска по заданным ключам:\n{0}", trie.result);
    }
}
