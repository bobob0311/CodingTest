import java.util.*;

class Solution {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 산봉우리 체크 배열
        boolean[] isSummit = new boolean[n + 1];
        for (int summit : summits) {
            isSummit[summit] = true;
        }

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(new int[] {path[1], path[2]});
            graph[path[1]].add(new int[] {path[0], path[2]});
        }


        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));


        for (int gate : gates) {
            minHeap.offer(new int[] {gate, 0});
            intensity[gate] = 0;
        }

        int answerIdx = -1;
        int answerValue = Integer.MAX_VALUE;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentIntensity = current[1];


            if (currentIntensity > intensity[currentNode]) {
                continue;
            }


            if (isSummit[currentNode]) {
                if (currentIntensity < answerValue || (currentIntensity == answerValue && currentNode < answerIdx)) {
                    answerValue = currentIntensity;
                    answerIdx = currentNode;
                }
                continue;
            }


            for (int[] neighbor : graph[currentNode]) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];


                int newIntensity = Math.max(currentIntensity, travelTime);
                if (newIntensity < intensity[nextNode]) {
                    intensity[nextNode] = newIntensity;
                    minHeap.offer(new int[] {nextNode, newIntensity});
                }
            }
        }

        return new int[] {answerIdx, answerValue};
    }
}
