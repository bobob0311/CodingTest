class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for(int i = c-1; i< my_string.length(); i+=m ){
            String str = my_string.substring(i,i+1);
            answer+=str;
        }
        
        return answer;
    }
}