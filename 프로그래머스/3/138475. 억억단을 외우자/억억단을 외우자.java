class Solution {
    public int[] solution(int e, int[] starts) {
        int[] divisorCount = new int[e + 1];
        int[] arr = new int[e + 1];
        int maxCount = 0;
        int maxIdx = 0;


        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divisorCount[j]++;
            }
        }


        for (int i = e; i >= 1; i--) {
            if (divisorCount[i] >= maxCount) {
                maxCount = divisorCount[i];
                maxIdx = i;
            }
            arr[i] = maxIdx;
        }


        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = arr[starts[i]];
        }

        return answer;
    }
}
