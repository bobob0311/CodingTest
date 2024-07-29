package Programmers.고득점kit.greedy;

import java.util.Stack;

/* 
왼쪽부터 가장 작은 수를 지워가는 방식으로 진행.
*/
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < current && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(current);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char num : stack) {
            result.append(num);
        }

        return result.toString();
    }
}
