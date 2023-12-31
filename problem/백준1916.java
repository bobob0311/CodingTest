package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
N개의 도시 
M개의 버스
A -> B 까지 가는데 버스 비용 최소화
도시 번호는 1~N
 */

/*
1:        N 도시의 개수
2:        M 버스의 개수
3 ~ M+2 : 출발도시 번호  /  도착지 도시 번호 / 버스 비용(0~100,000)
M+3 :     구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호 
 */

// 특정 노드에서 특정 노드로 가는 최단거리이므로 다익스트라 알고리즘 사용

class Nodes implements Comparable<Nodes> {
    int endNum;
    int weight;

    Nodes(int nodeNum, int weight) {
        this.endNum = nodeNum;
        this.weight = weight;
    }

    @Override
    public int compareTo(Nodes a) {
        return weight - a.weight;
    }
}

public class 백준1916 {
    static final int INF = Integer.MAX_VALUE;
    static List<ArrayList<Nodes>> list;
    static int N, M;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 도시의 개수
        M = Integer.parseInt(br.readLine()); // 버스의 개수

        list = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(start).add(new Nodes(end, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, destination));

    }

    static int dijkstra(int start, int destination) {
        PriorityQueue<Nodes> que = new PriorityQueue<Nodes>();
        boolean visit[] = new boolean[N + 1];

        dist[start] = 0;
        que.offer(new Nodes(start, 0));

        while (!que.isEmpty()) {
            Nodes queNode = que.poll();
            int start_nodeNum = queNode.endNum;

            if (!visit[start_nodeNum]) {
                visit[start_nodeNum] = true;

                for (Nodes node : list.get(start_nodeNum)) {
                    if (!visit[node.endNum] && dist[node.endNum] > (dist[start_nodeNum] + node.weight)) {
                        dist[node.endNum] = dist[start_nodeNum] + node.weight;
                        que.offer(new Nodes(node.endNum, dist[node.endNum]));
                    }
                }
            }
        }

        return dist[destination];
    }
}