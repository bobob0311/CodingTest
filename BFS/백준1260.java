// DFS와 BFS로 탐색한 결과를 출력하는 프로그램을 작성

// 정점의 개수 (1<=N<=1,000) 
// 간선의 개수 (1<=M<=10,000)
// 탐색을 시작할 정점의 번호 V

// N,M,V
// M개의 줄에는 간선이 연결하는 두정점의 번호, 두정점 사이에 여러개의 간선이 있을 수 있다. 주어지는 간선은 양방향

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준1260 {
    static StringBuilder d = new StringBuilder();
    static StringBuilder b = new StringBuilder();
    static int N, M, V;
    static int[][] node;
    static Queue<Integer> queue = new LinkedList<>();

    static boolean[] visited_b, visited_d;

    // 깊이우선으로 stack,재귀를 필요로함
    static void dfs(int x) {
        visited_d[x] = true;
        d.append(x + " ");
        for (int i = 0; i < N + 1; i++) {
            if (node[x][i] == 1 && !visited_d[i]) {
                dfs(i);
            }
        }

    }

    // 넓이 우선으로 queue를 필요로함
    static void bfs(int x) {
        queue.add(x);
        visited_b[x] = true;
        while (!queue.isEmpty()) {
            int target = queue.poll();
            b.append(target + " ");
            for (int i = 0; i < N + 1; i++) {
                if (node[target][i] == 1 && !visited_b[i]) {
                    queue.add(i);
                    visited_b[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 노드수
        M = sc.nextInt(); // 간선수
        V = sc.nextInt(); // 시작노드

        node = new int[N + 1][N + 1];
        visited_b = new boolean[N + 1];
        visited_d = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            node[first][second] = node[second][first] = 1;
        }
        dfs(V);
        System.out.println(d);

        bfs(V);
        System.out.println(b);

    }

}
