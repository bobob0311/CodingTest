package Programmers.고득점kit.Heap;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> deque = new LinkedList<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("D 1")) {
                if (deque.size() == 0) {
                    continue;
                }
                deque.remove(0);
            } else if (operations[i].equals("D -1")) {
                if (deque.size() == 0) {
                    continue;
                }
                deque.remove(deque.size() - 1);
            } else {
                int number = Integer.parseInt(operations[i].substring(2));
                for (int j = 0; j < deque.size() + 1; j++) {
                    if (j == deque.size()) {
                        deque.add(number);
                        break;
                    } else if (deque.get(j) < number) {
                        deque.add(j, number);
                        break;
                    }
                }
            }
        }
        if (deque.size() == 0) {
            return new int[] { 0, 0 };
        }
        return new int[] { deque.get(0), deque.get(deque.size() - 1) };
    }
}
