package SW기출;
/*
매 초 이동
벽이나 자신의 몸과 부딪히면 게임이 끝나는 방식
이동한 칸에 사과가있다면 사과가 없어지고꼬리는 움직이지 않는다
사과가 없다면 꼬리 칸을 비워준다

-> 투포인터 느낌인데 꺽이는걸 어떻게 표현해야 할지
-> 투포인터가 아닌 큐를 활용해서 표현 
 */

/*
보드의 크기 N
다음줄에 사과 개수 K

K개의 줄에는 사과의 위치 (행,열)

방향 변환 횟수 L

L 개의 줄에는 뱀의 방향 변환정보
x초가 끝난뒤에 L왼쪽 D오른 쪽으로 90도 방향회전

*/

import java.util.*;
import java.io.*;

public class 백준3190 {

    static int N; // 보드의 크기
    static int K; // 사과의 개수
    static int[][] map; // 보드판
    static int L; // 방향변환 횟수
    static int[] time;
    static char[] go;
    static int head;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int now_y = 0, now_x = 0;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            map[y][x] = 2; // 사과가 있는 곳은 2로 표시
        }

        L = Integer.parseInt(br.readLine());

        time = new int[L];
        go = new char[L];

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            go[i] = st.nextToken().charAt(0);
        }
        int idx = 0;
        int t = 1;
        head = 1;
        queue.add(new int[] { 0, 0 });
        while (true) {
            if (now_y + dy[head] < 0 || now_y + dy[head] >= N || now_x + dx[head] < 0 || now_x + dx[head] >= N) {
                System.out.println(t);
                break; // 범위를 넘어갔을 때
            } else {
                now_y += dy[head];
                now_x += dx[head];
                // 머리를 다음칸에 위치시키기

                if (map[now_y][now_x] == 1) {
                    System.out.println(t);
                    break;
                    // 몸을 만났기 때문에 종료
                } else if (map[now_y][now_x] == 0) {
                    map[now_y][now_x] = 1;
                    queue.add(new int[] { now_x, now_y });
                    arr = queue.poll();
                    int temp_x = arr[0];
                    int temp_y = arr[1];
                    map[temp_y][temp_x] = 0;

                    // 사과가 없는 경우이므로 몸길이를 줄여준다.
                } else if (map[now_y][now_x] == 2) {
                    map[now_y][now_x] = 1;
                    queue.add(new int[] { now_x, now_y });
                    // 사과가 있는경우 몸만 가기
                }
            }

            if (idx < L) {
                if (t == time[idx]) {
                    if (go[idx] == 'L') {
                        head--;
                    } else {
                        head++;
                    }
                    if (head < 0) {
                        head += 4;
                    } else if (head >= 4) {
                        head %= 4;
                    }
                    idx++;
                }
            }
            t++;
        }
    }

}
