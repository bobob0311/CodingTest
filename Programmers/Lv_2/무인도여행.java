import java.util.*;

class Solution {
    static int[] dx = new int[] { 1, -1, 0, 0 };
    static int[] dy = new int[] { 0, 0, 1, -1 };

    static boolean[][] visited;

    public int[] solution(String[] maps) {
        Queue<int[]> que = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();
        int[][] arr = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char v = maps[i].charAt(j);
                if (v == 'X') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = Integer.parseInt(String.valueOf(v));
                }

            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (arr[i][j] == 0) {
                    visited[i][j] = false;
                    continue;
                }
                if (visited[i][j] == false) {
                    que.offer(new int[] { i, j, arr[i][j] });
                    visited[i][j] = true;
                }
                int tempValue = 0;
                while (!que.isEmpty()) {
                    int[] arrs = que.poll();
                    int x = arrs[0];
                    int y = arrs[1];
                    int v = arrs[2];

                    tempValue += v;

                    for (int k = 0; k < 4; k++) {
                        if (x + dx[k] < maps.length && x + dx[k] >= 0 && y + dy[k] < maps[0].length() && y + dy[k] >= 0
                                && visited[x + dx[k]][y + dy[k]] == false && arr[x + dx[k]][y + dy[k]] != 0) {
                            visited[x + dx[k]][y + dy[k]] = true;
                            que.offer(new int[] { x + dx[k], y + dy[k], arr[x + dx[k]][y + dy[k]] });
                        }
                    }

                }
                if (tempValue != 0) {
                    answer.add(tempValue);
                    System.out.println(tempValue);
                }
            }
        }

        if (answer.size() == 0) {
            return new int[] { -1 };
        }
        int[] tempAnswer = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            tempAnswer[i] = answer.get(i);
        }
        Arrays.sort(tempAnswer);

        return tempAnswer;
    }
}