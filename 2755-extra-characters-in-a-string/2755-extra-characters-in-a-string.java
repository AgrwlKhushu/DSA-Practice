public final class Solution {
    
    public static int minExtraChar(String s, String[] dictionary) {
        Trie root = Trie.create(dictionary);
        int length = s.length();
        int[] table = new int[length + 1];
        for (int index = length - 1; index >= 0; index--) {
            table[index] = minExtraCharAt(s, index, length, root, table);
        }
        return table[0];
    }

    private static int minExtraCharAt(String s, int offset, int length, Trie node, int[] table) {
        int opt = 1 + table[offset + 1];
        int index = offset;
        while (index < length) {
            char c = s.charAt(index++);
            node = node.getChild(c);
            if (node == null) {
                break;
            }
            
            if (!node.isWord()) {
                continue;
            }

            opt = Math.min(opt, table[index]);
        }
        return opt;
    }
}

final class Trie {

    private static final int CHAR_MASK = 0x1F;

    private boolean isWord = false;
    private final Trie[] children = new Trie[27];

    public static Trie create(String[] dictionary) {
        Trie root = new Trie();
        for (String word : dictionary) {
            root.addWord(word);
        }
        return root;
    }

    public boolean isWord() {
        return isWord;
    }

    public Trie getChild(char c) {
        return children[c & CHAR_MASK];
    }

    private void addWord(String word) {
        Trie node = this;
        int length = word.length();
        for (int index = 0; index < length; index++) {
            int childIndex = word.charAt(index) & CHAR_MASK;
            Trie child = node.children[childIndex];
            if (child == null) {
                child = new Trie();
                node.children[childIndex] = child;
            }
            node = child;
        }
        node.isWord = true;
    }

    private Trie() {}
}