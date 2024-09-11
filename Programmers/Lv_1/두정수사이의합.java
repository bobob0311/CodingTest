class Solution {
    public long solution(int a, int b) {
        int min;
        int max;
        if (a < b) {
            min = a;
            max = b;
        } else if (a == b) {
            return a;
        } else {
            min = b;
            max = a;
        }
        long answer = 0;
        for (int i = min; i <= max; i++) {
            answer += (long) i;
        }
        return answer;
    }
}