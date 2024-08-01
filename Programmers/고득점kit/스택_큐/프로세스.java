package Programmers.고득점kit.스택_큐;

import java.util.*;
/*

*/

class Solution {
    class Info {
        boolean isMine;
        int priority;

        Info(int a, boolean b) {
            priority = a;
            isMine = b;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Info> list = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Info(priorities[i], i == location));
        }

        while (!list.isEmpty()) {
            Info now = list.remove(0);
            boolean printable = true;

            for (Info p : list) {
                if (now.priority < p.priority) {
                    printable = false;
                    break;
                }
            }
            if (!printable) {
                list.add(now);
                continue;
            }
            answer++;
            if (now.isMine)
                return answer;
        }
        return 1;
    }
}