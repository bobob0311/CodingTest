
/*
그냥 구현 문제인거같움?
2차원배열을 어떻게 정렬할 것인가 주어진 것으로 어떻게 삭제할 것을 판별할지가 핵심

06: 02 
06: 45
근무 태도 점수와 동료 평가 점수

어떤 사원이 임의의 사원보다 두 점수가 모두 낮은 경우가 한번이라도 있으면 인센 X
=> 이걸 어떻게 구현할 것인가 

두 점수의 합이 높은 순으로 석차를 내어 석차에 따라 인센티브가 차등 지급
도일할 경우 동석차
동석차의 수만큼 다음 석차는 건너 뜀

완호의 석차만 중요하다.
1. 완호보다 더했을 때 안되는 사람들을 탈락?
2. 오름차순 정렬해서 비교?
2. 그후 비교?
*/
import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        List<int[]> list = new ArrayList<>();
        int myScore = scores[0][0] + scores[0][1];
        list.add(scores[0]);
        for (int i = 1; i < scores.length; i++) {
            int[] tempArr = scores[i];
            if (tempArr[0] + tempArr[1] > myScore) {
                list.add(tempArr);
            }
        }

        int[][] myArr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            myArr[i] = list.get(i);
        }

        Arrays.sort(myArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (b[0] != a[0]) {
                    return Integer.compare(b[0], a[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });
        int max = myArr[0][1];
        int maxIdx = 0;

        for (int i = 1; i < myArr.length; i++) {
            int temp = max;
            max = Math.max(max, myArr[i][1]);
            // max가 바뀌지않았다 전것이 더 크다
            if (temp == max && max > myArr[i][1]) {
                if (myArr[maxIdx][0] != myArr[i][0]) {
                    myArr[i][0] = 0;
                    myArr[i][1] = 0;

                }
            } else {
                maxIdx = i;
            }
        }
        int[] answerArr = new int[myArr.length];
        for (int i = 0; i < myArr.length; i++) {
            answerArr[i] = myArr[i][0] + myArr[i][1];
        }

        Arrays.sort(answerArr);
        int answer = -1;
        answer = 1;

        for (int i = answerArr.length - 1; i >= 0; i--) {
            if (answerArr[i] == myScore) {
                return answer;
            }
            answer++;
        }

        return -1;
    }
}