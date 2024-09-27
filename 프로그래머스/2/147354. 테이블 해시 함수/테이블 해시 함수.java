/*
col,row_begin,row_end
튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬 만약 그 갑시 동일할시 기본키 첫칼럼 값기준 내림차순

*/


import java.util.*;


class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
         Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {  
                return Integer.compare(b[0], a[0]);
            } else {
                return Integer.compare(a[col - 1], b[col - 1]);
            }
        });
        
        int[] S_i = new int[data.length];
        
        for(int i =0; i<data.length; i++){
            int temp =0;
            int[] arr = data[i];
            for(int j=0; j<arr.length; j++){
                temp+=arr[j] % (i+1);
            }
            S_i[i] = temp;
        }
        int answer = 0;
        

        for(int i=row_begin; i<=row_end; i++){
            answer ^=S_i[i-1];    
        }

        return answer;
    }
}