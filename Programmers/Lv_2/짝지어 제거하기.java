import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.size() != 0) {
                if (st.peek() == s.charAt(i)) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            } else {
                st.push(s.charAt(i));
            }

        }

        if (st.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}