import java.util.*;
class Solution {
    public int solution(int a, int b) {
        List<Integer> list = new LinkedList<>();
        int idx =2;
        while(idx <= b){
            if(b % idx == 0){
                b/=idx;
                list.add(idx);
                idx = 2;
                continue;
            }else{
                idx++;
            }
        }
        for(int i = 0; i<list.size(); i++){
            int now = list.get(i);
            if(now == 2 || now == 5){
                continue;
            }else{
                if(a%now != 0){
                    return 2;
                }else{
                    a/=now;
                }
            }
        }
        
        return 1;
    }
}