import java.util.*;

class Solution {
    static class light{
        int rou;
        int min;
        int max;
        
        light(int[] signal){
            this.rou = signal[0] + signal[1] + signal[2];
            this.min = signal[0] +1;
            this.max = signal[1] + signal[0];
        }
        
        
        boolean isYellow(int time){
            int nowTime = time % rou;
            if(nowTime >= min && nowTime <= max) return true;
            return false;
        }
    }
    
    ArrayList<light> list = new ArrayList<>();
    
    public int solution(int[][] signals) {
        for(int[] signal : signals){
            list.add(new light(signal));
        }
        
        int max = (int) Math.pow(20,5);
        for(int i = 1; i< max+1; i++){
            boolean sig  = true;
            int nowTime = i;
            
            for(light now : list){
                if(!now.isYellow(nowTime)){
                    sig = false;
                }
            }
            if(sig)  return nowTime;
        }
        return -1;
    }
}