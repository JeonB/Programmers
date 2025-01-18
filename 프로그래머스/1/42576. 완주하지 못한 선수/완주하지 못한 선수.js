function solution(participant, completion) {
    let answer = '';
    function toMap(arr){
        const map = {}
        for(const person of arr){
            if(!map[person]) map[person] = 0
            map[person] += 1
        }
        
        return map
    }
    const participantMap = toMap(participant)
    const completionMap = toMap(completion)
    for(const key in participantMap){
        if(participantMap[key] !== completionMap[key]) return key
    }
    return answer;
}