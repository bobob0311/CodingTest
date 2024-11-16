class Solution {
    public int solution(int i, int j, int k) {
        int cnt = 0;
        for(int v = i; v<=j; v++){
            int temp = v; 
            while(temp > 0){
                if(temp % 10 == k){
                    cnt++;
                }    
                temp = temp/10;
            }
        }
        
        
        return cnt;
    }
}