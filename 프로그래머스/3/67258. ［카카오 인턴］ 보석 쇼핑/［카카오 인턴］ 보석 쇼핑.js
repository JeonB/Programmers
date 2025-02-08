function solution(gems) {
    const gemSortCnt = new Set(gems).size
    let left = 0 , right = 0
    const gemCount = new Map()
    let minlen = 100001 , answer = [1, gems.length]
    
    while(right < gems.length){
        gemCount.set(gems[right], (gemCount.get(gems[right]) || 0) + 1)
        right++
        while(gemCount.size === gemSortCnt){
            if(right - left < minlen){
                minlen = right - left
                answer = [left + 1 , right]
            }
            gemCount.set(gems[left], gemCount.get(gems[left]) - 1)
            if(gemCount.get(gems[left]) === 0){
                 gemCount.delete(gems[left])
            }
            left++
        }
    }
    return answer
}