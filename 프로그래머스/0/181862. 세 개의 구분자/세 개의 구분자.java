import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myStr.length(); i++) {
            char c = myStr.charAt(i);
            
            if ((c == 'a' || c == 'b' || c == 'c') && sb.length() > 0) {
                list.add(sb.toString());
                sb.setLength(0);  
            } 
            else if (c != 'a' && c != 'b' && c != 'c'){
                sb.append(c);
            }
        }
        
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        
        if (list.size() == 0) {
            return new String[]{"EMPTY"};
        }
        
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
