package Programmers.Lv_2;

import java.util.*;
/*
10일 회원 자격
한가지만 살 수 있음

원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우 회원가입 
*/

/*
Map을 이용하여 10일씩 돌면서 
하면될듯??

*/

class Solution {
    static boolean result;
    static int count = 0;

    public int solution(String[] want, int[] number, String[] discount) {
        int length = discount.length;

        Map<String, Integer> map = new HashMap<>();

        // want map생성
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if (map.get(discount[i]) != null) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }

        result = true;
        for (Integer v : map.values()) {
            if (v <= 0) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        if (result == true) {
            count++;
        }

        for (int i = 1; i < length; i++) {
            int idx = i;
            if (map.get(discount[i - 1]) != null) {
                map.put(discount[i - 1], map.get(discount[i - 1]) + 1);
            }
            if (i + 9 < length) {
                if (map.get(discount[i + 9]) != null) {
                    map.put(discount[i + 9], map.get(discount[i + 9]) - 1);
                }
            }

            result = true;
            for (Integer v : map.values()) {
                if (v <= 0) {
                    continue;
                } else {
                    result = false;
                    break;
                }
            }
            if (result == true) {
                count++;
            }
        }

        return count;
    }
}
