/*
각 지역은 유일한 번호로 구분
두 지역간의 길을 통과하는데 걸리는 시간은 모두 1로 동일

최단시간에 부대로 복귀

임무의 시작 때와 다르게 되돌아오는 경로가 없ㅇ져 복귀가 불가능한 부대원도 있을 수 있다. 


n => 강철부대 위치한 지역을 포함한 총 지역수 
roads => 두 지역을 왕복할 수 있는 길 정보
sources => 부대원이 위칳ㄴ ㅅ로 다른 지역
destination => 강철부대의 지역


sources 의 원 순서대로 강철부대로 복귀할 수 있는 최단시간을 담은 배열
*/

// 모든 점에서 한 점으로 갈 때의 최단 경로를 구해야하는 문제이다 
// 한점에서 모든 점으로의 경로랑 같은 것이 아닌가?
// 다익스트라 알고리즘 사용해보자 

// ArrayList VS LinkedList 잘 선택해야한다. 이거 하나로 갈리게 된다는...
import java.util.*;

class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        List<List<Integer>> list = new ArrayList<>();
        int[] answer = new int[n + 1];
        Arrays.fill(answer, -1);
        answer[destination] = 0;

        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < roads.length; i++) {
            list.get(roads[i][0]).add(roads[i][1]);
            list.get(roads[i][1]).add(roads[i][0]);
        }

        Queue<int[]> que = new LinkedList<>();
        for (Integer target : list.get(destination)) {
            que.offer(new int[] { target, 1 });
        }
        visited[destination] = true;
        int count = 0;
        while (!que.isEmpty()) {

            int[] V = que.poll();
            int nextTarget = V[0];

            if (!visited[nextTarget]) {
                count++;
                visited[nextTarget] = true;
                int nowCost = V[1];
                answer[nextTarget] = nowCost;
                for (Integer target : list.get(nextTarget)) {
                    if (!visited[target]) {
                        que.offer(new int[] { target, nowCost + 1 });
                    }

                }
            }

        }
        int idx = 0;
        int[] answerArr = new int[sources.length];

        for (int v : sources) {
            answerArr[idx] = answer[v];
            idx++;
        }

        return answerArr;
    }
}