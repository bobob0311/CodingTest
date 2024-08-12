package Programmers.Lv_2;

import java.util.*;
/*
10

10 ->1
15 20 30 -> 2

40 
*/

class Solution {

    int[] arr = new int[1000001];

    public int solution(int x, int y, int n) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        arr[x] = 0;

        if (x == y) {
            return 0;
        }

        while (!que.isEmpty()) {
            int target = que.poll();
            int count = arr[target];
            int case1 = target + n;
            int case2 = target * 2;
            int case3 = target * 3;

            if (case1 <= y && arr[case1] == 0) {
                que.add(case1);
                arr[case1] = count + 1;
            }
            if (case2 <= y && arr[case2] == 0) {
                que.add(case2);
                arr[case2] = count + 1;
            }
            if (case3 <= y && arr[case3] == 0) {
                que.add(case3);
                arr[case3] = count + 1;
            }
        }

        if (arr[y] == 0) {
            return -1;
        }
        return arr[y];
    }
}
