package Programmers.고득점kit.완전탐색;

/*
긴 쪽을 가로 혹은 세로로 모두 모은다고 생각한 후 나머지 쪽을 생각하면 
명함중 긴쪽만 모여있는 곳에서 제일 긴 값하나 짧은쪽만 모여있는 곳에서 제일 긴 값하나를 취하면 된다.
*/

class Solution {
    static int max_len1;
    static int max_len2;

    public int solution(int[][] sizes) {
        max_len1 = 0;
        max_len2 = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]) {
                max_len1 = Math.max(max_len1, sizes[i][0]);
                max_len2 = Math.max(max_len2, sizes[i][1]);
            } else {
                max_len1 = Math.max(max_len1, sizes[i][1]);
                max_len2 = Math.max(max_len2, sizes[i][0]);
            }
        }

        return max_len1 * max_len2;
    }
}
