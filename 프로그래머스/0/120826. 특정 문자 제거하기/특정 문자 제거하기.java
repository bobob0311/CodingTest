class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i<my_string.length(); i++){
            String nowString = my_string.substring(i,i+1);
            if(!letter.contains(nowString)){
                st.append(nowString);
            }
        }
        return st.toString();
    }
}