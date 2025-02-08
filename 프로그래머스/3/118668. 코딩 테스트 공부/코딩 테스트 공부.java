import java.util.*;
import java.io.*;

class Solution {
    static int maxA = 0;
    static int maxB = 0;
    
    public int solution(int alp, int cop, int[][] problems) {
        find(problems);
        maxA = Math.max(alp,maxA);
        maxB = Math.max(cop,maxB);
        int[][] dp = new int[maxA+1][maxB+1];
        for(int i = 0; i< maxA + 1; i++){
            Arrays.fill(dp[i], 10000000);
        }
        dp[alp][cop] = 0;
        
        for(int i = alp; i< maxA+1; i++){
            for(int j = cop; j< maxB+1; j++){
                    if(i+1 <= maxA) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] +1);    
                    if(j+1 <= maxB) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] +1);    
                for(int[] problem: problems){
                    // 풀 수 있을 때
                    if(i>= problem[0] && j>= problem[1]){
                        // 받았을 때 최대 보다 높을 경우 최대값으로 대체
                        int a = Math.min(maxA, i+ problem[2]);
                        int b = Math.min(maxB, j+ problem[3]);
                        
                        dp[a][b] = Math.min(dp[a][b], dp[i][j] + problem[4]); 
                    }
                }
            }
        }
    
        int answer = dp[maxA][maxB];
        return answer;
    }
    
    static void find(int[][] problems){
        for(int[] problem : problems){
            maxA = Math.max(problem[0], maxA);
            maxB = Math.max(problem[1], maxB);
        }
    }
}