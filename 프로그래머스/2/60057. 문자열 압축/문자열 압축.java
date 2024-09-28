/*
7 40
같은 값이 연속해서 나타나는 것을 문자의 개수와 반복되는 값으로 표현하고 싶다. 
1개 이상의 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return
제일 앞부터 정해진 길이만큼 잘라야한다. 


*/

class Solution {
    static int min = 10001;
    public int solution(String s) {
        if(s.length() == 1){
            return 1;
        }
        
        
        for(int i =1; i<=s.length()/2;i++){
            int length = s.length();
            boolean chk = false;
            int count = 1;
            for(int j =0; j<s.length() - i - i+1; j+=i){
                String now = s.substring(j,j+i);
                String next = s.substring(j+i,j+i+i);
                if(now.equals(next)){
                    if(!chk){
                        chk = true;
                    }
                    length-=i;
                    count++;
                }else{
                    if(chk){
                        length += String.valueOf(count).length();    
                        chk = false;
                    }
                    count = 1;
                }
            }
            if(chk){
                length+=String.valueOf(count).length();
            }
            min = Math.min(min,length);
        }
        

        return min;
    }
}