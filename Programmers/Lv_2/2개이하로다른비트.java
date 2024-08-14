package Programmers.Lv_2;

class Solution {
    static long[] answer;

    public long[] solution(long[] numbers) {
        answer = new long[numbers.length];

        for (int j = 0; j < numbers.length; j++) {
            String temp = "";
            long target = numbers[j];
            long number = target;

            while (number >= 2) {
                temp = String.valueOf(number % 2) + temp;
                number /= 2;
            }

            temp = String.valueOf(number) + temp;
            temp = "0" + temp;
            int digit = 0;
            // System.out.println(temp);

            for (int i = temp.length() - 1; i >= 0; i--) {

                if (i == temp.length() - 1 && temp.charAt(i) == '0') {
                    answer[j] = target + 1;
                    break;
                } else if (temp.charAt(i) == '0') {
                    answer[j] = target + (long) Math.pow(2, digit) - (long) Math.pow(2, digit - 1);
                    break;
                }
                digit++;
            }
        }
        return answer;
    }
}
