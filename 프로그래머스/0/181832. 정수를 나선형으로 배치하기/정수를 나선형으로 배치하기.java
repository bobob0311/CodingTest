class Solution {
    public int[][] solution(int n) {
        int x = 0;
        int y = 0;
        int[][] arr= new int[n][n];
        
        int num=2;
        arr[0][0] = 1;
        while(true){
            while(y+1 <n && arr[x][y+1] == 0){
                arr[x][++y] = num++;
            }
            while(x+1 < n && arr[x+1][y] == 0){
                arr[++x][y] = num++;
            }
            while(y-1 >=0 && arr[x][y-1] == 0){
                arr[x][--y] = num++;
            }
            while(x-1 >=0 && arr[x-1][y] == 0){
                arr[--x][y] = num++;
            }
            if(num >= n*n+1){
                break;
            }
        }

        return arr;
    }
}