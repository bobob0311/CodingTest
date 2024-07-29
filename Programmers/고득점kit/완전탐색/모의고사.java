package Programmers.고득점kit.완전탐색;

import java.util.*;

class Solution {
    static int[] target1;
    static int[] target2;
    static int[] target3;
    static int idx;
    static int targetIdx;
    static int[] count;

    static int target;

    public int[] solution(int[] answers) {
        count = new int[3];

        target1 = new int[] { 1, 2, 3, 4, 5 };
        target2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
        target3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        idx = 0;
        targetIdx = 0;

        while (idx < answers.length) {
            if (targetIdx == target1.length) {
                targetIdx = 0;
            }
            ;
            if (answers[idx] == target1[targetIdx]) {
                count[0]++;
            }
            ;
            idx++;
            targetIdx++;
        }
        ;

        idx = 0;
        targetIdx = 0;

        while (idx < answers.length) {
            if (targetIdx == target2.length) {
                targetIdx = 0;
            }
            if (answers[idx] == target2[targetIdx]) {
                count[1]++;
            }
            idx++;
            targetIdx++;
        }
        ;

        idx = 0;
        targetIdx = 0;

        while (idx < answers.length) {
            if (targetIdx == target3.length) {
                targetIdx = 0;
            }
            if (answers[idx] == target3[targetIdx]) {
                count[2]++;
            }
            idx++;
            targetIdx++;
        }
        ;

        int maxVal = Math.max(Math.max(count[0], count[1]), count[2]);
        ArrayList<Integer> answerList = new ArrayList<>();

        if (maxVal == count[0])
            answerList.add(1);
        if (maxVal == count[1])
            answerList.add(2);
        if (maxVal == count[2])
            answerList.add(3);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    };
}
