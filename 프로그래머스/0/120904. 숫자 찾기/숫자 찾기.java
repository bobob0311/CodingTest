class Solution {
    public int solution(int num, int k) {
        String numStr = String.valueOf(num);
        
        for(int i = 0; i<numStr.length(); i++){
            if(Integer.parseInt(numStr.substring(i,i+1)) == k){
                return i+1;
            }
        }
        
        return -1;
    }
}