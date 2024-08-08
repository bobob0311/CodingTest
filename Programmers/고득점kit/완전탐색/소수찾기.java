package Programmers.고득점kit.완전탐색;

import java.util.*;
/*
주요 포인트
1. set을 이용하여 소수가 중복 안되게
2. 아리스토텔레스의 체
3. "" => 빈문자열 만들기
 */

class Solution {
    static Set<Integer> primeSet = new HashSet<>();
    static boolean[] used;

    public int solution(String numbers) {
        used = new boolean[numbers.length()];

        dfs(0, numbers, "");

        return primeSet.size();
    }

    static void dfs(int depth, String numbers, String current) {
        if (!current.isEmpty()) {
            int number = Integer.parseInt(current);
            if (isPrime(number)) {
                primeSet.add(number);
            }
        }

        if (depth == numbers.length()) {
            return;
        }

        for (int j = 0; j < numbers.length(); j++) {
            if (!used[j]) {
                used[j] = true;
                dfs(depth + 1, numbers, current + numbers.charAt(j));
                used[j] = false;
            }
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
