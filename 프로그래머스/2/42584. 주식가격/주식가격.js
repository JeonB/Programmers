function solution(prices) {
   const n = prices.length
   const answer = new Array(n)
   
   for(let i = 0 ; i < n ; i++){
       answer[i] = n - 1 - i
   }
    
   const stack = [] 
   stack.push({index: 0, price : prices[0]})
    
   for(let i = 1 ; i < n ; i++){
       while(stack.length !== 0 && stack[stack.length-1].price > prices[i]){

               const {index,price} = stack.pop()
               answer[index] = i - index
       }
       stack.push({index:i,price: prices[i]})
   }
    
   return answer
}