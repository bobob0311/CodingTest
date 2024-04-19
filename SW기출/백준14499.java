package SW기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현 문제인거 같네?
// 주사위를  못하겠어요..

/*
N X M 인 지도 존재    오른쪽은 동 위쪽은 북
지도위에 주사위가 하나 놓여져있다.
지도의 좌표는 (r,c) r은 y좌표 c는 x좌표 0부터 세면된다.

가장 처음에 주사위에는 모든 면에 0
지도의 각 칸엔 정수가 쓰여져 있다 

- 주사위 굴렸을 때 이동한 칸이 0이면 
    주사위 바닥면에 쓰여있는 수가 칸에 복사

- 주사위 굴렸을 때 이동한 칸이 0이 아니라면 
    칸에 쓰여 있는 수가 주사위의 바닥면으로 복사
    칸에 쓰여 있는 수는 0 이된다.

주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 
상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오
 */

/*
세로 크기 N 가로 크기 M (1~20) 주사위 좌표 (x,y) -> (0<=x<=N-1 , 0<=y<=M-1)
 */
public class 백준14499 {
    static int[][] arr;
    static int N, M;
    static int[][] dice;
    static int now_x, now_y;
    static int target = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        now_y = Integer.parseInt(st.nextToken());
        now_x = Integer.parseInt(st.nextToken());
        int co = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dice = new int[4][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < co; i++) {
            int order = Integer.parseInt(st.nextToken());
            boolean chk = true;
            if (order == 4) { // 아래로
                if (now_y + 1 >= N) {
                    continue;
                } else {
                    now_y++;
                    int temp = dice[1][1];
                    dice[1][1] = dice[0][1];
                    dice[0][1] = dice[3][1];
                    dice[3][1] = dice[2][1];
                    dice[2][1] = temp;
                    chk(now_x, now_y);

                }

            } else if (order == 3) {
                if (now_y - 1 < 0) {
                    continue;
                } else {
                    now_y--;
                    int temp = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = dice[3][1];
                    dice[3][1] = dice[0][1];
                    dice[0][1] = temp;
                    chk(now_x, now_y);
                }
            } else if (order == 2) {
                if (now_x - 1 < 0) {
                    continue;
                } else {
                    now_x--;
                    int temp = dice[1][1];
                    dice[1][1] = dice[1][0];
                    dice[1][0] = dice[3][1];
                    dice[3][1] = dice[1][2];
                    dice[1][2] = temp;
                    chk(now_x, now_y);

                }
            } else if (order == 1) {
                if (now_x + 1 >= M) {
                    continue;
                } else {
                    now_x++;
                    int temp = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = dice[3][1];
                    dice[3][1] = dice[1][0];
                    dice[1][0] = temp;
                    chk(now_x, now_y);

                }
            }
        }

    }

    static void chk(int x, int y) {
        if (arr[y][x] == 0) {
            arr[y][x] = dice[1][1];
        } else {
            dice[1][1] = arr[y][x];
            arr[y][x] = 0;
        }
        System.out.println(dice[3][1]);
    }
}
