package Programmers.고득점kit.그래프;

import java.util.*;

class Solution {
    static boolean[] visited;
    static int max = 0;

    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<int[]> que = new LinkedList<>();
        Map<Integer, Integer> answerMap = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            map.put(i, new LinkedList<Integer>());

        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];

            map.get(a).add(b);
            map.get(b).add(a);
        }

        que.add(new int[] { 1, 0 });

        while (!que.isEmpty()) {
            visited[1] = true;
            int[] target = que.poll();
            int targetValue = target[0];
            int targetCount = target[1];
            List<Integer> targetList = map.get(targetValue);

            for (Integer a : targetList) {
                if (visited[a] == false) {
                    visited[a] = true;
                    que.add(new int[] { a, targetCount + 1 });
                    if (answerMap.get(targetCount + 1) == null) {
                        answerMap.put(targetCount + 1, 1);
                    } else {
                        answerMap.put(targetCount + 1, answerMap.get(targetCount + 1) + 1);
                    }
                    max = Math.max(max, targetCount + 1);
                }
            }
        }

        return answerMap.get(max);
    }
}
