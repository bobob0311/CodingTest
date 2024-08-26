
/*
블록에 적힌 번호가 n 가장 첫 블록 
n*2 n*3 ...

4

*/
import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        long length = end - begin;
        int[] answer = new int[(int) length + 1];

        int idx = 0;

        if (begin == 1) {
            begin++;
            answer[idx] = 0;
            idx++;
        }
        for (long i = begin; i <= end; i++) {

            boolean find = false;
            long max = 0;
            for (long j = 2; j <= (long) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    long v = i / j;
                    max = j;
                    if (v <= 10000000) {
                        answer[idx] = (int) v;
                        find = true;
                        break;
                    }
                }
            }
            if (!find) {
                if (max != 0) {
                    answer[idx] = (int) max;
                } else {
                    answer[idx] = (int) 1;
                }

            }

            idx++;
        }

        return answer;
    }
}