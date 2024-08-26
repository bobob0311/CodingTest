import java.util.*;
/*
카드에 1~100

작거나 같은 숫자 카드 준비
그만큼 작은 상자 준비

분류를 하는 느낌인거같아요..

우선 링크드 리스트로 분류의 값을 넣어보자!!

*/

class Solution {

    public int solution(int[] cards) {
        List<Integer> answerList = new LinkedList<>();

        for (int i = 0; i < cards.length; i++) {
            int count = 1;
            int curIdx = cards[i];
            if (curIdx == 0) {
                continue;
            }
            cards[i] = 0;
            while (true) {
                int nextIdx = cards[curIdx - 1];
                if (nextIdx != 0) {
                    cards[curIdx - 1] = 0;
                    count++;
                    curIdx = nextIdx;
                } else {
                    break;
                }
            }
            answerList.add(count);
        }
        if (answerList.size() == 1) {
            return 0;
        }

        int[] arr = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            arr[i] = answerList.get(i);
        }
        Arrays.sort(arr);
        int answer = arr[answerList.size() - 1] * arr[answerList.size() - 2];

        return answer;
    }
}