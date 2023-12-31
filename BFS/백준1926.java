package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 
출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 
연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다. */

/*첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 
줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 
0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다) */

/*첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 
없는 경우에는 가장 넓은 그림의 넓이는 0이다. */

public class 백준1926 {

    static int n, m; // 도화지 세로와 가로의 크기를 담을 변수
    static int[][] graph; // 그래프를 표현할 변수
    static boolean[][] visited; // 방문여부를 확인할 변수
    static int count = 0; // 갯수를 세줄 변수
    static int[][] pos = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    static void bfs(int x, int y) {
        visited[x][y] = true; // 이 점에 들렸다는 것을 확인
        Queue<int[]> queue = new LinkedList<>(); // 연결리스트로 queue를 생성
        queue.add(new int[] { x, y }); // que에 현재 점을 집어넣는다

        while (!queue.isEmpty()) { // que가 비워지기 전까지
            int[] arr = queue.poll(); // 제일 처음 들어온것을 arr로 저장
            int nowX = arr[0];
            int nowY = arr[1];

            for (int i = 0; i < pos.length; i++) { // 동서남북 4방향 모두 확인
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                // 주어진 크기 안으로 들어와있고 방문하지 않았을 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    count++; // 개수 증가
                    visited[nx][ny] = true; // 방문했다고 바꾸기
                    queue.add(new int[] { nx, ny }); // que에 이점 추가
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 스캐너 생성

        n = sc.nextInt(); // n 변수 값
        m = sc.nextInt(); // m 변수 값

        boolean zero = true;

        List<Integer> answer = new ArrayList<>(); // 정수만 들어갈 리스트 생성

        graph = new int[n][m]; // 그래프 크기 지정
        visited = new boolean[n][m]; // 참값도 똑같이 참 거짓

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt(); // 주어진 그래프 값 넣기

                if (graph[i][j] == 1) {
                    zero = false; // 넓이가 아예 없는경우
                }
            }
        }

        if (zero == true) {
            System.out.println("0");
            System.out.println("0");
            return;
        } // 예외처리같은 경우

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0;

                if (graph[i][j] == 1 && !visited[i][j]) { // 만약 1인데 방문하지 않은경우
                    count++; // 넓이를 1 늘린다
                    bfs(i, j); // 그점에서 bfs를 실행한다.
                    answer.add(count); //
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        System.out.println(answer.get(answer.size() - 1));

    }
}
