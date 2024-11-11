class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder st = new StringBuilder();
        String answer = "";
        for(int idx : index_list){
            st.append(my_string.substring(idx, idx+1));
        }
        
        
        return st.toString();
    }
}