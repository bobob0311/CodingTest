class Solution {
    public String solution(String my_string) {
        String temp = "aeiou";
        StringBuilder st = new StringBuilder();
        
        for(int i = 0; i<my_string.length(); i++){
            String str = my_string.substring(i,i+1);
            if(!temp.contains(str)){
                st.append(str);
            }
        }
        
        return st.toString();
    }
}