class Solution {
    public int solution(int[] array, int n) {
        int cnt =0;
        for (int v : array){
            if(v == n){
                cnt++;
            }
        }
        return cnt;
    }
}