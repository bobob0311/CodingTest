package Programmers.고득점kit.greedy;

import java.util.*;

/*
people => (int[]) 사람들의 무게가 들어가있는 배열
limit => (int) 구명보트의 최대 감당 무게
*/

/*
남아있는 사람중에 가장 무거운 사람을 가장 가벼운 사람과 태울 수 없다면 가장 무거운 사람만 타야된다.
=> 두명 밖에 탈 수 없기 때문에 이러한 상황이 발생

1. 가장 무거운 사람과 가장 가벼운 사람이 타는 경우
2. 가장 무거운 사람만 타는 경우 
*/

class Solution {
    static int idx1;
    static int idx2;
    static int count;

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        idx1 = 0;
        idx2 = people.length - 1;

        while (idx1 <= idx2) {
            if (people[idx2] + people[idx1] <= limit) {
                idx2--;
                idx1++;
                count++;
            } else {
                idx2--;
                count++;
            }
        }

        return count;
    }
}
