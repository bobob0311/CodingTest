import java.util.*;

/*
자카드 유사도 => 교집합의 크기를 두집합의 합집합의 크기로 나눈 값으로 정의
!! => 모두 공집합일 경우 1로 정의

두개씩 끊어서 자카드 유사도를 구해봐라
대문자와 소문자의 차이는 무시한다. 

*/

//65 ~ 90
//97~122

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();

        for (int i = 0; i < lowerStr1.length(); i++) {
            if (i + 1 < lowerStr1.length()) {
                char c1 = lowerStr1.charAt(i);
                char c2 = lowerStr1.charAt(i + 1);

                if ((int) c1 >= 97 && (int) c1 <= 122 && (int) c2 >= 97 && (int) c2 <= 122) {
                    String v = String.valueOf(c1) + String.valueOf(c2);
                    if (map1.get(v) != null) {
                        map1.put(v, map1.get(v) + 1);
                    } else {
                        map1.put(v, 1);
                    }
                }
            }
        }

        for (int i = 0; i < lowerStr2.length(); i++) {
            if (i + 1 < lowerStr2.length()) {
                char c1 = lowerStr2.charAt(i);
                char c2 = lowerStr2.charAt(i + 1);

                if ((int) c1 >= 97 && (int) c1 <= 122 && (int) c2 >= 97 && (int) c2 <= 122) {
                    String v = String.valueOf(c1) + String.valueOf(c2);
                    if (map2.get(v) != null) {
                        map2.put(v, map2.get(v) + 1);
                    } else {
                        map2.put(v, 1);
                    }
                }
            }
        }
        int n = 0;
        int u = 0;

        for (String str : map1.keySet()) {
            int v1 = map1.get(str);
            if (map2.get(str) != null) {
                n += Math.min(v1, map2.get(str));
                u += Math.max(v1, map2.get(str));
                map2.put(str, 0);
            } else {
                u += v1;
            }

        }

        for (Integer v : map2.values()) {
            u += v;
        }

        int answer;

        if (u != 0) {
            answer = n * 65536 / u;
        } else {
            answer = 65536;
        }
        return answer;
    }
}