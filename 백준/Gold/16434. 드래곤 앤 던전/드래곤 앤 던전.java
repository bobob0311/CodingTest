import java.util.*;
import java.io.*;

public class Main{
    static long Maxhp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 방의 개수
        int N = Integer.parseInt(st.nextToken());
        // 용사 초기 공격력
        long atk = Long.parseLong(st.nextToken());
        
        int[][] room = new int[N][3];
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
            room[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int idx = 0;
        long answer = 0;
        
        long start = 0;
        long end = Long.MAX_VALUE;
        
        while(start <= end){
            long curAtk = atk;
            idx = 0;
            Maxhp = (start + end)/2;
            long hp = Maxhp;
            boolean chk = true;
            
            while(idx < N){
                int[] now = room[idx++];

                if(now[0] == 1){
                    // 공격 받는 횟수
                    long time = (long)(now[2] -1) / curAtk;
                    hp -= (long) (time * now[1]);
                    if(hp <= 0){
                        chk = false;
                        break;
                    }
                }else{
                    curAtk += now[1];
                    hp += now[2];
                    if(hp > Maxhp){
                        hp = Maxhp;
                    }
                }
            }

            if(chk){
                end = Maxhp -1;
                answer = Maxhp;
            }else{
                start = Maxhp +1;
            }
                
        }
        System.out.println(answer);
        
    }
    
}
















