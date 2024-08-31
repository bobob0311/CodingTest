/*
7 21 시작
7 56 끝

=> 시간초과되는 것이 문제 처음에는 boolean[]를 이용했었고 그다음에는 que를 이용했었다. 
하지만 하나하나 만족하는지 체크할 필요가없었고 que로 하나씩 뺄필요도없이 배열의 인덱스를 하나하나 증가시켜주는 것으로 충분
쓸데없는 것을 추가하지 말자

5g 기지국이 4g 기지국보다 전달 범위 작다

전파거리 w이면 기지국이 설치된 아파트 기준 양쪽 w만큼
최소 설치하면서 모두 가능하게 

그리드?
*/

class Solution {

    static int count = 0;

    public int solution(int n, int[] stations, int w) {

        int length = stations.length;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            int min;

            if (idx != length) {
                min = stations[idx] - w;
            } else {
                min = 300000000;
            }

            if (i < min) {
                count++;
                if (i + 2 * w >= n) {
                    return count;
                } else {
                    i = i + 2 * w;
                }
            } else {

                int nowEnd = min + 2 * w;
                idx++;
                if (n <= nowEnd) {
                    return count;
                } else {
                    i = nowEnd;
                }
            }
        }

        return count;
    }
}