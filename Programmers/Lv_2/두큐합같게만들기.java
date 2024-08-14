package Programmers.Lv_2;

/*
 3 2 7 2 
 4 6 5 1
*/

class Solution {
    static int[] arr;
    static long sum;

    public int solution(int[] queue1, int[] queue2) {
        int length = queue1.length * 2;
        arr = new int[length];

        for (int i = 0; i < queue1.length; i++) {
            arr[i] = queue1[i];
            arr[i + queue1.length] = queue2[i];

            sum += (long) queue1[i] + (long) queue2[i];
        }
        int idx1 = 0;
        int idx2 = 0;

        long nowSum = 0;
        int answer = 999999999;
        while (idx2 < arr.length && idx1 < arr.length) {
            if (nowSum == sum / 2) {

                System.out.println(idx1 + " " + idx2);
                if (idx1 > queue1.length - 1) {
                    answer = Math.min(answer, idx1 + 1 + idx2 - queue1.length);
                } else if (idx2 < queue1.length) {
                    answer = Math.min(answer, idx2 + idx1 + 1 + queue1.length);
                } else {
                    answer = Math.min(answer, idx1 + idx2 - queue1.length + 1);

                }
                nowSum += arr[idx2];
                idx2++;
            }
            if (nowSum < sum / 2) {
                nowSum += arr[idx2];
                idx2++;
            } else if (nowSum > sum / 2) {
                nowSum -= arr[idx1];
                idx1++;
            }
        }

        if (answer == 999999999) {
            return -1;
        } else {
            return answer - 1;
        }
    }
}
