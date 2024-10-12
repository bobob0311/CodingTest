import java.util.*;
class Solution {
    public String solution(String p) {
        List<String> list = new ArrayList<>();
        while(p.length() != 0){
            int cnt1 = 0;
            int cnt2 = 0;
            int targetIdx = 0;
            for(int i =0; i<p.length(); i++){
                if(p.charAt(i) == '('){
                    cnt1++;
                }else{
                    cnt2++;
                }
                if(cnt1 == cnt2){
                    targetIdx = i;
                    break;
                }
            }
            String str1 = p.substring(0,targetIdx+1);
            String str2 = p.substring(targetIdx+1);
            list.add(str1);
            p = str2;    
        }
        String answer = "";
        for(int i = list.size()-1; i>=0; i--){
            String nowString = list.get(i);
            Stack<Integer> st = new Stack<>();
            boolean chk = false;
            for(int j =0; j<nowString.length();j++){
                if(nowString.charAt(j) == '('){
                    st.push(1);
                }else{
                    if(st.isEmpty()){
                        chk = true;
                        break;
                    }else{
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()){
                chk = true;
            }
            if(chk){
                answer = "("+answer+")";
                String temp = "";
                for(int k =1; k<nowString.length()-1; k++){
                    char target = nowString.charAt(k);
                    if(target == '('){
                        temp+=")";
                    }else{
                        temp+= "(";
                    }
                }
                answer += temp;
                
                
            }else{
                answer = nowString + answer;
            }
        }
        
        

        return answer;
    }
}