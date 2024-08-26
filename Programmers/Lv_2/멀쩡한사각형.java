/*
0,h
w,0

-w/h +h =

y = -w/h + h
*/

class Solution {
    static long answer = 0;

    public long solution(int w, int h) {
        // double x = (double) -h/w;
        answer += (long) w * h;
        for (double i = 0; i < w; i++) {
            int y1 = (int) Math.ceil((double) -i * h / w + h);
            int y2 = (int) Math.floor((double) -(i + 1) * h / w + h);
            long count = y1 - y2;
            answer -= count;
        }

        return answer;
    }
}