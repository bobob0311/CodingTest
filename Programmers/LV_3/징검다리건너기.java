/*
07 02 



디딤돌의 숫자는 한번 밟으면 1줄음
디딤돌 숫자 0 되면 그다음 디딤돌로 한번에 여러칸 가능
다음 밟을 수 있는 디딤돌이 여러개면 가장 가까운 디딤돌

한 친구가 징검다리를 모두 건너면 다음 친구 건넘

최대 몇 명까지 징검 다리를 건널 수 있는가?

한번에 건널 수 있는 디딤돌의 최대 칸수 k



k 구간이 0이되는 순간 => k 구간에서 최댓값이 최소인 구간을 찾는다 

*/

class Solution {

    public int solution(int[] stones, int k) {
        int max = 20000001;
        int min = 0;

        while (min < max) {
            int mid = (max + min) / 2;
            if (chk(mid, stones, k)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min - 1;
    }

    public boolean chk(int mid, int[] stones, int k) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid + 1 <= 0) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
}