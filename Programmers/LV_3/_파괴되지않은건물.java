/*
불가능입니다.
누적합이요? 예?

7 20 

N X M 의 행렬



적의 공격과 아군의 회복 스킬은 직사각형 모양

내구도가 0 이하가 되어도 내구도 계속 하락
*/

/*
board 는 n X m 의 형태 1000 X 1000 => 백만

skill 250000

type => 1,2     1 공격 2회복
r1~r2 는 행
c1~c2 는 열
degree는 숫자 

효율성이 있어서 이걸 어떻게 해야되지...
*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] arr = new int[board.length][board[0].length];

        int answer = 0;
        for (int i = 0; i < skill.length; i++) {
            int[] now = skill[i];
            int type = now[0];
            int r1 = now[1];
            int r2 = now[3];
            int c1 = now[2];
            int c2 = now[4];
            int degree = now[5];

            if (type == 1) {
                degree = -degree;
            }
            arr[r1][c1] += degree;
            if (r2 + 1 < board.length && c2 + 1 < board[0].length) {
                arr[r2 + 1][c2 + 1] += degree;
            }
            if (c2 + 1 < board[0].length) {
                arr[r1][c2 + 1] += -degree;
            }
            if (r2 + 1 < board.length) {
                arr[r2 + 1][c1] += -degree;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 1; j < board.length; j++) {
                arr[j][i] += arr[j - 1][i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += arr[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}