class Solution {
    public int solution(int n) {
        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n + 1; i++) {
            arr[i] = arr[i - 1] % 1234567 + arr[i - 2] % 1234567;
        }

        int answer = arr[n] % 1234567;
        return answer;
    }
}