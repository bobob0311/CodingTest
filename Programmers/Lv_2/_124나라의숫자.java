class Solution {
    public String solution(int n) {

        String result = "";
        String[] str124 = { "1", "2", "4" };
        while (n > 0) {

            n--;

            result = str124[n % 3] + result;

            n = n / 3;
        }

        return result;
    }
}
