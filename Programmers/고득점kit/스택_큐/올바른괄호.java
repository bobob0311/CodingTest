package Programmers.고득점kit.스택_큐;

import java.util.*;
/*
여는 것이 들어오면 스택에 집어넣고
닫는 것이 들어오면 스택에서 꺼내서 짝이 맞는지 확인
*/

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
            } else {
                if (stack.size() != 0) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
