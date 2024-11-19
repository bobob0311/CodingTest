class Solution {
    public int solution(int[] arr) {
        int chk = 0;
        int max = 0;
        for(int value : arr){
            int cnt = 0;
            while(true){
                if(value >= 50 && value % 2 ==0){
                    value= value/2;
                }else if(value < 50 && value % 2 ==1){
                    value = value * 2 +1;
                }else{
                    break;
                }
                cnt++;
            }
            max = Math.max(cnt, max);
        }

        return max;
    }
}