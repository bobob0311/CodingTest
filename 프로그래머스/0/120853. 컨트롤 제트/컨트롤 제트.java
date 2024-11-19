class Solution {
    public int solution(String s) {
        String[] strArr = s.split(" ");
        int prev = 0;
        int answer = 0;

        for(String now : strArr){
            if(now.equals("Z")){
                answer-=prev;
            }else{
                answer+= Integer.parseInt(now);
                prev = Integer.parseInt(now);
            }
        }
        
        
        return answer;
    }
}