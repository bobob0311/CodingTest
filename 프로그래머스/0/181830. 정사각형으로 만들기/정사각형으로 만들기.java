class Solution {
    public int[][] solution(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int max = Math.max(m,n);
        
        int[][] answer = new int[max][max];
        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}