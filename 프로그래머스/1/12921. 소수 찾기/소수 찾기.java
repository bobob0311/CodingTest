import java.util.*;

class Solution {
    public int solution(int n) {
        int count = 0;
        for(int i =2; i<=n;i++){
            boolean chk = false;
            for(int j =2; j<=Math.sqrt(i);j++){
                if(i%j == 0){
                    chk=true;
                    break;
                }
            }
            if(!chk){
                count++;
            }
        }
        return count;
    }
}