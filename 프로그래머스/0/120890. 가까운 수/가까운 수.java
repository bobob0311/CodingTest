import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = -20000;
        for(int value : array){
            int prevAbs = Math.abs(answer - n);
            int nowAbs = Math.abs(value - n);
            if(nowAbs < prevAbs){
                answer = value;
            }else if(nowAbs == prevAbs){
                if(value < answer){
                    answer = value;
                }
            }else{
                continue;
            }
        }
        return answer;
    }
}