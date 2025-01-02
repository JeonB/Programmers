function solution(strings, n) {
    
    return strings.sort((a,b) => {
           return a[n] === b[n] ?  a.localeCompare(b) :  a.charCodeAt(n) - b.charCodeAt(n)
        }
    )
 
}