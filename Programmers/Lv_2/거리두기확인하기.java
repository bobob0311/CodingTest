import java.util.*;
/*
한칸씩 두번 움직여야될듯?
*/

class Solution {
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            boolean chk = false;
            for (int j = 0; j < places[0].length; j++) {

                for (int k = 0; k < places[0][0].length(); k++) {

                    if (places[i][j].charAt(k) == 'P') {
                        for (int a = 0; a < 4; a++) {
                            if (chk) {
                                break;
                            }
                            if (j + dx[a] >= 0 && k + dy[a] >= 0 && j + dx[a] < 5 && k + dy[a] < 5) {
                                if (places[i][j + dx[a]].charAt(k + dy[a]) == 'X') {
                                    continue;
                                } else if (places[i][j + dx[a]].charAt(k + dy[a]) == 'P') {
                                    chk = true;
                                    answer[i] = 0;
                                    break;
                                }
                            }
                            for (int b = 0; b < 4; b++) {
                                if (j + dx[a] + dx[b] >= 0 && k + dy[a] + dy[b] >= 0 && j + dx[a] + dx[b] < 5
                                        && k + dy[a] + dy[b] < 5 && !(dx[a] + dx[b] == 0 && dy[a] + dy[b] == 0)) {
                                    if (places[i][j + dx[a] + dx[b]].charAt(k + dy[a] + dy[b]) == 'P') {
                                        int xv = j + dx[a] + dx[b];
                                        int yv = k + dy[a] + dy[b];
                                        chk = true;
                                        answer[i] = 0;

                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (chk == false) {
                answer[i] = 1;
            }

        }

        return answer;
    }
}