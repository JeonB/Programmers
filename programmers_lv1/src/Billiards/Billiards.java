package Billiards;

public class Billiards {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];


        answer[0]=(int)(Math.pow(startX-balls[0][0],2)+Math.pow(balls[0][1],2));
        return answer;
    }
}
//원쿠션 연습
// balls는 도착해야 하는 좌표의 위치 배열
// 입사각과 반사각이 같다 -> 주어진 ball좌표의 x나 y의 -값 비교?
// 그냥 하나 잡아서 거리 구하면 됨 결과는 같음