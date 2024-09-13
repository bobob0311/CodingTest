class Solution {
    public String solution(int n) {
        StringBuilder st = new StringBuilder();
        for(int i =0; i<n; i++){
            if(i%2 == 0){
                st.append("수");
            }else{
                st.append("박");
            }
        }
        
        return st.toString();
    }
}