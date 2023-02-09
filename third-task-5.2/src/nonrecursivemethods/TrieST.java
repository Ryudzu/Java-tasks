package nonrecursivemethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TrieST {

    private static final Logger logger = Logger.getLogger(TrieST.class.getName());

    private static final int R = 256;
    private TrieNode root;

    public TrieST() {
        root = new TrieNode();
    }

    class TrieNode {

        private TrieNode[] children;
        boolean isWord;
        int value;

        public TrieNode() {
            this.children = new TrieNode[R];
            this.isWord = false;
        }
    }

    // Нерекурсивный метод addNode, который создает R-частное trie-дерево.

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

    public static void main(String[] args) {
        TrieST trie = new TrieST();

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
