class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        
        val graph = buildGraph(n, edges, succProb)
        val probabilities = DoubleArray(n) { 0.0 }
        probabilities[start] = 1.0
        val queue: Queue<Int> = LinkedList<Int>()
        queue.offer(start)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            for (neighbor in graph[node]) {
                val probability = probabilities[node] * neighbor.probability

                if (probability > probabilities[neighbor.node]) {
                    probabilities[neighbor.node] = probability
                    queue.offer(neighbor.node)
                }
            }
        }

        return probabilities[end]

    }

    private fun buildGraph(n: Int, edges: Array<IntArray>, succProb: DoubleArray): Array<MutableList<Neighbor>> {
        val graph = Array(n) { mutableListOf<Neighbor>() }

        for (i in edges.indices) {
            val edge = edges[i]
            val u = edge[0]
            val v = edge[1]
            val probability = succProb[i]
            graph[u].add(Neighbor(v, probability))
            graph[v].add(Neighbor(u, probability))
        }

        return graph
    }

    data class Neighbor(val node: Int, val probability: Double)
}