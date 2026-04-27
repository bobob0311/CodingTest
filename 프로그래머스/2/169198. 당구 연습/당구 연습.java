class Solution {
    static int m, n, startX, startY;
    static int[][] balls;
    static int[] answer;

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        this.m = m;
        this.n = n;
        this.startX = startX;
        this.startY = startY;
        this.balls = balls;

        answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            sol(balls[i], i);
        }

        return answer;
    }

    static void sol(int[] ball, int idx) {
        int endX = ball[0];
        int endY = ball[1];

        int minLength = Integer.MAX_VALUE;

        if (startX != endX || endY > startY) {
            int dx = startX - endX;
            int dy = startY + endY;
            minLength = Math.min(minLength, dx * dx + dy * dy);
        }

        if (startY != endY || endX > startX) {
            int dx = startX + endX;
            int dy = startY - endY;
            minLength = Math.min(minLength, dx * dx + dy * dy);
        }

        if (startX != endX || endY < startY) {
            int dx = startX - endX;
            int dy = 2 * n - endY - startY;
            minLength = Math.min(minLength, dx * dx + dy * dy);
        }

        if (startY != endY || endX < startX) {
            int dx = 2 * m - endX - startX;
            int dy = startY - endY;
            minLength = Math.min(minLength, dx * dx + dy * dy);
        }

        answer[idx] = minLength;
    }
}