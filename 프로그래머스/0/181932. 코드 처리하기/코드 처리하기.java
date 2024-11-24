class Solution {
    public String solution(String code) {
        StringBuilder st = new StringBuilder();
        boolean mode = false;
        for(int i = 0; i<code.length(); i++){
            char now = code.charAt(i);
            if(now == '1'){
                mode = !mode;
            }else{
                if(!mode){
                    if(i % 2 ==0){
                        st.append(now);
                    }
                }else{
                    if(i % 2 == 1){
                        st.append(now);
                    }
                }
            }
        }
        if(st.toString().length() == 0){
            return "EMPTY";
        }
        
        
        return st.toString();
    }
}