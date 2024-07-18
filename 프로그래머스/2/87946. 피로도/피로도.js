function solution(k, dungeons) {
    
    function maxDungeons(k,dungeons,visited){
        let maxDungeonCount = 0;
        for(let i = 0 ; i < dungeons.length ; i++){
            if(dungeons[i][0] <= k && !visited[i]){
                visited[i] = true;
                maxDungeonCount = Math.max(maxDungeonCount ,maxDungeons(k - dungeons[i][1], dungeons , visited) + 1);
                visited[i] = false;
            }
        }

        return maxDungeonCount;
    }
    
    let visited = Array.from({ length: dungeons.length }, ()=>false);
    return maxDungeons(k,dungeons,visited)
}