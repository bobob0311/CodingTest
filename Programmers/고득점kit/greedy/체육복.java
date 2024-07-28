package Programmers.고득점kit.greedy;

/*
1. 학생은 앞번호의 학생이나 뒷번호의 학생에게만 가능

n => 학생의수 (2~30)
lost[] => 체육복을 도난당한 학생들의 번호
reserve => 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열

!! 여벌 체육복을 가져온 학생이 도난당할 수 있다. 
=> 이럴경우 하나만 도난 빌려줄수 없다.
*/

/*
시작부터해서 체육복을 도난 당한사람을 만나면
여벌을 챙겨온 사람이였는지 확인
앞에가 빌려줄 수 있으면 빌리고 없으면
뒤에서 빌린다
*/

class Solution {
    static int[] student;
    static int count;

    public int solution(int n, int[] lost, int[] reserve) {
        student = new int[n + 1];
        count = n;

        for (int i : lost) {
            student[i] -= 1;
        }
        for (int i : reserve) {
            student[i] += 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (student[i] < 0) {
                if (student[i - 1] == 1) {
                    student[i - 1]--;
                    student[i]++;
                } else if (i != n && student[i + 1] == 1) {
                    student[i + 1]--;
                    student[i]++;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (student[i] == -1) {
                count--;
            }
        }

        return count;
    }
}
