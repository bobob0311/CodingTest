import java.util.*;
class Solution {
    public String solution(String letter) {
        Map<String,String> map = new HashMap<>();
        String[] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int now = 97;
        for(int i = 0; i<str.length; i++){
            map.put(str[i],String.valueOf((char) now++));
        }
        
        String[] target = letter.split(" ");
        
        String answer = "";
        
        for(int i = 0; i<target.length;i++){
            answer += map.get(target[i]);
        }
        
        
        return answer;
    }
}