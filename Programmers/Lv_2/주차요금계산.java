package Programmers.Lv_2;

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<int[]> tempArr = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxTime = 23 * 60 + 59;

        for (String record : records) {
            int time = Integer.parseInt(record.substring(0, 2)) * 60 + Integer.parseInt(record.substring(3, 5));
            int carName = Integer.parseInt(record.substring(6, 10));

            if (map.get(carName) != null) {
                map.get(carName).add(time);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(time);
                map.put(carName, list);
            }
        }

        for (Integer k : map.keySet()) {
            List<Integer> list = map.get(k);

            if (list.size() % 2 == 1) {
                list.add(maxTime);
            }

            int sum = 0;
            for (int i = 0; i < list.size(); i += 2) {
                sum += list.get(i + 1) - list.get(i);
            }
            tempArr.add(new int[] { k, sum });
        }

        Collections.sort(tempArr, (a, b) -> a[0] - b[0]);
        int[] answer = new int[tempArr.size()];

        for (int i = 0; i < tempArr.size(); i++) {
            int time = tempArr.get(i)[1];
            int fee = fees[1];

            if (time > fees[0]) {
                fee += Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
            answer[i] = fee;
        }

        return answer;
    }
}
