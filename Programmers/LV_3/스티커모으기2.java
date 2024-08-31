/*
8 05 시작
8 34 끝

아니 아이디어는 좋은데 왜 노가다가되는거지 처음에 처리하는 방식이 뭔가 너무 바보같이 짠 기분
두가지로 나눠서 접근하는 방식이 맞을까?
맞는듯..?

인접해있는 스티커는 사용 할 수 없다. 

완전 탐색?
아니면 dp?
*/

/*
N의 길이는 100000이하
첫번째와 마지막 원소가 연결되어있다고 간주.
dp가 맞는듯?

0 0 2 0 0 0 0 1 0 0 

배열에 최댓값으로 나올 수 있는 값을 기입하면 되지않을까?
*/

class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) {
            return sticker[0];
        }
        if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        if (sticker.length == 3) {
            return Math.max(sticker[0], Math.max(sticker[1], sticker[2]));
        }

        int max = 0;
        int[] arr = new int[sticker.length];
        int[] arr2 = new int[sticker.length];

        // 1를 선택할 경우 마지막까지 못감.

        // 1를 선택한 경우
        for (int i = 0; i < 2; i++) {
            arr[i] = sticker[i];
        }

        arr[2] = arr[0] + sticker[2];
        arr[3] = sticker[3] + Math.max(arr[0], arr[1]);
        for (int i = 4; i < sticker.length - 1; i++) {
            arr[i] = Math.max(arr[i - 4], Math.max(arr[i - 3], arr[i - 2])) + sticker[i];
        }

        max = Math.max(arr[sticker.length - 2], arr[sticker.length - 3]);

        // 1를 선택하지 않은 경우 끝까지 갈 수 있음
        arr2[0] = 0;
        arr2[1] = sticker[1];
        arr2[2] = sticker[2];
        arr2[3] = arr2[1] + sticker[3];
        arr2[4] = sticker[4] + Math.max(arr2[1], arr2[2]);

        for (int i = 4; i < sticker.length; i++) {
            arr2[i] = Math.max(arr2[i - 4], Math.max(arr2[i - 3], arr2[i - 2])) + sticker[i];
        }

        max = Math.max(max, Math.max(arr2[sticker.length - 1], arr2[sticker.length - 2]));

        return max;
    }
}