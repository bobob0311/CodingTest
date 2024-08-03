package Programmers.고득점kit.정렬;

import java.util.*;

class Solution {
    static int[] answer;

    public int[] solution(int[] array, int[][] commands) {
        answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int targetIdx = commands[i][2] - 1;

            int[] myArr = new int[end - start + 1];

            for (int j = start; j <= end; j++) {
                myArr[j - start] = array[j];
            }
            Arrays.sort(myArr);
            answer[i] = myArr[targetIdx];
        }

        return answer;
    }
}
