package may_15_21.n제곱배열자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        // n행 n열 2차원배열 생성
        int[][] double_arr = new int[n][n];

        // i행 i열까지 숫자 i로 채우기
        for(int i = 1 ; i<=double_arr.length ; i++){
            for(int j = 0 ; j<i; j++){
                for(int k = 0; k<= j ; k++){
                    double_arr[j][k] = j+1;
                    double_arr[k][j] = j+1;
                }
            }
        }

        int row_l = (int)left/(n-1);
        int culumn_l = (int)left%n-1;
        if(culumn_l<0)
            culumn_l = n-1;
        int row_r = (int)right/(n-1);
        int culumn_r = (int)right%n-1;
        if(culumn_r<0)
            culumn_r = n-1;
        // arr[left] ~ arr[right] 만 남긴 값을 answer에 넣음
        int cnt = 0;
        if(row_l+1 < row_r){
            cnt =n;
        }

        for(int i = row_l+1 ; i<=row_r-1 ; i++ ){
            for(int j = 0; j<n;j++ )
                answer[cnt++] = double_arr[i][j];
        }
        int first = n-culumn_l;
        int last = n-culumn_r;
        for(int i = 0; i< first ;i++)
            answer[i] = double_arr[row_l][culumn_l++];
        for(int i = 0; i<last ;i++)
            answer[cnt++] = double_arr[row_r][culumn_r++];
        return answer;
    }
}