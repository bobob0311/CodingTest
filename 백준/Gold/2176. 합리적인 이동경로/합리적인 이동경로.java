import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N,M;
    static ArrayList<int[]>[] arr;
    static int[] dist;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }
    });
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N];
        Arrays.fill(dist,INF);
        dist[1] = 0;

        arr = new ArrayList[N];
        for(int i = 0; i<N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken()) -1;
            int two = Integer.parseInt(st.nextToken()) -1;
            int value = Integer.parseInt(st.nextToken());
            arr[one].add(new int[] {two,value});
            arr[two].add(new int[] {one,value});
        }

        dijkstra(1);

        dp = new int[N];
        Arrays.fill(dp,-1);
        System.out.println(dfs(0));
        

    }
    
    static int dfs(int now){
        if(now == 1) return 1;
        if(dp[now] != -1) return dp[now];
        
        dp[now] = 0;
        for(int[] next :arr[now]){
            if(dist[now] > dist[next[0]]){
                dp[now] += dfs(next[0]);
            }
        }
        return dp[now];
    }

    static  public void dijkstra(int start){
        pq.offer(new int[] {start,0});

        while(!pq.isEmpty()){
            int[] nowArr = pq.poll();
            int nowDist = nowArr[1];
            int nowNum = nowArr[0];
            if(nowDist > dist[nowNum]) continue;

            for(int[] nextArr : arr[nowArr[0]]){
                int nextIdx = nextArr[0];
                int nextDist = nextArr[1];
                int newDist = nowDist + nextDist;

                if(newDist < dist[nextIdx]) {
                    dist[nextIdx] = newDist;
                    pq.offer(new int[] {nextIdx, newDist});
                }

            }
        }
    }
}
