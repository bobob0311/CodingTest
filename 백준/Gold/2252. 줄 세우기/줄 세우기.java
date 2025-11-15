import java.io.*;
import java.util.*;

/*
(i,j) 위치부터 (x,y) 위치까지에 저장되어 있는 수들의 합을 구해보자
*/

public class Main {
    static int N,M;
    static ArrayList<LinkedList<Integer>> graph;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];

        graph = new ArrayList<>(N+1);
        for(int i = 0; i<N+1; i++) graph.add(new LinkedList<Integer>());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            indegree[end]++;
        }
        topologicalSort();
        System.out.println(sb.toString());
    }

    static void topologicalSort(){
        boolean[] chk = new boolean[N+1];
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i<N+1; i++){
            if(indegree[i] == 0) {
                que.offer(i);
                sb.append(i+" ");
            }
        }


        while(!que.isEmpty()){
            int now = que.poll();
            if(chk[now]) continue;
            chk[now] = true;
            for(Integer next : graph.get(now)){
                indegree[next]--;
                if(indegree[next] == 0) {
                    que.offer(next);
                    sb.append(next+" ");
                }
            }
        }

    }
}
