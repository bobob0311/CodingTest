/*
1
2 6
3 4 5

1
2 9
3 10 8
4 5  6  7

0,0

1
2  12
3  13 11
4  14 15 10
5  6  7  8  9


0,0 1,1

1
2 15
3 16 14
4 17 21 13
5 18 19 20 12
6 7   8  9 10 11

1. 아래일때는 0,0 1,1 ?

아래 오른쪽 왼쪽위

아래 오른쪽 왼쪽위
*/

class Solution {
    int[][] arr;
    
    public int[] solution(int n) {
        if(n ==1){
            return new int[] {1};
        }
        if(n == 3){
            return new int[] {1,2,6,3,4,5};
        }
        
        arr= new int[n][n];
        int target =0;
        for(int i=1; i<=n;i++){
            target+=i;
        }
        int[] answer = new int[target];
        int num=1;
        int idxX=0;
        int idxY=0;
        
            while(idxY != n){
                arr[idxY][idxX] = num;
                num++;
                idxY++;
            }
            idxY--;
            idxX++;
            while(idxX != n){
                arr[idxY][idxX] = num;
                idxX++;
                num++;
            }
        
       
        idxX--;
        while(num!=target+1){
            
            while(arr[--idxY][--idxX] == 0){
                arr[idxY][idxX] = num;
                num++;
               // System.out.println(idxY + " " + idxX + " num");
            }
            idxX++;
            idxY++;
        
            while(arr[++idxY][idxX] == 0){
                arr[idxY][idxX] = num;
                num++;
               // System.out.println(idxY + " " + idxX + " num");
            }
            idxY--;
            
            while(arr[idxY][++idxX] == 0){
                arr[idxY][idxX] = num;
                num++;
               // System.out.println(idxY + " " + idxX + " num");
            }
            idxX--;
          
        }
        int idx=0;
        for(int i=0; i<n;i++){
            for(int j =0; j<=i ;j++){
                answer[idx]= arr[i][j];
                idx++;
            }
        }
 
        return answer;
    }
}