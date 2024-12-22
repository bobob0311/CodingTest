import java.io.*;

/*
1
00 11
100 001 111
0000 0011 1001 1100 1111
00001 10000 00100 11100 11001 10011 00111 11111 

*/

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr =new int[n+1];
        if(n<2){
            System.out.println(1);
            return;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i = 3; i<=n; i++){
            arr[i] = (arr[i-2] +arr[i-1])%15746;
        }
        
        System.out.println(arr[n]);
    }
}