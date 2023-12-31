package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
모든 컴픁는 연결되어있으야하며 연결하는 비용을 최소화하고싶다
 */

/*
1:    N 컴퓨터의 수 (1~1000)
2:    M 연결할 수 있는 선의 수 (1~100,000)
3~M+2: a컴퓨터 / b컴퓨터 / 두 컴퓨터를 연결하는 비용(1~10,000)
*/

// 모든 컴퓨터를 연결하는 최소비용이므로 최소신장트리 사용

class Nodes implements Comparable<Nodes> {
    int start;
    int end;
    int result;

    Nodes(int start, int end, int result) {
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    public int compareTo(Nodes a) {
        return result - a.result;
    }
}

public class 백준1922 {
    static ArrayList<Nodes> nodeList;
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 연결하는 선의 수

        nodeList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = Integer.parseInt(st.nextToken());

            nodeList.add(new Nodes(start, end, result));
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Collections.sort(nodeList);

        int answer = 0;

        for (Nodes lists : nodeList) {
            Nodes node = lists;

            if (find(node.start) != find(node.end)) { // 연결이 되어있느냐?
                answer += node.result;
                union(node.start, node.end); // 연결이 되었음을 나타내준다.
            }
        }

        System.out.println(answer);

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
