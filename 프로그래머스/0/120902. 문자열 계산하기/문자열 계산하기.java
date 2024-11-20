class Solution {
    public int solution(String my_string) {
        String[] str = my_string.split(" ");
        int answer = 0;
        for(int i = 0; i<str.length; i++){
            String value = str[i];
            if(value.equals("+")){
                answer += Integer.parseInt(str[++i]);
            }else if(value.equals("-")){
                answer -= Integer.parseInt(str[++i]);
            }else{
                answer += Integer.parseInt(str[i]);
            }
        }
        
        return answer;
    }
}