import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        
        long cnt = 0;
        
        for(int i = 0; i<n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i<n; i++){
            if(arr[i] >= c){
                if(arr[i] == c){
                    cnt++;
                }
                continue;
            }
            
            for(int j = i+1; j<n; j++){
                if(arr[i] + arr[j] >= c){
                    if(arr[i] + arr[j] == c){
                        cnt++;
                    }
                    continue;
                }
                cnt += binarySearch(arr,i,j,c);
                        
                        
                        
                    
                
            }
        }
        if(cnt > 0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
        
    }
    public static int binarySearch(int[] arr, int idx1, int idx2, int target){
        int start = 0;
        int end = arr.length-1;
        long now = (long) (arr[idx1] + arr[idx2]);
        int answer = -1;
        long c = (long) target;
        while(start <= end){
            int mid = (start + end)/2;
            
            if(now + arr[mid] > c ){
                end = mid-1;
            }else if(now + arr[mid] < c ){
                start = mid + 1;
            }else{
                answer = mid;
                break;
            }
        }
        if(answer != idx1 && answer != idx2 && answer != -1){
            return 1;
        }else{
            return 0;
        }
    }
}