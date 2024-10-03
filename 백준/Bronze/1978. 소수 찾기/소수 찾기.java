import java.util.Scanner;

public class Main {
    // 소수인지 확인하는 함수
    public static boolean isPrime(int number) {
        if (number < 2) return false;  // 0과 1은 소수가 아님
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;  // 약수가 있으면 소수가 아님
            }
        }
        return true;  // 약수가 없으면 소수
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫 줄에 주어지는 수의 개수 N
        int N = sc.nextInt();
        
        int primeCount = 0;
        
        // N개의 수를 입력받아 소수인지 확인
        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            if (isPrime(number)) {
                primeCount++;  // 소수일 때만 카운트 증가
            }
        }
        
        // 소수의 개수 출력
        System.out.println(primeCount);
        
        sc.close();
    }
}
