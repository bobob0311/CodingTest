class Solution {
    public int solution(int[] num_list) {
        int cnt = 0;
        
        for(int num : num_list){
            int temp = num;
            while(temp !=1){
                if(temp % 2 == 0){
                    temp /= 2;
                }else{
                    temp = (temp - 1)/2;
                }
                cnt++;
            }
        }

        return cnt;
    }
}