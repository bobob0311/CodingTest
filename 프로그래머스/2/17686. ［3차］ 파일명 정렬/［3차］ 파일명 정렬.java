/*
head 는 한글자 이상 
Number 은 한글자에서 최대 다섯 글자 사이의 연속된 숫자 
TAIL은 나머지 부분

우선 분리를 해야될거같은데

map에 index와 이름을 대문자로 만들어서 넣자 
map에 키는 이름을 대문자로 index랑 숫자를 넣어야한다. 
*/

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Map<String,List<int[]>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i<files.length; i++){
            String nowFile = files[i];
            boolean chk = false;
            int headerIdx=0;
            int numIdx=0;
            for(int j = 0; j<nowFile.length(); j++){
                char nowChar = nowFile.charAt(j);
                if(nowChar == ' '){
                    if(chk){
                        numIdx = j;
                        break;
                    }else{
                        continue;
                    }
                }
                int nowString = (int) nowChar; 
                
                if(!chk && nowString >=48 && nowString< 58){
                    chk= true;
                    headerIdx = j;
                    continue;
                }
                if(chk){
                    if(nowString < 48 || nowString >=58){
                        numIdx = j;
                        break;  
                    }
                }
            }
            if(numIdx == 0){
                numIdx = nowFile.length();
            }
            
            String key = nowFile.substring(0,headerIdx).toUpperCase();
            int num = Integer.parseInt(nowFile.substring(headerIdx,numIdx));
            
            if(map.get(key) == null){
                map.put(key,new ArrayList<>());
                list.add(key);
            }
            map.get(key).add(new int[] {num,i}); 
        }
        
        String[] strArr = new String[list.size()];
        for(int i = 0; i<list.size(); i++){
            strArr[i] = list.get(i);
        }
        
        Arrays.sort(strArr);
        int idx = 0;
        String[] answer = new String[files.length]; 
        
        for(int i = 0; i<strArr.length; i++){
            List<int[]> nowList = map.get(strArr[i]);
            nowList.sort((a, b) -> {
                int cmp = Integer.compare(a[0], b[0]);
                if (cmp == 0) {
                    return Integer.compare(a[1], b[1]);
                }
                return cmp;
            });
            for(int j =0;j<nowList.size(); j++){
                answer[idx++] = files[nowList.get(j)[1]];
            }
        }
        
       
        
        
        

        return answer;
    }
}