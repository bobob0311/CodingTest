import java.util.*;
class Solution {
    String[] wordArr;
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        wordArr = new String[] {"A","E","I","O","U"};
        dfs("",0);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                return i;
            }
        }
        return 0;
    }
    void dfs(String str, int len){
        list.add(str);
        if(len == 5){
            return;
        }
        for(int i = 0; i<wordArr.length; i++){
            dfs(str+wordArr[i], len + 1);
        }
    }
}