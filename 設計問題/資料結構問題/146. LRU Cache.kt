class LRUCache(private val capacity: Int) {
    private val cacheMap = mutableMapOf<Int, Node>()
    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (cacheMap.containsKey(key)) {
            val node = cacheMap[key]!!
            moveToHead(node)
            return node.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (cacheMap.containsKey(key)) {
            val node = cacheMap[key]!!
            node.value = value
            moveToHead(node)
        } else {
            if (cacheMap.size >= capacity) {
                val tailPrev = tail.prev!!
                removeNode(tailPrev)
                cacheMap.remove(tailPrev.key)
            }
            val newNode = Node(key, value)
            cacheMap[key] = newNode
            addToHead(newNode)
        }
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeNode(node: Node) {
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }

    private fun addToHead(node: Node) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }

    data class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */