/*
박혀있는 말뚝 중 두개 두 말뚝 사이의 공간이 현수막 밑변
적절한 깃대 두 말뚝 정중앙에 깃대의 길이가 현수막의 높이 삼각형 모양으로 현수막

말뚝 N
깃대 ㅡ
최대 현수막 넓이 R
*/
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        st =  new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        st =  new StringTokenizer(br.readLine());
        int[] git = new int[M];
        for(int i = 0; i<M;i++){
            git[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(git);
     
        double answer = -1;
        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                int a = arr[j] - arr[i];
                
                int start = 0;
                int end = M-1;
                
                while(start<= end){
                    int mid = (start + end)/2;
                    double target =(double) (git[mid] * a)/2;
                    if(target<=R){
                        start = mid +1;
                        answer = Math.max(answer,target);
                    }else{
                        end = mid -1;
                    }
                }
            }
        }
        System.out.println(answer == -1 ? -1 : String.format("%.1f", answer));
        
        
    }
}

