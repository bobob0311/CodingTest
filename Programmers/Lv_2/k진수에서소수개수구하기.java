package Programmers.Lv_2;

/*
1. 진수 변환 
*/
class Solution {
    static int count = 0;

    public int solution(int n, int k) {
        String temp = "";

        while (n >= k) {
            temp = String.valueOf(n % k) + temp;
            n /= k;
        }
        temp = String.valueOf(n) + temp;

        String[] arr = temp.split("0");
        for (String str : arr) {
            if (str.equals("")) {
                continue;
            }
            long num = Long.parseLong(str);

            if (num < 2) {
                continue;
            }
            if (num == 2) {
                count++;
                continue;
            }
            if (num % 2 == 0) {
                continue;
            }
            boolean prime = true;
            for (long i = 3; i <= Math.sqrt(num) + 1; i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                count++;
            }
        }

        return count;
    }
}
