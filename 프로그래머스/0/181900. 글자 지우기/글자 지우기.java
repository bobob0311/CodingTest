import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        int prev = -1;
        StringBuilder st = new StringBuilder();
        for(int next : indices){
            st.append(my_string.substring(prev+1, next));
            prev = next;
        }
        st.append(my_string.substring(prev+1));
        return st.toString();
    }
}