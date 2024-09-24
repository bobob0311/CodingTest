class Solution {
    public String solution(int[] numbers, String hand) {
        int l = 10;
        int r = 12;
        String answer = "";
        
        for(int num : numbers){
            if (num == 0){
                num = 11;
            }
            if(num == 1 || num == 4 || num == 7){
                answer+="L";
                l = num;
            }else if(num == 3 || num == 6 || num == 9){
                answer+="R";
                r = num;
            }else{
                int temp1 = (num-1) /3;
                int temp2 =  ((num-1) %3);
                
                int leftTemp1 = (l-1) /3; 
                int leftTemp2 = ((l-1) %3);
                
                int rightTemp1 = (r-1) /3; 
                int rigthTemp2 = ((r-1) % 3);
                
                int closeRight = Math.abs(rightTemp1 - temp1) + Math.abs(rigthTemp2 - temp2);
                int closeLeft = Math.abs(leftTemp1 - temp1) + Math.abs(leftTemp2 - temp2);
                
                if(closeRight > closeLeft ){
                    answer+="L";
                    l = num;
                }else if(closeRight < closeLeft){
                    answer+="R";
                    r = num;
                }else{
                    if(hand.equals("right")){
                        answer+="R";
                        r = num;
                    }else{
                        answer+="L";
                        l = num;
                    }
                }
            }
        }
        
        return answer;
    }
}