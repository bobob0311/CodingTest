package Programmers.Lv_2;

import java.util.*;

class Solution {
    static int count = 0;

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        for (int v : tangerine) {
            if (map.get(v) != null) {
                map.put(v, map.get(v) + 1);
            } else {
                map.put(v, 1);
            }
        }
        for (Integer i : map.values()) {
            maxHeap.add(i);
        }
        while (k > 0) {
            k -= maxHeap.poll();
            count++;
        }
        return count;
    }
}
