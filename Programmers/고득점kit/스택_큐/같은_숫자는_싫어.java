package Programmers.고득점kit.스택_큐;

import java.util.*;
/*
arr 연속적으로 나타나는 숫자는 하나만 남긴다.
제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서 유지

arr[] => 1000000이하
arr 에는 0~9까지의정수 
*/

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new LinkedList<>();

        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (list.get(list.size() - 1) == arr[i]) {
                continue;
            } else {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
