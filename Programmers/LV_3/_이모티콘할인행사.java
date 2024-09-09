/*
1. 서비스 가입자를 최대한 늘리는것
2. 이모티콘 판매액을 최대한 늘리는 것


n명의 카카오톡 사용자들에게 이모티콘 m개를 할일하여 판매
할인율은 10, 20, 30, 40 중 하나

- 자신의 기준에 따라 일정 비율 이상 할인하는 임티 모두 구매
- 구매 비용의 합이 일정 가격 이상일시 이모티콘 구매를 취소 이모티콘 플러스 서비스에 가입
*/

// 전부다 해봐도될듯?

// 완전탐색에 좀 약한듯.

class Solution {
    static int[] p = new int[] { 10, 20, 30, 40 };
    static int maxCount = 0;
    static int maxTotal = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] arr = new int[emoticons.length];
        dfs(0, arr, users, emoticons);

        int[] answer = { maxCount, maxTotal };
        return answer;
    }

    public void dfs(int depth, int[] arr, int[][] users, int[] emoticons) {
        if (depth == arr.length) {
            calculate(arr, users, emoticons);
            return;
        }

        for (int v : p) {
            arr[depth] = v;
            dfs(depth + 1, arr, users, emoticons);
        }
    }

    public void calculate(int[] arr, int[][] users, int[] emoticons) {
        int count = 0;
        int total = 0;

        for (int[] user : users) {
            int discount = user[0];
            int price = user[1];
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= discount) {
                    sum += ((emoticons[i]) * (100 - arr[i])) / 100;
                }
            }

            if (sum >= price) {
                count++;
            } else {
                total += sum;
            }
        }
        if (maxCount < count) {
            maxCount = count;
            maxTotal = total;
        } else if (maxCount == count) {
            maxTotal = Math.max(maxTotal, total);
        }

    }
}