import java.util.*;
    
class Solution {
    static boolean chk=false;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        
        for(int i =0; i<numbers.length; i++){
            StringBuilder st = new StringBuilder();
            long number = numbers[i];
            while(number >1){
                st.insert(0,String.valueOf(number%2));
                number/=2;
            }
            st.insert(0,String.valueOf(number));

            String nowStr = st.toString();
            
            int tempNum = 0;
            int digit =0;
            while(true){
                tempNum+=Math.pow(2,digit);
                if(nowStr.length()<=tempNum){
                    break;
                }
                digit++;
            }
            
            while(tempNum != nowStr.length()){
                nowStr = "0" + nowStr;
            }
            
            
            chk = false;

            int maxIdx = nowStr.length()-1;
            int minIdx = 0;
            int midIdx = (maxIdx+minIdx)/2;
            
            dfs(nowStr,maxIdx,midIdx+1,nowStr.charAt((maxIdx+minIdx)/2));
            dfs(nowStr,midIdx-1,minIdx,nowStr.charAt((maxIdx+minIdx)/2));
            
            
            
            // System.out.println("String: " + nowStr.length());
            if(chk){
                answer[i] = 0;
            }else{
                answer[i] = 1;
            }
        }
        
        

        return answer;
    }
    void dfs(String nowString, int maxIdx, int minIdx,char upChar){
        if(chk){
            return;
        }
        if(maxIdx <= minIdx){
            if(upChar=='1'){
                return;
            }else{
                if(nowString.charAt(maxIdx) == '1'){
                    chk= true;
                    return;
                }else{
                    return;
                }
            }
        }
        int midIdx = (maxIdx+minIdx)/2;
        char nowChar = nowString.charAt(midIdx);
        if(upChar == '0'){
            if(nowChar == '1'){
                chk = true;
                return;
            }else{
                dfs(nowString, maxIdx,midIdx+1,'0');
                dfs(nowString, midIdx-1,minIdx,'0');
            }
        }else{
            if(nowChar == '1'){
                dfs(nowString, maxIdx,midIdx+1,'1');
                dfs(nowString, midIdx-1,minIdx,'1');
            }else{
                dfs(nowString, maxIdx,midIdx+1,'0');
                dfs(nowString, midIdx-1,minIdx,'0');
            }
        }
    }
}