class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] { -1 };
        }
        int v = s / n;
        int[] answer = new int[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = v;
        }

        int h = s % n;
        for (int i = 0; i < h; i++) {
            answer[answer.length - 1 - i]++;
        }

        return answer;
    }
}