import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        List<String> list = new ArrayList<>(cacheSize);
        int time =0;
        for(String city : cities){
            String temp = city.toLowerCase();
            int chk = list.indexOf(temp);
            if(chk != -1){
                time++;
                
                list.remove(chk);
                list.add(temp);
            }else{
                time+=5;
                if(list.size() == cacheSize){
                    list.remove(0);
                    list.add(temp);
                }else{
                    list.add(temp);
                }
            }
        }
        
        return time;
    }
}