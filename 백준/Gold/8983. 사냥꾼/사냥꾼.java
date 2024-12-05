import java.util.*;
import java.io.*;
/*
M개의 사대

한 사대에서 거리가 L보다 작거나 같은 위치이 동물을 잡을 수 있다. 



*/
public class Main{
    static int M,N,L;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 사대의 수 (100000)
        M = Integer.parseInt(st.nextToken());
        // 동물의 수 (100000)
        N = Integer.parseInt(st.nextToken());
        // 사정거리 (십억)
        L = Integer.parseInt(st.nextToken());
        
        int[] pos = new int[M];
        int[][] arr = new int[N][2];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<M; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pos);
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        
        int cnt = 0;
        int idx = 0;
        
        for(int i = 0; i<N; i++){
            int nowX = arr[i][0];
            int nowY = arr[i][1];
            
            int left = 0;
            int right = M - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (pos[mid] < nowX) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 가장 가까운 사대와 거리 비교
            int x = pos[left];
            if (left > 0 && Math.abs(pos[left - 1] - nowX) < Math.abs(x - nowX)) {
                x = pos[left - 1];
            }
                
            if(Math.abs(x - nowX) + nowY <= L){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}