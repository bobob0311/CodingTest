package Programmers.고득점kit.스택_큐;

import java.util.*;

/*
기능은 진도가 100%일때 서비스에 반영
뒤에 있는 기능이 더 빨리 개발도 가능
뒤에있는 기능은 앞에있는 기능이 배포될때 배포

progresses => 순서가 적혀있음
speeds => 개발속도가 적혀있음

return => 각 배포마다 몇 개의 기능이 배포되는지
*/

/*

*/

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int target = progresses[i];
            int day = 0;
            while (target < 100) {
                target += speeds[i];
                day++;
            }
            list.add(day);
        }
        int temp = list.get(0);
        int count = 1;
        for (int i = 1; i < progresses.length; i++) {
            if (temp < list.get(i)) {
                answer.add(count);
                count = 1;
                temp = list.get(i);
            } else {
                count++;
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
