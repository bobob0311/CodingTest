package Programmers.Lv_2;

import java.util.*;

/*
정렬하는 과정과 
max가 계속바뀌는 점을 유의하면 될듯.
*/

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        // for(int i =0; i<targets.length; i++){
        // System.out.print(targets[i][0]);
        // System.out.print(targets[i][1]);
        // System.out.println(" ");
        // }

        int i = 0;
        int count = 0;

        while (i <= targets.length) {
            int max = targets[i][1] * 2;
            count++;

            if (i + 1 == targets.length) {
                return count;
            }
            i++;
            while (targets[i][0] * 2 < max) {
                max = Math.min(max, targets[i][1] * 2);
                if (i + 1 == targets.length) {
                    return count;
                }
                i++;
            }
        }

        return 0;
    }
}