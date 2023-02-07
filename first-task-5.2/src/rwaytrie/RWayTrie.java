package rwaytrie;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RWayTrie {

    private static final Logger logger = Logger.getLogger(RWayTrie.class.getName());

    // Создание класса TrieNode, с помощью которого можно будет создать trie-дерево, в качестве размера массива children был взят
    // расширенный размер таблицы ASCII. Корень root должен быть пустым и указывать на узлы-вершины. Поле isWord будет запоминать
    // все добавленные ключи в дерево, тем самым при том же поиске можно будет проверить есть ли тот или иной ключ в самом дереве.
    // Сам isWord будет присваиваться последнему символу ключа и устанавливаться на true.

    private static final int R = 256;
    private TrieNode root;

    public RWayTrie() {
        root = new TrieNode();
    }

    class TrieNode {

        private TrieNode[] children;
        private boolean isWord;
        private int value;

        public TrieNode() {
            this.children = new TrieNode[R];
            this.isWord = false;
        }
    }

    // Создание trie-дерева с помощью метода addNode, где в качестве индекса выступает код символа, если такой в дереве не существует, то
    // создается новый объект newNode и занимает ячейку с вычисленным индексом, тем самым создается узел и currentNode теперь будет указывать
    // на него, чтобы в будущем, проверяя последующие символы, ставить их после первого поставленного символа и так далее. Если идет добавление
    // схожего ключа в дальнейшем, то currentNode просто пробегает по уже добавленным таким узлам и если натыкается на не занятую ячейку, то
    // добавляет новый узел.

    public void addNode(String keyWord, int value) {
        TrieNode currentNode = root;
        for (int i = 0; i < keyWord.length(); i++) {
            int index = keyWord.charAt(i);

            if (currentNode.children[index] == null) {
                TrieNode newNode = new TrieNode();
                currentNode.children[index] = newNode;
                currentNode = newNode;
            } else
                currentNode = currentNode.children[index];
        }
        currentNode.isWord = true;
        currentNode.value = value;
    }

    // Построение R-частного trie-дерева с помощью метода drawTree.
    // Идея взята отсюда: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java#answer-8948691

    public void drawTree() {
        drawTree("", root, 0, true, true);
    }

    private void drawTree(String prefix, TrieNode currentNode, int index, boolean isTail, boolean isRoot) {
        if(!isRoot)
            System.out.println(prefix + (isTail ? "└── " : "├── ") + (char) index + "");

        TrieNode lastChild = null;
        int lastChildId = 0;
        boolean isLastChild = true;
        for (int i = R - 1; i >= 0; i--) {
            if(currentNode.children[i] != null) {
                if(isLastChild) {
                    isLastChild = false;
                    lastChild = currentNode.children[i];
                    lastChildId = i;
                    continue;
                }
                drawTree(prefix + (isRoot ? "" : (isTail ? "    " : "│   ")), currentNode.children[i], i, false, false);
            }
        }
        if (lastChild != null)
            drawTree(prefix + (isRoot ? "" : (isTail ? "    " : "│   ")), lastChild, lastChildId, true, false);
    }

    public static void main(String[] args) {
        RWayTrie trie = new RWayTrie();
        trie.addNode("no", 0);
        trie.addNode("is", 1);
        trie.addNode("th", 2);
        trie.addNode("ti", 3);
        trie.addNode("fo", 4);
        trie.addNode("al", 5);
        trie.addNode("go", 6);
        trie.addNode("pe", 7);
        trie.addNode("to", 8);
        trie.addNode("co", 9);
        trie.addNode("to", 10);
        trie.addNode("th", 11);
        trie.addNode("ai", 12);
        trie.addNode("of", 13);
        trie.addNode("th", 14);
        trie.addNode("pa", 15);

        // Результат выполнения программы.

        logger.log(Level.INFO, "Нарисованное R-частное trie-дерево по заданным ключам: ");
        trie.drawTree();
    }
}
