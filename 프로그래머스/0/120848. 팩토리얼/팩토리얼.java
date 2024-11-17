class Solution {
    public int solution(int n) {
        int target = 1;
        int result = 1;
        while(result <= n){
            result *=++target;
        }
        return target - 1;
    }
}