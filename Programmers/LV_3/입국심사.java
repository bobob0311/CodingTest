/*
7:25

한 심사대에서는 한명만 심사 가능

모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고싶다. 

기다리는 수 n
한 명을 심사하는데 걸리는 시간 times 배열
*/

/*
심사를 받는데 걸리는 시간의 최솟값을 return ;;


*/

class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long end = 1000000000000000000L;

        while (start < end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int time : times) {
                count += (long) mid / time;
            }
            if (count < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}