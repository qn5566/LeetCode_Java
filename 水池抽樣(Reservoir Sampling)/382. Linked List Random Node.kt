
Linked List Random Node 是一道較為基礎的 Linked List 題目，要求你實現一個類 Solution，並且在類裡面定義一個名為 getRandom 的函數，
使得該函數能夠等概率地返回 Linked List 中的一個節點。
實現的過程中，可以利用 Reservoir Sampling 算法，保證每個節點被選中的概率都是相等的。具體而言，可以使用一個變數 result 來記錄目前已經選中的節點，
初始值為第一個節點，然後對於第 i 個節點，以概率 $1/i$ 選擇留下這個節點，否則就隨機選擇已經選中的節點中的一個進行替換。
這樣可以保證每個節點被選中的概率都是 $1/n$，其中 $n$ 是節點的總數。
在具體實現時，可以先遍歷一遍 Linked List，得到節點的總數 $n$，然後再遍歷一遍 Linked List，按照上述算法選擇節點。可以使用 Random 類來生成隨機數。

這裡我們使用了 java.util.Random 來生成隨機數，從而實現了在鏈表中等概率選擇節點的功能。
在 getRandom 方法中，我們逐個遍歷鏈表中的節點，對於每個節點，以 $1/\text{count}$ 的概率保留該節點。這樣做的原因是因為：

對於第一個節點，我們以 $1/1$ 的概率保留它，因為它是唯一的節點；
對於第二個節點，我們以 $1/2$ 的概率保留它，因為我們需要等概率選擇第一個節點或第二個節點；
對於第三個節點，我們以 $1/3$ 的概率保留它，因為我們需要等概率選擇前兩個節點或第三個節點；
...
以此類推，對於第 $i$ 個節點，我們以 $1/i$ 的概率保留它。這樣做可以保證在遍歷完整個鏈表後，
每個節點被選中的概率都是相等的，即等概率選擇節點。最後，我們返回被保留的節點的值即可。

Reservoir Sampling（蓄水池抽樣）是一种随机抽样算法，通常用于从一个很大的数据集中等概率地随机选择k个样本，使得每个样本的概率相等，即1/n。它的应用场景包括但不限于：

在海量数据中进行统计分析
某些机器学习算法中的随机样本选择
在实时流数据处理中，对大数据集进行近似的随机抽样
这个算法的核心思想是，维护一个大小为k的蓄水池，每次从数据流中读取一个新的样本，
用等概率的方法将其替换掉蓄水池中的一个旧样本。因为每个样本被选中的概率相等，所以最后蓄水池中每个样本被选中的概率都是1/n。
这样就可以达到从大数据集中等概率地随机选择k个样本的目的。


ex: Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.

class Solution(head: ListNode?) {
    private val random = Random(System.currentTimeMillis())
    private var head: ListNode? = null

    init {
        this.head = head
    }

    fun getRandom(): Int {
        var count = 1
        var curr = head
        var result = 0
        
        while (curr != null) {
            // 以 1/count 的概率保留該節點
            if (random.nextInt(count) == 0) {
                result = curr.`val`
            }
            
            count++
            curr = curr.next
        }

        return result
    }
}

#if (random.nextInt(count) == 0) 
这段代码是 Reservoir Sampling 的核心部分，它的作用是以 $1/k$ 的概率保留当前元素，
其中 $k$ 是当前遍历的节点数目。
具体来说，假设当前节点是第 $i$ 个节点，已经遍历了 $i-1$ 个节点，我们想要以 $1/i$ 的概率选择第 $i$ 个节点。
为了满足这个条件，我们使用 random.nextInt(count) 生成一个随机数 $r$，如果 $r=0$，就选择第 $i$ 个节点。
由于 nextInt(count) 会生成一个在 $[0, count-1]$ 范围内的随机整数，因此，当 $count$ 等于 $i$ 时，$r=0$ 的概率正好为 $1/i$。
同时，当 $count$ 大于 $i$ 时，$r=0$ 的概率也是 $1/i$。因此，对于每个节点，都有 $1/i$ 的概率被选择，从而保证了 Reservoir Sampling 的正确性。
