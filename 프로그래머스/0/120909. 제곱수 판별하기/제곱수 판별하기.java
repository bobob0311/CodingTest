import java.util.*;
class Solution {
    public int solution(int n) {
        int temp = (int) Math.sqrt(n);
        if(temp*temp == n){
            return 1;
        }
        return 2;
    }
}