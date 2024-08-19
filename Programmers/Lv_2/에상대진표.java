class Solution {
    static int count = 0;

    public int solution(int n, int a, int b) {
        while (a != b) {
            if (a % 2 != 0) {
                a = (a + 1) / 2;
            } else {
                a /= 2;
            }
            if (b % 2 != 0) {
                b = (b + 1) / 2;
            } else {
                b /= 2;
            }
            count++;
        }

        return count;
    }
}