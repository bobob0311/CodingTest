package Programmers.Lv_2;

/*
12345
22345
33345
44445
55555
*/

class Solution {
    public int[] solution(int n, long left, long right) {
        long length = right - left + 1;
        int[] answer = new int[(int) length];
        int idx = 0;
        for (long i = left; i < right + 1; i++) {
            long m = ((i + 1) / n) + 1;
            long t = (i + 1) % n;
            if (t == 0) {
                answer[idx] = (int) n;
            } else if (m >= t) {
                answer[idx] = (int) m;
            } else {
                answer[idx] = (int) t;
            }
            idx++;

        }

        return answer;
    }
}
