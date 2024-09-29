/*
도넛 => 크기가 n인 도넛 모양 그래프는 n개의 정점과 n개이 간선

막대 => n개의 정점과 n-1개의 간선

8자 => 2n+1개의 정점과 2n+2개의 간선

정점을 먼저 찾는다?
정점을 먼저 찾고 삭제한 후에 가는게 좋을거같기도?
근데 어떻게 찾는가?

나가는 간선만 있으면 인가?

*/

/*
deges의 길이는 백만입니다. 
하나를 삭제하고 해본다? 
따로 로직을 생각한다?


*/
import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
         int max = 0;
        for(int i = 0; i < edges.length; i++){
            max = Math.max(max, Math.max(edges[i][0],  edges[i][1]));
        }

        
        int[] answer = new int[4];
         ArrayList<Integer>[] graph = new ArrayList[max+1];
        int[] st = new int[max+1];
        int[] en = new int[max+1];
        Queue<Integer> que = new LinkedList<>();
        
        int findIdx=0;
        for(int i = 1 ; i<max+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end);
            st[start]++;
            en[end]++;
        }
        for(int i =0; i<max+1; i++){
            if(st[i] >=2 && en[i] == 0){
                findIdx = i;
            }
        }
        answer[0] = findIdx;
        boolean[] visited = new boolean[max+1];
        for(Integer startNode : graph[findIdx]){
            que.add(startNode);
            int node = 1;
            int edge = 0;
            while(!que.isEmpty()){
                int start = que.poll();
                for(Integer v : graph[start]){
                    edge++;
                    if(visited[v] == false){
                        visited[v] = true;
                        node++;
                        que.add(v);
                    }
                }
            }
            if(node==edge){
                answer[1]++;
            }else if(node - edge == 1){
                answer[2]++;
            }else{
                answer[3]++;
            }
        }     

        return answer;
    }
}