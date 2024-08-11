package Programmers.Lv_2;
/*
        long min = (long) r1 * r1;
        long max = (long) r2 * r2;
이 식 앞에 (long) 안해줘서 하루종일 붙잡고있던 문제
자료형 공부가 부족한거 같기도
*/

class Solution {
    public long solution(int r1, int r2) {
        long min = (long) r1 * r1;
        long max = (long) r2 * r2;
        long answer = 0;

        for (long i = 1; i <= r2; i++) {
            long temp = i * i;

            // 최대로 나올 수 있는 정수
            int tempMax = (int) Math.sqrt(max - temp);
            // 최소로 나올 수 있는 정수
            int tempMin = (int) Math.ceil(Math.sqrt(min - temp));
            answer += tempMax - tempMin + 1;
        }

        answer = answer * 4;

        return answer;
    }
}