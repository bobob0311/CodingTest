/*
사다리꼴만 있었을 때 개수
1=>   삼    +    왼     + 오  
2=>왼 삼 (오)  +  삼+(오)+왼  + 삼 (오)



*/

class Solution {
    public int solution(int n, int[] tops) {
        int[][] dp = new int[n+1][2];
        dp[0][1] = 1;
        for(int i =0; i<n ; i++){
            int top = tops[i];
            int next = i+1;
            dp[next][0] = (dp[i][0] + dp[i][1]) % 10007;
            if(top == 0){
                dp[next][1] = (dp[i][0] + dp[i][1] *2) % 10007;
            }else{
                dp[next][1] = (dp[i][0] *2 + dp[i][1] *3) % 10007;
            }
        }
        
        return (dp[n][0] + dp[n][1]) % 10007;
    }
}