import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder st = new StringBuilder();
        Set<String> set = new HashSet<>();
        
        for(int i= 0; i<my_string.length(); i++){
            String tempStr = my_string.substring(i,i+1);
            int prev = set.size();
            set.add(tempStr);
            if(prev != set.size()){
                st.append(tempStr);
            }
        }
        
        return st.toString();
    }
}