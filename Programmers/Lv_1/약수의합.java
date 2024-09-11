import java.util.*;

class Solution {
    static int answer = 0;

    public int solution(int n) {

        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    answer += i;
                } else {
                    answer += i;
                    answer += n / i;
                }

            }
        }
        return answer;
    }
}