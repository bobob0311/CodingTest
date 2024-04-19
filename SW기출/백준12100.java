package SW기출;

import java.io.*;
import java.util.*;

/*
같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다.
한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 합쳐지지 않는다 

- 블록 추가 X

 */
public class 백준12100 {
    static int N;// 보드의 크기 (1~20)
    static int[][] arr;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        F(0);
        System.out.println(res);

    }

    public static void F(int count) {
        if (count == 5) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    res = Math.max(res, arr[i][j]);
            return;
        }
        int[][] nextMap = new int[N][N];

        for (int k = 0; k < N; k++)
            nextMap[k] = arr[k].clone();
        // 2 위 1왼 0 오 3 아래

        move(2);
        System.out.println("");
        move(0);
        System.out.println("");
        move(2);
        System.out.println("");
        move(0);
        System.out.println("");
        move(0);

        for (int k = 0; k < N; k++)
            arr[k] = nextMap[k].clone(); // 원복

    }

    public static void move(int format) {
        int idx;
        int target;

        if (format == 0) {
            for (int i = 0; i < N; i++) {
                idx = 0;
                for (int j = 0; j < N - 1; j++) {
                    target = arr[i][N - 2 - j];

                    if (arr[i][N - 1 - idx] == 0) {
                        if (target != 0) { // idx는 0인데 target은값이 있는 경우
                            arr[i][N - 1 - idx] = target; // idx걸린 값만 바꿔주기 즉 땡겨주기
                            arr[i][N - 2 - j] = 0;
                        }
                        continue;
                    } else {
                        if (target != 0) {
                            if (arr[i][N - 1 - idx] == target) {

                                arr[i][N - 1 - idx] = target * 2;
                                arr[i][N - 2 - j] = 0;
                                idx++;
                            } else {
                                idx++;
                                int temp = target;
                                arr[i][N - 2 - j] = 0;
                                arr[i][N - 1 - idx] = temp;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.println("");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]);
                }
            }

        }

        else if (format == 1) {
            for (int i = 0; i < N; i++) {
                idx = 0;

                for (int j = 0; j < N - 1; j++) {
                    target = arr[i][j + 1];

                    if (arr[i][idx] == 0) {
                        if (target != 0) { // idx는 0인데 target은값이 있는 경우
                            arr[i][idx] = target; // idx걸린 값만 바꿔주기 즉 땡겨주기
                            arr[i][j + 1] = 0;
                        }
                        continue;
                    } else {
                        if (target != 0) {
                            if (arr[i][idx] == arr[i][j + 1]) {
                                arr[i][idx] = target * 2;
                                arr[i][j + 1] = 0;
                                idx++;
                            } else {
                                idx++;
                                int temp = target;
                                arr[i][j + 1] = 0;
                                arr[i][idx] = temp;
                            }
                        }
                    }

                }

            }
            for (int i = 0; i < N; i++) {
                System.out.println("");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]);
                }
            }

        }

        else if (format == 2) {
            for (int i = 0; i < N; i++) {
                idx = 0;
                for (int j = 0; j < N - 1; j++) {
                    target = arr[j + 1][i];

                    if (arr[idx][i] == 0) {
                        if (target != 0) { // idx는 0인데 target은값이 있는 경우
                            arr[idx][i] = target; // idx걸린 값만 바꿔주기 즉 땡겨주기
                            arr[j + 1][i] = 0;
                        }
                        continue;
                    } else {
                        if (target != 0) {
                            if (arr[idx][i] == target) {

                                arr[idx][i] = target * 2;
                                arr[j + 1][i] = 0;
                                idx++;
                            } else {
                                idx++;
                                int temp = target;
                                arr[j + 1][i] = 0;
                                arr[idx][i] = temp;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.println("");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]);
                }
            }

        }

        else if (format == 3) {
            for (int i = 0; i < N; i++) {
                idx = 0;
                for (int j = 0; j < N - 1; j++) {
                    target = arr[N - 2 - j][i];

                    if (arr[N - 1 - idx][i] == 0) {
                        if (target != 0) { // idx는 0인데 target은값이 있는 경우
                            arr[N - 1 - idx][i] = target; // idx걸린 값만 바꿔주기 즉 땡겨주기
                            arr[N - 2 - j][i] = 0;
                        }
                        continue;
                    } else {
                        if (target != 0) {
                            if (arr[N - 1 - idx][i] == target) {

                                arr[N - 1 - idx][i] = target * 2;
                                arr[N - 2 - j][i] = 0;
                                idx++;
                            } else {
                                idx++;
                                int temp = target;
                                arr[N - 2 - j][i] = 0;
                                arr[N - 1 - idx][i] = temp;
                            }

                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.println("");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]);
                }
            }

        }
    }
}
