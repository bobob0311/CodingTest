package Programmers.Lv_2;

import java.util.*;
/*
1. 철수 다 나누고 영희 하나도 못나누는 양수 a
2. 영희 다 나누고 철수 하나도 못나누는 양수 a
*/

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = arrayA.length;
        int min1 = 100000001;
        int min2 = 100000001;

        int answer = 0;

        for (int i = 0; i < length; i++) {
            if (min1 > arrayA[i]) {
                min1 = arrayA[i];
            }
        }

        for (int i = 0; i < length; i++) {
            if (min2 > arrayB[i]) {
                min2 = arrayB[i];
            }
        }

        for (int i = 2; i <= min1; i++) {
            if (min1 % i == 0) {
                boolean chk = true;
                for (int j = 0; j < length; j++) {

                    if (arrayA[j] % i != 0) {
                        chk = false;
                        break;
                    }
                }
                if (chk == true) {
                    map.put(i, 1);
                }
            }
        }

        for (int i = 2; i <= min2; i++) {
            if (min2 % i == 0) {
                boolean chk = true;
                for (int j = 0; j < length; j++) {

                    if (arrayB[j] % i != 0) {
                        chk = false;
                        break;
                    }
                }
                if (chk == true) {
                    if (map.get(i) != null) {
                        map.put(i, map.get(i) - 1);
                    } else {
                        map.put(i, -1);
                    }
                }
            }
        }
        int max = 0;
        for (int v : map.keySet()) {
            boolean chk = true;
            if (map.get(v) == 1) {
                for (int i = 0; i < length; i++) {
                    if (arrayB[i] % v == 0) {
                        chk = false;
                        break;
                    }
                }
                if (chk == true) {
                    max = Math.max(v, max);
                }
            } else if (map.get(v) == -1) {
                for (int i = 0; i < length; i++) {
                    if (arrayA[i] % v == 0) {
                        chk = false;
                        break;
                    }
                }
                if (chk == true) {
                    max = Math.max(v, max);
                }
            }
        }

        return max;
    }
}
