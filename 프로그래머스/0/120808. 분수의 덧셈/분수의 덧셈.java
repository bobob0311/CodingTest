class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int up = ((numer1 * denom2) + (numer2 * denom1));
        int down = (denom1 * denom2);
        
        int limit = Math.min(up,down);
        int temp = 1;
        for(int i = 2; i<=limit; i++){
            if(up % i == 0 && down % i == 0){
                temp = i;
            }
        }
        
        int[] answer = new int[] {up/temp, down/temp};
        return answer;
    }
}