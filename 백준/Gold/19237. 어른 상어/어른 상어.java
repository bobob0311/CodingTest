import java.io.*;
import java.util.*;

/*
N*N 칸에 M마리의 상어
모든 상어가 자신의 위치에 냄새 => k 번 이동 후 냄새가 사라진다.

- 상하좌우 인접한 칸으로 이동
    1. 냄새가 없는 칸의 방향으로 잡는다.
    2. 자신의 냄새가 있는 칸으로 방향을 잡는다.
    우선순위는 상어마다 다를 수 있고 바라보는 방향에 따라 다를 수 있다.
    모든 상어가 이동후 한칸에 여러마리 상어가 되면 가장 작은 번호 상어만 살아남는다.
*/

public class Main {
    static StringTokenizer st;

    static int[] dx = new int[] {0, -1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, 0, -1, 1};

    static int N, M, K;

    static int[][] map;
    static int[][] smellOwner;
    static int[][] smellTime;

    static HashMap<Integer, Shark> sharkMap = new HashMap<>();

    static class Shark {
        ArrayList<ArrayList<Integer>> direction = new ArrayList<>();
        int myDirection;

        Shark(int dir) {
            this.myDirection = dir;
            direction.add(new ArrayList<>()); // 1~4 인덱스 맞추기용
        }

        void addDirection(ArrayList<Integer> arr) {
            direction.add(arr);
        }

        ArrayList<Integer> getPreferDirection(int dir) {
            return direction.get(dir);
        }

        void changeDirection(int dir) {
            this.myDirection = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        smellOwner = new int[N][N];
        smellTime = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int nowValue = Integer.parseInt(st.nextToken());
                map[i][j] = nowValue;

                if (nowValue != 0) {
                    smellOwner[i][j] = nowValue;
                    smellTime[i][j] = K;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharkMap.put(i, new Shark(Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i <= M; i++) {
            Shark nowShark = sharkMap.get(i);
            for (int j = 0; j < 4; j++) {
                ArrayList<Integer> tempArr = new ArrayList<>(4);
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < 4; z++) {
                    tempArr.add(Integer.parseInt(st.nextToken()));
                }
                nowShark.addDirection(tempArr);
            }
        }

        int time = 0;

        while (time < 1000) {
            int[][] tempMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int nowTarget = map[i][j];

                    if (nowTarget != 0) {
                        int[] nextPosition = findPosition(nowTarget, i, j);
                        int nextX = nextPosition[0];
                        int nextY = nextPosition[1];

                        int exTarget = tempMap[nextX][nextY];

                        if (exTarget == 0 || exTarget > nowTarget) {
                            tempMap[nextX][nextY] = nowTarget;
                        }
                    }
                }
            }

            decreaseSmell();

            int sharkCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = tempMap[i][j];

                    if (map[i][j] != 0) {
                        sharkCnt++;
                        smellOwner[i][j] = map[i][j];
                        smellTime[i][j] = K;
                    }
                }
            }

            time++;

            if (sharkCnt == 1) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }

    static int[] findPosition(int sharkNum, int x, int y) {
        Shark nowShark = sharkMap.get(sharkNum);
        int nowDirection = nowShark.myDirection;

        ArrayList<Integer> directionPrefers = nowShark.getPreferDirection(nowDirection);

        int[] emptySmellPosition = chkEmptyPosition(directionPrefers, x, y, nowShark);
        if (emptySmellPosition != null) return emptySmellPosition;

        return chkMySmellPosition(sharkNum, directionPrefers, x, y, nowShark);
    }

    static int[] chkEmptyPosition(ArrayList<Integer> directionPrefers, int x, int y, Shark nowShark) {
        for (Integer nowDir : directionPrefers) {
            int nextX = x + dx[nowDir];
            int nextY = y + dy[nowDir];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (smellTime[nextX][nextY] == 0) {
                    nowShark.changeDirection(nowDir);
                    return new int[] {nextX, nextY};
                }
            }
        }
        return null;
    }

    static int[] chkMySmellPosition(int sharkNum, ArrayList<Integer> directionPrefers, int x, int y, Shark nowShark) {
        for (Integer nowDir : directionPrefers) {
            int nextX = x + dx[nowDir];
            int nextY = y + dy[nowDir];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (smellOwner[nextX][nextY] == sharkNum && smellTime[nextX][nextY] > 0) {
                    nowShark.changeDirection(nowDir);
                    return new int[] {nextX, nextY};
                }
            }
        }
        return null;
    }

    static void decreaseSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smellTime[i][j] > 0) {
                    smellTime[i][j]--;
                    if (smellTime[i][j] == 0) {
                        smellOwner[i][j] = 0;
                    }
                }
            }
        }
    }
}