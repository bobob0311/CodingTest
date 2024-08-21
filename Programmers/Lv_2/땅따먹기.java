import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] answer = new int[land.length][4];

        for (int j = 0; j < 4; j++) {
            answer[0][j] = land[0][j];
        }

        for (int i = 1; i < land.length; i++) {
            int max_value = 0;
            int max_idx = 0;
            for (int k = 0; k < 4; k++) {
                if (answer[i - 1][k] > max_value) {
                    max_value = answer[i - 1][k];
                    max_idx = k;
                }
            }
            Arrays.sort(answer[i - 1]);

            for (int j = 0; j < land[0].length; j++) {
                if (j == max_idx) {
                    answer[i][j] += answer[i - 1][2] + land[i][j];
                } else {
                    answer[i][j] += max_value + land[i][j];
                    ;
                }
            }
        }

        Arrays.sort(answer[land.length - 1]);

        return answer[land.length - 1][3];
    }
}