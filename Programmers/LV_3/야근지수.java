
/*
최대한 같은 수로 맞추는게 핵심인 것 같습니다. 
pq에 넣고 하나씩 뺴면서 -1 하면 어떨까요?
*/
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        while (n != 0) {
            int v = pq.poll();
            if (v == 0) {
                return 0;
            } else {
                pq.offer(v - 1);
                n--;
            }

        }
        long answer = 0;

        for (int i = 0; i < works.length; i++) {
            long v = (long) pq.poll();
            System.out.println(v);
            answer += v * v;
        }

        return answer;
    }
}