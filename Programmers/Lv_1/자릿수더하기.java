import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String numString = String.valueOf(n);
        for (int i = 0; i < numString.length(); i++) {
            int num = Integer.parseInt(String.valueOf(numString.charAt(i)));
            answer += num;
        }

        return answer;
    }
}