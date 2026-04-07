import java.io.*;
import java.util.*;

/*
길이가 N인 컨베이어 벨트
2N 벨트가 위아래를 감싸고있다.
1  ~  N (위)
2N ~ N+1(아래)
- 1번칸이 있는 위치를 올리는 위치, N번 칸이 있는 위치를 내리를 위치

=> 컨베이어 벨트에 박스 모양 로봇을 올린다.
N에 도착하면 그 즉시 내림
- 벨트 위에서 스스로 이동이 가능
올리는 위치에 올리거나 어떤 칸으로 이동 할 시 칸의 내구도는 1만큼 감소

1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전
2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동할 수 ㅣㅇ싿면 이동
    => 이동하려는 칸에 로봇이 없어야하며 내구도가 1이상 남아있어야 한다.
3. 올리는 위치에 칸의 내구도가 0이아니면 로봇을 올린다.
4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료 아니면 반복


- 회전하고
- 한번씩 이동하는
- 시작점에 로봇 올리기
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[] robots;
    static int N,K;
    static int[] hp;

    static int cnt = 0;

    static Queue<Integer> robotsQue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        hp = new int[2 * N +1];
        robots = new boolean[2 * N +1];


        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= 2 *N ; i++) hp[i] = Integer.parseInt(st.nextToken());

        play();

    }

    static void play(){
        // 내구도가 0인 칸의 개수
        // 현재 단계
        int step = 1;

        while(true){
            moveAll();
            moveRobots();
            addRobots();
            if(checkFinishCondition(K)) {
                System.out.println(step);
                return;
            };
            step++;
        }
    }

    static void addRobots(){
        if(hp[1] != 0){
            hp[1]--;
            robots[1] = true;
        }
    }

    static void moveAll(){
        int temp = hp[2*N];
        for(int i = 2*N; i>0; i--){
            hp[i] = hp[i-1];
        }
        hp[1] = temp;

        for(int i = N-1; i>1; i--){
            robots[i] = robots[i-1];
        }
        robots[1] = false;
        robots[N] = false;
    }


    static void moveRobots(){
        for(int i = N; i>1 ; i--){
            if(robots[i-1] && !robots[i] && hp[i] >=1){
                hp[i]--;
                robots[i] = true;
                robots[i-1] = false;
            }
        }
        robots[N] = false;
    }

    static boolean checkFinishCondition(int limit){
        int cnt = 0;
        for(int i = 1; i< 2 *N +1; i++){
            if(hp[i] == 0) cnt++;
        }
        if(cnt >= limit) return true;
        return false;
    }
}