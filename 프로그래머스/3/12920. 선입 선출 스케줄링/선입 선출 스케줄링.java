import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        // 만약 초기 작업 개수 n이 코어 수보다 작거나 같다면, n번째 코어가 마지막 작업을 수행하게 됩니다.
        if (n <= cores.length) {
            return n; 
        }

        n -= cores.length; // 각 코어가 1개의 작업을 처리한 후 남은 작업 개수

        // 이진 탐색으로 최소 작업 완료 시간을 찾기
        long startIdx = 0;
        long endIdx = 500000000L;
        long midIdx;

        while (startIdx < endIdx) {
            midIdx = (startIdx + endIdx) / 2;
            long count = 0;

            for (int core : cores) {
                count += midIdx / core; 
            }

            if (count < n) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx;
            }
        }

        long prevCount = 0;
        for (int core : cores) {
            prevCount += (endIdx - 1) / core;
        }

        int target = (int) (n - prevCount); 


        for (int i = 0; i < cores.length; i++) {
            if (endIdx % cores[i] == 0) { 
                target--;
                if (target == 0) {
                    return i + 1;
                }
            }
        }

        return -1; 
    }
}
