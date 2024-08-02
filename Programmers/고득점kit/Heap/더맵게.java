package Programmers.고득점kit.Heap;

import java.util.*;

/*
모든 음식의 스코빌 지수를 K 이상

가장 안매운거 + (두 번째로 안매운거 *2) => 섞인 스코빌 지수
*/

/*
모든 음식의 스코빌 지수를 K 이상으로 만들어야한다. 
몇번을 섞어야 하는가
*/

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            minHeap.offer(scoville[i]);
        }

        int count = 0;

        while (minHeap.peek() < K) {
            if (minHeap.size() == 1) {
                count = -1;
                break;
            }
            minHeap.offer(minHeap.poll() + (minHeap.poll() * 2));
            count++;
        }
        return count;
    }

}
