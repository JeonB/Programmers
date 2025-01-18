function solution(before, after) {
 const a =  [...before].sort() 
 const b =  [...after].sort() 

   return  a.every((val, index) => val === b[index]) ? 1 : 0;
}