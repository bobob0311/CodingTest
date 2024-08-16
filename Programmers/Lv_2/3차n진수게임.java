import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String s = "0";

        int now = 1;
        while (s.length() < t * m + p) {
            int temp = now;
            String temp_str = "";
            while (temp >= n) {
                String str = "";
                int v = temp % n;
                if (v >= 10) {
                    if (v == 10) {
                        str = "A";
                    } else if (v == 11) {
                        str = "B";
                    } else if (v == 12) {
                        str = "C";
                    } else if (v == 13) {
                        str = "D";
                    } else if (v == 14) {
                        str = "E";
                    } else if (v == 15) {
                        str = "F";
                    }
                } else {
                    str = String.valueOf(v);
                }
                temp /= n;

                temp_str = str + temp_str;

            }
            String str = "";
            if (temp >= 10) {
                if (temp == 10) {
                    str = "A";
                } else if (temp == 11) {
                    str = "B";
                } else if (temp == 12) {
                    str = "C";
                } else if (temp == 13) {
                    str = "D";
                } else if (temp == 14) {
                    str = "E";
                } else if (temp == 15) {
                    str = "F";
                }
            } else {
                str = String.valueOf(temp);
            }
            temp_str = str + temp_str;
            s += temp_str;
            now++;
        }
        String answer = "";

        for (int i = p - 1; i < (t - 1) * m + p; i += m) {
            answer += s.charAt(i);
        }

        return answer;
    }
}