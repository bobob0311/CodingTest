class Solution {
    public String solution(String rsp) {
        StringBuilder st = new StringBuilder();
        
        for(int i = 0; i<rsp.length(); i++){
            if(rsp.charAt(i) == '0'){
                st.append("5");
            }else if(rsp.charAt(i) == '2'){
                st.append("0");
            }else{
                st.append("2");
            }
        }
        
        return st.toString();
    }
}