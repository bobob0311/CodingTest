class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[202];
        for(int[] line : lines){
            int start = line[0] + 100;
            int end = line[1] + 100;
            for(int i =start; i<end;i++){
                arr[i]++;
            }
        }
        int cnt = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= 2){
                cnt++;
                
            }
        }

        return cnt;
    }
}