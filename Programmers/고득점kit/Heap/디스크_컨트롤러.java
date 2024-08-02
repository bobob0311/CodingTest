package Programmers.고득점kit.Heap;

import java.util.*;

/*
요청되는 시점과 작업의 소요시간을 확인해서 작업의 요청부터 종료까지 걸린 시간의 평균의 가장 짧은 시간을 return 

요청부터 종료까지의 시간
=> 대기 시간 + 작업시간
=> 작업시간은 일정하다 대기시간을 최소화할 수 있는 방법을 찾는 것이 목표
대기시간을 최소화하기 위해서는 가장 짧은 jobs를 먼저 실행해야한다. 
*/

class Solution {
    class Info implements Comparable<Info> {
        int start;
        int time;

        Info(int s, int t) {
            this.start = s;
            this.time = t;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.time, o.time);
        }

    }

    public int solution(int[][] jobs) {
        List<Info> jobList = new ArrayList<>();

        for (int[] job : jobs) {
            jobList.add(new Info(job[0], job[1]));
        }

        jobList.sort(Comparator.comparingInt(info -> info.start));

        PriorityQueue<Info> pque = new PriorityQueue<>();

        int idx = 0;
        int time = 0;
        int waitTime = 0;
        int goTime = 0;

        while (idx < jobs.length || pque.size() != 0) {

            while (idx < jobs.length && jobList.get(idx).start == time) {
                pque.offer(jobList.get(idx));
                idx++;
            }

            if (pque.size() != 0 && goTime <= time) {
                goTime = time;
                goTime += pque.poll().time;
            }
            waitTime += pque.size();
            time++;
        }

        int wholeTime = 0;
        for (int i = 0; i < jobs.length; i++) {
            wholeTime += jobs[i][1];
        }

        return (wholeTime + waitTime) / jobs.length;
    }
}
