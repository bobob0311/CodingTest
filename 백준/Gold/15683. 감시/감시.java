import java.io.*;
import java.util.*;

/*
사무실은 N*M의 직사각형
K개의 CCTV가 설치되어있음
- 한방향
- 한방향과 반대 방향
- 한방향과 직각 방향
- 세방향
- 네방향


CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시
=> 벽을 통과할 수는 없다.

회전은 항상 90도 방향으로 가능
=> 세로 또는 가로 방향으로
CCTV의 정보가 주어졌을 때 CCTV의 방향을 적절히 정해서 사각 지대의 최소 크기를 구해라

*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int N,M;
    static int[][] map;
    static int answerCnt = 0;

    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int noneAnswer = 0;
        map = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++){
                int nowVal = Integer.parseInt(st.nextToken());

                // 벽일경우 -1
                // cctv일경우 -2
                if(nowVal == 6){
                    map[i][j] = -1;
                    noneAnswer++;
                }else if(nowVal == 0){
                    map[i][j] = 0;
                }else{
                    map[i][j] = -2;
                    noneAnswer++;
                    list.add(new int[]{nowVal,i,j});
                }
            }
        }
        sol(0);
        System.out.println(N*M - answerCnt-noneAnswer);
    }

    static void sol(int step) {
        if(step == list.size()){
            answerCnt = Math.max(answerCnt, countCan());
            return;
        }
        int[] nowList = list.get(step);

        int cctvCase = nowList[0];
        int nowX = nowList[1];
        int nowY = nowList[2];

        if(cctvCase == 1){
            for(int i = 0; i<4; i++){
                cctv1(i,step,nowX,nowY);
            }
        }else if(cctvCase == 2){
            for(int i  =0; i<2; i++){
                cctv2(i,step,nowX,nowY);
            }
        }else if(cctvCase == 3){
            for(int i = 0; i<4; i++){
                cctv3(i,step,nowX,nowY);
            }
        }else if(cctvCase == 4){
            for(int i = 0; i<4; i++){
                cctv4(i,step,nowX,nowY);
            }
        }else{
            cctv5(step,nowX,nowY);
        }
    }

    static void cctv1(int dir, int step, int nowX, int nowY){
        if(dir == 0){
            goRight(nowX, nowY);
            sol(step +1);
            backRight(nowX,nowY);
        }else if(dir == 1){
            goLeft(nowX,nowY);
            sol(step +1);
            backLeft(nowX,nowY);
        }else if(dir ==2){
            goUp(nowX,nowY);
            sol(step +1);
            backUp(nowX,nowY);
        }else{
            goDown(nowX,nowY);
            sol(step+1);
            backDown(nowX,nowY);
        }
    }

    static void cctv2(int dir, int step, int nowX, int nowY){
        if(dir == 0){
            goRight(nowX, nowY);
            goLeft(nowX,nowY);
            sol(step +1);
            backLeft(nowX,nowY);
            backRight(nowX,nowY);
        }else{
            goUp(nowX,nowY);
            goDown(nowX,nowY);
            sol(step+1);
            backUp(nowX,nowY);
            backDown(nowX,nowY);
        }
    }

    static void cctv3(int dir, int step, int nowX, int nowY){
        if(dir == 0){
            goRight(nowX, nowY);
            goDown(nowX,nowY);
            sol(step +1);
            backRight(nowX,nowY);
            backDown(nowX,nowY);
        }else if(dir == 1){
            goLeft(nowX,nowY);
            goUp(nowX,nowY);
            sol(step +1);
            backLeft(nowX,nowY);
            backUp(nowX,nowY);
        }else if(dir ==2){
            goUp(nowX,nowY);
            goRight(nowX, nowY);
            sol(step +1);
            backRight(nowX,nowY);
            backUp(nowX,nowY);
        }else{
            goDown(nowX,nowY);
            goLeft(nowX,nowY);
            sol(step+1);
            backDown(nowX,nowY);
            backLeft(nowX,nowY);
        }
    }

    static void cctv4(int dir, int step, int nowX, int nowY){
        if(dir == 0){
            goRight(nowX, nowY);
            goDown(nowX,nowY);
            goLeft(nowX,nowY);
            sol(step +1);
            backLeft(nowX,nowY);
            backRight(nowX,nowY);
            backDown(nowX,nowY);
        }else if(dir == 1){
            goLeft(nowX,nowY);
            goUp(nowX,nowY);
            goRight(nowX, nowY);
            sol(step +1);
            backRight(nowX,nowY);
            backLeft(nowX,nowY);
            backUp(nowX,nowY);
        }else if(dir ==2){
            goUp(nowX,nowY);
            goRight(nowX, nowY);
            goDown(nowX,nowY);
            sol(step +1);
            backDown(nowX,nowY);
            backRight(nowX,nowY);
            backUp(nowX,nowY);
        }else{
            goUp(nowX,nowY);
            goDown(nowX,nowY);
            goLeft(nowX,nowY);
            sol(step+1);
            backDown(nowX,nowY);
            backLeft(nowX,nowY);
            backUp(nowX,nowY);
        }
    }

    static void cctv5(int step, int nowX, int nowY){
            goRight(nowX, nowY);
            goDown(nowX,nowY);
            goLeft(nowX,nowY);
            goUp(nowX,nowY);
            sol(step +1);
            backLeft(nowX,nowY);
            backRight(nowX,nowY);
            backDown(nowX,nowY);
            backUp(nowX,nowY);
    }





    static int countCan(){
        int cnt = 0;
        for(int i = 0; i<N; i++ ){
            for(int j = 0; j<M; j++){
                if(map[i][j] > 0) cnt++;
            }
        }
        return cnt;
    }

    static void goRight(int x, int y){
        // 범위 밖으로 나가지않을경우
        int nowX = x;
        int nowY = y +1;

        while(nowY<M){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowY++;
                continue;
            }
            map[nowX][nowY]++;
            nowY++;
        }
    }

    static void backRight(int x, int y){
        // 범위 밖으로 나가지않을경우
        int nowX = x;
        int nowY = y +1;

        while(nowY<M){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowY++;
                continue;
            }
            map[nowX][nowY]--;
            nowY++;
        }
    }

    static void goLeft(int x, int y){
        // 범위 밖으로 나가지않을경우
        int nowX = x;
        int nowY = y -1;

        while(nowY>=0){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowY--;
                continue;
            }
            map[nowX][nowY]++;
            nowY--;
        }
    }

    static void backLeft(int x, int y){
        // 범위 밖으로 나가지않을경우
        int nowX = x;
        int nowY = y -1;

        while(nowY>=0){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowY--;
                continue;
            };
            map[nowX][nowY]--;
            nowY--;
        }
    }

    static void goUp(int x, int y){
        int nowX = x -1;
        int nowY = y;

        while(nowX>=0){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowX--;
                continue;
            }
            map[nowX][nowY]++;
            nowX--;
        }
    }

    static void backUp(int x, int y){
        int nowX = x -1;
        int nowY = y;

        while(nowX>=0){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowX--;
                continue;
            }
            map[nowX][nowY]--;
            nowX--;
        }
    }

    static void goDown(int x, int y){
        int nowX = x +1;
        int nowY = y;

        while(nowX<N){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowX++;
                continue;
            }
            map[nowX][nowY]++;
            nowX++;
        }
    }

    static void backDown(int x, int y){
        int nowX = x +1;
        int nowY = y;

        while(nowX<N){
            if(map[nowX][nowY] == -1) break;
            if(map[nowX][nowY] == -2) {
                nowX++;
                continue;
            }
            map[nowX][nowY]--;
            nowX++;
        }
    }





}