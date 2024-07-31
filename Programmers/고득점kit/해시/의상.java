package Programmers.고득점kit.해시;

import java.util.*;

class Solution {
    static int answer;

    public int solution(String[][] clothes) {
        answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (map.get(clothes[i][1]) != null) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }

        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        return answer - 1;
    }

}
