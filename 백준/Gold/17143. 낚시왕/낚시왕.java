import java.io.*;
import java.util.*;


public class Main {
    static StringTokenizer st;

    static int R, C, M;
    static int[][][] map;
    static int answer = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R][C][3];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = new int[] {size,speed,direction};
        }

        int nowLocation = -1;

        while(nowLocation <C - 1){
            nowLocation++;
            int catchedSize = 0;
            for(int i = 0; i< R; i++){
                if(map[i][nowLocation][0] != 0){
                    catchedSize = map[i][nowLocation][0];
                    map[i][nowLocation] = new int[] {0,0,0};
                    break;
                }
            }
            answer+=catchedSize;
            map = moveShark(map);
        }

        System.out.println(answer);
    }

    static int[][][] moveShark(int[][][] nowMap){
        int[][][] newMap = new int[R][C][3];

        for(int i = 0; i< R; i++){
            for(int j = 0; j<C; j++){
                if(nowMap[i][j][0] !=0){
                    int[] nowNode = nowMap[i][j];

                    int nowSize = nowNode[0];
                    int nowSpeed = nowNode[1];
                    int nowDirection = nowNode[2];

                    int positionX =i;
                    int positionY =j;

                    // 위인경우
                    if(nowDirection == 1){
                        int offset = nowSpeed % (R * 2 -2);
                        positionX = i - offset;

                        if(positionX <0){
                            positionX = Math.abs(positionX);
                            nowDirection = 2;
                            if(positionX >= R){
                               positionX = R-1 - (positionX - (R-1));
                               nowDirection =1;
                            }
                        }


                    }else if(nowDirection ==2){
                        int offset = nowSpeed % (R * 2 -2);
                        positionX = i + offset;

                        if(positionX >= R){
                            positionX = R - 1 - (positionX - (R - 1));
                            nowDirection = 1;
                            if(positionX < 0){
                                positionX = -positionX;
                                nowDirection = 2;
                            }
                        }


                    }else if(nowDirection == 3){
                        int offset = nowSpeed % (C * 2 -2);
                        positionY = j + offset;

                        if(positionY >= C){
                            positionY = C - 1 - (positionY - (C - 1));
                            nowDirection = 4;
                            if(positionY < 0){
                                positionY = -positionY;
                                nowDirection = 3;
                            }
                        }

                    }else{
                        int offset = nowSpeed % (C * 2 -2);
                        positionY = j - offset;

                        if(positionY < 0){
                            positionY = -positionY;
                            nowDirection = 3;
                            if(positionY >= C){
                                positionY = C - 1 - (positionY - (C - 1));
                                nowDirection = 4;
                            }
                        }
                    }

                    if(newMap[positionX][positionY][0] != 0){
                        if(newMap[positionX][positionY][0] <nowSize){
                            newMap[positionX][positionY] = new int[] {nowSize,nowSpeed,nowDirection};
                        }
                    }else{
                        newMap[positionX][positionY] = new int[] {nowSize,nowSpeed,nowDirection};
                    }

                }

            }
        }
        return newMap;
    }



}