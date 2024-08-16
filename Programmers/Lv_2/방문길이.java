class Solution {
    static boolean[][][][] visited = new boolean[11][11][11][11];
    static int count;

    public int solution(String dirs) {

        int nowX = 0;
        int nowY = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);

            if (c == 'U') {
                if (nowX + 1 > 5) {
                    continue;
                } else {
                    nowX++;
                    get(nowX, nowX - 1, nowY, nowY);
                }
            } else if (c == 'D') {
                if (nowX - 1 < -5) {
                    continue;
                } else {
                    nowX--;
                    get(nowX, nowX + 1, nowY, nowY);
                }
            } else if (c == 'R') {
                if (nowY + 1 > 5) {
                    continue;
                } else {
                    nowY++;
                    get(nowX, nowX, nowY, nowY - 1);

                }

            } else {
                if (nowY - 1 < -5) {
                    continue;
                } else {
                    nowY--;
                    get(nowX, nowX, nowY, nowY + 1);

                }

            }
        }

        return count;
    }

    static void get(int x1, int x2, int y1, int y2) {
        if (x1 < 0) {
            x1 += 11;
        }
        if (x2 < 0) {
            x2 += 11;
        }
        if (y1 < 0) {
            y1 += 11;
        }
        if (y2 < 0) {
            y2 += 11;
        }

        if (visited[x1][x2][y1][y2] == false) {
            visited[x1][x2][y1][y2] = true;
            visited[x2][x1][y2][y1] = true;
            count++;
        }

        return;
    }
}
