class DualPriorityQueue {
    constructor() {
        this.minHeap = [];
        this.maxHeap = new Map(); // 삭제된 요소를 추적하기 위한 맵
    }

    insert(value) {
        this.minHeap.push(value);
        this.minHeap.sort((a, b) => a - b); // 최소 힙 유지
        this.maxHeap.set(value, (this.maxHeap.get(value) || 0) + 1); // 개수 저장
    }

    deleteMax() {
        while (this.minHeap.length) {
            const maxVal = this.minHeap.pop();
            if (this.maxHeap.has(maxVal) && this.maxHeap.get(maxVal) > 0) {
                this.maxHeap.set(maxVal, this.maxHeap.get(maxVal) - 1);
                if (this.maxHeap.get(maxVal) === 0) this.maxHeap.delete(maxVal);
                return;
            }
        }
    }

    deleteMin() {
        while (this.minHeap.length) {
            const minVal = this.minHeap.shift();
            if (this.maxHeap.has(minVal) && this.maxHeap.get(minVal) > 0) {
                this.maxHeap.set(minVal, this.maxHeap.get(minVal) - 1);
                if (this.maxHeap.get(minVal) === 0) this.maxHeap.delete(minVal);
                return;
            }
        }
    }

    getMinMax() {
        const validNumbers = this.minHeap.filter(val => this.maxHeap.has(val) && this.maxHeap.get(val) > 0);
        return validNumbers.length ? [validNumbers[validNumbers.length - 1], validNumbers[0]] : [0, 0];
    }
}

function solution(operations) {
    const dpq = new DualPriorityQueue();

    for (const op of operations) {
        const [command, num] = op.split(" ");
        const value = Number(num);

        if (command === "I") {
            dpq.insert(value);
        } else if (command === "D" && value === 1) {
            dpq.deleteMax();
        } else if (command === "D" && value === -1) {
            dpq.deleteMin();
        }
    }

    return dpq.getMinMax();
}
