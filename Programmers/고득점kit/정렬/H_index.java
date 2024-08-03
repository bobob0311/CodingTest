package Programmers.고득점kit.정렬;

import java.util.*;

/*
n 편중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h 번이하 인용 h의 최댓값이  과학자의 H-index
*/

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int idx = 0;
        int high = citations.length;
        int low = 0;
        int h = 0;
        int answer = 0;

        while (idx != citations.length) {
            if (h <= high && h >= low) {
                answer = h;
            }
            if (h < low || h > high) {
                return h - 1;
            }
            while (h == citations[idx]) {
                idx++;
                high--;
                low++;
                if (idx == citations.length) {
                    break;
                }
            }

            h++;
        }
        /*
         * 0 10 0
         * 1 10 0
         * 2 8 2
         * 3 8 2
         * 4 5 5
         * 
         * 1 1 3 3 3 5 5 6 11 41
         */
        return answer;
    }
}
