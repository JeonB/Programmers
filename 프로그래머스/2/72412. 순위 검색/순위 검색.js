function solution(info, query) {
    let answer = [];
    const map = {}
    const preprocess = (infoArr, score, idx) =>{
        const condition = infoArr.join('')
        if(!map[condition]) map[condition] = []
        map[condition].push(score)
        
        for(let i = idx ; i < infoArr.length ; i++){
           const tmp = [...infoArr]
           tmp[i] = '-'
            preprocess(tmp,score,i+1)
        }
    }
    for(const data of info){
        const [language,occupation,career,food,score] = data.split(' ')
        preprocess([language,occupation,career,food],parseInt(score),0)
    }
    for(const key in map){
        map[key].sort((a,b) => a-b)
    }
    const binarySearch = (arr , target)=>{
        let left = 0
        let right = arr.length
        while(left < right){
            const mid = Math.floor((left + right) / 2)
            if(arr[mid] >= target) right = mid
            else left = mid + 1
        }
        return arr.length - left
    }
    for(const q of query){
        const [condition, targetScore] = q.replace(/ and /g,"").split(" ")
        if(map[condition]){
           const cnt = binarySearch(map[condition],parseInt(targetScore))
           answer.push(cnt)
        }else  answer.push(0)
    }
    
    return answer;
}