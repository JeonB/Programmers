function solution(operations) {
    let queue = [];

    operations.forEach(op => {
        const [command, num] = op.split(" ");
        const value = Number(num);

        if (command === "I") {
            queue.push(value);
        } else if (command === "D" && queue.length) {
            queue.sort((a, b) => a - b);
            value === 1 ? queue.pop() : queue.shift();
        }
    });

    if (queue.length === 0) return [0, 0];

    queue.sort((a, b) => a - b);
    return [queue[queue.length - 1], queue[0]];
}