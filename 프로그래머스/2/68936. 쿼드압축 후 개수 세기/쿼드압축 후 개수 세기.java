import java.util.*;
class Solution {
      public static int[] solution(int[][] arr) {
        int[] result = new int[2]; // result[0] -> 0의 개수, result[1] -> 1의 개수
        compress(arr, 0, 0, arr.length, result);
        return result;
    }

    private static void compress(int[][] arr, int row, int col, int size, int[] result) {
        if (isUniform(arr, row, col, size)) {
            // 압축 가능하다면 해당 숫자의 개수를 증가
            result[arr[row][col]]++;
        } else {
            // 압축 불가능하면 4개의 영역으로 나눠서 재귀적으로 처리
            int newSize = size / 2;
            compress(arr, row, col, newSize, result);                     // 좌상단
            compress(arr, row, col + newSize, newSize, result);          // 우상단
            compress(arr, row + newSize, col, newSize, result);          // 좌하단
            compress(arr, row + newSize, col + newSize, newSize, result); // 우하단
        }
    }

    private static boolean isUniform(int[][] arr, int row, int col, int size) {
        int value = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}