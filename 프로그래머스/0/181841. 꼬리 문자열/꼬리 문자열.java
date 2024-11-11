class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder st = new StringBuilder();
        for(int i = 0 ; i<str_list.length; i++){
            if(str_list[i].contains(ex)){
                continue;
            }else{
                st.append(str_list[i]);
            }
        }
        
        return st.toString();
    }
}