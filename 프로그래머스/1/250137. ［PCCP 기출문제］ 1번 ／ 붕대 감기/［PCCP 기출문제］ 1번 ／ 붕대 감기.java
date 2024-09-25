// t초 붕대 감으면서 1초마다 x 체력 회복 t초 다 감으면 y 만큼 추가 회복 
// 최대 체력 존재

//공격 당하는 순간에 회복 X 기술 취소되고 기술 끝날시 붕대 감기 다시 사용
// 0 이되면 캐릭 죽음 , 피해량만큼 체력 줄음
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = bandage[0];
        int per = bandage[1];
        int ss = bandage[2];
        
        int limit = health;
        Arrays.sort(attacks,(a,b)-> Integer.compare(a[0],b[0]));
        int maxTime = attacks[attacks.length-1][0];
        int idx = 0;
        
        int nowHp = limit;
        int count = 0;
        for(int i =0; i<=maxTime ; i++){
            if(i == attacks[idx][0]){
                nowHp -= attacks[idx][1];
                idx++;
                count = 0;
                if(nowHp <=0){
                    return -1;
                }
            }else{
                nowHp+=per;
                count++;
                if(count == time){
                    count=0;
                    nowHp+=ss;
                }
                if(nowHp>=limit){
                    nowHp = limit;
                }
            }
            
        }
        

        return nowHp;
    }
}