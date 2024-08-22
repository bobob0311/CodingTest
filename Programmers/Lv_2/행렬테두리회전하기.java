/*
x1,y1,x2,y2
*/

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] arr = new int[rows][columns];
        int v = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = v++;
            }
        }
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int min = 100000;
            int[] curArr = queries[i];
            int x1 = curArr[0] - 1;
            int y1 = curArr[1] - 1;
            int x2 = curArr[2] - 1;
            int y2 = curArr[3] - 1;

            int temp = arr[x1][y2];
            for (int y = y2; y > y1; y--) {
                arr[x1][y] = arr[x1][y - 1];
                min = Math.min(min, arr[x1][y]);

            }
            for (int x = x1; x < x2; x++) {
                arr[x][y1] = arr[x + 1][y1];
                min = Math.min(min, arr[x][y1]);
            }
            for (int y = y1; y < y2; y++) {
                arr[x2][y] = arr[x2][y + 1];
                min = Math.min(min, arr[x2][y]);
            }
            for (int x = x2; x > x1 + 1; x--) {
                arr[x][y2] = arr[x - 1][y2];
                min = Math.min(min, arr[x][y2]);
            }
            arr[x1 + 1][y2] = temp;
            min = Math.min(min, arr[x1 + 1][y2]);
            answer[i] = min;
        }

        return answer;
    }
}