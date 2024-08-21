class Solution {
    public int solution(int n) {
        int answer = 0;
        int startIdx = 1;
        while (startIdx <= n) {
            int temp = 0;
            for (int i = startIdx; i < n + 1; i++) {
                temp += i;
                if (temp == n) {
                    answer++;
                    break;
                } else if (temp > n) {
                    break;
                }
            }
            startIdx++;
        }
        return answer;
    }
}