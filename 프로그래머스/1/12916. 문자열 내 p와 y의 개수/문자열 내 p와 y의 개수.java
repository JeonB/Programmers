class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        for(char c : s.toCharArray()){
            if(c == 'y' || c == 'Y') y++;
            else if(c == 'p' || c == 'P') p++;
}
        if(p == 0 && y == 0) return answer;
        if(p != y) return false;

        return answer;
    }
}