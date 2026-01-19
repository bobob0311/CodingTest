import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        for(int t = 0; t<K; t++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ArrayList<LinkedList<Integer>> graph = new ArrayList<>(v+1);

            for(int i = 0; i< v+1; i++) graph.add(new LinkedList<>());

            for(int i = 0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            int cnt = 0;
            boolean[] visited = new boolean[v+1];

            Queue<int[]> que = new LinkedList<>();

            int[] colors = new int[v+1];

            boolean flag = true;

            for(int i = 1; i< v+1; i++){
                if(visited[i]) continue;
                colors[i] = 1;

                que.add(new int[] {i,colors[i]});
                visited[i] = true;

                while(!que.isEmpty()){
                    int[] nowNode = que.poll();

                    int nowV = nowNode[0];
                    int nowColor = nowNode[1];

                    for(Integer next : graph.get(nowV)){
                        if(visited[next]){
                            if(colors[next] == nowColor) flag = false;
                        }else{
                            visited[next] = true;
                            if(nowColor ==1){
                                colors[next] = 2;
                            }else {
                                colors[next] = 1;
                            }
                            que.add(new int[] {next,colors[next]});
                            visited[next] = true;
                        }
                    }
                }
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");

        }

    }
}