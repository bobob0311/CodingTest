package Programmers.Lv_2;

class Solution {
    static int time = 0;
    static int totalCount = 0;

    public int[] solution(String s) {
        while (!s.equals("1")) {
            time++;
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }

            int next_one = s.length() - count;
            totalCount += count;
            String temp = "";
            while (next_one >= 2) {
                int v = next_one % 2;
                next_one /= 2;
                temp = String.valueOf(v) + temp;
            }
            s = String.valueOf(next_one) + temp;
        }

        int[] answer = { time, totalCount };
        return answer;
    }
}