import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

/*
2차원 세계에 블록이 쌓여있는데 비가 오면 블록 사이에 빗물이 고인다.


*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int H,W;
    static Stack<Integer> stk = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int topIdx = 0;
        int topH = arr[0];
        int water = 0;
        stk.add(arr[0]);
        for(int i = 1; i<W; i++){
            int nowNum = arr[i];

            if(nowNum <stk.peek()){
                water += topH - nowNum;
            }else{
                answer += water;
                water = 0;
                topH = nowNum;
                topIdx = i;
                stk.add(nowNum);
            }
        }
        stk.clear();

        water = 0;
        stk.add(arr[W-1]);
        topH = arr[W-1];
        int minIdx = topIdx;
        for(int i = W-2; i>=minIdx; i--){
            int nowNum = arr[i];

            if(nowNum <stk.peek()){
                water += topH - nowNum;
            }else{
                answer += water;
                water = 0;
                topH = nowNum;
                topIdx = i;
                stk.add(nowNum);
            }
        }
        System.out.println(answer);

    }

}