import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = new char[s.length()];
        
        for(int i =0; i<s.length(); i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);

        String answer = "";
        for(int i =0; i<arr.length;i++){
            answer+= arr[arr.length-1-i];
        }

        return answer;
    }

}