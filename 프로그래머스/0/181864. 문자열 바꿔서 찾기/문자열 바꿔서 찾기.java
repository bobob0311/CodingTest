class Solution {
    public int solution(String myString, String pat) {
        String tempStr = "";
        
        for(int i =0; i<pat.length(); i++){
            if(pat.charAt(i) == 'A'){
                tempStr+="B";
            }else{
                tempStr+="A";
            }
        }
        
        for(int i =0; i<myString.length() - pat.length()+1; i++){
            if(myString.substring(i,i+pat.length()).equals(tempStr)){
                return 1;
            }
        }
        
        return 0;
    }
}