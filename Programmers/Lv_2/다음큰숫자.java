/*
n의 다음 큰 숫자는 2진수로 변환했을 때 1의 개수가 같으면서 제일 작은 수
*/

class Solution {
    public int solution(int n) {
        int target = n;
        int count = 0;
        while (target > 1) {
            if (target % 2 == 1)
                count++;
            target /= 2;
        }
        if (target == 1)
            count++;
        while (true) {
            n++;
            target = n;
            int chkCount = 0;
            while (target > 1) {
                if (target % 2 == 1)
                    chkCount++;
                target /= 2;
            }
            if (target == 1)
                chkCount++;
            if (chkCount == count) {
                return n;
            }

        }

    }
}