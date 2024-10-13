/*
0 -> 자유
1 -> 통행금지
2-> 좌회전이나 우회전이 금지 전에 오던 방향으로 그대로 진행만가능
자동차는 오른쪽 또는 아래로만 이동가능!!

전체 가능한 경로이 수를 출력해라.
3차원 배열을 가져와서 위에서 온경우와 왼쪽에서 온 경우를 나눠서 생각을 해볼까? 
*/

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] answerArr = new int[m][n][2];
        // 오른쪽으로 가는 경우
        answerArr[0][0][0] = 1;
        // 아래로 가는 경우
        answerArr[0][0][1] = 1;
        
        for(int i =0; i<m ; i++){
            for(int j =0; j<n ; j++){
                int target = cityMap[i][j];
                
                
                if(i == 0 && j==0){
                    continue;
                }
                // 첫째 줄, 첫째 열 처리 과정
                if(i == 0){
                    if(target == 0 || target == 2){
                        answerArr[i][j][0] += answerArr[i][j-1][0] %MOD;
                        continue;
                        }else{
                        continue;
                    }
                }
                if(j == 0){
                    if(target==0 || target == 2){
                        answerArr[i][j][1] += answerArr[i-1][j][1] %MOD;
                        continue;
                    }else{
                        continue;
                    }
                }
                
                // 나머지 경우
                if(target == 0 || target == 2){
                    if(cityMap[i-1][j] == 2){
                        answerArr[i][j][1] = answerArr[i-1][j][1];      
                    }else if(cityMap[i-1][j] == 0){
                        answerArr[i][j][1] = (answerArr[i-1][j][0] + answerArr[i-1][j][1]) %MOD;
                    }
                    if(cityMap[i][j-1] == 2){
                        answerArr[i][j][0] = answerArr[i][j-1][0];          
                    }else if(cityMap[i][j-1] == 0){
                        answerArr[i][j][0] = (answerArr[i][j-1][0] + answerArr[i][j-1][1]) %MOD;
                    }
                    
                }else{
                    continue;
                }
                
            }
        }
        
        
        
        
        int answer = 0;
        return (answerArr[m-1][n-1][0] + answerArr[m-1][n-1][1]) %MOD;
    }
}