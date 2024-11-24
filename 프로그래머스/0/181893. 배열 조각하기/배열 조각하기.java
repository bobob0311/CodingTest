class Solution {
    public int[] solution(int[] arr, int[] query) {
        int endIdx = query.length;
        int startIdx = 0;
        
        for(int i = 0; i<query.length; i++){
            int nowQuery = query[i];
            if(i % 2 == 0){
                endIdx = endIdx - (endIdx - startIdx  - nowQuery);  
            }else{
                startIdx += nowQuery;
            }
        }
        
        int[] answer = new int[endIdx - startIdx + 1];
        int idx = 0;
        for(int i = startIdx;i<=endIdx; i++){
            answer[idx++] = arr[i];
        }
        return answer;
    }
}