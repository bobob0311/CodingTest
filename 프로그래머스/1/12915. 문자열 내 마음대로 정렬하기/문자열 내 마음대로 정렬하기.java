import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.charAt(n) == o2.charAt(n)){
                    return o1.compareTo(o2);
                }else{
                    return Character.compare(o1.charAt(n),o2.charAt(n));
                }
            }
        });
        return strings;
    }
}