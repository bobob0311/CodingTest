class Solution {
    public String solution(String my_string, int n) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i<my_string.length(); i++){
            String str = my_string.substring(i,i+1);
            for(int j =0; j<n; j++){
                st.append(str);
            }
        }
        return st.toString();
    }
}