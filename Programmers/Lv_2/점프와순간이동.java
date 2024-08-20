import java.util.*;

/* 
K칸 점프 현재까 온거리 *2 
건전지 작동 K칸 앞으로할때만 건저지 사용
순간이동이 효율적이다.
N 만큼 떨어져있는 장소로간다.
*/

public class Solution {
    static int count = 0;

    public int solution(int n) {
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n - 1) / 2;
                count++;
            }

        }

        return count + 1;
    }
}