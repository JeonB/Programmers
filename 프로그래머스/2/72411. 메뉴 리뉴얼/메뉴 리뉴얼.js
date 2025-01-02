function solution(orders, course) {
    const getCombinations = (arr, selectNumber) => {
        const results = [];
        if (selectNumber === 1) return arr.map((value) => [value]);
        arr.forEach((fixed, index, origin) => {
            const rest = origin.slice(index + 1);
            const combinations = getCombinations(rest, selectNumber - 1);
            const attached = combinations.map((combination) => [fixed, ...combination]);
            results.push(...attached);
        });
        return results;
    };

    const countMap = {};
    
    orders.forEach((order) => {
        const sortedOrder = order.split('').sort();
        course.forEach((num) => {
            getCombinations(sortedOrder, num).forEach((comb) => {
                const key = comb.join('');
                countMap[key] = (countMap[key] || 0) + 1;
            });
        });
    });

    const result = [];

    course.forEach((num) => {
        const filtered = Object.keys(countMap)
            .filter((key) => key.length === num && countMap[key] >= 2);
        if (filtered.length) {
            const max = Math.max(...filtered.map((key) => countMap[key]));
            filtered
                .filter((key) => countMap[key] === max)
                .forEach((key) => result.push(key));
        }
    });

    return result.sort();
}
