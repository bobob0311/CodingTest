package Programmers.Lv_2;

class Solution {
    static int countz = 0;
    static int counto = 0;

    public int[] solution(int[][] arr) {
        boolean h = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != arr[0][0]) {
                    h = false;
                    break;
                }

            }
            if (!h) {
                break;
            }
        }
        if (!h) {
            f(0, arr.length, 0, arr.length, arr);
        } else {
            if (arr[0][0] == 0) {
                countz++;
            } else {
                counto++;
            }
        }

        int[] answer = { countz, counto };
        return answer;
    }

    static void f(int startx, int endx, int starty, int endy, int[][] arr) {
        if (endx - startx == 1) {
            if (arr[startx][starty] == 0) {
                countz++;
            } else {
                counto++;
            }
            return;
        }
        int midx = (endx + startx) / 2;
        int midy = (endy + starty) / 2;

        int[][] arrs = new int[][] { { startx, midx, starty, midy },
                { startx, midx, midy, endy },
                { midx, endx, starty, midy },
                { midx, endx, midy, endy } };

        for (int[] x : arrs) {
            boolean chk = true;
            int target = arr[x[0]][x[2]];
            // System.out.println(x[0] + " " + x[1] + " " + x[2] + " " + x[3]);
            for (int i = x[0]; i < x[1]; i++) {
                for (int j = x[2]; j < x[3]; j++) {

                    if (target != arr[i][j]) {
                        chk = false;
                        break;
                    }
                }
                if (!chk) {
                    break;
                }
                // System.out.println("");
            }

            if (chk == true) {
                if (target == 0) {
                    countz++;
                } else {
                    counto++;
                }
            } else {
                f(x[0], x[1], x[2], x[3], arr);
            }
        }
        return;
    }
}
