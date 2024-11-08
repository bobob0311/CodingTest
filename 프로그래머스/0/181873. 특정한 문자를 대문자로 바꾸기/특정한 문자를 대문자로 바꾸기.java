class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        for(int i = 0; i<my_string.length(); i++){
            String target = my_string.substring(i,i+1);
            if(target.equals(alp)){
                answer += target.toUpperCase();
            }else{
                answer += target;
            }
        }
        return answer;
    }
}