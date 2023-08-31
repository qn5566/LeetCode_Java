在本题中，我们需要实现前缀树（Trie），Trie，也称为字典树、前缀树或键树，是一种有序树，用于保存关联数组，其中键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是从根节点到代表键的节点的路径上保存。

具体来说，我们需要实现以下方法：

insert(word: String)：将单词 word 插入到 Trie 数据结构中。
search(word: String)：如果单词 word 在 Trie 中，则返回 true ；否则，返回 false 。
startsWith(prefix: String)：如果 Trie 中存在以给定前缀 prefix 为开头的单词，则返回 true ；否则，返回 false 。
我们可以使用一个类 TrieNode 来表示前缀树的节点，每个节点包含以下信息：

isEnd: 表示当前节点是否是一个单词的结尾。
children: 一个哈希表，保存当前节点的子节点，哈希表的键是子节点对应的字符，值是子节点的引用。
具体实现方法如下：
class Trie() {

    /** Initialize your data structure here. */
    private val root = TrieNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var curr = root
        for (char in word) {
            if (!curr.contains(char)) {
                curr.put(char, TrieNode())
            }
            curr = curr.get(char)
        }
        curr.isEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var curr = root
        for (char in word) {
            if (!curr.contains(char)) {
                return false
            }
            curr = curr.get(char)
        }
        return curr.isEnd
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var curr = root
        for (char in prefix) {
            if (!curr.contains(char)) {
                return false
            }
            curr = curr.get(char)
        }
        return true
    }

    private class TrieNode {
        private val children = HashMap<Char, TrieNode>()
        var isEnd = false

        fun contains(char: Char): Boolean {
            return children.containsKey(char)
        }

        fun get(char: Char): TrieNode {
            return children[char]!!
        }

        fun put(char: Char, node: TrieNode) {
            children[char] = node
        }
    }
}

在Trie数据结构中，这段代码的作用是在当前节点的子节点中查找一个字符，并返回该子节点。
假设当前节点表示前缀树中某个字符串的末尾字符，我们需要通过该字符在前缀树上找到下一个字符的节点，以此来遍历整个字符串。
具体来说，get(char) 方法会返回当前节点的子节点集合 children 中对应字符 char 的子节点。
这个方法的返回值是一个 TrieNode 对象，表示前缀树中以 char 字符为键值的子树根节点。如果当前节点没有以 char 字符为键值的子节点，该方法将抛出一个异常。
而 curr = curr.get(char) 语句则表示将当前节点移动到其子节点中以 char 为键值的子节点上，
以此来遍历字符串的下一个字符。该语句的返回值是一个 TrieNode 对象，表示前缀树中以 char 字符为键值的子树根节点。
