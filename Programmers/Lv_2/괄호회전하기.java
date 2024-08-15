package Programmers.Lv_2;

import java.util.*;

class Solution {
    static int count = 0;

    public int solution(String s) {
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int idx = i;

            Stack<Integer> st = new Stack<>();
            int c = 1;

            boolean chk = true;
            while (c <= length) {

                if (idx == length) {
                    idx = idx % length;
                }
                if (s.charAt(idx) == '(') {
                    st.push(1);

                } else if (s.charAt(idx) == ')') {
                    if (st.size() != 0 && st.peek() == 1) {
                        st.pop();
                    } else {
                        chk = false;
                        break;
                    }

                } else if (s.charAt(idx) == '{') {
                    st.push(2);

                } else if (s.charAt(idx) == '}') {
                    if (st.size() != 0 && st.peek() == 2) {
                        st.pop();
                    } else {
                        chk = false;
                        break;
                    }

                } else if (s.charAt(idx) == '[') {
                    st.push(3);

                } else {
                    if (st.size() != 0 && st.peek() == 3) {
                        st.pop();
                    } else {
                        chk = false;
                        break;
                    }

                }
                idx++;
                c++;
            }
            if (chk == true && st.size() == 0) {
                count++;
            }

        }
        return count;
    }
}