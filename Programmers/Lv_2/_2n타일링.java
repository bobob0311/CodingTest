/*
1

1 1개

2
11 2개
--

3
1--
--1 3개
111


4
1111

--11
----
11-- 5개
1--1

----


5
11111

--111
1--11
11--1
111--

----1
1----
--1--
8

6
*/

class Solution {
    public int solution(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] % 1000000007 + arr[i - 2] % 1000000007;
        }

        return arr[n] % 1000000007;
    }
}