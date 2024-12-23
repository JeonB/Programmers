function solution(brown, yellow) {
    let answer = [];
    let rectangle = brown + yellow
 
    for(let i = 3 ; i <= Math.sqrt(rectangle) ; i++){
        if(rectangle % i === 0){
            const width = rectangle/i 
            const height = i
            if((width - 2 ) * (height - 2) === yellow) return [width,height]
        }
    }
    return ["노답"];
}