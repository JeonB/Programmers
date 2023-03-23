package Billiards;

public class Billiards {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for(int i = 0 ; i< balls.length;i++){
//            answer[i]=(int)(Math.pow(startX-balls[i][0],2)+Math.pow(startY-balls[i][1],2));
            if(startY == balls[i][1]){
                if(n/2 < balls[i][1]){
                    int y = startY-balls[i][1]+2*(n-balls[i][1]);
                    int x = startX - balls[i][0];
                    answer[i]= (int)(Math.pow(y,2)+Math.pow(x,2));
                }
                else {
                    int y = startY + balls[i][1];
                    int x = startX - balls[i][0];
                    answer[i]=(int)(Math.pow(y,2)+Math.pow(x,2));
                }
            }
            else if(startX == balls[i][0]){
                if(m/2 < balls[i][0]){
                    int x = startX - balls[i][0] + 2 * (m - balls[i][0]);
                    int y = startY - balls[i][1];
                    answer[i] = (int)(Math.pow(x,2)+Math.pow(y,2));
                }
                else {
                    int x = startX + balls[i][0];
                    int y = startY - balls[i][1];
                    answer[i] = (int)(Math.pow(x,2)+Math.pow(y,2));
                }
            } else if (true) {
//                if(startX>balls[i][0] && startY > balls.[i][1])
//                 Math.pow(m-startX,2)+Math.pow(n-startY,2)+Math.pow(startX-balls[i][0])+Math.pow(startY-balls[i][1]) +


            }

        }
        return answer;
    }
}
//원쿠션 연습
// balls는 도착해야 하는 좌표의 위치 배열
// 입사각과 반사각이 같다 -> 주어진 ball좌표의 x나 y의 -값 비교?
// 그냥 하나 잡아서 거리 구하면 됨 결과는 같음