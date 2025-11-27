import java.io.*;
import java.util.*;

/*
도미노
블록 하나를 넘어뜨리면 연쇄 작용으로 넘어지는데
도미노가 다른 블록을 넘어뜨리지 못하게 배치되어 있다면 다음 블록을 수동으로 넘어뜨려야한다.

=> 도미노 블록의 배치가 주어졌을때, 모든 블록을 넘어뜨리기 위해 손으로 넘어뜨려야 하는 블록의 개수의 최솟값을 구해라

N, M 은 100000 을 넘지 않는다.

1. 도미노가 넘어지는 과정은 위상 정렬
2. 손으로 넘어뜨려야하는 도미노를 어떻게 선정하는가?
    indegree가 0인 경우 연결된거 다 넘어뜨리기
    서로가 서로를 넘어뜨리는 경우 빼고는 다 괜찮아진거같은데 이러면

*/

public class Main {
    static int T,N,M;
    static ArrayList<LinkedList<Integer>> graph;
    static ArrayList<LinkedList<Integer>> reverseGraph;
    static boolean[] visited;
    static int[] scc;
    static Stack<Integer> stk = new Stack<>();
    static boolean[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t <T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            
            graph = new ArrayList<>();
            reverseGraph = new ArrayList<>();
            int cnt = 0;
            parent = new boolean[100001];
            visited = new boolean[N+1];
            scc = new int[N+1];

            for(int i = 0; i< N + 1; i++){
                graph.add(new LinkedList<>());
                reverseGraph.add(new LinkedList<>());
            }

            for(int i = 0; i< M; i++){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                reverseGraph.get(v).add(u);
            }

            for(int i = 1; i< N+1; i++){
                if(!visited[i]) dfs(i);
            }

            Arrays.fill(visited,false);

            int num =1;

            while(!stk.isEmpty()){
                int node = stk.pop();

                if(!visited[node]) reDfs(node,num++);
            }



            Arrays.fill(visited,false);

            for(int i = 1; i< num ; i++){
                if(!parent[i]) cnt++;
            }
            sb.append(cnt+"\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int node){
        visited[node] = true;
        for(Integer next : graph.get(node)){
            if(visited[next]) continue;
            dfs(next);
        }
        stk.push(node);
    }

    static void reDfs(int now, int number){
        visited[now] = true;
        scc[now] = number;

        for(Integer next : reverseGraph.get(now)){
            if(!visited[next]) reDfs(next,number);
            if(visited[next]){
                if(scc[next] != number){
                    parent[number] = true;
                }
            }
        }
    }


}
