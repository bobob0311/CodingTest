import java.io.*;
import java.util.*;

/*
공항 1~G까지의 번호
P개의 비행기
i번째  비행기를 1~G번째 게이트에 도킹
어느 게이트에도 도킹할 수없다면 공항이 폐쇄
*/

public class Main {

    static int G,P;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        check = new int[G+1];
        Arrays.fill(check, -1);

        for(int i = 1; i<=P; i++){
            int max = Integer.parseInt(br.readLine());
            int idx = findNextIdx(max);
            if(idx == 0){
                System.out.println(i-1);
                return;
            }
        }
        System.out.println(P);


    }

    static int findNextIdx(int value){
        if(value == 0 || check[value] == 0) return 0;

        // 만약 이미 도킹되어있는 상태라면!
        if(check[value] != -1){
           return check[value] = findNextIdx(check[value]);
        }else{
            check[value] = value-1;
            return value;
        }
    }

}