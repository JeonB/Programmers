function solution(arr) {
    let answer = [0,0];
    
    
    function compress(row , col , size){
        
        const target = arr[row][col]
        
        for(let i = row ; i<row+size ;i++){
            for(let j = col ; j<col+size ; j++){
                if(target !== arr[i][j]){
                    return(
                    compress(row, col, size/2)+
                    compress(row+size/2,col,size/2)+
                    compress(row,col+size/2,size/2)+
                    compress(row+size/2,col+size/2,size/2))
                }
            }
        }
        
        return target === 0 ? answer[0]++ : answer[1]++
    }
    
    compress(0,0,arr.length)
    
    return answer;
}