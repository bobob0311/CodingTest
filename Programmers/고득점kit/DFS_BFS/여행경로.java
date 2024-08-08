package Programmers.고득점kit.DFS_BFS;
/*
가장 중요한 것은 
1. visited라는 관점이 Node방문 개념이아닌 edge 관점으로 생각해야된다는 점
2. 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 하기 위해 
    모든 경로를 찾은 후 경로를 그냥 쫙 나열한다음에 sort를 통해 
    알파벳 순서가 앞서는 경로를 찾아낸다는 점.
 */

import java.util.*;

class Solution {
    static ArrayList<String> route = new ArrayList<>();
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(route);
        return route.get(0).split(" ");
    }

    static void dfs(int depth, String now, String path, String[][] tickets) {
        if (depth == tickets.length) {
            route.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
