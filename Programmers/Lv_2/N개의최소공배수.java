import java.util.*;
/*
2
2 3
2 2 2
2 7

2 2 2 3 7

*/

class Solution {
    public int solution(int[] arr) {

        Map<Integer, Integer> answer = new HashMap<>();

        for (int j = 0; j < arr.length; j++) {
            int target = arr[j];
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 2; i < 101; i++) {
                if (target < i) {
                    break;
                }

                while (target >= i) {
                    if (target % i == 0) {
                        target /= i;
                        if (map.get(i) != null) {
                            map.put(i, map.get(i) + 1);
                        } else {
                            map.put(i, 1);

                        }
                    } else {
                        break;
                    }
                }

            }
            for (Integer k : map.keySet()) {
                if (answer.get(k) != null) {
                    if (answer.get(k) < map.get(k)) {
                        answer.put(k, map.get(k));
                    }
                } else {
                    answer.put(k, map.get(k));
                }
            }
        }
        int a = 1;

        for (Integer k : answer.keySet()) {
            a = a * (int) Math.pow(k, answer.get(k));
        }
        return a;
    }
}