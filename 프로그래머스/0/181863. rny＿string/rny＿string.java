class Solution {
    public String solution(String rny_string) {
        StringBuilder st = new StringBuilder();
        
        for(int i = 0; i<rny_string.length(); i++){
            if(rny_string.charAt(i) == 'm'){
                st.append("rn");
            }else{
                st.append(rny_string.substring(i,i+1));
            }
        }
        
        return st.toString();
    }
}