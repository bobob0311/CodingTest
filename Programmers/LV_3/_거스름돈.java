/*
06 31

거스름돈을 n원 줄때 방법의 수

거슬러 줘야하는 금액 n 
보유하고 있는 돈의 종류 money => 무한하다고 가정

거스름돈 으로 낼 수 있는 모든 것을 체크 

ex) 1원으로 n원까지 낼 수 있는 모든 원들을 +1 
1,2,3,4,5....

그후 만약 4원이 있다? 그러면 기존 1원으로 낸건 뿌라스 거기에 4원으로 낼 수 있는 값들도 뿌라스 해준다

1원 으로 하나 4원으로 하나 => 5원가능
1원 으로 두개 4원ㅇ로 하나 => 6원가능


다시 풀어볼 가치가 있다. 
*/

class Solution {
    public int solution(int n, int[] money) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < money.length; i++) {
            int v = money[i];
            arr[v]++;

            for (int j = 0; j <= n; j++) {
                if (j - v < 0) {
                    continue;
                }
                arr[j] += arr[j - v];
            }
        }

        int answer = arr[n];
        return answer;
    }
}