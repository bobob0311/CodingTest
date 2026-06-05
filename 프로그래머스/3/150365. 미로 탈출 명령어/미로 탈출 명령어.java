import java.util.*;

class Solution {

    static int N, M;
    static int endX, endY;

    static String[] dir = {"d", "l", "r", "u"};
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;

        int nowX = x;
        int nowY = y;
        endX = r;
        endY = c;

        int minDist = getDistance(nowX, nowY, endX, endY);

        if (minDist > k) {
            return "impossible";
        }

        if ((k - minDist) % 2 != 0) {
            return "impossible";
        }

        StringBuilder answer = new StringBuilder();

        for (int step = 0; step < k; step++) {
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (!isInRange(nextX, nextY)) {
                    continue;
                }

                int remain = k - step - 1;
                int distanceToEnd = getDistance(nextX, nextY, endX, endY);

                if (distanceToEnd <= remain && (remain - distanceToEnd) % 2 == 0) {
                    answer.append(dir[i]);
                    nowX = nextX;
                    nowY = nextY;
                    break;
                }
            }
        }

        return answer.toString();
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}