class Solution {
    public int solution(int n) {
        int nowNum = 1;
        int answer = 0;
        while(true){
            if(nowNum % 3 == 0){
                nowNum++;
                continue;
            }else{
                if(String.valueOf(nowNum).contains("3")){
                    nowNum++;
                    continue;
                }else{
                    answer++;
                    if(answer == n){
                       return nowNum;
                    }    
                    nowNum++;
                }
            }
            
        }

    }
}