import java.util.*;
/*
컨테이너 벨트 : 놓인 순서대로 내리기 즉 => queue

-> 택배 기사님이 알려준 순서에 맞게 실어야함

보조 컨테이너 : 마지막에 보조 컨테이너 벨트에 보관한 상자부터 => stack

보조를 사용해도 원하는 순서대로 안되면 상자 끝

*/

class Solution {
    public int solution(int[] order) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[order.length];

        for (int i = 0; i < order.length; i++) {
            arr[i] = i + 1;
        }

        int answer = 0;

        // 현재 컨테이너 벨트에 있는거
        int idx = 0;

        int answerIdx = 0;
        int nowTarget = order[answerIdx];
        while (idx <= order.length - 1) {

            if (arr[idx] == nowTarget) {
                answer++;
                answerIdx++;
                idx++;
                nowTarget = order[answerIdx];
            } else if (st.size() != 0 && st.peek() == nowTarget) {
                st.pop();
                answer++;
                answerIdx++;
                nowTarget = order[answerIdx];
            } else {
                st.push(arr[idx]);
                idx++;
            }
        }
        while (!st.isEmpty()) {
            if (st.pop() == nowTarget) {
                answer++;
                answerIdx++;
                if (answerIdx == order.length) {
                    break;
                }
                nowTarget = order[answerIdx];
            } else {
                break;
            }
        }

        return answer;
    }
}