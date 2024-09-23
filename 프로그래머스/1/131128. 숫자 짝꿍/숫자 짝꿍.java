import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder st = new StringBuilder();
        
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[10];
        
        
        for(int i = 0; i<X.length(); i++){
            arr1[Integer.parseInt(String.valueOf(X.charAt(i)))]++;
        }

        for(int i = 0; i<Y.length(); i++){
            arr2[Integer.parseInt(String.valueOf(Y.charAt(i)))]++;
        }

        for(int i =0; i<10;i++){
            arr3[i] = Math.min(arr1[i], arr2[i]);
        }
        
        for(int i = 9; i>=0; i--){
            int cnt = arr3[i];
            
            for(int j = 0 ; j<cnt; j++){
                st.append(i);
            }
        }
        String answer = st.toString();
        
        if(answer.length() == 0){
            return "-1";
        }
        
        if(answer.charAt(0) == '0'){
            return "0";
        }

        

        return st.toString();
    }
}