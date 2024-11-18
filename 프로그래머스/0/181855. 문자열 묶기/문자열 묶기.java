import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(String str : strArr){
            if(map.get(str.length()) != null){
                map.put(str.length(), map.get(str.length())+1);
            }else{
                map.put(str.length(),1);
            }
        }
        int max = 0;
        for(Integer v : map.values()){
            if(v>max){
                max = v;
            }
        }
        
        return max;
    }
}