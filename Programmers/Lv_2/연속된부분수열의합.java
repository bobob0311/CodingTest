package Programmers.Lv_2;

/*
투포인터 문제 코드가 깔끔하지 못함..
 */

class Solution {
    static int min_length = 1000001;
    static int max_idx;
    static int min_idx;

    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int idx1 = 0;
        int idx2 = 0;
        sum = sequence[0];
        while (true) {
            if (sum == k) {
                if (idx2 - idx1 + 1 < min_length) {
                    min_idx = idx1;
                    max_idx = idx2;
                    min_length = max_idx - min_idx + 1;
                }
            }
            if (sum >= k || idx2 == sequence.length - 1) {
                if (idx1 == sequence.length) {
                    break;
                }
                sum -= sequence[idx1];
                idx1++;
            } else {
                idx2++;
                sum += sequence[idx2];
            }

        }

        int[] answer = new int[] { min_idx, max_idx };
        return answer;
    }
}
