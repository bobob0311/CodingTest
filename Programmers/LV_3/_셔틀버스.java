/*
6 18
7 16 
노가다로 품;


9시부터  n회  t분 간격   m명 탑승
대기 순서대로 태우고 바로 출발

콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각


- 같은 시각에 도착한 크루중 대기열에서 제일 뒤에 선다
- 23:59 에 집에 돌아간다.
*/

// 1회 운영 1분 간격 5명 탑승이면 왜 9시 도착? => 9시부터 시작이라

// 2회 운영 10분 간격 2명 탑승 이면 왜 9시9분? 08시ㅔ 온사람 09
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int startTime = 60 * 9;
        int[] arr = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            int T1 = Integer.parseInt(timetable[i].substring(0, 2)) * 60;
            int T2 = Integer.parseInt(timetable[i].substring(3));
            int time = T1 + T2;
            arr[i] = time;
        }
        Arrays.sort(arr);
        // 탄사람들
        int idx = 0;
        int tempAnswer = 0;
        int last = 0;

        for (int i = startTime; i <= startTime + (n - 1) * t; i += t) {
            int count = 0;
            if (idx == arr.length) {
                tempAnswer = startTime + (n - 1) * t;
                int t1 = tempAnswer / 60;
                int t2 = tempAnswer % 60;
                String a1;
                String a2;
                if (String.valueOf(t1).length() == 1) {
                    a1 = "0" + String.valueOf(t1);
                } else {
                    a1 = String.valueOf(t1);
                }
                if (String.valueOf(t2).length() == 1) {
                    a2 = "0" + String.valueOf(t2);
                } else {
                    a2 = String.valueOf(t2);
                }

                String a = a1 + ":" + a2;
                return a;
            }
            while (count < m) {
                // 아직 자리가 남아있는데 사람들이 다 탄경우
                if (idx >= timetable.length) {
                    tempAnswer = startTime + (n - 1) * t;
                    break;
                }
                // startTime 보다 일찍온사람 태움
                if (arr[idx] <= i) {
                    last = arr[idx];
                    idx++;
                    count++;
                } else {
                    tempAnswer = i;
                    break;
                }

            }
        }
        // 다 못탄경우
        if (idx <= arr.length) {
            tempAnswer = Math.max(last - 1, tempAnswer);
        }

        // 한명도 안탄경우 제일 마지막에 타면된다.
        if (idx == 0) {
            tempAnswer = startTime + (n - 1) * t;
            int t1 = tempAnswer / 60;
            int t2 = tempAnswer % 60;
            String a1;
            String a2;
            if (String.valueOf(t1).length() == 1) {
                a1 = "0" + String.valueOf(t1);
            } else {
                a1 = String.valueOf(t1);
            }
            if (String.valueOf(t2).length() == 1) {
                a2 = "0" + String.valueOf(t2);
            } else {
                a2 = String.valueOf(t2);
            }
            return a1 + ":" + a2;
        }

        int t1 = tempAnswer / 60;
        int t2 = tempAnswer % 60;
        String a1;
        String a2;
        if (String.valueOf(t1).length() == 1) {
            a1 = "0" + String.valueOf(t1);
        } else {
            a1 = String.valueOf(t1);
        }
        if (String.valueOf(t2).length() == 1) {
            a2 = "0" + String.valueOf(t2);
        } else {
            a2 = String.valueOf(t2);
        }

        return a1 + ":" + a2;
    }
}