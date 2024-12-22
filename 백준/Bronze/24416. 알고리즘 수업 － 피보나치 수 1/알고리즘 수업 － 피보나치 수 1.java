import java.io.*;

public class Main{
    static int cnt1 = 0;
    static int cnt2 = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        fib(N);
        fibonacci(N);
        System.out.println(cnt1+" "+cnt2);
    }
    
    static int fib(int n){
        if(n == 1 || n ==2){
            cnt1++;
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }
    
    static void fibonacci(int n){
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            cnt2++;
        }
    }
}