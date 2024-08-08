package Programmers.고득점kit.완전탐색;

/* 오잉... */

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            int m;
            int n;
            if (yellow % i == 0) {
                m = i;
                n = yellow / i;
                if (m * 2 + n * 2 + 4 == brown) {
                    return new int[] { n + 2, m + 2 };
                }
            }

        }
        return new int[] {};
    }
}
