class Solution {
    public int solution(int[] array, int height) {
        int cnt = 0;
        for(int v: array){
            if(v > height){
                cnt++;
            }
        }
        return cnt;
    }
}