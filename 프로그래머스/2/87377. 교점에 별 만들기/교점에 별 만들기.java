import java.util.*;

class Solution {
    long minX = Long.MAX_VALUE;
    long maxX = Long.MIN_VALUE;
    long minY = Long.MAX_VALUE;
    long maxY = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        Set<long[]> set = new HashSet<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] lineOne = line[i];
                int[] lineTwo = line[j];
                int A = lineOne[0];
                int B = lineOne[1];
                int E = lineOne[2];
                int C = lineTwo[0];
                int D = lineTwo[1];
                int F = lineTwo[2];
                long temp = (long) A * D - (long) B * C;

                if (temp == 0) continue;

                long numeratorX = (long) E * C - (long) A * F;
                long numeratorY = (long) B * F - (long) E * D;

                if (numeratorX % temp == 0 && numeratorY % temp == 0) {
                    long y = numeratorX / temp;
                    long x = numeratorY / temp;
                    set.add(new long[]{x, y});

                    minX = Math.min(x, minX);
                    minY = Math.min(y, minY);
                    maxX = Math.max(x, maxX);
                    maxY = Math.max(y, maxY);
                }
            }
        }

        int xLength = (int) (maxY - minY + 1);
        int yLength = (int) (maxX - minX + 1);
        char[][] grid = new char[xLength][yLength];

        for (int i = 0; i < xLength; i++) {
            Arrays.fill(grid[i], '.');
        }

        for (long[] now : set) {
            long x = now[0];
            long y = now[1];

            int adjustedX = (int) (x - minX);
            int adjustedY = (int) (maxY - y);

            grid[adjustedY][adjustedX] = '*';
        }

        String[] answer = new String[xLength];
        for (int i = 0; i < xLength; i++) {
            answer[i] = new String(grid[i]);
        }

        return answer;
    }
}
