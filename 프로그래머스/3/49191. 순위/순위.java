/*
한명의 등수를 어떻게 알 수 있을까?

*/
class Solution {
    
    
    public int solution(int n, int[][] results) {
        int answer=0;
        int[][] arr = new int[n+1][n+1];
        
        for(int i = 0; i<results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            arr[a][b] = 1;
            arr[b][a] = -1;
        }           
        
        for(int i =1; i<n+1; i++){
            for(int j =1; j< n+1; j++){
                for(int k =1; k<n+1; k++){
                    if (arr[i][k] == 1 && arr[k][j] == 1 && arr[i][j] ==0 ) {
                        arr[i][j] = 1;  
                        arr[j][i] = -1;
                    } else if (arr[i][k] == -1 && arr[k][j] == -1 && arr[i][j] ==0) {
                        arr[i][j] = -1; 
                        arr[j][i] = 1;
                    }
                }
            }
        }

        for(int[] players : arr){
            int count =0;
            for(int i= 1; i<=n; i++){
                if(players[i] == 0){
                    count++;
                }
                if(count == 2){
                    break;
                }
            }
            if(count == 1){
                answer++;
            }
        }
        
        return answer;
    }
}