class Solution {
    public int solution(int[] array) {
        int[] arr = new int[1001];
        int max = 0;
        for(int v : array){
            arr[v]++;
            max = Math.max(arr[v],max);
        }
        int idx =-1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == max){
                if(idx != -1){
                    return -1;
                }else{
                    idx = i;
                }
            }
        }
        return idx;
    }
}