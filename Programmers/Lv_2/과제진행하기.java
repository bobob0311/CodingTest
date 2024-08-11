package Programmers.Lv_2;

import java.util.*;

// 너무 노가다로 한거같기도하고..

/*
시작해야 하는 순서대로 정렬
1. Start한 시간 + 수행시간 > 다음거 시작해야하는 시간 
    다음거 Start시간 - Start한 시간 해서 Stack에 넣는다.

2. Start한 시간 + 수행시간 < 다음거 시작해야하는 시간 
    다 한것으로 올리고 Stack에 남아있는게 있다면 꺼내서 실행

3. Start한 시간 + 수행시간 == 다음거 시작해야하는 시간
    다음거 실행
    
4. 만약 배열을 다 돌았는데 stack에 남아있다? 그럼 그냥 쭉쭉 넣기

Stack 필요
첫번째 돌때 배열로? 정렬을 해야하니까 배열로 돌아야되나?
Stack에 넣을때는 이름하고 남은 시간만?

*/

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new LinkedList<>();
        Stack<int[]> st = new Stack<>();

        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                int aValue = Integer.parseInt(a[1].substring(0, 2)) * 60 + Integer.parseInt(a[1].substring(3));
                int bValue = Integer.parseInt(b[1].substring(0, 2)) * 60 + Integer.parseInt(b[1].substring(3));
                return Integer.compare(aValue, bValue);

            }
        });

        int StartTime = change(plans[0]);
        int time = changeM(plans[0]);
        int idx = 0;

        while (idx != plans.length) {
            if (idx == plans.length - 1) {
                answer.add(plans[idx][0]);
                break;
            }
            int nextStartTime = change(plans[idx + 1]);
            time = changeM(plans[idx]);

            if (StartTime + time > nextStartTime) {
                int atime = time - (nextStartTime - StartTime);
                st.push(new int[] { idx, atime });

            } else {
                answer.add(plans[idx][0]);

                if (StartTime + time < nextStartTime) {
                    int restTime = nextStartTime - StartTime - time;
                    while (!st.isEmpty()) {
                        if (restTime == 0) {
                            break;
                        }
                        int[] target = st.pop();
                        int targetIdx = target[0];
                        int targetValue = target[1];
                        if (restTime < targetValue) {
                            targetValue -= restTime;
                            restTime = 0;
                            st.push(new int[] { targetIdx, targetValue });
                        } else {
                            restTime -= targetValue;
                            answer.add(plans[targetIdx][0]);
                        }
                    }
                }
            }
            StartTime = nextStartTime;
            idx++;
        }

        while (!st.isEmpty()) {
            int[] target = st.pop();
            answer.add(plans[target[0]][0]);
        }

        String[] arr = answer.toArray(String[]::new);
        return arr;
    }

    static int change(String[] str) {
        return Integer.parseInt(str[1].substring(0, 2)) * 60 + Integer.parseInt(str[1].substring(3));
    }

    static int changeM(String[] str) {
        return Integer.parseInt(str[2]);
    }
}
