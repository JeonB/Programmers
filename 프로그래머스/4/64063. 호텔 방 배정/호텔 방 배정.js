function solution(k, room_number) {
    const assigned = new Map(); // 유니온-파인드를 위한 맵
    const answer = [];

    function find(room) {
        if (!assigned.has(room)) {
            assigned.set(room, room + 1);
            return room;
        }
        let nextRoom = find(assigned.get(room)); // 경로 압축
        assigned.set(room, nextRoom);
        return nextRoom;
    }

    for (let num of room_number) {
        let room = find(num);
        answer.push(room);
    }

    return answer;
}