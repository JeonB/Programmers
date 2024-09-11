import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int hIndex = 0;
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            // 해당 인덱스에서의 H-Index 조건 확인
            int h = n - i; 
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        
        return hIndex;
}
}