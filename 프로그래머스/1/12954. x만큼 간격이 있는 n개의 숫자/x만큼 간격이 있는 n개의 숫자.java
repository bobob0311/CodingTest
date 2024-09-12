class Solution {
    public long[] solution(int x, int n) {
        long[] arr = new long[n];
        
        long v=0;
        for(int i =0; i<n;i++){
            v +=(long)x;
            arr[i] = v;
        }
        
        return arr;
    }
}