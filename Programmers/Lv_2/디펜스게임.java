import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> qp = new PriorityQueue<>();

        int length = Math.min(k, enemy.length);
        int count = length;

        for (int i = 0; i < length; i++) {
            qp.offer(enemy[i]);
        }

        for (int i = k; i < enemy.length; i++) {
            if (qp.peek() < enemy[i]) {
                qp.offer(enemy[i]);
                n -= qp.poll();
                count++;
            } else {
                n -= enemy[i];
                count++;
            }
            if (n < 0) {
                count--;
                break;
            }
        }

        return count;
    }
}