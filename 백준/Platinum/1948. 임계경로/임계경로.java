import java.io.*;
import java.util.*;

/*
모든 도로가 일방 통행 / 사이클 없음
시작 도시로 부터 도착도시까지 출발을 하여 가능한 모든 경로를 탐색
모든 경로 중에서 가장 늦는 사람의 경로를 구해야할 듯
가장 늦은 사라이 지나는 도로의 수를 카운트

출발 도시 inDegree 0
도착 도시 outDegree 0
*/

public class Main {
    static int N,M;
    static int totalStart, totalEnd;
    static ArrayList<LinkedList<long[]>> graph = new ArrayList<>();
    static ArrayList<LinkedList<long[]>> reverseGraph = new ArrayList<>();
    static int[] indgree;
    static long[] memory;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         N = Integer.parseInt(br.readLine());
         M = Integer.parseInt(br.readLine());
        indgree = new int[N+1];
        for(int i = 0; i< N+1; i++){
            graph.add(new LinkedList<>());
            reverseGraph.add(new LinkedList<>());
        }

        memory = new long[N+1];

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(startCity).add(new long[] {endCity,time});
            reverseGraph.get(endCity).add(new long[] {startCity,time});
            indgree[endCity]++;
        }

        st = new StringTokenizer(br.readLine());
        totalStart = Integer.parseInt(st.nextToken());
        totalEnd = Integer.parseInt(st.nextToken());
        solution();
        System.out.println(memory[totalEnd]);
        System.out.println(reverseSolution());
    }

    static int reverseSolution(){
        Queue<Integer> que = new LinkedList<>();
        que.offer(totalEnd);
        int cnt = 0;
        boolean[] visited = new boolean[N+1];

        visited[totalEnd] = true;
        while(!que.isEmpty()){
            int now = que.poll();
            for(long[] nextArr : reverseGraph.get(now)){
                long nextNode = nextArr[0];
                long time =nextArr[1];
                if(memory[now] == memory[(int)nextNode] + time){
                    cnt++;
                    if(!visited[(int)nextNode]){
                        que.offer((int)nextNode);
                        visited[(int) nextNode]= true;
                    }
                }

            }
        }
        return cnt;
    }

    static void solution(){
        Queue<long[]> pq = new LinkedList<>();
        pq.offer(new long[] {totalStart,0});

        while(!pq.isEmpty()){
            long[] arr = pq.poll();
            long nowNode = arr[0];
            long nowTime = arr[1];

            for(long[] nextArr : graph.get((int)nowNode)){
                long nextNode = nextArr[0];
                long time = nextArr[1];
                if(memory[(int)nextNode] <= nowTime + time){
                    memory[(int)nextNode] = nowTime + time;
                }

                if(--indgree[(int)nextNode] == 0){
                    pq.offer(new long[] {nextNode, memory[(int)nextNode]});
                }
            }

        }

    }

}
