package may_15_21.n제곱배열자르기;

/**
 * 정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.
 *
 * n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
 * i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
 * 1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
 * 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
 * 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
 * 정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.
 */
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];

        /* n^n 배열과 그 값을 담을 1차원 배열
        * arr[0 [0,0]],arr[1 [0,1]],arr[2 [0,2]],..
        * arr[0 [0/n,0%n]],arr[1 [1/n,1%n]],arr[2 [2/n,2%n]]
        * */
        long a = 0;
        long b = 0;
        int index = 0 ;
        for (long i = left; i <= right; i++) {
             a = i / n;
             b = i % n;
            if (a < b) {
                answer[index++] = (int) b + 1;
                continue;
            }
            answer[index++] = (int) a +1;
        }

        return answer;
    }
}

/*
*   while progresses :
        #몇개의 기능이 배포되는지 저장
        cnt = 0
        #작업 리스트가 남아있고 맨 앞의 작업의 진도가 100인 경우: 기능 배포 변수 증가. 해당 작업과 작업 속도를 리스트에서 제거
        while progresses and progresses[0] >= 100:
            cnt+=1
            progresses.pop(0)
            speeds.pop(0)

        # 작업 리스트의 진도를 증가
        progresses = [progresses[i]+speeds[i] for i in range(len(progresses))]

        #만약 오늘 기능이 배포되었다면 결과리스트에 추가
        if cnt:
            answer.append(cnt)
    */