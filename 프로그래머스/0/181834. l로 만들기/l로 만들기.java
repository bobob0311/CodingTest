class Solution {
    public String solution(String myString) {
        int cond = (int) 'l';
        StringBuilder st = new StringBuilder();
        for(int i = 0; i<myString.length(); i++){
            if((int) myString.charAt(i) <= cond){
                st.append("l");
            }else{
                st.append(myString.substring(i,i+1));
            }
        }
        return st.toString();
    }
}