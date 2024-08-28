import java.util.*;
/*
2 * N 명의 사원  / N명씩 나눠 숫자 게임 진행

1. 무작위 자연수 부여
2. 한번씩 경기
3. A한명 B한명 숫자 공개 숫자가 큰쪽이 승점 1 
4. 같다면 승점 X

A팀의 출전 순서가 정해졌을 때 B팀의 최종 승점을 가장 높이는 방법

A팀의 배열을 정렬하고 
B팀의 배열을 정렬 
B의 낮은 수부터 이길 수 있는 수가 있는 지 확인 이길 수 있으면 배열을 지우는 방식으로 진행하면 될듯

*/

class Solution {
    public int solution(int[] A, int[] B) {
        int count = 0;
        int length = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;

        for (int i = 0; i < length; i++) {
            if (B[i] > A[idx]) {
                count++;
                idx++;
            }
        }

        return count;
    }
}