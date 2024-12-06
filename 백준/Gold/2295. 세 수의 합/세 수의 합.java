import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        // 두 수의 합을 저장할 배열
        int[] sum = new int[arr.length * (arr.length)];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum);

        int answer = 0;
        for (int i = arr.length - 1; i >= 0; i--) { // 큰 값부터 탐색
            for (int j = 0; j < i; j++) { // 작은 값과 차이를 계산
                if (binarySearch(sum, arr[i] - arr[j])) {
                    answer = Math.max(answer, arr[i]);
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    // 이진 탐색 구현
    static boolean binarySearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2; // 올바른 mid 계산
            if (arr[mid] < value) {
                start = mid + 1;
            } else if (arr[mid] > value) {
                end = mid - 1;
            } else {
                return true; // 값이 존재하면 true 반환
            }
        }
        return false; // 찾지 못한 경우 false 반환
    }
}
