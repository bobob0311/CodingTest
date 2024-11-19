class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            int k = query[2];
            for(int i = start; i<=end; i++){
                if(i % k ==0 && k!=0){
                    arr[i]++;
                }
            }
        }
        
        return arr;
    }
}