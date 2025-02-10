import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] lines) {
        StringTokenizer st;
        
        int[] startTimeArr = new int[24*60*60*1000+4004];
        int[] endTimeArr = new int[24*60*60*1000+4004];
        for(String line: lines){
            st = new StringTokenizer(line);
            st.nextToken();
            String S = st.nextToken();
            String T = st.nextToken();
            int endTime = calcTime(S) + 4000;
            int startTime = endTime - (int) (Float.parseFloat(T.substring(0,T.length()-1)) * 1000) +1;
            
            startTimeArr[startTime] += 1;
            endTimeArr[endTime+1] += -1;
        }
        int now = 0;
        for(int i = 0; i<= 999;i++){
            if(startTimeArr[i] > 0){
                now+= startTimeArr[i];
            }
        }
        int answer = 0;
        answer = Math.max(now,answer);
        int max = 24*60*60*1000+4004;
        for(int i = 1000; i< max; i++){
            if(startTimeArr[i] > 0){
                now+=startTimeArr[i];
            }
            if(endTimeArr[i- 999] < 0){
                now+=endTimeArr[i-999];
            }
            answer = Math.max(now,answer);
        }
        
        return answer;
    }
    
    static int calcTime(String str){
        int hour = Integer.parseInt(str.substring(0,2)) * 60* 60 * 1000;
        int min = Integer.parseInt(str.substring(3,5)) * 60 * 1000;
        int sec = Integer.parseInt(str.substring(6,8)) * 1000 + Integer.parseInt(str.substring(9));
        return hour+min+sec;
    }
}