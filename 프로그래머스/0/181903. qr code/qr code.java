class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i< code.length();i++){
            if(i % q == r){
                char now = code.charAt(i);
                st.append(now);
            }
        }

        return st.toString();
    }
}