package Programmers.고득점kit.해시;

/* !
N마리 중 N/2 마리 가져가도됨

nums => 포켓몬의 종류가 담긴 배열 (1~10,0000) 짝수로 주어짐
종류 번호나느 1~200,000

*/

/*
가장 많은 종류의 포켓몬을 가져가는 것이 목표
*/

/*
boolean 배열을 200000칸 만들어서 종류의 개수만 새주자~
*/

class Solution {
    static int count;
    static boolean[] pok;

    public int solution(int[] nums) {
        pok = new boolean[200001];
        count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pok[nums[i]] == false) {
                count++;
                pok[nums[i]] = true;
            }
        }
        return Math.min(count, nums.length / 2);

    }
}
