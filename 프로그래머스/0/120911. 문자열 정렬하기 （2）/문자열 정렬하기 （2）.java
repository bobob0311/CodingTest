import java.util.*;
class Solution {
    public String solution(String my_string) {
        List<String> list = new LinkedList<>();
        String tempStr = my_string.toLowerCase();
        for(int i = 0; i<tempStr.length(); i++){
            String now = tempStr.substring(i,i+1);
            list.add(now);
        }
        Collections.sort(list);
        
        StringBuilder st = new StringBuilder();
        
        for(int i = 0; i<list.size(); i++){
            st.append(list.get(i));    
        }
        
        return st.toString();
    }
}