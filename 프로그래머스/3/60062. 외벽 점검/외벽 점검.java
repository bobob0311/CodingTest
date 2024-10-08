/*
완전히 동그람 모양
외벽 총 둘레 n

n (1~200) => 외벽 총 둘레 
weak (1~15) 오름차순으로 정렬

weak 원소는 0 ~ n-1

dist (1~8) 원소는 1~100

시계로 도나 반시계로 도나 똑같나? 시작점이 다른거지 사실 상 동일하다고 생각해도된다. 
긴거를 먼저 쓰는게 맞는듯?
*/
import java.util.*;

class Solution {
    static int size;
    static int min = 200;
    public int solution(int n, int[] weak, int[] dist) {  
        size = n;
        boolean[] chk = new boolean[dist.length];
        Arrays.sort(dist);
        int answer = 0;
        for(int i =0; i<weak.length; i++){
            dfs(dist,i,weak,chk,weak[i]);
        }
        
        if(min == 200){
            return -1;
        }
        return min;
        
    }
    
    void dfs(int[] dist, int startIdx, int[] weak,boolean[] chk, int now){
        if(now >= weak[startIdx] + size){
            int count=0;
            for(int i = 0; i<dist.length; i++){
                if(chk[i]){
                    count++;
                }
            }
            min = Math.min(min, count);
            return;
        }
        int temp = now;
        
        
        for(int i =0; i<dist.length; i++){
            if(chk[i] == false){
                now += dist[i];
                boolean go = false;
                if(now >= size){
                    int tempNow = now%size;
                    for(int j =0; j<weak.length; j++){
                        if(weak[j] > tempNow){
                            now = weak[j] + size;
                            go = true;
                            break;
                        }
                    }
                }else{
                    for(int j =0; j<weak.length; j++){
                        if(weak[j] > now){
                            now = weak[j];
                            go = true;
                            break;
                        }
                    }
                }
                if(!go){
                    now =size + weak[0];
                }
                chk[i] = true;
                dfs(dist,startIdx,weak,chk,now);
                chk[i] = false;
                now = temp;
            }
            
        }
    }
}