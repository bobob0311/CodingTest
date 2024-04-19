package SW기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
/*
직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는


N,M 크기 
파란 구슬을 구멍에 넣지않고 빨간 구슬을 구멍을 통해 빼야한다.
왼쪽, 오른쪽 위, 아래 기울이기 가능
 */

/*
N (세로의 크기) M (가로의 크기) (3~10)
 . -> 빈칸
 # -> 공이 이동할 수 없는 장애물 또는 벽
 o -> 구멍의 위치
 R -> 빨간 구슬의 위치
 B -> 파란 구슬의 위치 
 */

public class 백준13460 {
    static int N, M;
    static char[][] map;
    static int re_y, re_x;
    static int bl_y, bl_x;
    static boolean[][][][] checked; // 이걸 생각못했다 BFS인것두 백트래킹이라고 생각하고 있었음
    static int min = 11;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new char[N][M];
        checked = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < M; j++) {
                if (a.charAt(j) == 'R') {
                    re_y = i;
                    re_x = j;
                    map[i][j] = '.';
                } else if (a.charAt(j) == 'B') {
                    bl_y = i;
                    bl_x = j;
                    map[i][j] = '.';
                } else {
                    map[i][j] = a.charAt(j);
                }

            }
        }
        bfs(re_x, re_y, bl_x, bl_y, 0);

        if (min == 11) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static void bfs(int red_x, int red_y, int blue_x, int blue_y, int count) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { red_x, red_y, blue_x, blue_y, count });
        checked[red_y][red_x][blue_y][blue_x] = true;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int now_count = arr[4];

            if (now_count >= 10) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int rx = arr[0];
                int ry = arr[1];
                int bx = arr[2];
                int by = arr[3];

                while (map[ry + dy[i]][rx + dx[i]] != '#') {
                    ry += dy[i];
                    rx += dx[i];
                    if (map[ry][rx] == 'O') {
                        break;
                    }
                }

                while (map[by + dy[i]][bx + dx[i]] != '#') {
                    by += dy[i];
                    bx += dx[i];
                    if (map[by][bx] == 'O') {
                        break;
                    }
                }

                if (map[by][bx] == 'O')
                    continue;

                if (map[ry][rx] == 'O') {
                    min = Math.min(min, now_count + 1);
                    return;
                }

                if (rx == bx && ry == by && map[ry][rx] != 'O') {
                    int rm = Math.abs(rx - arr[0]) + Math.abs(ry - arr[1]);
                    int bm = Math.abs(bx - arr[2]) + Math.abs(by - arr[3]);

                    if (rm > bm) {
                        rx -= dx[i];
                        ry -= dy[i];
                    } else { // 빨간 공이 더 빨리 도착한 경우
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if (!checked[ry][rx][by][bx]) {
                    checked[ry][rx][by][bx] = true;
                    q.add(new int[] { rx, ry, bx, by, now_count + 1 });
                }
            }

        }

    }

}
