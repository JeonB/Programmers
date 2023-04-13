package april_10_16.카펫;

public class Solution {
    /*
    Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
    Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아
    return 하도록 solution 함수를 작성해주세요
    */
    public int[] solution(int brown, int yellow) {

        int height = 0;
        int width = 0;
        int n = brown + yellow;
        for(int i = 1 ; i*i <= n ; i++){
            if(n%i ==0){
                height = i;
                width = n/i;
            }
            if(yellow%(width -2) == 0)
                break;
        }
        int[] answer = {width,height};
        return answer;
    }
}
