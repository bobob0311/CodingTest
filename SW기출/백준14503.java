package SW기출;

import java.io.*;
import java.util.*;

/*
방은 N X M 크기의 직사각형 // 칸은 벽또는 빈칸이다.     
동(오른쪽) 서(왼쪽) 남(아래) 북(위)
처음에 빈 칸은 전부 청소되지 않은 상태

1. 현재 칸 청소가 안되있으면 청소
2. 주변 4칸중 청소되지 않은 빈칸이없다면
    1. 한칸 후진이 가능하다면 한칸 후진 후 다시 1번
    2. 바라보는 방향의 뒤쪽이 벽이면 후진 -> 종료 조건


3. 4칸 중 청소되지 않은 빈칸이 있는 경우
    1. 반시계 방향으로 90 회전
    2. 바라보는 방향으로 앞쪽이 청소되지 않았을 경우 한칸 전진 
    3. 1번으로 돌아간다.

 */

//중간중간 맥락을 놓치면서 코딩을 하는 듯?

public class 백준14503 {
    static int N, M;
    static int[][] arr;
    static int head; // 바라보는 방향 0 위 1 오른쪽 2 아래 3 왼쪽 -> 시계 방향인데 이건
    static boolean[][] chk; // 청소한걸 확인하는 역할
    static int count = 0;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 }; // -1이면 위 1이면 아래

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        chk = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        int first_y = Integer.parseInt(st.nextToken());
        int first_x = Integer.parseInt(st.nextToken());

        head = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        play(first_x, first_y);
        System.out.println(count);
    }

    static boolean check(int x, int y, int num) { // 확인할 방향을 num으로

        if (x + dx[num] < 0 || x + dx[num] >= M || y + dy[num] < 0 || y + dy[num] >= N) {
            return false;
        }

        return true;
    }

    static void play(int x, int y) {
        int now_y = y;
        int now_X = x;

        while (true) {

            if (chk[now_y][now_X] == false) { // 0으로만 가야된다.
                chk[now_y][now_X] = true;
                count++;
            }

            boolean canMove = false;

            for (int i = 0; i < 4; i++) { // 청소되지 않은 빈칸이 있는 경우
                if (arr[now_y + dy[i]][now_X + dx[i]] == 0
                        && chk[now_y + dy[i]][now_X + dx[i]] == false) {
                    canMove = true;
                }
            }

            if (canMove == true) { // 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우.
                head = head - 1;
                if (head < 0) {
                    head += 4;
                }
                // 반시계로 돌리기

                if (arr[now_y + dy[head]][now_X + dx[head]] == 0
                        && chk[now_y + dy[head]][now_X + dx[head]] == false) {
                    now_y = now_y + dy[head];
                    now_X = now_X + dx[head];
                }
                continue;
            } else {
                int back = head - 2;
                if (back < 0) {
                    back += 4;
                }
                // 뒤에 방향을 나타내는 back 변수 만들기 head는 바라보는 방향이므로 유지

                if (arr[now_y + dy[back]][now_X + dx[back]] == 0) {
                    now_y = now_y + dy[back];
                    now_X = now_X + dx[back];
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}
