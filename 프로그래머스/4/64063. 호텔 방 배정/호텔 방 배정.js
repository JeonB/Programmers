function solution(k, room_number) {
    const map = new Map()
    function find(roomNum){
        if(!map.has(roomNum)){
            map.set(roomNum, roomNum+1)
            return roomNum
        }
        const nextRoom = find(map.get(roomNum))
        map.set(roomNum,nextRoom)
        return nextRoom
    }
    const answer = []
    for(const num of room_number){
        const room = find(num)
        answer.push(room)
    }
    return answer;
}