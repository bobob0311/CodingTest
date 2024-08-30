import java.util.*;
/*
-30000 ~ 30000 진입 진출 지점 있을때
모든 차가 카메라에 찍혀야된다. 


*/

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 0;
        int last = -30000;
        for (int i = 0; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            last = end;
            count++;
            while (true) {
                if (i == routes.length - 1) {
                    break;
                }
                if (routes[i + 1][0] <= last) {
                    last = Math.min(last, routes[i + 1][1]);
                    i++;
                } else {
                    break;
                }
            }

        }

        return count;
    }
}