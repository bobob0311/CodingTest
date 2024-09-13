class Solution {
    public int solution(int[] numbers) {
        int[] arr = new int[10];
        for(int i=0; i<numbers.length;i++){
            int idx =numbers[i];
            arr[idx] = 1;
        }
                int answer = 0;
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] !=1){
                answer+=i;
            }
        }

        return answer;
    }
}