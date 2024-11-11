class Solution {
    public String solution(int[] numLog) {
        StringBuilder st = new StringBuilder();
        for(int i = 1; i<numLog.length; i++){
            if(numLog[i] - numLog[i-1] == 1){
                st.append("w");
            }else if(numLog[i] - numLog[i-1] == -1){
                st.append("s");
            }else if(numLog[i] - numLog[i-1] == 10){
                st.append("d");
            }else{
                st.append("a");
            }
        }
        return st.toString();
    }
}