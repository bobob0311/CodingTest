// 대문자 65 ~ 90
// 소문자 97 ~ 122

class Solution {
    public String solution(String s, int n) {
        StringBuilder st = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                st.append(" ");
                continue;
            }
            int value = s.charAt(i);
            int nowValue = value +n;
            if(value>=97){
                if(nowValue > 122){
                    int c = 97+nowValue - 122 - 1;
                    st.append(String.valueOf((char) c));
                }else{
                    st.append(String.valueOf((char) nowValue));
                }
                
            }else{
                if(nowValue >90){
                    int c = 65 + nowValue - 90 - 1;
                    st.append(String.valueOf((char) c));
                }else{
                    st.append(String.valueOf((char)nowValue));
                }
            }
        }
        
        return st.toString();
    }
}