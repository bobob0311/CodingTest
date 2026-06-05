import java.util.*;

class Solution {

    static int N, M, K;
    static int startX, startY, endX, endY;

    // 먼저 사전식으로 나열하고 dx, dy도 그거에 맞게 변경
    static String[] dir = {"d", "l", "r", "u"};
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        K = k;
        
        startX = x;
        startY = y;
        endX = r;
        endY = c;
        
        int nowX = startX;
        int nowY = startY;

        int minDist = getDistance(nowX, nowY, endX, endY);


        
        if(!isCanDest(minDist,K)) return "impossible";
//         if (minDist > k) {
//             return "impossible";
//         }

//         if ((k - minDist) % 2 != 0) {
//             return "impossible";
//         }

        StringBuilder answer = new StringBuilder();

        for (int step = 0; step < k; step++) {
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (!isInRange(nextX, nextY)) {
                    continue;
                }

                int remain = k - step - 1;
                int endDist = getDistance(nextX, nextY, endX, endY);

                if (isCanDest(endDist,remain)) {
                    answer.append(dir[i]);
                    nowX = nextX;
                    nowY = nextY;
                    break;
                }
            }
        }

        return answer.toString();
    }
    
    // 현재 최소 남은 거리 , 현재 K의 남은수  
    static boolean isCanDest(int dist, int remain){
        // 사용할 수 있는 칸으로 갈 수 가 없는 경우 
        // 남은게 짝수가 아니라 구현할 수 없는 경우 
        return (remain-dist) >= 0 && (remain-dist) % 2 == 0;
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}