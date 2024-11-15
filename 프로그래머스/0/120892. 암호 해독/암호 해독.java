class Solution {
    public String solution(String cipher, int code) {
        StringBuilder st = new StringBuilder();
        for(int i =code-1; i<cipher.length(); i+= code){
            String tempStr = cipher.substring(i,i+1);
            st.append(tempStr);
        }
        return st.toString();
    }
}