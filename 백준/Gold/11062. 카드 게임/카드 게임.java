import java.io.*;
import java.util.*;

/*
N개의 카드가 일렬로 각 카드에는 점수가 존재

가장 왼쪽 혹은 가장 오른쪽 카드를 가져오며 카드가 없으면 종료

근우와 명우 서로 자신의 점수를 가장 높일 수 있는 전략으로 게임에 임한다.
*/

public class Main {
    static int T, cardSize;
    static int[] cards;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        int t = 0;


        while(t != T){
            t++;
            cardSize = Integer.parseInt(br.readLine());
            dp = new int[cardSize][cardSize];
            for(int i = 0; i< cardSize; i++){
                Arrays.fill(dp[i],-1);
            }

            cards = new int[cardSize];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<cardSize; i++){
                cards[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(myTurn(0, cardSize-1));
        }

    }

    static public int myTurn(int start,int end){
        if(start > end) return 0;
        if(dp[start][end] != -1) return dp[start][end];

        int pickLeft = cards[start] + opponentTurn(start+1, end);
        int pickRight = cards[end] + opponentTurn(start, end -1);
        return dp[start][end] = Math.max(pickRight,pickLeft);
    }

    static public int opponentTurn(int start, int end){
        if(start > end) return 0;

        return Math.min(myTurn(start+1, end) , myTurn(start, end-1));
    }
}
