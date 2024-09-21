import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        int _max = wallet[1];
        int _min = wallet[0];
        
        
        int max = Math.max(bill[0],bill[1]);
        int min = Math.min(bill[0],bill[1]);
        
        while(true){
            if(max <= _max && min <= _min){
                break;
            }else{
                int temp = max / 2;
                max = Math.max(temp,min);
                min = Math.min(temp,min);
                answer++;
            }
        }
        
        
        return answer;
    }
}