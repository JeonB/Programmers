import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
       
        return explore(k, dungeons, new boolean[dungeons.length]);
    }
    
    private int explore(int k, int[][] dungeons, boolean[] visited){
        int maxDungeons = 0;
        
        for(int i = 0 ; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                int dungeonExplored = explore(k - dungeons[i][1], dungeons, visited) + 1;
                maxDungeons = Math.max(maxDungeons, dungeonExplored);
                visited[i] = false;
            }
        }
        
        return maxDungeons;
    }
}