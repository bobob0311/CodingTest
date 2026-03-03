import java.io.*;
import java.util.*;

/*
N개의 구두가 쌓여있음

하루에 한 작업만 수행이 가능
i번째 작업을 완료하는 데 Ti(1<= Ti <= 1000)일이 걸린다.

하루 지연이 될때 마다 Si(1 <= Si <= 10000) 센트를 지불해야한다.
최저 보상금을 지불하는 작업 순서를 정해야한다.
*/

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 번호, 시간, 보상금
        int[][] data = new int[N][3];

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            data[i] =new int[] {i+1,day, time};
        }

        Arrays.sort(data,(a,b)-> {
            float firstWeight = (float)a[2]/a[1];
            float secondWeight= (float)b[2]/b[1];

            if(firstWeight == secondWeight){
                return a[0] - b[0];
            }else{
                if(firstWeight < secondWeight){
                    return 1;
                }else{
                    return -1;
                }
            }

        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< N; i++){
            sb.append(data[i][0]+" ");
        }

        System.out.println(sb.toString());
    }
}