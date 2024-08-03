package Programmers.고득점kit.정렬;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numString = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numString[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numString, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (numString[0].equals("0")) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numString.length; i++) {
            answer.append(numString[i]);
        }

        return answer.toString();
    }
}
