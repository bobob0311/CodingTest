class Solution {
    public String solution(String bin1, String bin2) {
        int c = 0;
        int a1 = 0;
        int a2 = 0;
        for(int i = bin1.length()-1; i>=0;i--){
            if(bin1.charAt(i) == '1'){
                a1+= Math.pow(2,c);
            }
            c++;
        }
        c= 0;
        for(int i = bin2.length()-1; i>=0;i--){
            if(bin2.charAt(i) == '1'){
                a2+= Math.pow(2,c);
            }
            c++;
        }
        int answerNum = a1+a2;

        String answer = "";
        
        while(answerNum > 1){
            int now =  answerNum % 2;
            answerNum/=2;
            answer = String.valueOf(now) + answer; 
        }
        answer = String.valueOf(answerNum) + answer;
        
        return answer;
    }
}