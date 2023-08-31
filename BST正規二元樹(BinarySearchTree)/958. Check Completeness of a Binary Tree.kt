
958. Check Completeness of a Binary Tree
Medium
2.5K
34
Companies
Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:

Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.


解題思路

完全二叉樹的性質：

對於所有的 $i$ (1 <= i <= n)，左子樹的編號都是 $2i$，右子樹的編號都是 $2i+1$。
如果序列中的一個節點沒有右子節點，則序列中該節點後的所有節點都不能有子節點（即該序列不是二叉樹）。
因此，我們可以在遍歷整棵樹的同時，對每個節點進行以下操作：

如果遇到空節點，將空節點標記為 true。
如果遇到非空節點，檢查其前一個節點是否為空節點，如果是，返回 false。
最後檢查最後一個節點後面是否還有空節點，如果有，返回 false。

class Solution {
    fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) return true
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var hasGap = false // 是否出現空位
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == null) {
                hasGap = true
                continue
            }
            // 如果出現空位後，又出現新節點，則不是完全二叉樹
            if (hasGap) return false
            queue.offer(node.left)
            queue.offer(node.right)
        }
        return true
    }
}

判斷完全二叉樹的主要思路是使用 BFS（Breadth-First Search）遍歷二叉樹，
當遇到空節點時，標記 hasGap 為 true。如果 hasGap 已經為 true 但後續又出現新節點，
則不是完全二叉樹。最後，如果 BFS 結束時還沒有返回 false，則該二叉樹是完全二叉樹。


為什麼要用LinkedList
使用 LinkedList 是因為該類別具有方便地實現佇列的功能，可以使用 add() 方法從佇列尾端加入節點，使用 remove() 方法從佇列前端移除節點，符合二元樹廣度優先搜索時的先進先出原則。此外，Java語言內建的 LinkedList 也提供了高效率的方法實作這些操作。




彭泰德
queue.offer(root) 
這什麼意思
queue.offer(root) 是 Java 中 Queue 接口提供的方法之一，用于将一个元素插入队列的尾部，即入队操作。在这个算法中，我们将根节点加入队列，然后不断进行以下操作：

从队列中取出一个节点。
如果当前节点为 null，说明该节点及其子节点不是一个完全二叉树，返回 false。
如果当前节点不为 null 且上一个节点的 left 或 right 子节点为空，但当前节点有 left 或 right 子节点，说明该节点及其子节点不是一个完全二叉树，返回 false。
将当前节点的左右子节点依次加入队列中。
当队列为空时，遍历结束，说明该二叉树是一个完全二叉树，返回 true。




彭泰德
為什麼要先
queue.offer(node.left) 
在
queue.offer(node.right)
在這個算法中，先將左節點加入佇列的原因是要保證樹的完整性。對於一個完整的二元樹，其所有的節點都滿足以下兩點條件之一：

有兩個子節點；
沒有子節點。
因此，當我們遍歷二元樹時，先將左節點加入佇列，保證滿足上述兩點條件之一，然後再加入右節點。這樣可以確保我們的樹是完整的，並且我們不會漏掉任何一個節點。




彭泰德
幹嘛不用add
offer() 和 add() 都是在队列尾部添加一个元素，但是它们的行为略有不同。当队列元素已满时，add() 方法会抛出一个 IllegalStateException 异常，而 offer() 方法只是返回 false，不会抛出异常。

在实际应用中，如果我们使用有容量限制的队列（如 ArrayBlockingQueue），为了避免程序因为队列满了而抛出异常，我们通常会使用 offer() 方法而不是 add() 方法。在这个题目中，我们使用 LinkedList 实现队列，它的容量是动态调整的，因此使用 offer() 或 add() 都没有问题。




彭泰德
while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == null) {
                hasGap = true
                continue
            }
            // 如果出現空位後，又出現新節點，則不是完全二叉樹
            if (hasGap) return false
            queue.offer(node.left)
            queue.offer(node.right)
        }
這段裡面的
continue
是做什麼
continue 是在循环语句中使用的关键字，当执行到 continue 语句时，会跳过本次循环剩余的语句，直接进入下一轮循环。

在这个代码段中，当遇到一个节点为 null 时，将 hasGap 标记为 true，然后执行 continue 跳过本轮循环中下面的语句，直接进入下一轮循环，处理下一个节点。这样就可以检查当前是否出现了空位，并且在后面的判断中避免将空位误认为是有效节点。




彭泰德
那為什麼不直接在那邊 return false
如果直接在 if (node == null) 的分支中 return false，那么在遇到第一个空节点时就会直接返回结果，无法判断后面的节点是否符合完全二叉树的定义，因此需要用 continue 跳过当前节点，继续遍历后面的节点，直到队列为空或者遇到一个空节点和它的子节点。当遇到一个空节点和它的子节点时，如果后面还有非空节点，则说明这不是完全二叉树，可以直接返回 false。