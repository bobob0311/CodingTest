import java.util.*;

class Solution {
    static int max = 0;

    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        int[] tempArr = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
            tempArr[a[i]] += 1;
        }

        for (int nowValue : set) {
            if (tempArr[nowValue] <= max) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                if (a[j] == nowValue) {
                    list.add(j);
                }
            }
            if (max > list.size()) {
                continue;
            }
            boolean[] chk = new boolean[list.size()];
            if (list.size() == 0) {
                continue;
            }
            int prev = list.get(0);
            int cnt = 0;

            if (prev != 0) {
                chk[0] = true;
                cnt++;
            }

            for (int i = 1; i < list.size(); i++) {
                int nowIdx = list.get(i);
                // 미리 true가 되었다는 건 왼쪽에서 원소를 가져왔다는것
                if (chk[i - 1]) {
                    if (prev + 1 == nowIdx) {
                        prev = nowIdx;
                        continue;
                    } else {
                        chk[i] = true;
                        prev = nowIdx;
                        cnt++;
                    }
                    // false 라는건 이전 거 오른쪽에서 찾아야된다는 것
                } else {
                    // 이전것도 오른쪽에서 찾고 지금 것도 왼쪽에서 찾ㅇㄹ 수 있는 경우
                    if (prev + 2 < nowIdx) {
                        chk[i - 1] = true;
                        chk[i] = true;
                        prev = nowIdx;
                        cnt += 2;
                        // 지금것만 왼쪽에서 찾을 수 있는 경우
                    } else if (prev + 1 < nowIdx) {
                        chk[i - 1] = true;
                        prev = nowIdx;
                        cnt++;
                    } else {
                        prev = nowIdx;
                    }
                }

            }
            if (prev != a.length - 1) {
                if (chk[list.size() - 1] == false) {
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
        }

        return max * 2;
    }
}