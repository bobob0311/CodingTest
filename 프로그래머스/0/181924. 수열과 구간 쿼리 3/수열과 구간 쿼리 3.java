class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i<queries.length; i++){
            int one = queries[i][0];
            int two = queries[i][1];
            
            int temp = arr[one];
            arr[one] = arr[two];
            arr[two] = temp;
        }
        
        return arr;
    }
}