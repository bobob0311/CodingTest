/*
a^2 + b^2 <=c^2
*/

class Solution {
    static long answer = 0;

    public long solution(int k, int d) {
        long c = (long) d * (long) d;
        for (int i = 0; i <= d; i += k) {
            long a = (long) i * (long) i;
            long now = (long) Math.sqrt(c - a) / k;
            answer += now + 1;
        }

        return answer;
    }
}