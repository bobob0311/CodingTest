import java.util.*;
class Solution {
    int max = 0;
    public int solution(int n, int[][] edge) {
        List<Integer>[] list = new ArrayList[n+1];
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i<n+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<edge.length; i++){
            int[] now = edge[i];
            list[now[0]].add(now[1]);
            list[now[1]].add(now[0]);
        }
        
        
        int[] dist = new int[n+1];
        boolean[] chk = new boolean[n+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist,INF);
        
        dist[1] = 0;
        que.offer(1);
        while(!que.isEmpty()){
            int nowIdx = que.poll();
            chk[nowIdx] = true;
            
            for(int nextIdx : list[nowIdx]){
                if(chk[nextIdx]){
                    continue;
                }
                if(dist[nextIdx] > dist[nowIdx] + 1){
                    dist[nextIdx] = dist[nowIdx]+ 1;
                    if(max < dist[nextIdx]){
                        max = dist[nextIdx];
                    }
                }
            }
            int min = 200000;
            int idx = -1;
            for(int i = 0; i<dist.length; i++){
                if(min > dist[i] && !chk[i]){
                    min = dist[i];
                    idx = i;
                }
            }
            if(idx != -1) que.offer(idx);
        }
        int cnt=0;
        for(int v : dist){
            if(max == v){
                cnt++;
            }
        }
        
        return cnt;
    }
}