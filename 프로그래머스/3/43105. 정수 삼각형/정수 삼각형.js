function solution(triangle) {
  const n = triangle.length
  const dp = Array.from({length:n}, () => Array(n).fill(-1))
  
  function memo(i,j,triangle) {
      if(i === n) return 0
      if(dp[i][j] !== -1) return dp[i][j]
      
      return dp[i][j] = triangle[i][j] +Math.max(memo(i+1,j,triangle),memo(i+1,j+1,triangle))
  }
    return memo(0,0,triangle)
}