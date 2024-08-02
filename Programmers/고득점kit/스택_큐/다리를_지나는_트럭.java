package Programmers.고득점kit.스택_큐;

import java.util.*;

/*
다리에 올라가는 조건
bridge_length 대
weigth 이하의 무개

!! => 다리에 완전히 오르지 않은 트럭의 무게는 무시
*/

/*
bridge_length => 다리에 올라갈 수 있는 트럭 수 
weight => 다리가 견딜 수 있는 무게
truck_weights => 트럭 별 무게
*/

/*
truck_weights를 다 더 했을 때 weight 보다 작거나 같아야한다. 
bridge_length 이상으로 올라갈 수 없음
*/

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        List<Integer> list = new LinkedList<>();
        int length = truck_weights.length;
        int idx = 0;
        int bLength = bridge_length;

        for (int i = 0; i < bLength; i++) {
            list.add(0);
        }
        int count = 0;
        int nowWeight = 0;
        while (idx != length) {
            if (nowWeight + truck_weights[idx] <= weight) {
                nowWeight += truck_weights[idx];
                list.add(0, truck_weights[idx]);
                idx++;

            } else {
                list.add(0, 0);
            }
            count++;
            nowWeight -= list.get(bLength - 1);
            list.remove(bLength - 1);

        }

        return count + bLength;
    }
}
