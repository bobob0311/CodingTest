import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new LinkedList<>();
        for(int i = l ; i<=r; i++){
            if(i % 5 != 0){
                continue;
            }else{
                boolean chk = true;
                int now = i;
                while(now >0){
                    if(now % 10 == 0 || now % 10 == 5){
                        now /= 10;
                    }else{
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    list.add(i);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        if(list.size() == 0){
            return new int[] {-1};
        }
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}