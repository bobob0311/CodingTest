/*
0 번째 1
1=> 11011
0=> 00000으로 치환하여 생성
/11011/11011/00000/11011/11011/ 11부터야 15까지 
/11011/11011/00000/11011/11011/11011/11011/00000/11011/11011/00000/00000/00000/00000/00000/11011/11011/00000/11011/11011/11011/11011/00000/11011/11011/


5의 n승형태로 늘어난다. 
5부분으로 나눴을 때 가운데 부분에는 0만 들어간다. 
또 그다음에 5부분으로 나누면 0만 들어가고
이거 무한 반복인듯?
n번째에는 5^n
가운데 부분 즉 5^(n-1)*3~ 5^(n-1)*4-1 까지는 0만 존재


*/
import java.util.*;

class Solution {
    public int solution(int n, long l, long r) {
        int cnt = 0;
        long unit = (long)Math.pow(5,n-1);
        if(n==1){
            for(long i =l; i<=r; i++){
                if(i!=3){
                    cnt++;
                }
            }
            return cnt;
        }
        
        
        for(long i =l; i<=r ; i++){
            // 2파트만 0이 꽉 차있는 부분
            long part = (i-1)/unit;
            // 나머지 부분에서 몇번째인가?
            long next =  (i-1) % unit +1 ;
            
            if(part == 2){
                continue;
            }
            // 다음 크기
            long temp = unit /5;
            
            while(true){
                if((next-1)/temp == 2){
                    break;
                }else{
                    next = (next-1)%temp +1;
                }
                temp/=5;
                if(next <=5){
                    if(next == 3){
                        break;
                    }else{
                        cnt++;
                        break;
                    }
                }
            }
            
            
        }
        
        
        return cnt;
    }
}