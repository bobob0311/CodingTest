package Programmers.Lv_2;

import java.util.*;
/*
14 10  19 20
14 20  15 20
15 00  19 00
16 40  19 00
18 20  21 20

*/

class Solution {
    static int[][] timeArr;
    static int _max = 0;

    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);

        timeArr = new int[book_time.length][2];

        if (book_time.length == 1) {
            return 1;
        }

        for (int i = 0; i < book_time.length; i++) {
            int startTime = Integer.parseInt(book_time[i][0].substring(0, 2)) * 60
                    + Integer.parseInt(book_time[i][0].substring(3));
            int endTime = Integer.parseInt(book_time[i][1].substring(0, 2)) * 60
                    + Integer.parseInt(book_time[i][1].substring(3)) + 10;
            timeArr[i][0] = startTime;
            timeArr[i][1] = endTime;
        }
        Arrays.sort(timeArr, (a, b) -> Integer.compare(a[0], b[0]));
        int end = timeArr[0][1];

        pq.offer(end);
        _max = Math.max(_max, pq.size());

        for (int i = 1; i < timeArr.length; i++) {
            if (pq.peek() > timeArr[i][0]) {
                pq.offer(timeArr[i][1]);
                _max = Math.max(_max, pq.size());
            } else {
                while (pq.size() != 0 && pq.peek() <= timeArr[i][0]) {
                    pq.poll();

                }
                pq.offer(timeArr[i][1]);
            }
        }

        return _max;
    }
}
