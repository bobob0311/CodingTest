package problem;

import java.io.*;
import java.util.*;

/*
마을은 N개의 집
집을 연결하는 길 M
두 개의 분리된 마을로 분할할 계획 
*/

/*

 */

class Nodes implements Comparable<Nodes> {
    int start;
    int end;
    int weight;

    Nodes(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Nodes a) {
        return weight - a.weight;
    }
}

public class 백준1647 {
    static int N, M;
    static ArrayList<Nodes> list;
    static int[] parent;
    static int result = 0;
    static int temp = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Nodes(s, e, w));
        }

        parent = new int[N + 1];

        Collections.sort(list);

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (Nodes lists : list) {
            Nodes node = lists;

            if (find(node.end) != find(node.start)) {
                result += node.weight;
                temp = node.weight;
                union(node.end, node.start);
            }
        }

        System.out.println(result - temp);

    }

    public static int find(int answer) {
        if (parent[answer] == answer) { // 재귀함수의 종료 부분
            return answer;
        } else {
            return parent[answer] = find(parent[answer]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
