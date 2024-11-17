class Solution {
    public int solution(int[] date1, int[] date2) {
        long one = (date1[0]-1) * 12 * 365 + (date1[1]-1) * 30 + date1[2];
        long two = (date2[0]-1) * 12 * 365 + (date2[1]-1) * 30 + date2[2];
        
        if(one < two){
            return 1;
        }else{
            return 0;
        }

    }
}