package BST正規二元樹;

/**
 * Trie，又称前缀树或字典树，用于判断字符串是否存在或者是否具有某种字符串前缀。
 * 字典树主要有如下三点性质：
 * 
 * 1. 根节点不包含字符，除根节点意外每个节点只包含一个字符。
 * 
 * 2. 从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串。
 * 
 * 3. 每个节点的所有子节点包含的字符串不相同。
 */
class Trie {

    private class Node {
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {
    }

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        if (node == null)
            return;
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(word.substring(1), node.childs[index]);
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null)
            return false;
        if (word.length() == 0)
            return node.isLeaf;
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.childs[index]);
    }

    public boolean startsWith(String prefix) {
        return startWith(prefix, root);
    }

    private boolean startWith(String prefix, Node node) {
        if (node == null)
            return false;
        if (prefix.length() == 0)
            return true;
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), node.childs[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
