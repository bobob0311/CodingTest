class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            int k = query[2];
            int max = -1;
            for(int i =start; i<=end;i++){
                if(k < arr[i]){
                    if(max == -1){
                        max = arr[i];
                    }else{
                        max = Math.min(max,arr[i]);
                    }
                }
            }
            answer[idx++] = max;
        }
        
        return answer;
    }
}