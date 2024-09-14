class Solution {
    public int solution(int n) {
        String temp = "";
        while(n>=3){
            int tempInt = n%3;
            temp = String.valueOf(tempInt) + temp;
            n/=3;
        }
        temp = String.valueOf(n) +temp;

        int answer = 0;
        
        for(int i = 0; i < temp.length(); i++){
            answer += Character.getNumericValue(temp.charAt(i)) * Math.pow(3,i);
        }
        
        
        return answer;
    }
}