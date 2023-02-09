package nonrecursivemethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TST {

    private static final Logger logger = Logger.getLogger(TST.class.getName());

    private TrieNode root;

    class TrieNode {

        private char keyChar;
        boolean isWord;
        int value;

        private TrieNode left;
        private TrieNode right;
        private TrieNode middle;

        public TrieNode(char keyChar) {
            this.keyChar = keyChar;
            this.isWord = false;
        }
    }

    // Нерекурсивный метод addNode, который создает trie-дерево тернарного поиска.

    public void addNode(String word, int value) {
        char[] keyChar = word.toCharArray();
        int i = 0;

        if (root == null)
            root = new TrieNode(keyChar[0]);

        TrieNode currentNode = root;
        while (i < keyChar.length) {
            if (isLeftNode(currentNode, keyChar, i)) {
                currentNode = currentNode.left;
                i--;
            } else if (isRightNode(currentNode, keyChar, i)) {
                currentNode = currentNode.right;
                i--;
            } else {
                if (isMiddleNode(currentNode, keyChar, i))
                    currentNode = currentNode.middle;
                else {
                    currentNode.isWord = true;
                    currentNode.value = value;
                }
            }
            i++;
        }
    }

    // Отдельные методы для упрощения основного метода addNode.

    public boolean isLeftNode(TrieNode currentNode, char[] keyChar, int i) {
        if (keyChar[i] < currentNode.keyChar) {
            if (currentNode.left == null)
                currentNode.left = new TrieNode(keyChar[i]);
            return true;
        } else
            return false;
    }

    public boolean isRightNode(TrieNode currentNode, char[] keyChar, int i) {
        if (keyChar[i] > currentNode.keyChar) {
            if (currentNode.right == null)
                currentNode.right = new TrieNode(keyChar[i]);
            return true;
        } else
            return false;
    }

    public boolean isMiddleNode(TrieNode currentNode, char[] keyChar, int i) {
        if (i < keyChar.length - 1) {
            if (currentNode.middle == null)
                currentNode.middle = new TrieNode(keyChar[i+1]);
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        TST trie = new TST();

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

        logger.log(Level.INFO, "Ключи были успешно добавлены!");
    }
}
