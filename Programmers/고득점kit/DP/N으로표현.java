package Programmers.고득점kit.DP;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int N, int number) {
        if (N == number)
            return 1;

        Set<Integer>[] dp = new Set[9];

        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int op1 : dp[j]) {
                    for (int op2 : dp[i - j]) {
                        dp[i].add(op1 + op2);
                        dp[i].add(op1 - op2);
                        dp[i].add(op1 * op2);
                        if (op2 != 0)
                            dp[i].add(op1 / op2);
                    }
                }
            }
            if (dp[i].contains(number))
                return i;
        }
        return -1;
    }
}
