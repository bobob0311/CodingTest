import java.io.*;
import java.util.*;

/*
1~n번까지의 번호

작년에 순위를 발표했는데 상대적 순위가 바뀐 팀의 목로간을 발표하려고한다.

1. 확실한 순위를 만들 수 없는 경우
2. 일관성이 없는 정보일 수도 있다.
*/

public class Main {
    static boolean[][] edges;
    static int N;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testSize = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int t = 0; t< testSize; t++){
            N = Integer.parseInt(br.readLine());
            indegree = new int[N+1];
            edges = new boolean[N+1][N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i< N; i++){
                int num = Integer.parseInt(st.nextToken());
                indegree[num] = i;

                for(int j = 1; j<=N; j++){
                    if(j!=num && !edges[j][num]){
                        edges[num][j] = true;
                    }
                }
            }
            int M = Integer.parseInt(br.readLine());
            for(int k=0;k<M;k++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                swap(a, b);
            }
            sb.append(topologicalSort()).append("\n");
        }


        System.out.println(sb.toString());
    }

    static String topologicalSort(){
        Queue<Integer> que = new LinkedList<>();
        StringBuilder tempSb= new StringBuilder();
        for(int i = 1; i<N+1; i++){
            if(indegree[i] == 0) {
                que.offer(i);
            }
        }

        for(int i = 0; i<N; i++){
            if(que.size() == 0) return "IMPOSSIBLE";

            if(que.size() > 1) return  "?";

            int cur = que.poll();
            tempSb.append(cur+" ");
            for(int j = 1; j<=N; j++){
                if(edges[cur][j]) {
                    edges[cur][j] = false;
                    if(--indegree[j] == 0) que.add(j);

                }
            }
        }
        return tempSb.toString();
    }
    static void swap(int a, int b) {
        if(!edges[a][b]) {
            edges[a][b] = true;
            edges[b][a] = false;
            indegree[a]--;
            indegree[b]++;
        } else {
            edges[b][a] = true;
            edges[a][b] = false;
            indegree[b]--;
            indegree[a]++;
        }
    }
}
