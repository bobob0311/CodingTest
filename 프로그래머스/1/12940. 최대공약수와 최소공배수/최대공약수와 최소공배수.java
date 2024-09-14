class Solution {
    public int[] solution(int n, int m) {
        int min =1;
        int max =Math.max(n,m);
        while(true){
            if(min % n == 0 && min % m ==0){
                break;
            }
            min++;
        }
        while(true){
            if(n % max ==0 && m%max == 0){
                break;
            }
            max--;
        }
        
        
        
        int[] answer = {max,min};
        return answer;
    }
}