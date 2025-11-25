import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    static ArrayList<LinkedList<Integer>> graph;
    static ArrayList<LinkedList<Integer>> reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stk;
    static int[] scc; // 노드별 SCC 번호
    static int sccCount; // SCC 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 도미노 개수
            M = Integer.parseInt(st.nextToken()); // 관계 개수

            // 그래프 초기화
            graph = new ArrayList<>();
            reverseGraph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new LinkedList<>());
                reverseGraph.add(new LinkedList<>());
            }

            // 간선 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                reverseGraph.get(v).add(u); // 뒤집은 그래프
            }

            // 1단계 DFS: 피니시 순서 스택에 저장
            visited = new boolean[N + 1];
            stk = new Stack<>();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) dfs(i);
            }

            // 2단계 DFS: 뒤집은 그래프에서 SCC 구성
            visited = new boolean[N + 1];
            scc = new int[N + 1];
            sccCount = 0;
            while (!stk.isEmpty()) {
                int node = stk.pop();
                if (!visited[node]) {
                    reDfs(node, sccCount++);
                }
            }

            // SCC DAG indegree 계산
            int[] indegree = new int[sccCount];
            for (int u = 1; u <= N; u++) {
                for (int v : graph.get(u)) {
                    if (scc[u] != scc[v]) { // 서로 다른 SCC끼리 간선 존재
                        indegree[scc[v]]++;
                    }
                }
            }

            // indegree 0인 SCC 개수 = 최소 손으로 넘어뜨려야 하는 블록 수
            int result = 0;
            for (int i = 0; i < sccCount; i++) {
                if (indegree[i] == 0) result++;
            }

            System.out.println(result);
        }
    }

    // 1단계 DFS: 원 그래프에서 DFS 수행, 스택에 피니시 순서 저장
    static void dfs(int v) {
        visited[v] = true;
        for (int next : graph.get(v)) {
            if (!visited[next]) dfs(next);
        }
        stk.push(v); // DFS 종료 시점에 push
    }

    // 2단계 DFS: 뒤집은 그래프에서 DFS 수행, 하나의 SCC 구성
    static void reDfs(int v, int number) {
        visited[v] = true;
        scc[v] = number;
        for (int next : reverseGraph.get(v)) {
            if (!visited[next]) reDfs(next, number);
        }
    }
}
