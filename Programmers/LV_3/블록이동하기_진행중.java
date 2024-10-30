
/*
최단 거리인데 회전이 들어간다. 
bfs를 사용해야겠지? 
회전 하는 로직을 추가하고 

1. 방향 추가
2. 회전 추가 

100이하

*/
import java.util.*;

class Solution {
    public int solution(int[][] board) {
        Queue<int[][]> que = new LinkedList<>();
        int len = board.length;
        // 공통 대가리 방향
        boolean[][][][] chk = new boolean[board.length][board.length][board.length][2];
        chk[0][0][1][0] = true;

        que.add(new int[][] { { 0, 0 }, { 0, 1 }, { 0, 0 } });
        while (!que.isEmpty()) {
            int[][] arr = que.poll();
            int[] tail = arr[0];
            int[] head = arr[1];
            int[] info = arr[2];
            int direction = info[0];
            int count = info[1];

            if (head[0] == len - 1 && head[1] == len - 1) {
                return count;
            }

            System.out.println(count);
            System.out.println("x:" + head[0] + "y:" + head[1]);

            // 가로 배치인 경우
            if (direction == 0) {
                int x = head[0];

                // y의 좌표들
                int right = head[1] + 1;
                int left = head[1] - 1;

                if (right < len && board[x][right] == 0 && chk[x][right - 1][right][0] == false) {
                    chk[x][right - 1][right][0] = true;
                    que.add(new int[][] { { x, right - 1 }, { x, right }, { 0, count + 1 } });
                }
                if (left - 1 >= 0 && board[x][left - 1] == 0 && chk[x][left - 1][left][0] == false) {
                    chk[x][left - 1][left][0] = true;
                    que.add(new int[][] { { x, left - 1 }, { x, left }, { 0, count + 1 } });
                }
                // 오른쪽 왼쪽이동 끝

                // 회전 하는 로직
                // 1. tail기준 오른쪽 회전, tail기준 왼쪽 회전
                int headY = head[1];
                int tailY = tail[1];
                if (x + 1 < len && board[x + 1][headY] == 0 && board[x + 1][tail[1]] == 0
                        && chk[tailY][x][x + 1][1] == false) {
                    chk[tailY][x][x + 1][1] = true;
                    que.add(new int[][] { tail, { x + 1, tailY }, { 1, count + 1 } });
                }
                if (x - 1 >= 0 && board[x - 1][headY] == 0 && board[x - 1][tail[1]] == 0
                        && chk[tailY][x - 1][x][1] == false) {
                    chk[tailY][x - 1][x][1] = true;
                    que.add(new int[][] { { x - 1, tailY }, tail, { 1, count + 1 } });
                }
                // 2. head 기준 오른쪽 회전 , head 기준 왼쪽 회전
                if (x + 1 < len && board[x + 1][tailY] == 0 && board[x + 1][head[1]] == 0
                        && chk[headY][x][x + 1][1] == false) {
                    chk[headY][x][x + 1][1] = true;
                    que.add(new int[][] { head, { x + 1, head[1] }, { 1, count + 1 } });
                }
                if (x - 1 >= 0 && board[x - 1][tailY] == 0 && board[x - 1][head[1]] == 0
                        && chk[headY][x - 1][x][1] == false) {
                    chk[headY][x - 1][x][1] = true;
                    que.add(new int[][] { { x - 1, head[1] }, head, { 1, count + 1 } });
                }

            } else {
                // 세로 배치인 경우
                int y = head[1];
                int up = head[0] - 1;
                int down = head[0] + 1;
                if (down < len && board[down][y] == 0 && chk[y][down - 1][down][1] == false) {
                    chk[y][down - 1][down][1] = true;
                    que.add(new int[][] { { down - 1, y }, { down, y }, { 1, count + 1 } });
                }
                if (up - 1 >= 0 && board[up - 1][y] == 0 && chk[y][up - 1][up][1] == false) {
                    chk[y][up - 1][up][1] = true;
                    que.add(new int[][] { { up - 1, y }, { up, y }, { 1, count + 1 } });
                }
                // 위아래 이동 끝
                // 1. tail기준 오른쪽 회전, tail기준 왼쪽 회전
                int headX = head[0];
                int tailX = tail[0];

                if (y + 1 < len && board[headX][y + 1] == 0 && board[tailX][y + 1] == 0
                        && chk[tailX][y][y + 1][0] == false) {
                    chk[tailX][y][y + 1][0] = true;
                    que.add(new int[][] { tail, { tailX, y + 1 }, { 0, count + 1 } });
                }
                if (y - 1 >= 0 && board[headX][y - 1] == 0 && board[tailX][y - 1] == 0
                        && chk[tailX][y - 1][y][0] == false) {
                    chk[tailX][y - 1][y][0] = true;
                    que.add(new int[][] { { tailX, y - 1 }, tail, { 0, count + 1 } });
                }
                // 2. head 기준 오른쪽 회전 , head 기준 왼쪽 회전
                if (y + 1 < len && board[tailX][y + 1] == 0 && board[headX][y + 1] == 0
                        && chk[headX][y][y + 1][0] == false) {
                    chk[headX][y][y + 1][0] = true;
                    que.add(new int[][] { head, { headX, head[1] + 1 }, { 0, count + 1 } });
                }
                if (y - 1 >= 0 && board[tailX][y - 1] == 0 && board[headX][y - 1] == 0
                        && chk[headX][y - 1][y][0] == false) {
                    chk[headX][y - 1][y][0] = true;
                    que.add(new int[][] { { headX, head[1] - 1 }, head, { 0, count + 1 } });
                }

            }
        }
        return 0;
    }
}