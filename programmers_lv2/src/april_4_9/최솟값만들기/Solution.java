package april_4_9.최솟값만들기;

public class Solution
{
    //두 배열의 원소를 뽑아 곱하여 나온1 값을 합하여 누적된 합값이 최솟값이 되도록하는 메소드
    //두 배열의 길이는 같으며 K번 째 원소를 뽑았으면 재사용 불가
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // 1. 람다식 이용 -> 효율성 테스트 실패
        // int[] arrA = Arrays.stream(A).sorted().toArray();
        // int[] arrB = Arrays.stream(B)
        //         .boxed()
        //         .sorted(Comparator.reverseOrder())
        //         .mapToInt(Integer::intValue)
        //         .toArray();

        // 2. bruteforce -> 효율성 테스트 실패
        //     int temp = 0;
        //     for(int j = 0 ; j< A.length-1 ; j++){
        //         for(int i = 1 ; i< A.length-j ; i++)
        //     {
        //         temp = A[i-1];
        //         if(A[i-1]> A[i]){
        //             A[i-1] = A[i];
        //             A[i] = temp;
        //         }
        //         temp = B[i-1];
        //         if(B[i-1] < B[i]){
        //             B[i-1] = B[i];
        //             B[i] = temp;
        //         }
        //     }
        // }

//        Arrays.sort(A);
//        Arrays.sort(B);
        quickSort(A,0,A.length-1);
        quickSort(B,0,B.length-1);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }


    static void swap(int[] data, int pl, int pr) {
        int temp = data[pl];
        data[pl] = data[pr];
        data[pr] = temp;
    }

    static void quickSort(int[] data, int left, int right) { // left, right는 각 커서의 시작점
        int pl = left;
        int pr = right;
        int pivot = data[(pl + pr) / 2]; // 피벗은 각 끝의 커서의 중간 값으로 선택

        do {
            while (data[pl] < pivot) { // data[pl] 값이 pivot보다 큰 수 탐색
                pl++;
            }
            while (data[pr] > pivot) { // data[pr] 값이 pivot보다 작은 수 탐색
                pr--;
            }
            if (pl <= pr) { // pl보다 pr이 크면 교환(오름차순)
                swap(data, pl++, pr--);
            }
        } while (pl <= pr);

        // 정렬 끝난 후 나누어진 두개의 그룹에 데이터 수를 체크
        if (left < pr)
            quickSort(data, left, pr); // left가 pr보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
        if (pl < right)
            quickSort(data, pl, right); // pl이 right보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
    }
}
