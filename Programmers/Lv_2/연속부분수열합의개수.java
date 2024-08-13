package Programmers.Lv_2;

import java.util.*;

class Solution {

    public int solution(int[] elements) {
        Set<Integer> s = new HashSet<>();

        for (int l = 1; l <= elements.length; l++) {
            for (int i = 0; i < elements.length; i++) {
                int count = 0;
                int idx = i;
                int nowSum = 0;

                while (count != l) {
                    if (idx > elements.length - 1) {
                        idx %= (elements.length);
                    }
                    nowSum += elements[idx];
                    count++;
                    idx++;
                }
                s.add(nowSum);
                // System.out.println(l + " " + nowSum);
            }

        }
        return s.size();
    }
}