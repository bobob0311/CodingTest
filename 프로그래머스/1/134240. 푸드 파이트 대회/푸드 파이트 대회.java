class Solution {
    public String solution(int[] food) {
        String answer = "0";

        for(int i =food.length-1; i>=0;i--){
            int count = food[i]/2;
            String idx = String.valueOf(i);
            for(int j = 0; j<count; j++){
                answer += idx;
                answer = idx +answer;
            }
        }
                return answer;
    }
}