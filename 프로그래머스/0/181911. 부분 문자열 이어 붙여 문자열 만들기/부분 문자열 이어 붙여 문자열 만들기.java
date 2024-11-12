class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i<parts.length; i++){
            int start = parts[i][0];
            int end = parts[i][1] + 1;
            st.append(my_strings[i].substring(start,end));
        }
        
        return st.toString();
    }
}