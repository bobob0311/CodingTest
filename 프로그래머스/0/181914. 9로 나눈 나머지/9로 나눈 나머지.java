class Solution {
    public int solution(String number) {
        int target = 0;
        for(int i = 0; i<number.length(); i++){
            int now = Integer.parseInt(number.substring(i,i+1));
            target+=now;
        }
        
        return target%9;
    }
}