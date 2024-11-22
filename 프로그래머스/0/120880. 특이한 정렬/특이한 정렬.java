import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i<numlist.length; i++){
            list.add(numlist[i]);
        }
        
        Collections.sort(list, (a,b)-> {
            if(Math.abs(n-a) == Math.abs(n-b)){
                return Integer.compare(-a,-b);
            }else{
                return Integer.compare(Math.abs(n-a), Math.abs(n-b));
            }
        });
        
        for(int i = 0; i<list.size(); i++){
            numlist[i] = list.get(i);
        }
        
        return numlist;
    }
}