package Programmers.Lv_2;

import java.util.*;

class Solution {
    static int[] answer;

    public int[] solution(int[] numbers) {
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        answer = new int[numbers.length];
        que.add(new int[] { 0, numbers[0] });

        for (int i = 1; i < numbers.length; i++) {
            int target = numbers[i];
            while (true) {
                if (que.peek() == null) {
                    break;
                }
                int[] tempArr = que.peek();
                if (target > tempArr[1]) {
                    int[] arr = que.poll();
                    answer[arr[0]] = target;
                } else {
                    break;
                }
            }
            que.add(new int[] { i, target });
        }

        for (int i = 0; i < numbers.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
