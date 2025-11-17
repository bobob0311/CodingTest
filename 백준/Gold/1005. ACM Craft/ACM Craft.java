import java.io.*;
import java.util.*;

/*
건물 짓는 순서가 정해져 있지않고
첫이랑 두번째 다를 수 있다.

각각 건설을 시작하여 완성되기까지 Delay가 존재
특정건물을 가장 빨리 지을 때까지 걸리는 최소시간을 알아내 보자
*/

public class Main {
    static int N,K;
    static int[] delayTimes, indegree;
    static ArrayList<LinkedList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testSize = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        for(int t = 0; t<testSize; t++){
            st = new StringTokenizer(br.readLine());
            // 건물의 총 개수
            N = Integer.parseInt(st.nextToken());
            // 규칙의 총 개수
            K = Integer.parseInt(st.nextToken());

            delayTimes = new int[N+1];
            graph = new ArrayList<>();
            indegree = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i< N+1; i++){
                delayTimes[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i<N+1; i++){
                graph.add(new LinkedList<>());
            }

            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int after = Integer.parseInt(st.nextToken());
                indegree[after]++;
                graph.get(prev).add(after);
            }

            int target = Integer.parseInt(br.readLine());

            int answer = calcMinimumTime(target);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static public int calcMinimumTime(int target){
        int time = 0;
        Queue<int[]> que = new LinkedList<>();
        int[] totalTimes = new int[N+1];

        for(int i = 1; i< N+1; i++){
            if(indegree[i] == 0) que.offer(new int[]{i,0});
        }

        while(!que.isEmpty()){
            int[] nowArr = que.poll();
            int nowNode = nowArr[0];
            int nowTime = nowArr[1];

            if(nowNode == target) {
                time = nowTime + delayTimes[nowNode];
                break;
            }

            for(Integer nextNode : graph.get(nowNode)){
                indegree[nextNode]--;
                totalTimes[nextNode] = Math.max(totalTimes[nextNode],nowTime + delayTimes[nowNode]);
                if(indegree[nextNode] == 0) que.offer(new int[] {nextNode,totalTimes[nextNode]});
            }
        }

        return time;
    }
}
