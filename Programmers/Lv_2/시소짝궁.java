package Programmers.Lv_2;

import java.util.*;
/*
2 3 4
탑승한 사람의 무게 * 거리 를 같게 만들어야된다. 

2 => 1
3 => (3* 2) /2
4 => (4* 3) / 2 => 6 

*/

class Solution {

    public long solution(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        Map<Integer, Integer> equal = new HashMap<>();

        for (int weight : weights) {
            if (equal.get(weight) != null) {
                equal.put(weight, equal.get(weight) + 1);
            } else {
                equal.put(weight, 1);
            }
            int[] targetList = new int[] { weight * 2, weight * 3, weight * 4 };
            for (int target : targetList) {
                if (map.get(target) != null) {
                    map.put(target, map.get(target) + 1);
                } else {
                    map.put(target, 1);
                }
            }
        }

        long count = 0;
        for (int v : equal.values()) {
            if (v > 1) {
                count += (long) ((long) v * ((long) v - 1));
            }
        }

        for (int v : map.values()) {
            if (v > 1) {
                answer += (long) ((long) v * ((long) v - 1)) / 2;
            }
        }

        return answer - count;
    }
}
