
/*
교점 중 정수 좌표에 별을 그려야한다. 

1000C2 = 500000

*/
import java.util.*;

class Solution {
    long minX = 9999999;
    long maxX = -99999999;
    long minY = 9999999;
    long maxY = -99999999;

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
                int temp = A * D - B * C;

                if (temp == 0) {
                    continue;
                } else {
                    long numeratorX = E * C - A * F;
                    long numeratorY = B * F - E * D;

                    if (numeratorX % temp == 0 && numeratorY % temp == 0) {
                        long x = numeratorX / temp;
                        long y = numeratorY / temp;
                        set.add(new long[] { x, y });
                        minX = Math.min(x, minX);
                        minY = Math.min(y, minY);
                        maxX = Math.max(x, maxX);
                        maxY = Math.max(y, maxY);
                    }
                }

            }
        }
        int xLength = (int) (maxX - minX + 1);
        int yLength = (int) (maxY - minY + 1);
        List<StringBuilder> list = new ArrayList<>(xLength + 1);
        for (int i = 0; i < xLength; i++) {
            list.add(new StringBuilder());
            for (int j = 0; j < yLength; j++) {
                list.get(i).append('.');
            }
        }
        for (long[] now : set) {
            int x = (int) (xLength - (now[0] - minX + 1));
            int y = (int) (now[1] - minY);
            list.get(x).setCharAt(y, '*');
        }

        String[] answer = new String[xLength];
        for (int i = 0; i < xLength; i++) {
            answer[i] = list.get(i).toString();
        }

        return answer;

    }
}