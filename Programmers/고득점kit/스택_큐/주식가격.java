package Programmers.고득점kit.스택_큐;

import java.util.*;
/*
가격이 떨어지지 않은 기간이 몇 초인지 return 
*/

/*
prices => 2~100000이하의 배열

스택의 개념을 이용해서 제일 위에꺼랑 현재꺼랑 비교
*/

class Solution {
    class Info {
        int idx;
        int value;

        Info(int i, int v) {
            idx = i;
            value = v;
        }
    }

    static int[] answer;

    public int[] solution(int[] prices) {
        List<Info> stack = new LinkedList<>();
        answer = new int[prices.length];

        stack.add(new Info(0, prices[0]));

        for (int i = 1; i < prices.length; i++) {
            while (stack.size() != 0) {
                int nowValue = stack.get(stack.size() - 1).value;
                if (nowValue > prices[i]) {
                    int myIdx = stack.get(stack.size() - 1).idx;
                    answer[myIdx] = i - myIdx;
                    stack.remove(stack.size() - 1);
                } else {
                    break;
                }
            }
            stack.add(new Info(i, prices[i]));
        }
        for (int i = 0; i < prices.length - 1; i++) {
            if (answer[i] == 0) {
                answer[i] = prices.length - i - 1;
            }
        }
        return answer;
    }
}
