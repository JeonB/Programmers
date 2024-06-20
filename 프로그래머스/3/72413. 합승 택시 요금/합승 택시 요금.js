class MinHeap {
    constructor() {
        this.heap = [];
    }

    push(node) {
        this.heap.push(node);
        this.bubbleUp(this.heap.length - 1);
    }

    pop() {
        const min = this.heap[0];
        const end = this.heap.pop();
        if (this.heap.length > 0) {
            this.heap[0] = end;
            this.bubbleDown(0);
        }
        return min;
    }

    bubbleUp(index) {
        const element = this.heap[index];
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            const parent = this.heap[parentIndex];
            if (element[1] >= parent[1]) break;
            this.heap[index] = parent;
            index = parentIndex;
        }
        this.heap[index] = element;
    }

    bubbleDown(index) {
        const length = this.heap.length;
        const element = this.heap[index];
        while (true) {
            const leftChildIdx = 2 * index + 1;
            const rightChildIdx = 2 * index + 2;
            let leftChild, rightChild;
            let swap = null;
            if (leftChildIdx < length) {
                leftChild = this.heap[leftChildIdx];
                if (leftChild[1] < element[1]) {
                    swap = leftChildIdx;
                }
            }
            if (rightChildIdx < length) {
                rightChild = this.heap[rightChildIdx];
                if (
                    (swap === null && rightChild[1] < element[1]) ||
                    (swap !== null && rightChild[1] < leftChild[1])
                ) {
                    swap = rightChildIdx;
                }
            }
            if (swap === null) break;
            this.heap[index] = this.heap[swap];
            index = swap;
        }
        this.heap[index] = element;
    }

    isEmpty() {
        return this.heap.length === 0;
    }
}

function dijkstra(n, graph, start) {
    const distances = Array(n + 1).fill(Infinity);
    distances[start] = 0;
    const minHeap = new MinHeap();
    minHeap.push([start, 0]);

    while (!minHeap.isEmpty()) {
        const [currentNode, currentDistance] = minHeap.pop();
        if (currentDistance > distances[currentNode]) continue;

        for (const [neighbor, weight] of graph[currentNode]) {
            const distance = currentDistance + weight;
            if (distance < distances[neighbor]) {
                distances[neighbor] = distance;
                minHeap.push([neighbor, distance]);
            }
        }
    }

    return distances;
}

function solution(n, s, a, b, fares) {
    const graph = Array.from({ length: n + 1 }, () => []);
    for (const [u, v, w] of fares) {
        graph[u].push([v, w]);
        graph[v].push([u, w]);
    }

    const startDistances = dijkstra(n, graph, s);
    const aDistances = dijkstra(n, graph, a);
    const bDistances = dijkstra(n, graph, b);

    let minFare = Infinity;
    for (let k = 1; k <= n; k++) {
        minFare = Math.min(minFare, startDistances[k] + aDistances[k] + bDistances[k]);
    }

    return minFare;
}