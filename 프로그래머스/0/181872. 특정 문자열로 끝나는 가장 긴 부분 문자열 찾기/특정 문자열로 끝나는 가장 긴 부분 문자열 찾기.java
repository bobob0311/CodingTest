class Solution {
    public String solution(String myString, String pat) {
        int idx = -1;
        for(int i = 0; i<myString.length() - pat.length() +1; i++){
            if(myString.substring(i,i+pat.length()).equals(pat)){
                idx = i;
            }
        }
        
        
        
        String answer = myString.substring(0,idx+pat.length());
        return answer;
    }
}