import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[] {a,b,c,d};
        int[] num = new int[7]; 
        for(int v : arr){
            set.add(v);
            num[v]++;
        }
        if(set.size() == 1){
            return a* 1111;
        }else if(set.size() == 4){
            int min = 7;
            for(int v:arr){
                if(v == 0){
                    continue;
                }
                min = Math.min(v,min);
            }
            return min;
        }else if(set.size() == 2){
            int q = 0;
            int p = 0;
            for(int i = 1; i<7;i++){
                if(num[i] == 3){
                    p = i;
                }else if(num[i] == 1){
                    q = i;
                }
            }
            if( p != 0){
                return (10 *p +q) * (10 *p +q);
            }
            for(int i = 1; i<7;i++){
                if(num[i] == 2){
                    if(p == 0){
                        p = i;    
                    }else{
                        q =i;
                    }
                    
                }
            }
            return (p+q) * Math.abs(p-q);
            
            
        }else if(set.size() == 3){
            int q=0;
            int r=0;
            for(int i = 1; i<7;i++){
                if(num[i] == 1){
                    if(q == 0){
                        q = i;
                    }else{
                        r = i;
                    }
                }
            }
            return q*r;
        }
        
        
        int answer = 0;
        return answer;
    }
}