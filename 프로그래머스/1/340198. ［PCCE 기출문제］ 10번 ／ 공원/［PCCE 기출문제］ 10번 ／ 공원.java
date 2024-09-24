class Solution {
    public int solution(int[] mats, String[][] park) {
        int arr[][] = new int[park.length][park[0].length];
        for(int i =0; i<park.length; i++){
            for(int j =0; j<park[0].length; j++){
                if(park[i][j].equals("-1")){
                    arr[i][j] = 1;
                }
            }
        }
        int max = 0;
        
        
        for(int i =0; i<park.length; i++){
            for(int j =0; j<arr[0].length; j++){
                if(i-1>=0 && j-1>=0){
                    if(arr[i][j] !=0){
                        arr[i][j] = Math.min(arr[i-1][j-1] ,Math.min(arr[i-1][j],arr[i][j-1]))+1;
                        max = Math.max(max,arr[i][j]);
                    }
                }
            }
        }

        int answer = -1;
        
        for(int mat : mats){
            if(mat <=max){
                answer = Math.max(answer,mat);
            }
        }
        
        return answer;
    }
}