class Solution {
    public int solution(int hp) {
        int cnt = hp / 5;
        hp = hp%5;
        cnt += hp/3;
        hp = hp %3;
        cnt += hp;
        return cnt;
    }
}