class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers,0,0,target);
        return answer;
    }
    
    public int dfs(int[] numbers, int index, int sum, int target){
        if(numbers.length == index){
            if(sum == target) return 1;
            else return 0;
        }
        
        int add = dfs(numbers, index + 1, sum + numbers[index],target);
        int sub = dfs(numbers, index + 1, sum - numbers[index],target);
        
        return add + sub;
    }
}