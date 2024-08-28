import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<int[]> list = new ArrayList<>();
        int sortIndex;
        if(ext.equals("code")){
            Arrays.sort(data,(a,b) -> Integer.compare(a[0],b[0]));
            sortIndex = 0;
        }else if(ext.equals("date")){
            Arrays.sort(data,(a,b) -> Integer.compare(a[1],b[1]));
            sortIndex = 1;
        }else if(ext.equals("maximum")){
            Arrays.sort(data,(a,b) -> Integer.compare(a[2],b[2]));
            sortIndex = 2;
        }else{
            Arrays.sort(data,(a,b) -> Integer.compare(a[3],b[3]));
            sortIndex = 3;
        }
        
        for(int i = 0 ; i<data.length ; i++){
            if(data[i][sortIndex] >= val_ext) break;
            
            list.add(data[i]);
        }
        
        answer = list.toArray(new int[list.size()][]);
        
        if(sort_by.equals("code")){
            Arrays.sort(answer,(a,b) -> Integer.compare(a[0],b[0]));
            sortIndex = 0;
        }else if(sort_by.equals("date")){
            Arrays.sort(answer,(a,b) -> Integer.compare(a[1],b[1]));
            sortIndex = 1;
        }else if(sort_by.equals("maximum")){
            Arrays.sort(answer,(a,b) -> Integer.compare(a[2],b[2]));
            sortIndex = 2;
        }else{
            Arrays.sort(answer,(a,b) -> Integer.compare(a[3],b[3]));
            sortIndex = 3;
        }
        
        
        return answer;
    }
}